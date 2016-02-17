package model.db;

import java.util.Iterator;
import java.util.Observer;

import entities.User;

/**
 * Adapter to make neo4j DB seem like a mysqldatabase.
 * @author denlillemand
 *
 */
public class Adapter implements IMysqlDbWrapper 
{
	private GraphDb graphDb;
	
	public Adapter(GraphDb graphDb)
	{
		this.graphDb = graphDb;
	}

	@Override
	public void configuireDb() throws Exception {
		//graphDb.configuireGraphDb();
		
	}

	@Override
	public Iterator<User> retrieveAllUsers() {
		//Graph<User> graph = graphDb.retrieveAllusersFromGraphDb()
		//return graph.iterator();
		return null;
	}

	@Override
	public Iterator<User> retrieveAllUserFriends(User user) {
		//Graph<User> graph = graphDb.retrieveAlluserFriendsFromGraphDb();
		//return graph.iterator();
		return null;
	}



	@Override
	public void addFriend(User mainUser, User friendUser) {
		//graphDb.addRelationship(mainUser,friendUser);
	}

	@Override
	public void removeFriend(User mainUser, User friendUser) {
//		graphDb.removeRelationship(mainUser, friendUser);
		
		
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterator<User> retrieveAllUserFriends(String key) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registerObserver(Observer observer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeObserver(Observer observer) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
	
}
