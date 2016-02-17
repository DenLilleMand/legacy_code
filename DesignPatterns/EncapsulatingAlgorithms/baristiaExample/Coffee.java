package baristiaExample;

public class Coffee extends CaffeineBeverage
{
	/**
	 * prepare recipe er den sammen
	 * kald order som med Te's prepareRecipe,
	 * s� derfor har vi t�nkt os at abstrahere den op p� 
	 * CaffeineBeverage niveau
	 */
//	public void prepareRecipe()
//	{
//		boilWater();
//		brewCoffeeGrinds();
//		pourInCup();
//		addSugerAndMilk();
//	}
	
	public void brew()
	{
		System.out.println("Dripping coffee through filter");
	}
	
	public void addCondiments()
	{
		System.out.println("Adding sugar and milk");
	}

	private void addSugerAndMilk() 
	{
		System.out.println("Adding suger and milk");	
	}

	private void brewCoffeeGrinds() 
	{
		System.out.println("Brewing coffee grinds");
	}
}
