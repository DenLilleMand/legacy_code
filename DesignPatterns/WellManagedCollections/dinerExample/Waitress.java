package dinerExample;

import java.util.ArrayList;

public class Waitress 
{
	Menu pancakeHouseMenu;
	Menu dinerMenu;
	
	public Waitress(PancakeHouseMenu pancakeHouseMenu, DinerMenu dinerMenu)
	{
		this.pancakeHouseMenu = pancakeHouseMenu;
		this.dinerMenu = dinerMenu;
	}
	
	/**
	 * det her er implementationen af de 2 restauranters menuer,
	 * fordi den ene bruger et array og den anden bruger et forloop,
	 * og hvis det var 3 restauranter der skulle bindes sammen, s� ville 
	 * det v�re 3x loops - s� det her er s�dan som man IKKE skal g�re. jeg
	 * laver en seperat pakke til den rigtige implementation.
	 * 
	 * 
	 */
	
	
	
	/**
	 * Den gamle kode er her udkommenteret da de havde 2 forskellige
	 * interfaces, den nye kode kan findes p� side 334, og som den metode
	 * som ikke er udkommenteret. 
	 * @param dinerIterator2 
	 */
//	public void printMenu()
//	{
//		//prints every item on the menu
//		PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
//		ArrayList<MenuItem> breakfastItems = pancakeHouseMenu.getMenuItems();
//		
//		DinerMenu dinerMenu = new DinerMenu();
//		MenuItem[] lunchItems = dinerMenu.getMenuItems();
//		
//		for(int i = 0; i < breakfastItems.size(); i++)
//		{
//			MenuItem menuItem = (MenuItem)breakfastItems.get(i);
//			System.out.println(menuItem.getName() + " ");
//			System.out.println(menuItem.getPrice() + " ");
//			System.out.println(menuItem.getDescription() + " ");
//		}
//		
//		for(int i = 0; i < lunchItems.length; i++)
//		{
//			MenuItem menuItem = lunchItems[i];
//			System.out.println(menuItem.getName() + " ");
//			System.out.println(menuItem.getPrice() + " ");
//			System.out.println(menuItem.getDescription() + " ");
//		}
//	}
	/**
	 * det begynder at ligne noget, nu k�rer vi kun 1 l�kke,
	 * men de 2 iterators minder meget om hinanden, s� de burde faktisk dele den samme interface, s�dan
	 * at vi kan fjerne den konkrete implementation fra Waittress klassen, alts� de 2 client objekter. 
	 * det kunne v�re rart hvis waittress var fuldst�ndigt ligeglad med hvilken slags iterator der blev passet.
	 * Faktisk har vi ogs� lavet vores helt eget Iterator interface, men vi burde enblig bruge
	 * javas implementation, det her var kun for at se hvordan det fungerede. 
	 * s� vi vil ligge de 2 Iterators sammen ved at bruge javas egen implementation.
	 * i vores java interface klasse, er der ogs� en remove() metode,
	 * denne metode skal kaste en java.lang.UnsupportedOperationException hvis den
	 * ikke skal implementeres. og at enhver client burde checke for den her exception f�r
	 * der bliver brugt remove().
	 * det her er den gamle metode fra vores egen implementation
	 */
//	public void printMenu()
//	{
//		Iterator pancakeIterator =  pancakeHouseMenu.createIterator();
//		Iterator dinerIterator = dinerMenu.createIterator();
//		
//		System.out.println("MENU\n----\nBREAKFAST");
//		printMenu(pancakeIterator);
//		System.out.println("\nLUNCH");
//		printMenu(dinerIterator);
//	}
	
	public void printMenu()
	{
		java.util.Iterator pancakeIterator =  pancakeHouseMenu.createIterator();
		java.util.Iterator dinerIterator = dinerMenu.createIterator();
		
		System.out.println("MENU\n----\nBREAKFAST");
		printMenu(pancakeIterator);
		System.out.println("\nLUNCH");
		printMenu(dinerIterator);
	}
	/**
	 * i den gamle implementation burde der bare v�re Iterator istedet
	 * for javas version selF.
	 * @param iterator
	 */
	private void printMenu(java.util.Iterator iterator)
	{
		while(iterator.hasNext())
		{
			MenuItem menuItem = (MenuItem)iterator.next();
			System.out.println(menuItem.getName() + ", ");
			System.out.println(menuItem.getPrice() + " --- ");
			System.out.println(menuItem.getDescription());
		}
	}
	
	public void printBreakFastMenu()
	{
		//prints just breakfast items
	}
	
	public void printLunchMenu()
	{
		//prints just lunch items
	}
	
	public void printVegetarianMenu()
	{
		//prints all vegetarian menu items
	}
	
	public boolean isItemVegetarian(MenuItem item)
	{
		return false;
		//given the name of an item, returns true if so, returns false if isn't.
	}
	
}
