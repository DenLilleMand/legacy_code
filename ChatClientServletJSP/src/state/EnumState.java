package state;

import entities.User;
import entities.UserStatus;
public enum EnumState
{
		INSTANCE;
	    private User jspUser = new User("jspclient", true,UserStatus.USER,false);
	    public User getUser()
	    {
	    	return jspUser;
	    }
	    EnumState()
	    {
	        
	    }

	    public static EnumState getInstance()
	    {
	        return INSTANCE;
	    }

	}
	
