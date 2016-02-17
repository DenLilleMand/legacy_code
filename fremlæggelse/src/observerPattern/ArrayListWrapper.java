package observerPattern;

import java.util.ArrayList;
import java.util.Observable;

public class ArrayListWrapper extends Observable
{
	private static ArrayListWrapper instance;
	private ArrayList<Person> personList = new ArrayList<Person>();
	
	public void addPerson(Person person)
	{
		personList.add(person);
		measurementsChanged(person);
	}
	
	public void measurementsChanged(Person person)
	{
		setChanged();
		notifyObservers(person);
	}
	
	public void removePerson(Person person)
	{
		personList.remove(person);
		measurementsChanged(person);
	}
	
	private ArrayListWrapper()
	{
		//handle reflection
	}
	
	public static ArrayListWrapper getInstance()
	{
		if(instance != null)
		{
			Person person = new Person();
			
			for(int i = 0; i < 9; i++)
			{u
				personList.add(person);
			}
			instance = new ArrayListWrapper();
		}
		return instance;
	}
	
	
	
	
	
	
	
	
	
	
}
