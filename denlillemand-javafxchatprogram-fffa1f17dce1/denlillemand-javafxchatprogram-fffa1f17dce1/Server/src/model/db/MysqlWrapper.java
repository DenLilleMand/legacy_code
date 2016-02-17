package model.db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import entities.User;
import entities.UserStatus;

public class MysqlWrapper extends Observable implements IMysqlDbWrapper
{
	private static MysqlWrapper instance = null;
	private static final String dbconnection = "jdbc:mysql://127.0.0.1:3306/examproject?user=root&password=denlilleiceman20";;
	private static final String DATABASENAME = "examproject";
	private static ResultSet rs;
	private static Connection con;
	private static CallableStatement cs;
	public static final String ZERO = "";
	private ArrayList<User> userList;
	
	private MysqlWrapper() throws Exception
	{
		if(instance != null)
		{
			throw new IllegalAccessException("Reflection/frameworks is not allowed!");
		}
			configuireDb();
			
	}
	
	
	
	public static MysqlWrapper getInstance()
	{
		if(instance == null)
		{
			try 
			{
				instance = new MysqlWrapper();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
	
	
	public void configuireDb() throws Exception
	{
		connectToDB() ;
	}
	
	private void connectToDB() throws Exception
	{
		closeConnection();
		con = DriverManager.getConnection(dbconnection);
	}
	
	private void closeConnection() throws Exception
	{
			if (con != null) 
			{
				con.close();
			}
	}
	
	@Override
	public Iterator<User> retrieveAllUsers() throws Exception
	{
		if(userList != null)
		{
			return userList.iterator();
		}
		cs = con.prepareCall("CALL "+DATABASENAME+".`retrieveAllUsers`()");
		rs = cs.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		ArrayList<User> userList = new ArrayList<User>();
		User user;
		while (rs.next()) {
			user = null;
			int count = rsmd.getColumnCount();
			for (int i = 1; i <= count; i++) {
				String col = rsmd.getColumnName(i);
				
				switch(col)
				{
					case "username":
					if (rs.getString(i).equals("null"))
					{
						continue;						
					}
					else
					{
						user = User.newUser(rs.getString(i),UserStatus.USER);	
					}	
						break;
				}
				if(user != null)
				{
					userList.add(user);					
				}
			}
		}
		this.userList = userList;
		return userList.iterator();
	}
	
	@Override
	public Iterator<User> retrieveAllUserFriends(User user) throws Exception
	{
		cs = con.prepareCall("CALL "+DATABASENAME+".`retrieveAllFriends`(?)");
		cs.setString(1, user.getUserName());
		rs = cs.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		ArrayList<User> friendList = new ArrayList<User>();
		User friend;
		while (rs.next()) 
		{
			friend = null;
			int count = rsmd.getColumnCount();
			for (int i = 1; i <= count; i++) {
				String col = rsmd.getColumnName(i);
				switch(col)
				{
					case "friend":
						friend = User.newFriend(rs.getString(i),UserStatus.FRIEND);	
						friendList.add(friend);	
						break;
				}
			}
		}
		return friendList.iterator();
	}
	
	@Override
	public void addFriend(User mainUser, User friendUser) throws Exception
	{
		cs = con.prepareCall("CALL "+DATABASENAME+".`addFriend`(?,?)");
		cs.setString(1, mainUser.getUserName());
		cs.setString(2, friendUser.getUserName());
		cs.execute();
		measurementsChanged();
	}
	
	@Override
	public void removeFriend(User mainUser, User friendUser) throws Exception
	{
		cs = con.prepareCall("CALL "+DATABASENAME+".`removeFriend`(?,?)");
		cs.setString(1, mainUser.getUserName());
		cs.setString(2, friendUser.getUserName());
		cs.execute();
		measurementsChanged();
		
	}
	
	private void measurementsChanged()
	{
		setChanged();
		notifyObservers();
	}

	@Override
	public void addUser(User user) throws Exception
	{
		cs = con.prepareCall("CALL "+DATABASENAME+".`addUser`(?)");
		cs.setString(1, user.getUserName());
		cs.execute();
		measurementsChanged();
	}

	@Override
	public Iterator<User> retrieveAllUserFriends(String key) throws Exception
	{
		cs = con.prepareCall("CALL "+DATABASENAME+".`retrieveAllFriends`(?)");
		cs.setString(1, key);
		rs = cs.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		ArrayList<User> friendList = new ArrayList<User>();
		User friend;
		while (rs.next()) 
		{
			friend = null;
			int count = rsmd.getColumnCount();
			for (int i = 1; i <= count; i++) {
				String col = rsmd.getColumnName(i);
				switch(col)
				{
					case "friend":
						friend = User.newFriend(rs.getString(i),UserStatus.FRIEND);	
						friendList.add(friend);	
						break;
				}
			}
		}
		return friendList.iterator();
	}



	@Override
	public void registerObserver(Observer observer) 
	{
		addObserver(observer);	
	}



	@Override
	public void removeObserver(Observer observer) 
	{
		removeObserver(observer);
	}
}
