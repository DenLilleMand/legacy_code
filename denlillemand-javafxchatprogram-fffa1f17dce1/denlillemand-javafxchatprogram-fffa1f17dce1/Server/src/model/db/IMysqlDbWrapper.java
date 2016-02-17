package model.db;

import java.util.Iterator;
import java.util.Observer;

import entities.User;

public interface IMysqlDbWrapper {

	public void configuireDb() throws Exception;
	public Iterator<User> retrieveAllUsers() throws Exception;
	
	public Iterator<User> retrieveAllUserFriends(User user) throws Exception;

	public void addFriend(User mainUser, User friendUser) throws Exception;
	
	public void removeFriend(User mainUser, User friendUser) throws Exception;
	public void addUser(User user) throws Exception;
	public Iterator<User> retrieveAllUserFriends(String key) throws Exception;
	public void registerObserver(Observer observer);
	public void removeObserver(Observer observer);
	
}
