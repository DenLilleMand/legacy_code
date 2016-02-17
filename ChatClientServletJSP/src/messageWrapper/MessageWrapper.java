package messageWrapper;

import java.util.ArrayList;

import network.NetworkControllerClient;

public class MessageWrapper implements Observer
{
	ArrayList<String> messages = new ArrayList<String>();
	private static MessageWrapper instance = null;
	
	public ArrayList<String> getMessages()
	{
		return messages;
	}
	
	public static MessageWrapper getInstance()
	{
		if(instance == null)
		{
			instance = new MessageWrapper();
		}
		return instance;
	}
	
	private MessageWrapper()
	{
		if(instance != null)
		{
			throw new IllegalStateException();
		}
	}
	
	@Override
	public void update(Observable observable, Object inputObject) 
	{
		System.out.println("the update method was called in the ServletJSP project.");
		if(observable instanceof NetworkControllerClient)
		{
			messages.add((String)inputObject);
		}
	}

}
