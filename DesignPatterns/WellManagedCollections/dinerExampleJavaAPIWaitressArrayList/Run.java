package dinerExampleJavaAPIWaitressArrayList;
/**
 * vi kommer ikke til at implementere det her kode
 * så det kører ordentligt. men hvad man gerne vil vise følger:
 *
 * 
 * definition.
 * 
 * the iterator pattern provides a way to access the elements of 
 * an aggregate object sequentially without exposing its underlying 
 * representation.
 * 
 * 
 * 
 * @author DenLilleMand
 *
 */
public class Run {
	
	/**
	 * nyeste stykke kode som burde virke med en
	 * kombineret iterator:
	 */
	public static void main(String[] args)
	{
		PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
		DinerMenu dinerMenu = new DinerMenu();
		CafeMenu cafeMenu = new CafeMenu();
		
		Waitress waitress = new Waitress(pancakeHouseMenu,dinerMenu,cafeMenu);
		waitress.printMenu();
			
	}
//	Iterator iterator = breakfastMenu.createIterator();
//	
//	while(iterator.hasNext())
//	{
//		MenuItem menuItem = (MenuItem) iterator.next();
//	}
	/**
	 * dette er præcis det samme stykke kode for både vores
	 * array og vores ArrayList.
	 * 
	 * og dette kan gøres fordi de begge implementere et Iterator interface der kræver en hasNext() 
	 * og next() metode -- og så gør den bare forskellige ting i baggrunden... hos arrayet ville den lave []
	 * operationer og på arraylisten bruger den bare get() - kan se ditte på side 331.
	 */
}
