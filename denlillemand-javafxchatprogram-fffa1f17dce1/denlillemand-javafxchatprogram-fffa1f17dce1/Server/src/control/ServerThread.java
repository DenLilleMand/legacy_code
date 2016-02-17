package control;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import decoratorImplementation.ObservableDecorator;
import eventHandlingController.State;
import entities.ArrayListWrapper;
import entities.MessageEvent;
import entities.MessageWrapper;
import entities.User;
import entities.UserStatus;
import eventHandlingController.EventHandlingControllerMain;
import javafx.concurrent.Task;

public class ServerThread implements Runnable, Observer    
{
	private ObjectOutputStream objectOutput;
	private ObjectInputStream objectInput;
	private static EventHandlingControllerMain ehcMain;
	private State state = State.getInstance();
	private ArrayListWrapper clientWrapper = ArrayListWrapper.getInstance();
	private MessageWrapper messageWrapper = MessageWrapper.getInstance();
	private DbController dbController = DbController.getInstance();
	private User thisThreadsUser = null;
	
	
	public ServerThread(Socket socket, Observable userObs, Observable messageObs)throws Exception
	{
		userObs.addObserver(this);
		messageObs.addObserver(this);
		setupStreams(socket);
	}

	@Override
	public void run() 
	{	
		try 
		{
			whileChatting();
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	private void whileChatting() throws Exception
	{
		Task<Void> task = new Task<Void>() 
		{
			@Override
			public void run() 
			{
				try 
				{
					ehcMain = EventHandlingControllerMain.getInstance();
					/**
					 * Den her bracket kode er ikke lige vupti-doo, vi m� nok hellere implementere noget som tjekker p�
					 * instanceof user / String og s� g�re noget med hvad end der er modtaget iforhold til det tjek.
					 * men p� den anden siden s� f�r vi vel kun user informationen i den her bracket kode 1 gang, s� 1 tjek hver gang
					 * er lidt et overkill .... m�ske burde vi tage imod userObjektet et andet sted, eller m�ske er det her okay. 
					 */
					User user = (User) objectInput.readObject(); 
					thisThreadsUser = user;
					ArrayList<User> updatedUserListWithFriends = new ArrayList<User>();
					for(User oldUser :clientWrapper.getUserList())
					{
						updatedUserListWithFriends.add(oldUser.copy());
					}
					Iterator<User> friendIterator = dbController.retrieveAllUserFriends(thisThreadsUser);
	        			while(friendIterator.hasNext())
	        			{
	        				User friend = friendIterator.next();
	        				for(User oldUser : updatedUserListWithFriends)	
	        				{
	        					if(oldUser.getUserName().equalsIgnoreCase(friend.getUserName()))
	        					{
	        						oldUser.setUserStatus(UserStatus.FRIEND);
	        					}
	        				}
	        					
	    	        	}
	        		
	      
					objectOutput.writeObject(updatedUserListWithFriends);
	        		objectOutput.flush();
	        		if(user != null && user.isNewUser())
	        		{
	        			//System.out.println("new user:" + user.getUserName());
	        			dbController.addUser(user); //wtf ! adder user 3 steder, dårligt design lol.
	        			clientWrapper.addUser(user); //skal �ndres til bare at s�tte en user online i listen. Client wrapper.addUser skal kun kaldes hvis det er en new user.
	        			ehcMain.getData().add(user);	
	        			
	        		}
	        		else
	        		{
	        			for(User iterateUser : ehcMain.getData())
	        			{
	        				if(iterateUser.getUserName().equals(user.getUserName()))
	        				{
	        					clientWrapper.setOnline(iterateUser); //implement this method.
	        				}
	        			}
	        			ehcMain.updateTableView();
	        		}
					
					/**
					 * 
						this while(true) is suppose to be doWhile loops i think, checking on something.
						but there is other avenues of this that we'll explore first. such as
						the client sending a userObject with isOnline(false) and then we'll just remove it,
						and terminate the connection.    this will have to be done with a logoutButton + 
						shutdown hook- so we make sure that we get the UserObject, this will not work 
						if the clients internet get hanged. so in that case we would have to find an actual
						way for the server to check in the socket somehow, but all of the methods for this
						seems to have some kind of error
					*/
					Boolean b = true;
					while (b)
					{
						try
						{
							handleCommunication(objectInput.readObject());
						}
						catch(Exception e)
						{
							e.printStackTrace();
							clientWrapper.setUserOffline(user);
							for(User iterateUser : ehcMain.getData())
		        			{
		        				if(iterateUser.getUserName().equals(user.getUserName()))
		        				{
		        					iterateUser.setOnline(false);
		        				}
		        			}
							ehcMain.updateTableView();
							b = false;
						}
					}
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
//				System.out.println("We jumped out of the while(true) loop that contains the client"
//						+ " thread.");
			}
			@Override
			protected Void call() throws Exception 
			{
				return null;
			}
		};
		new Thread(task).start();
	}
	
	private void handleCommunication(Object inputObject) throws Exception
	{
		if(inputObject instanceof MessageEvent)
		{
			MessageEvent event = (MessageEvent) inputObject;
			messageWrapper.setMessage(event);
			ehcMain.showMessage(event.getSender() + "(" + event.getSubject() +"):" + event.getMessage());
		}
		else if(inputObject instanceof User)
		{
			User inputUser = (User) inputObject;
//			System.out.println("this is the inputUser:" + inputUser + " This is his userstatus:" + inputUser.getUserStatus() + ". username:" + inputUser.getUserName()
//					+ ". ");
			if(inputUser.getUserStatus().equalsIgnoreCase(UserStatus.FRIEND))
			{
				dbController.addFriend(thisThreadsUser, inputUser);
			}else if(inputUser.getUserStatus().equalsIgnoreCase(UserStatus.USER))
			{
				//System.out.println("thisThreadUser:" + thisThreadsUser);
				dbController.removeFriend(thisThreadsUser, inputUser);
			}
		}
		else
		{
			System.out.println("is type of User:");
			System.out.println(inputObject instanceof User);
			System.out.println("we reached this location with object:" + inputObject);	
		}
	}
	
	private void setupStreams(Socket socket) throws Exception
	{
		objectOutput = new ObjectOutputStream(socket.getOutputStream());
		objectInput = new ObjectInputStream(socket.getInputStream());
	}
	/**
	 * Vi mangler stadig at implementere et message system, s� vi har brug for en ny wrapper klasse til beskeder.
	 * M� lige t�nke over hvordan det skal implementeres. 
	 */
	@Override
	public void update(Observable observable, Object objectToSend) 
	{	
		if(observable instanceof ObservableDecorator)
		{
				try
				{
					System.out.println("Sending User stuff:" + ((User) objectToSend).isOnline());
					objectOutput.writeObject(objectToSend);
					objectOutput.flush();
				} catch (IOException e) 
				{
					e.printStackTrace();
				}
		}
		else if(observable instanceof MessageWrapper)
		{
				System.out.println("Sending Message stuff:" + (MessageEvent)objectToSend);
				try
				{
					objectOutput.writeObject(objectToSend);
					objectOutput.flush();	
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
		}
	}
}
