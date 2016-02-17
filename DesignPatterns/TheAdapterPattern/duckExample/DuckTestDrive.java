package duckExample;
/**
 * AdapterPattern Definition:"
 * The Adapter Pattern converts the interface of a class
 * into another interface the clients expect. Adapter lets classes
 * work together that couldn't otherwise because of incompatible
 * interfaces."
 * 
 * Der er faktisk både Object adapters og klasse adapters,
 * men man har brug for at kunne extende flere klasser samtidigt for at bruge
 * klasse adapters.. og det kan vi jo ikke i java. så jeg læser bare igennem den sektion
 * der starter på side 248 ... og tager ikke noter.
 * 
 * @author DenLilleMand
 *
 */
public class DuckTestDrive {

	public static void main(String[] args) 
	{
		MallardDuck duck = new MallardDuck(); //en duck fordi den implementere
											  //den rene form for Duck
		
		WildTurkey turkey = new WildTurkey();
		Duck turkeyAdapter = new TurkeyAdapter(turkey);
		
		System.out.println("The Turkey says ...");
		turkey.gobble();
		turkey.fly();
		
		System.out.println("\nThe Duck says ...");
		testDuck(duck);
		System.out.println("\nThe TurkeyAdapter says ...");
		testDuck(turkeyAdapter);
	}
	
	public static void testDuck(Duck duck)
	{
		duck.quack();
		duck.fly();
	}
}
