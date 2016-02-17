package dinerExampleJavaAPIWaitressArrayList;

import java.util.HashMap;
import java.util.Iterator;

public class CafeMenu implements Menu
{
	HashMap<String,Object>menuItems = new HashMap<String,Object>();
	
	public CafeMenu()
	{
		addItem("Veggie Burger and Air Fries","Veggie burger on a whole wheat bun,"
				+ "lettuce, tomato and fries",true,3.99);
	}

	private void addItem(String name, String description, boolean vegetarian, double price) 
	{
		MenuItem menuItem = new MenuItem(name,description,vegetarian,price);
		menuItems.put(menuItem.getName(),menuItem);
	}

	@Override
	public Iterator createIterator() 
	{
		return menuItems.values().iterator();
	}
	
	/**
	 * Har selF ikke brug for den her metode,
	 * fordi den viser vores interne implementation,
	 * vi har ikke lyst til at misse katte begynder at fjolle med
	 * den.
	 * @return
	 */
//	public HashMap getItems()
//	{
//		return menuItems;
//	}
	
	
}
