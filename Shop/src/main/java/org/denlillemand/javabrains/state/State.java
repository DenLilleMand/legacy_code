package org.denlillemand.javabrains.state;

public class State 
{
	private static State instance;
	
	private State()
	{
		//handle reflection
	}
	
	public static State getInstance()
	{
		if(instance == null)
		{
			instance = new State();
		}
		return instance;
	}
}
