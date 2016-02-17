package baristiaExampleWithHook;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CoffeeWithHook extends CaffeineBeverageWithHook
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
	
	private String getUserInput() throws Exception
	{
		String answer = null;
		
		System.out.println("Would you like milk and sugar?");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		answer = in.readLine();
		
		if(answer == null)
		{
			System.out.println("No");
		}
		
		return answer;
	}
	
	public boolean customerWantsCondiments() 
	{
		String answer = null;
		try
		{
			answer = getUserInput();			
		}
		catch(Exception e)
		{
			//ignore
		}
		
		if(answer.toLowerCase().startsWith("y"))
		{
			return true;
		}
		return false;
		
	}
	
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
