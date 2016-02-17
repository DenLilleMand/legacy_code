package dinerExample;
/**
 * vi kommer ikke til at implementere det her kode
 * så det kører ordentligt. men hvad man gerne vil vise følger:
 * 
 * OKAY lol .. begyndte at ændre vores egen implementation til Java's implementation, af
 * interfaced, ehm ... og halvvejs besluttede jeg så at copypaste package, sådan at 
 * vi både havde en vi selv havde implementeret og en fra java... men nu må man nød til at
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
	 * dette er præcis det samme stykke kode for både vores
	 * array og vores ArrayList.
	 * 
	 * og dette kan gøres fordi de begge implementere et Iterator interface der kræver en hasNext() 
	 * og next() metode -- og så gør den bare forskellige ting i baggrunden... hos arrayet ville den lave []
	 * operationer og på arraylisten bruger den bare get() - kan se ditte på side 331.
	 */
}
