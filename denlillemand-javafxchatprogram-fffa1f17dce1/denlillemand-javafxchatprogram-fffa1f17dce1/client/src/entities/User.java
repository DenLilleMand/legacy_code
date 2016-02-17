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
	
	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	
	public User copy()
	{
		return new User(getUserName(),isOnline(),getUserStatus(),isNewUser());
	}
	
	public User()
	{
	}

	/**factory pattern: */
	public static User newFriend(String userName)
	{
		return new User(userName,false,UserStatus.FRIEND,false);
	}
	
	public static User newUser(String userName)
	{
		return new User(userName,false,UserStatus.USER, false);
	}

	
	public int getId() 
	{
		return id;
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
	
	public User(String userName, Boolean b,String userStatus, boolean isNewUser)
	{
		this.userStatus = userStatus;
		this.userName = userName;
		this.online = b;
		this.newUser = isNewUser;
	}
}
