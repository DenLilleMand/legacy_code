package decoratorImplementation;

import java.util.ArrayList;

import entities.IArrayListWrapper;
import entities.User;

public class LoggerDecorator implements IArrayListWrapper{
	
	private IArrayListWrapper arrayListWrapper;
	public LoggerDecorator(IArrayListWrapper arrayListWrapper)
	{
		this.arrayListWrapper = arrayListWrapper;
	}
	
	@Override
	public void removeUser(User user) {
		System.out.println("LoggerDecorator removeing:" + user);
		arrayListWrapper.removeUser(user);
		
	}

	@Override
	public ArrayList<User> getUserList() {
		System.out.println("LoggerDecorator getting user list");
		return arrayListWrapper.getUserList();
	}

	@Override
	public void addUser(User user) {
		System.out.println("adding user:" + user);
		arrayListWrapper.addUser(user);
		
	}

	@Override
	public boolean setUserOffline(User inputUser) {
		System.out.println("Setting user offline:" + inputUser);
		return arrayListWrapper.setUserOffline(inputUser);
	}

	@Override
	public void setOnline(User iterateUser) 
	{
		System.out.println("setting user online:" + iterateUser);
		arrayListWrapper.setOnline(iterateUser);
		
	}
	
}
