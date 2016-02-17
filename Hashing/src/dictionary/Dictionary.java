package dictionary;

public class Dictionary<K,V>
{
	private int SIZE = 797;//fordi 797 er et prim tal.
	Entry[] intervalArray = new Entry[SIZE]; 
	
	
	public void add(K key, V value)
	{
		Entry<K, V> newEntry = new Entry(key, value);
		//beregn hascode og index
		//brug index til at indsætte entry i array'et
		//hvis der er plads. Hvis ikke plads: tilføj til eksisterende
		//entrys linked list.
	}
	
	public int hashCode(K key)
	{
		//definer et g (kontant, int).
		int hash = 0;
		int n = ((String) key).length();
		for (int i=0; i < n; i++)
		{
			hash = g * hash + s.charAt(i);
		}
		//beregn hashcode ud fra key
		// antag evt at key er en String, fremtidigt burde kunne håndtere alle typer.
		//result = 
	}
	
	public int calculateIndex(int hashCode)
	{
		
	}
	
}
