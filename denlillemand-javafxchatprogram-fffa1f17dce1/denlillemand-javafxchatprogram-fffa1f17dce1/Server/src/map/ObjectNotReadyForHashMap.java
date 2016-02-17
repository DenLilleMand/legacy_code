package map;

public class ObjectNotReadyForHashMap 
{
	private String name;
	private int hey;
	
	public ObjectNotReadyForHashMap(String name, int hey)
	{
		this.name = name;
		this.hey = hey;
	}
	
//	@Override
//	public boolean equals(Object obj)
//	{
//		return name.equalsIgnoreCase(((ObjectNotReadyForHashMap) obj).getName());
//	}
//	
//	@Override
//	public int hashCode()
//	{
//		int hash=7;
//		for (int i=0; i < name.length(); i++) 
//		{
//		    hash = hash*31+name.charAt(i); //pseudeu recursion.
//		}
//		return hash;
//    }
//	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	}
	

