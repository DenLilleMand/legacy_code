package baristiaExample;

public abstract class CaffeineBeverage 
{
	/**
	 * prepareRecipe starter som abstract 
	 * sådan som vi har lavet den, men fordi de 2 klasser
	 * som extender den her begge 2 bruger den samme algoritme inde i metoden
	 * vil vi prøve at abstrahere den op på det her niveau.
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
		addCondiments();
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
}
