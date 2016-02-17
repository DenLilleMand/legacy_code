package baristiaExampleWithHook;
/**
 * p� side 300 kan man l�se mere pr�cist hvorn�r man skal bruge en abstract metode
 * og hvorn�r man skal lave en konkret metode samt evt. implementere hooks.
 * @author DenLilleMand
 *
 */
public class BeverageTestDrive 
{
	public static void main(String [] args)
	{
		TeaWithHook teaHook = new TeaWithHook();
		CoffeeWithHook coffeeHook = new CoffeeWithHook();
		
		System.out.println("Making Tea w/ hook...");
		teaHook.prepareRecipe();
		System.out.println("Making Coffee w/ hook...");
		coffeeHook.prepareRecipe();
	}
	
	
	
}
