package sets;

import entity.Student;

public class Set<T> implements SetInterface<T>
{
	private int index = 0;
	private T[] setArray;
	
	
	public Set(int size) 
	{
		setArray = (T[]) new Object[size];
	}


	public boolean isEmpty()
	{
		if(setArray[0] == null)
			return true;
		return false;
	}
	
	
	public int size()
	{
		return index; //vi skal jo svare tilbage hvor vi er kommet til, og det er ikke +1 fordi
					  //den altid peger på den næste plads.
	}
	
	
	public void add(T item)
	{
		setArray[index] = item;
		index++;
	}
	
	public void contains(T item)
	{
		
	}
	/**
	 * Create a new set of elements that appears in both this and the other set.
	 * @param other
	 * @return
	 */
	public Set<T> union(Set<T> other)
	{
		return other;
	}
	/** 
	 * Creates a new set of elements that in this set but not the other set.
	 * @param other
	 * @return
	 */
	public Set<T> intersection(Set<T> other)
	{
		Set<T> resultSet = new Set<T>(other.size());
		for(int i = 0; i < setArray.length; i++)
		{
			for(int j = 0; j < other.size();i++)
			{
				//
				if(setArray[i] == other[j])
				{
					whatToDelete.append("{"+currentStudentIds[i]+"}");
				}
			}
		}
		
		
		return resultSet;
	}
	
	
	public void removeAll()
	{
		
	}
	
	public String setStudentIds(int[] newFagIds, Student student)
	{
		int[] currentStudentIds = student.getFagIds();
		StringBuilder whatToDelete = new StringBuilder("This is what we have to delete:");
		for(int i = 0; i < currentStudentIds.length; i++)
		{
			for(int j = 0; j < newFagIds.length;i++)
			{
				//hvis de matcher så skal vi lade den være, hvis den er i newFagIds, men ikke i 
				//currentStudentIds så skal den tilføjes, og hvis den er i currentStudentIds men ikke
				//i newFagIds så skal den slettes og dermed tilføjes til vores whatToDelete
				if(currentStudentIds[i] == newFagIds[j]) //får jeg en nullPointer her eller et match?
				{
					whatToDelete.append("{"+currentStudentIds[i]+"}");
				}
			}
		}
		return whatToDelete.toString();
	}
	
	public int[] returnFagIdsForStudent(T item)
	{
		return ((Student) item).getFagIds();
	}
}
