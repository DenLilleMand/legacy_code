package entities;

import java.util.ArrayList;

public interface IArrayListWrapper 
{
	public void removeUser(User user);

	public ArrayList<User> getUserList();


	public void addUser(User user);

	public boolean setUserOffline(User inputUser);

	public void setOnline(User iterateUser);
}
