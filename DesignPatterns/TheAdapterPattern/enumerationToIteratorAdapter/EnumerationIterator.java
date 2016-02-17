package enumerationToIteratorAdapter;

import java.util.Enumeration;
/**
 * vi kan selF også få brug for at lave en iterator
 * om til en Enumerator - sådan at vi har suppport i noget
 * legacy kode ... men det er jo præcis det samme som det her. 
 * @author DenLilleMand
 *
 */
public class EnumerationIterator {
	Enumeration enumeration;
	
	public EnumerationIterator(Enumeration enumeration)
	{
		this.enumeration = enumeration;
	}
	
	public boolean hasNext()
	{
		return enumeration.hasMoreElements();
	}
	
	public Object next()
	{
		return enumeration.nextElement();
	}
	
	public void remove()
	{
		throw new UnsupportedOperationException();
	}
	
	
}
