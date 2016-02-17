package dinerExampleJavaAPI;
/**
 * vi kommer ikke til at implementere det her kode
 * s� det k�rer ordentligt. men hvad man gerne vil vise f�lger:
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
	 * dette er pr�cis det samme stykke kode for b�de vores
	 * array og vores ArrayList.
	 * 
	 * og dette kan g�res fordi de begge implementere et Iterator interface der kr�ver en hasNext() 
	 * og next() metode -- og s� g�r den bare forskellige ting i baggrunden... hos arrayet ville den lave []
	 * operationer og p� arraylisten bruger den bare get() - kan se ditte p� side 331.
	 */
}
