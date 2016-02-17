package mattisprojektObserver;

import java.util.ArrayList;
import java.util.Observable;

public class ArrayListWrapper extends Observable
{
	private ArrayList<Person> personList = new ArrayList<Person>();
	
	public ArrayListWrapper()
	{
		for(int i = 0; i <10; i++)
		{
			personList.add(new Person("herpderp"+i));
		}
	}
	
	public ArrayList<Person> getList()
	{
		return personList;
	}
	
	
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
	
	
}
