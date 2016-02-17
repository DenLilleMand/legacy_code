package decoratorImplementation;

import java.util.ArrayList;
import java.util.Observable;

import entities.IArrayListWrapper;
import entities.User;

public class ObservableDecorator extends Observable implements IArrayListWrapper{
	IArrayListWrapper arrayListWrapper;
	
	public ObservableDecorator(IArrayListWrapper arrayListWrapper)
	{
		this.arrayListWrapper = arrayListWrapper;
	}

	@Override
	public void removeUser(User user) 
	{
		arrayListWrapper.removeUser(user);
		measurementsChanged(user);
	}

	@Override
	public ArrayList<User> getUserList() {
		return arrayListWrapper.getUserList();
	}

	private void measurementsChanged(User user)
	{
		setChanged();
		notifyObservers(user);
	}


	@Override
	public void addUser(User user) {
		arrayListWrapper.addUser(user);
		measurementsChanged(user);	
		
	}

	@Override
	public boolean setUserOffline(User inputUser) 
	{
		if(arrayListWrapper.setUserOffline(inputUser))
		{
			measurementsChanged(inputUser);		
			return true;
		}
		return false;
		
	}

	@Override
	public void setOnline(User iterateUser)
{
		arrayListWrapper.setOnline(iterateUser);
		measurementsChanged(iterateUser);	
	}

}
