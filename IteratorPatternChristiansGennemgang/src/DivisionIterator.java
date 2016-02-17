import java.util.Iterator;

public class DivisionIterator<T> implements Iterator<T> 
{

	T[] vps;
	private int currentLocation;

	

	public DivisionIterator(T[] inputVps)
	{
		vps = inputVps;
		currentLocation = 0;
	}

	
	@Override
	public boolean hasNext() 
	{
		int index = currentLocation;
		if(vps[index++] == null)
		{
			return false;
		}
		return true;
	}

	@Override
	public T next() 
	{
		return vps[currentLocation++];
	}
	
	public int size()
	{
		return vps.length;
	}

	public void remove()
	{
		vps[currentLocation] = vps[vps.length-1];
		vps[vps.length-1] = null;
	}

	

}
