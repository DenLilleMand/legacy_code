package opg2.hashing;

import java.util.LinkedList;


public class HashListLinked<K,V> {
	
	private Entry<K,V>[] internalArray = (Entry<K,V>[]) new Entry[size];
	private static int size = 5;
	
	public HashListLinked()
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
			Entry<K,V> e =  findEmpty(internalArray[index]);
			e.setNext(new Entry<K,V>(key, value));
		}
		else
		{
			internalArray[index] = new Entry<K,V>(key, value);
		}
	}
	
	private  Entry<K, V> findEmpty( Entry<K, V> e) {

			if(e.getNext() == null)
			{
				return e;
			}
			else
			{
				findEmpty(e.getNext());
			}
		return null;
	}
	
	private Entry<K, V> findElement(Entry<K, V> entry, K key) {
		if(entry.getKey() == key)
		{
			System.out.println("findEle: " + entry.getKey() + " key: " + key);
			return entry;
		}
		else
		{
			return findElement(entry.getNext(),key);
		}
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
				if(e.getNext() != null)
				{
					i++;
				}
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
			Entry<K,V> e = findElement(internalArray[index], key);
			System.out.println("get: " + e.getKey() + "   " + e.getValue());
			return e.getValue();
		}
		else
		{
			return internalArray[index].getValue();
		}
	}
}
