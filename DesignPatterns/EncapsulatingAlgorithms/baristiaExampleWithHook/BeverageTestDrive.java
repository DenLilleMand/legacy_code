package baristiaExampleWithHook;
/**
 * på side 300 kan man læse mere præcist hvornår man skal bruge en abstract metode
 * og hvornår man skal lave en konkret metode samt evt. implementere hooks.
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
