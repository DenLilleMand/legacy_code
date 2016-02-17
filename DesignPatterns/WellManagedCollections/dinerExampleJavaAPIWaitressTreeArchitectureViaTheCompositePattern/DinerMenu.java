package dinerExampleJavaAPIWaitressTreeArchitectureViaTheCompositePattern;

import java.util.Iterator;

public class DinerMenu extends Menu{
	static final int MAX_ITEMS = 6;
	private int numberOfItems = 0;
	MenuItem[] menuItems;
	
	public DinerMenu()
	{
		super("","");
		menuItems = new MenuItem[MAX_ITEMS];
		
		addItem("Vegetarian BLT","(Fakin') Bacon with lettuce & tomato on a whole wheat",
				true, 2.99);
		
		addItem("BLT","Bacon with lettuce & tomato on whole wheat", false, 2.99);
		
		addItem("Soup of the day","Soup of the Day, with a side of potato salad", false,3.29);
		
		addItem("Hotdog", "A hot dog, with saurkraut, relish, onions, topped with cheese", false,3.05);
		
		/**
		 * a couple of other Diner Menu Items added here:
		 */
	}
	
	public Iterator createIterator()
	{
		return new DinerMenuIterator(menuItems);
	}

	private void addItem(String name, String description, boolean vegetarian, double price) 
	{
		MenuItem menuItem = new MenuItem(name, description, vegetarian,price);
		if(numberOfItems >= MAX_ITEMS)
		{
			System.out.println("Sorry, menu is full! Can't add item to menu");
		}
		else 
		{
			menuItems[numberOfItems] = menuItem;
			numberOfItems = numberOfItems + 1;
		}
	}


	
	/**
	 * 'We're not going to need the getMenuItems()
	 * method anymore and in fact, we don't want it
	 * because it exposes our internal implementation.
	 */
//	public MenuItem[] getMenuItems()
//	{
//		return menuItems;
//	}
	
	/**
	 * Other menu methods here:
	 */
}
