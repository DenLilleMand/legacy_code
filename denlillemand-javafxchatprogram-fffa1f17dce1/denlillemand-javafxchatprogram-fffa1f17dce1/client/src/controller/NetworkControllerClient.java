package controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import entities.MessageEvent;
import entities.User;
import eventHandlingController.EventHandlingControllerMainClient;
import state.State;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import mediator.GUIEventMediator;

public class NetworkControllerClient 
{
	private static NetworkControllerClient instance;
	private String serverIP = "127.0.0.1";
	private Socket connectionSocket;
	private ObjectInputStream objectInputStream;
	private ObjectOutputStream objectOutputStream;
	private GUIEventMediator eventMediator;
	private State state = State.getInstance();
	private EventHandlingControllerMainClient ehcm;


	private NetworkControllerClient()
	{
		if(instance != null)
		{
			throw new IllegalStateException();
		}
	}
	
	public static NetworkControllerClient getInstance()
	{
		if(instance == null)
		{
			instance = new NetworkControllerClient();
		}
		return instance;
	}
	

	private void setupStreams() throws Exception
	{	
		objectInputStream = new ObjectInputStream(connectionSocket.getInputStream());
		objectOutputStream = new ObjectOutputStream(connectionSocket.getOutputStream());
	}
	
	
	public void whileChatting() throws Exception
	{
		Task<Void> task = new Task<Void>() 
		{
			@Override
			public void run() 
			{
				try 
				{
					ehcm = EventHandlingControllerMainClient.getInstance();
					//System.out.println("Sending user:" + state.getUser().getUserName());
					objectOutputStream.writeObject(state.getUser().copy());
					state.getUser().setNewUser(false);
					
					
					//f�r en arrayliste ned, som vi s� skal bruge til at lave vores
					//observable liste og give den videre til vores table.
					while(true)
					{	
						handleObject(objectInputStream.readObject());
					}
				} catch (Exception e) 
				{
				}
			}
			@Override
			protected Void call() throws Exception 
			{
				return null;
			}
		};
		new Thread(task).start();
	}

	public void connectToServer() throws Exception
	{
		connectionSocket = null;
		try 
		{
			connectionSocket = new Socket(serverIP, 6789);
			eventMediator = GUIEventMediator.getInstance();
			setupStreams();
			whileChatting();
		} catch (IOException ex) 
		{
			ex.printStackTrace();
		} finally 
		{
		}
	}
	
	@SuppressWarnings("unchecked")
	private void handleObject(Object inputObject)
	{
		if(inputObject instanceof MessageEvent)
		{
			Platform.runLater(new Runnable() 
			{
	             @Override public void run() 
	             {
	            	 MessageEvent event = (MessageEvent) inputObject;
	            	 eventMediator.updateCollectiveChat(event.getSender() + "(" + event.getSubject() +"):" + event.getMessage());
	             }
	         });
		}
		else if(inputObject instanceof User)
		{
			User user = (User)inputObject;
			//Muligheder?  en User er gået offline, en User er blevet tilføjet,
			//En user er blevet slettet(?),En user er kommet online.
//			System.out.println("this client just received this user object:" + user
//					+ "  online: "+ user.isOnline()+ " new User:" + user.newUser +" username:" + user.userName);
			if(user.getUserName().equalsIgnoreCase(state.getUser().getUserName()))
			{
				return;
			}
			else if(user.newUser)
			{
				ehcm.getData().add(user);
				setUserOnline(user);
				ehcm.updateTableView();
			}
			else if(user.isOnline())
			{
				setUserOnline(user);
				ehcm.updateTableView();
			}
			else if(!user.isOnline())
			{
				for(int i = 0; i < ehcm.getData().size(); i++)
				{
					if(ehcm.getData().get(i).userName.equalsIgnoreCase(user.getUserName()))
					{
						ehcm.getData().get(i).setOnline(false); 
						ehcm.updateTableView();
					}
				}
			}
		}
		else if(inputObject instanceof ArrayList<?>)
		{
			ehcm.getData().addAll((ArrayList<User>) inputObject);
			
			//System.out.println("Size on ehcm list on client:" + ehcm.getData().size());
//			for(User user : ehcm.getData())
//			{
//				//System.out.println("how many friends:" + user.getUserStatus());
//			}
			for(int i = 0; i < ehcm.getData().size(); i++)
			{
				if(ehcm.getData().get(i).getUserName().equalsIgnoreCase(state.getUser().getUserName()))
				{
					ehcm.getData().remove(i);
					break;
				}
			}
			ehcm.updateTableView();
		}
	}
	
	private void setUserOnline(User user)
	{
		for(int i = 0; i < ehcm.getData().size(); i++)
		{
			if(ehcm.getData().get(i).userName.equalsIgnoreCase(user.getUserName()))
			{
				ehcm.getData().get(i).setOnline(true); 	
				ehcm.updateTableView();
			}
		}
	}

	public void sendMessage(String message, String subject, List<String> subjects) throws Exception
	{
		MessageEvent newEvent = new MessageEvent();
		newEvent.setMessage(message);
		newEvent.setSubjects(subjects);
		newEvent.setSubject(subject);
		newEvent.setSender(state.getUser().getUserName());
		objectOutputStream.writeObject(newEvent);
		objectOutputStream.flush();
	}
	
	public void disconnect() throws Exception
	{
		if(objectOutputStream != null && objectInputStream != null)
		{
			objectOutputStream.close();
			objectInputStream.close();	
		}
	}
	
	

	public void removeFriend(User selectedFriend) throws Exception
	{
		//System.out.println("lol");
		objectOutputStream.writeObject(selectedFriend);
		objectOutputStream.flush();
	}
	
	public void addFriend(User selectedUser) throws Exception
	{
		//System.out.println("herpderp");
		objectOutputStream.writeObject(selectedUser);
		objectOutputStream.flush();
	}
	
}
