package map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class MitHashMap<K,V> implements Map<K,V>
{
	private final int MASK = 0x7FFFFFFF; // 2^32-1
	private int CAPACITY;
	private Entry<K,V>[] array;
	private static int size = 0;
	
	@SuppressWarnings("unchecked")
	public MitHashMap(int capacity)
	{
		this.CAPACITY = capacity;
		array =  new Entry[CAPACITY];
	}
	
	public MitHashMap()
	{
		this(797);
	}
	
	private int hash(K key) 
	{
		return (key.hashCode() & MASK) % CAPACITY;
	}
	
	/**
	 * Associates the specified value with the specified key in this map.
	 *  If the map previously 
	 * contained a mapping for the key, the old value is replaced.
	 */
	@Override
	public V put(K key, V value) 
	{
		assert key != null;
		assert value != null;
		int hashedIndex = hash(key); 
		Entry<K,V> newEntry = new MitEntry<K,V>(key,value);
		while (array[hashedIndex] != null) 
		{
			if(newEntry.getKey().equals(key))
			{
				array[hashedIndex] =  newEntry;
				return value;
			}
			hashedIndex += 1;  
		}
		if(reachedCapacity())
		{
			expandCapacity(size * 2);
		}
		size++; 
		array[hashedIndex] = newEntry;
		return array[hashedIndex].getValue();
	}
	
	private void expandCapacity(int newSize) {
		@SuppressWarnings("unchecked")
		Entry<K,V>[] newArray = new Entry[newSize];
		System.arraycopy(array, 0, newArray, 0, size);
		array = newArray;
		
	}

	private boolean reachedCapacity() {
		return size == CAPACITY;
	}

	@Override
	public V get(K key) 
	{
		int hashedIndex = hash(key);
		while(array[hashedIndex] != null)
		{
			if(array[hashedIndex].getKey().equals(key))
			{
				return array[hashedIndex].getValue();
			}
		}
		return null;
	}
	
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean containsKey(K key) {
		if(get(key) != null)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean containsValue(V value) 
	{
		for(int i = 0; i < array.length; i++)
		{
			if(array[i] != null)
			{
				if(array[i].getValue().equals(value))
				{
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public V remove(K key) 
	{
		int hashedIndex = hash(key); 
		while (array[hashedIndex] != null)
		{
			if(array[hashedIndex].getKey().equals(key))
			{
				Entry<K,V> temp = array[hashedIndex];
				array[hashedIndex] = null;
				return temp.getValue();
			}
		}
		return null;
	}

	@Override
	public void putAll(Map<K, V> map) 
	{
		assert map != null;
		for(K key : map.keySet())
		{
			put(key,map.get(key));
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() 
	{
		array = (Entry<K,V>[]) new Entry[CAPACITY];	
	}

	@Override
	public Set<K> keySet() {
		Set<K> set = new HashSet<>();
		for(int i = 0; i < array.length; i++)
		{
			Entry<K,V> entry = array[i];
			if(entry != null)
			{
				set.add(entry.getKey());
			}
		}
		return set;
	}

	@Override
	public Collection<V> values() 
	{
		Collection<V> collection = new ArrayList<>();
		for(int i = 0; i < array.length; i++)
		{
			Entry<K,V> entry = array[i];
			if(entry != null)
			{
				collection.add(entry.getValue());
			}
		}
		return collection;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		Set<Entry<K,V>> set = new HashSet<>();
		for(int i = 0; i < array.length; i++)
		{
			set.add(array[i]);
		}
		return set;
	}

	public int size() 
	{
		return size;
	}
	
	public class MitEntry<K,V> implements Entry<K,V>
	{
		K key;
		V value;
		
		public MitEntry(K key, V value)
		{
			this.key = key;
			this.value = value;
		}
		
		public K getKey()
		{
			return key;
		}
		
		public V getValue()
		{
			return value;
		}
		
		public void setKey(K key)
		{
			this.key = key;
		}
		
		@Override
		public V setValue(V value)
		{
			this.value = value;
			return value;
		}
	}

	
}
