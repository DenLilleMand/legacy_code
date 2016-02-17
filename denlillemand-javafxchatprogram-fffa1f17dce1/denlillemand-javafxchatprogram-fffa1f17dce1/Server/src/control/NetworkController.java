package control;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import collections.tree.TreeRootWrapper;
import decoratorImplementation.LoggerDecorator;
import decoratorImplementation.ObservableDecorator;
import javafx.concurrent.Task;
import entities.ArrayListWrapper;
import entities.IArrayListWrapper;
import entities.MessageWrapper;

public class NetworkController
{
	private static NetworkController instance;
	private ObjectOutputStream objectOutput;
	private ObjectInputStream objectInput;
	private ServerSocket serverSocketForChat;
	private Socket socket;
	private MessageWrapper messageWrapper = MessageWrapper.getInstance();
	private IArrayListWrapper clientWrapper = ArrayListWrapper.getInstance();
	
	private NetworkController()
	{
		if(instance != null)
		{
			throw new IllegalStateException();
		}
	}
	
	public static NetworkController getInstance()
	{
		if(instance == null)
		{
			instance = new NetworkController();
		}
		return instance;
	}
	
	public void closeCrap() throws Exception
	{
		objectInput.close();
		objectOutput.close();
		socket.close();
	}
	
	public void startRunning() throws Exception
	{
			serverSocketForChat = new ServerSocket(6789, 100);//100 = hvor mange der venter p� min port
			messageWrapper.addObserver(UDPController.getInstance()); // må bare rykke dem der 
			messageWrapper.addObserver(TreeRootWrapper.getInstance(null));
			try
			{
				Task<Void> task = new Task<Void>() 
				{
					@Override
					public void run() 
					{
						try 
						{
								while(true) 
								{
									LoggerDecorator logger = new LoggerDecorator(clientWrapper);
									ObservableDecorator observable = new ObservableDecorator(logger);
									Thread thread = new Thread(new ServerThread(serverSocketForChat.accept(),observable,messageWrapper));
					        		thread.start();        		
					        	}
						} catch (Exception e) 
						{
							e.printStackTrace();
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
			catch(Exception  eofException)
			{
				eofException.printStackTrace();
			}finally
			{
			}	
	}
}
