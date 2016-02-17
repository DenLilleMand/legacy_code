package state;

import java.io.Serializable;
import entities.User;
import entities.UserStatus;

public class State implements Serializable, Cloneable //ikke særlig singleton :)
{
	public static State instance = null;
	private User jspUser = new User("jspclient", true,UserStatus.USER,false);
	
	public static State getInstance()
	{
		if(instance == null)
		{
			instance = new State();
		}
		return instance;
	}
	
	private State()
	{
		if(instance != null)
		{
			throw new IllegalStateException();
		}
	}
	
	public User getUser()
	{
	    return jspUser;
	}
	
	
	
}
