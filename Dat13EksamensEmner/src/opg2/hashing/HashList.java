package opg2.hashing;

import java.util.LinkedList;


public class HashList<K,V> {
	
	private Entry<K,V>[] internalArray = (Entry<K,V>[]) new Entry[size];
	private static int size = 5;
	
	public HashList()
	{
		
	}
	
	public void add(K key, V value) throws Exception
	{
		int h = hashCode(key);
		System.out.println("add: " + h);
		
		int index = calculateIndex(h);
		System.out.println("calIndex: " + index);
		if(internalArray[index] != null)
		{
			int i=  findEmpty(index);
			if(i == -1)
			{
				throw new Exception("array is full");
			}
			internalArray[i] = new Entry<K,V>(key, value);
		}
		else
		{
			internalArray[index] = new Entry<K,V>(key, value);
		}
	}
	
	private int findEmpty(int index) {
		for(int i = index; i < size;i++)
		{
			if(internalArray[i] == null)
			{
				return i;
			}
		}
		
		for(int i = 0; i < index;i++)
		{
			if(internalArray[i] == null)
			{
				return i;
			}
		}
		return -1;
	}
	
	private int findElement(int index, K key) {
		for(int i = index; i < size;i++)
		{
			System.out.println("findElement: " + internalArray[i].getKey() + " key: " + key);
			if(internalArray[i].getKey() == key)
			{
				return i;
			}
		}
		
		for(int i = 0; i < index;i++)
		{
			System.out.println("findElement: " + internalArray[i].getKey() + " key: " + key);
			if(internalArray[i].getKey() == key)
			{
				return i;
			}
		}
		return -1;
	}

	public int hashCode(K key)
	{
		int g = 10;
		int hash = 0;
		int n = key.toString().length();
		for (int i=0; i < n; i++)
		{
			hash = g * hash + key.toString().charAt(i);
		}
		return hash;
	}
	
	public int calculateIndex(int hashCode)
	{
		
		return hashCode % size ;
	}

	public int noOfElements() {
		int i = 0;
		for(Entry e : internalArray)
		{
			if(e != null)
			{
				i++;
			}
		}
		return i;
	}

	public Object get(K key) {
		int hashcode = hashCode(key);
		int index = calculateIndex(hashcode);
		System.out.println("get: " + internalArray[index].getKey());
		if(internalArray[index].getKey() != key)
		{
			int newIdx = findElement(index, key);
			if(newIdx != -1)
			{
				return internalArray[newIdx].getValue();
			}
		}
		else
		{
			return internalArray[index].getValue();
		}
		return null;
	}
}
