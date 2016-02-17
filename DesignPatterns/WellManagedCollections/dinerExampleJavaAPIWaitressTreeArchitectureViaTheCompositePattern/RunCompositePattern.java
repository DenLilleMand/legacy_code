package dinerExampleJavaAPIWaitressTreeArchitectureViaTheCompositePattern;
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
 * Definition p� The Composite Pattern:"The Composite Pattern
 * allows you to compose objects into tree structures to 
 * represent part-whole hierarchies. Composite lets clients
 * treat individual objects and compositions of objects uniformly. "
 * 
 * OKAY! ... man m� nok lige g� tilbage i bogen og tjekke det der CompositePattern ud - 
 * jeg forst�r det sku ikke helt :) .. det er lidt for mange kald rundt og for mange ting der bliver
 * givet ind som parametre ,, desuden mangler nogle af klasserne m�ske nogle metoder, f.eks er det underligt
 * at vores MenuComponent returner en null Iterator, den burde m�ske have noget at g�re med CompositeIteratoreren,
 * eller ogs� h�nger det s�dan sammen at vores  tree-struktur fra vores forrige eksempel, hvor der bliver
 * itereret recursivt er det man stadig bruger i vores MenuItem og MenuComponent, imens hvis man skal vide
 * noget specifikt som alle de menuer som er vegatarer - s� skal man bruge en composite fordi den er exstern og giver
 * mere kontrol(men selF ogs� mere ansvar) . Jeg hopper videre til singleton Pattern . 
 * 
 * 
 * 
 * @author DenLilleMand
 *
 */
public class RunCompositePattern {
	
	
	public static void main(String[] args)
	{
		MenuComponent pancakeHouseMenu = new Menu("PANCAKE HOUSE MENU", "BreakFast");
		MenuComponent cafeMenu = new Menu("CAFE HOUSE MENU", "Lunch");
		MenuComponent dinerMenu = new Menu("DINER HOUSE MENU", "Dinner");
		MenuComponent dessertMenu = new Menu(" DESSERT MENU", "Dessert");
	
		MenuComponent allMenus = new Menu("ALL MENUS", "All Menus Combined");
		
		allMenus.add(pancakeHouseMenu);
		allMenus.add(dinerMenu);
		allMenus.add(cafeMenu);
		
		//add menu items here
		
		dinerMenu.add(new MenuItem("Pasta", "Spaghetti with Marianara Sauce, and a slice"
				+ " of sourdough bread",true,3.89));
		
		dinerMenu.add(dessertMenu);
		
		dessertMenu.add(new MenuItem("Apple Pie", "Apple pie with a flakey crust, topped with vanilla icecream",true,159));
		
		//add more menu items here
		
		
		Waitress waitress = new Waitress(allMenus);
		
		//waitress.printMenu();
		waitress.printVegetarianMenu();
	}

	
}
