package entities;

import java.io.Serializable;


public class User implements Serializable
{
	private static final long serialVersionUID = 1L;
	private Boolean online;
	//public SimpleStringProperty userName;
	public String userName;
	public boolean newUser;
	private int id;
	public String userStatus; //this enum is kept as a String for Serialization purposes.
							  //tried to optimize it, but aparently the optimal way is to get
							  //some 3rd party library called xmlsomethingsomething. whatever...
	public User()
	{
	}
	
	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	

	/**factory methods: */
	public static User newFriend(String userName, String userStatus)
	{
		return new User(userName,false,userStatus);
	}
	
	public static User newUser(String userName, String userStatus)
	{
		return new User(userName,false,userStatus);
	}

	
	public int getId() 
	{
		return id;
	}
	
	public User copy()
	{
		return new User(getUserName(),isOnline(),getUserStatus());
	}
	
	public boolean isNewUser() {
		return newUser;
	}

	public void setNewUser(boolean newUser) {
		this.newUser = newUser;
	}

	public String getUserName()
	{
		return userName;
	}
	
	public Boolean isOnline()
	{
		return online;
	}
	
	public void setOnline(boolean online)
	{
		this.online = online;
	}
	
	public User(String userName, Boolean b,String userStatus)
	{
		this.userStatus = userStatus;
		this.userName = userName;
		this.online = b;
	}
}
