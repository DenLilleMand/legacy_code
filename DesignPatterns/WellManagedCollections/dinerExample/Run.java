package dinerExample;
/**
 * vi kommer ikke til at implementere det her kode
 * s� det k�rer ordentligt. men hvad man gerne vil vise f�lger:
 * 
 * OKAY lol .. begyndte at �ndre vores egen implementation til Java's implementation, af
 * interfaced, ehm ... og halvvejs besluttede jeg s� at copypaste package, s�dan at 
 * vi b�de havde en vi selv havde implementeret og en fra java... men nu m� man n�d til at
 * fjerne remove metoden + fjerne java.util.Iterator implementationer i den her pakke. 
 * ps - jeg tror at det er bedst at holde sig til javas interface med remove() metoden osv.
 * det virker til at den eneste grund til at vi implementerede det selv var at 
 * vi skulle vide hvordan det foregik.
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
		
		Waitress waitress = new Waitress(pancakeHouseMenu,dinerMenu);
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
