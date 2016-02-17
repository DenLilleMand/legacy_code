package opg3.dictionary;

public class MyDictionary<K,V> implements IDictionary<K,V>{

	private Entry<K,V>[] internalArray = (Entry<K,V>[]) new Entry[798];
	
	@Override
	public void add(K key, V value) throws Exception 
	{
		int result = findEmpty();
		if(result >= 0)
		{
			internalArray[result] = new Entry<K,V>(key,value); 
		}
		else
		{
			throw new Exception("Array is full.");
		}
	}
	
	private int findEmpty()
	{
		for(int i = 0; i<internalArray.length;i++)
		{
			if(internalArray[i] == null)
			{
				return i;
			}
		}
		return -1;
	}
	
	private int findElement(K key)
	{
		for(int i = 0; i<internalArray.length;i++)
		{
			if(internalArray[i] != null)
			{
				if(internalArray[i].getKey().equals(key))
				{
					return i;
				}				
			}
		}
		return -1;
	}

	@Override
	public V remove(K key) 
	{
		int index = findElement(key);
		V v =internalArray[index].getValue();
		internalArray[index] = null;
		return v;
	}

	@Override
	public V getValue(K key) 
	{
		int index = findElement(key);
		V v = internalArray[index].getValue();
		return v;
	}

	@Override
	public boolean contains(K key) 
	{
		if(findElement(key) == -1)
		{
			return false;
		}
		else{
			return true;
		}
	}
	

	@Override
	public boolean isEmpty() 
	{
		for(int i = 0; i<internalArray.length;i++)
		{
			if(internalArray[i] != null)
			{
				return false;
			}
		}
		return true;
	}

	@Override
	public int getSize() {
		return internalArray.length;
	}

	@Override
	public void clear() {
		internalArray = (Entry<K,V>[]) new Entry[798];
		
	}

}
