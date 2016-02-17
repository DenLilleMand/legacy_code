package control;

import java.util.Iterator;

import entities.User;
import model.db.IMysqlDbWrapper;
import model.db.MysqlWrapper;

public class DbController 
{
	public IMysqlDbWrapper dbWrapper = MysqlWrapper.getInstance();
	private static DbController instance = null;
	
	/**har en queue. nu når vi har med et singleton objekt at gøre. så hver gang nogle
	tilføjer et query til databasen, så ligger vi det i en queue, der kører en task, 
	Vores umiddelbare største problem med dette er at vi skal have en baggrundstråd,
	kørende blockingQueue, der hele tiden prøver at execute queries. 
	Så må vi se hvad der sker  når vi kører en while(true)
	der gør det. En god ide kunne være at bruge JavaFX Task. eller kigge på en executor service.
	
	*/
	private DbController()
	{
		if(instance != null)
		{
			throw new IllegalStateException();
		}
	}
	
	public static DbController getInstance()
	{
		if(instance == null)
		{
			instance = new DbController();
		}
		return instance;
	}
	
	public void setMysqlDbWrapper(IMysqlDbWrapper dbWrapper)
	{
		this.dbWrapper = dbWrapper;
	}
	
	
	
	public void addFriend(User mainUser, User friend)
	{
		try 
		{
			dbWrapper.addFriend(mainUser, friend);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void removeFriend(User mainUser, User friend)
	{
		try 
		{
			dbWrapper.removeFriend(mainUser, friend);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	public void addUser(User user) throws Exception
	{
		dbWrapper.addUser(user);
	}
	
	public Iterator<User> retrieveAllUserFriends(User user) throws Exception
	{
		return dbWrapper.retrieveAllUserFriends(user);
	}
}
