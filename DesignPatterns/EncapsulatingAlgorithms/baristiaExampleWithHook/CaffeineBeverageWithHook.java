package baristiaExampleWithHook;

public abstract class CaffeineBeverageWithHook
{
	/**
	 * prepareRecipe startede som abstract 
	 * s�dan som vi har lavet den, men fordi de 2 klasser
	 * som extender den her begge 2 bruger den samme algoritme inde i metoden,
	 * alts� den samme r�kkef�lge af metode kald + relativt samme metode kald
	 * vil vi pr�ve at abstrahere prepareRecipe op p� det her niveau.
	 *P� side 290-291 kan man se hvad vi g�r efter.
	 *Vi kan endda g�re den final hvis vi har lyst.
	 *Faktisk har vi lavet prepareRecipe om til det der hedder en
	 *template algorithm - og den tillader subclasses til at give
	 *os implementationen et vilk�rligt antal af stepsne, som f.eks brew()
	 *og addCondiments() i vores tilf�lde.
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
