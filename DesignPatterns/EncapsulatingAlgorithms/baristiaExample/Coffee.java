package baristiaExample;

public class Coffee extends CaffeineBeverage
{
	/**
	 * prepare recipe er den sammen
	 * kald order som med Te's prepareRecipe,
	 * så derfor har vi tænkt os at abstrahere den op på 
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
