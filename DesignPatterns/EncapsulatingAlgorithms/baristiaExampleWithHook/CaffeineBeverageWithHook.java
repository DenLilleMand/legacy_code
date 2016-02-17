package baristiaExampleWithHook;

public abstract class CaffeineBeverageWithHook
{
	/**
	 * prepareRecipe startede som abstract 
	 * sådan som vi har lavet den, men fordi de 2 klasser
	 * som extender den her begge 2 bruger den samme algoritme inde i metoden,
	 * altså den samme rækkefølge af metode kald + relativt samme metode kald
	 * vil vi prøve at abstrahere prepareRecipe op på det her niveau.
	 *På side 290-291 kan man se hvad vi går efter.
	 *Vi kan endda gøre den final hvis vi har lyst.
	 *Faktisk har vi lavet prepareRecipe om til det der hedder en
	 *template algorithm - og den tillader subclasses til at give
	 *os implementationen et vilkårligt antal af stepsne, som f.eks brew()
	 *og addCondiments() i vores tilfælde.
	 *
	 */
	public final void prepareRecipe()
	{
		boilWater();
		brew();
		pourInCup();
		if(customerWantsCondiments())
		{
			addCondiments();
		}
		
	}
	
	public abstract void brew();
	public abstract void addCondiments();
	
	public void boilWater()
	{
		System.out.println("Boiling water");
	}
	
	public void pourInCup()
	{
		System.out.println("Pour in cup");
	}
	
	/**
	 * hook
	 * @return
	 */
	public boolean customerWantsCondiments()
	{
		return true;
	}
}
