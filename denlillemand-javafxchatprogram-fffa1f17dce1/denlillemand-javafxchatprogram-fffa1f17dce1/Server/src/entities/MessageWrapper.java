package entities;

import java.util.Observable;


public class MessageWrapper extends Observable 
{
	private MessageEvent message;
	
	private static MessageWrapper instance;
	
	private MessageWrapper()
	{
		//handle reflection
	}
	
	public synchronized static MessageWrapper getInstance()
	{
		if(instance == null)
		{
			instance = new MessageWrapper();
		}
		return instance;
	}
	
	public synchronized MessageEvent getMessageEvent()
	{
		return message;
	}
	
	public synchronized void setMessage(MessageEvent inputObject)
	{
		this.message = inputObject;
		measurementsChanged(inputObject);
	}
	
	private synchronized void measurementsChanged(MessageEvent message)
	{
		setChanged();
		notifyObservers(message);
	}

	
	
	
}
