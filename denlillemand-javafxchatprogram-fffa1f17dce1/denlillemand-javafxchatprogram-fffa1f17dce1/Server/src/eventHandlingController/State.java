package eventHandlingController;

import java.util.ArrayList;

import entities.User;

public class State 
{
	//protected ArrayList<User> userList = new ArrayList<User>();
	protected ArrayList<Thread> threadList = new ArrayList<Thread>();
	protected ArrayList<User> onlineList = new ArrayList<User>();
	private static State instance;
	
	private State()
	{
		//handle reflection mb
	}
	
	public static State getInstance()
	{
		if(instance == null)
		{
			instance = new State();
		}
		return instance;
	}
	
//	public ArrayList<User> getUserList()
//	{
//		return userList;
//	}
	
	public void setUserOffline(User inputUser)
	{
		for(User user : onlineList)
		{
			if(user.getUserName().equalsIgnoreCase(inputUser.getUserName()));
			{
				user.setOnline(false);
			}
		}
	}

	public void setUserOnline(User inputUser)
	{
		for(User user : onlineList)
		{
			if(user.getUserName().equalsIgnoreCase(inputUser.getUserName()));
			{
				user.setOnline(true);
			}
		}
	}
	
	
}
