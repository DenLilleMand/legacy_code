package baristiaExampleWithHook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * har lavet den her te og kaffe klasse.
 * og de deler nogle metoder, men ikke alle - og så skal vi prøve
 * at få dem til at arbejde bedre sammen.
 * @author DenLilleMand
 *
 */
public class TeaWithHook extends CaffeineBeverageWithHook{
	/**
	 * prepare recipe er den sammen
	 * kald order som med Te's prepareRecipe,
	 * så derfor har vi tænkt os at abstrahere den op på 
	 * CaffeineBeverage niveau
	 */
//	public void prepareRecipe()
//	{
//		boilWater();
//		steepTeaBag();
//		pourInCup();
//		addLemon();
//	}
	
	public void addCondiments()
	{
		System.out.println("Adding lemon");
	}
	
	
	public void brew()
	{
		System.out.println("Steeping the tea");
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


	private String getUserInput() throws IOException 
	{
		String answer = null;
		
		System.out.println("Would you like lemon?");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		answer = in.readLine();
		
		if(answer == null)
		{
			System.out.println("No");
		}
		
		return answer;
	}

//	private void addLemon() {
//		System.out.println("Adding lemon");
//		
//	}
//
//	private void steepTeaBag() {
//		System.out.println("Steeping the tea bag");
//		
//	}
	
}
