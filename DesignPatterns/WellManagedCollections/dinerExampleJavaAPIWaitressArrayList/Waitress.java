package dinerExampleJavaAPIWaitressArrayList;

import java.util.ArrayList;
import java.util.Iterator;
/**
 * side 341 forklare hvordan den nye model ser ud.
 * @author DenLilleMand
 *
 */
public class Waitress 
{
	ArrayList<Menu> menus;
	//der er en hashtable implementation som starter på side
	//347-353. viser også at man kan gøre dette med vectors og alle de andre
	//- men hvis de ikke implementere en iterator, så laver vi jo bare en selv til dem.
	
	
	public Waitress(ArrayList<Menu> menus)
	{
		this.menus = menus;
	}
	
	/**
	 * det her er implementationen af de 2 restauranters menuer,
	 * fordi den ene bruger et array og den anden bruger et forloop,
	 * og hvis det var 3 restauranter der skulle bindes sammen, så ville 
	 * det være 3x loops - så det her er sådan som man IKKE skal gøre. jeg
	 * laver en seperat pakke til den rigtige implementation.
	 * 
	 * 
	 * Den gamle kode er her udkommenteret da de havde 2 forskellige
	 * interfaces, den nye kode kan findes på side 334, og som den metode
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
	 * det begynder at ligne noget, nu kører vi kun 1 løkke,
	 * men de 2 iterators minder meget om hinanden, så de burde faktisk dele den samme interface, sådan
	 * at vi kan fjerne den konkrete implementation fra Waittress klassen, altså de 2 client objekter. 
	 * det kunne være rart hvis waittress var fuldstændigt ligeglad med hvilken slags iterator der blev passet.
	 * Faktisk har vi også lavet vores helt eget Iterator interface, men vi burde enblig bruge
	 * javas implementation, det her var kun for at se hvordan det fungerede. 
	 * så vi vil ligge de 2 Iterators sammen ved at bruge javas egen implementation.
	 * i vores java interface klasse, er der også en remove() metode,
	 * denne metode skal kaste en java.lang.UnsupportedOperationException hvis den
	 * ikke skal implementeres. og at enhver client burde checke for den her exception før
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
	
	/**
	 * den her kode er fed fordi vi har fjernet koblingen imellem typerne der bliver iterereret over
	 * fra Waitress klassen,
	 * men vi har stadig det problem at hver gang vi vil tilføje noget nyt til den her klasse,
	 * så skal vi ind og 
	 * men vi har 
	 */
	public void printMenu()
	{
		Iterator menuIterator = menus.iterator();
		while(menuIterator.hasNext())
		{
			Menu menu = (Menu)menuIterator.next();
			printMenu(menu.createIterator());
		}
	}
	/**
	 * i den gamle implementation burde der bare være Iterator istedet
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
