package map;

public class ObjectReadyForHashMap 
{
	private String name;
	
	public ObjectReadyForHashMap(String name)
	{
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		assert obj != null;
		return name.equalsIgnoreCase(((ObjectReadyForHashMap) obj).getName());
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int hashCode()
	{
		int hash=7;
		for (int i=0; i < name.length(); i++) 
		{
		    hash = hash*31+name.charAt(i); //pseudeu recursion.
		}
		return hash;
		
    }
	
	}
	

