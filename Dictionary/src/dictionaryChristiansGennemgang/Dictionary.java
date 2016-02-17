package dictionaryChristiansGennemgang;

public class Dictionary<Key, Value> implements IDictionary<Key, Value>
{
	
	@SuppressWarnings("unchecked")
	Entry<Key, Value>[] array = (Entry<Key, Value>[]) new Entry[10];
	private int currentIndex;
	
	
	@Override
	public void add(Key key, Value value) 
	{
		array[currentIndex++] = new Entry<Key, Value>(key,value);
	}

	@Override
	public void remove(Object key) 
	{
		for(int i = 0; i < array.length; i++)
		{
			if(array[i].getKey().equals(key))
			{
				array[i] = null;
			}
		}

	}

	@Override
	public Value getValue(Object key) 
	{
		for(int i = 0; i < array.length; i++)
		{
			if(array[i].getKey().equals(key))
			{
				return array[i].getValue();
			}
		}
		return null;
	}

	@Override
	public boolean contains(Object key) 
	{
		for(int i = 0; i < array.length; i++)
		{
			if(array[i].getKey().equals(key))
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isEmpty() 
	{
		if(array.length == 0) //bare fordi et arrays length er noget, betyder det ikke at arrayed ikke er tomt,
		return true;
		return false;
	}

	@Override
	public int getSize() 
	{
		return array.length;
	}

	@Override
	public void clear() 
	{
		
	}

}
