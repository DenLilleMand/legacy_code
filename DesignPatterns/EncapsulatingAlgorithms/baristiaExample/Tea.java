package baristiaExample;
/**
 * har lavet den her te og kaffe klasse.
 * og de deler nogle metoder, men ikke alle - og s� skal vi pr�ve
 * at f� dem til at arbejde bedre sammen.
 * @author DenLilleMand
 *
 */
public class Tea extends CaffeineBeverage{
	/**
	 * prepare recipe er den sammen
	 * kald order som med Te's prepareRecipe,
	 * s� derfor har vi t�nkt os at abstrahere den op p� 
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
