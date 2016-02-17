package entities;

import java.util.ArrayList;
import java.util.Observable;

import decoratorImplementation.FakeAbstractClass;
/**
 * Jeg ved ikke helt om det her er en ordentlig m�de at g�re det p�, men jeg tror hvertfald der er 
 * nogle problemer med at intet er synkroniseret.
 * @author DenLilleMand
 *
 */
public class ArrayListWrapper extends FakeAbstractClass implements IArrayListWrapper
{
	private ArrayList<User> userList = new ArrayList<User>();
	private static ArrayListWrapper instance; 
	
	private ArrayListWrapper()
	{
		//handle reflection
	}
	
	public static ArrayListWrapper getInstance()
	{
		if(instance == null)
		{
			instance = new ArrayListWrapper();
		}
		return instance;
	}

	
	public void removeUser(User user)
	{
		user.setOnline(false);
		userList.remove(user);
	}
	
	public ArrayList<User> getUserList()
	{
		return userList;
	}
	
	
	public void addUser(User user) 
	{
		userList.add(user);
	}

	public boolean setUserOffline(User inputUser) {
		inputUser.setOnline(false);
		User copiedUser = null;
		for(User user : userList)
		{
			if(user.getUserName().equalsIgnoreCase(inputUser.getUserName()))
			{
				copiedUser = user.copy();
				copiedUser.setOnline(false);
				return true;
			}
		}
		return false;
	}
	public void setOnline(User iterateUser) {
		iterateUser.setOnline(true);
		User copiedUser = iterateUser.copy();
		copiedUser.setOnline(true);
		
	}
}
