package model;

public class User {
	private String userName;
	private String password;
	private String userId;
	
	
	public String getPassword() 
	{
		return password;
	}
	
	public void setPassword(String password) 
	{
		this.password = password;
	}
	
	public String getUserName() 
	{
		return userName;
	}
	
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}
	
	public String getUserId() 
	{
		return userId;
	}
	
	public void setUserId(String userId) 
	{
		this.userId = userId;
	}
}