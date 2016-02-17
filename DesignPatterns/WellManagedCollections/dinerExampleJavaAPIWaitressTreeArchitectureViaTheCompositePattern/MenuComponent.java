package dinerExampleJavaAPIWaitressTreeArchitectureViaTheCompositePattern;

import java.util.Iterator;

public abstract class MenuComponent 
{
	/**
	 * add / remove/ getChild() er composite metoder
	 * @param menuComponent
	 */
	public void add(MenuComponent menuComponent)
	{
		throw new UnsupportedOperationException();
	}
	
	public void remove(MenuComponent menuComponent)
	{
		throw new UnsupportedOperationException();
	}
	
	public MenuComponent getChild(int i)
	{
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Resten af metoderne er Operation metoder,
	 * print() metoden gælder dog både for Menus og Menuitems.
	 * 
	 * @return
	 */
	public String getName()
	{
		throw new UnsupportedOperationException();
	}
	
	public String getDescription()
	{
		throw new UnsupportedOperationException();
	}
	
	public double getPrice()
	{
		throw new UnsupportedOperationException();
	}
	
	public boolean isVegetarian()
	{
		throw new UnsupportedOperationException();
	}
	
	public void print()
	{
		throw new UnsupportedOperationException();
	}
	
	public Iterator createIterator()
	{
		return null;
		
	}
}
