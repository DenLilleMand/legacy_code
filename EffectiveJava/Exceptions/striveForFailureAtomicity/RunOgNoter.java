package striveForFailureAtomicity;

public class RunOgNoter {
	/**
	 * Strive for failure atomicity
	 * 
	 * tl;dr;
	 * As a rule, any generated exception that is part of a method's
	 * specification should leave the object in the same state it was in prior to the method 
	 * invocation. Where this rule is violated, the API documentation should clearly indicate what state the object will be left in. 
	 * Unfortunately, plenty of existing API documentation fails to live up this ideal.
	 * 
	 * 
	 * ---------
	 * Noter:
	 * Okay, s� den her sektion omhandler 
	 * 'failure atomicity', det g�r ud p� at n�r 
	 * man smider et objekt ind i en metode, og den s� fejler,
	 * hvis objektet er immutable, s� er atomicity gratis, men hvis
	 * det er mutable s� kan det v�re at vores metode n�r at �ndre objektet
	 * f�r den fejler, Dette kan skade vores program n�r vi s�
	 * recover fra denne her situation, hvis objektet er et State objekt(worst case?),
	 * anyway - m�den man kan undg� dette p� er som sagt enten kun at give metoder immutable objekter,
	 * men det kommer ikke til at ske, s� en anden m�de er at 
	 * checke inputtet og s� smide en exception f�r objektet n�r at blive �ndret.
	 * 
	 *  p� side 279 er der et godt eksempel p� et seri�st real-life problem
	 *  med dette, som omhandler en stack, igen er det muligvis noget der kommer
	 *  til at give mere mening efter vi har l�st data abstractions bogen.
	 *  
	 *  En interessersant ting er at f.eks Collections.sort smider alle sine input lister ind i arrays,
	 *  f�r den begynder at sorte - dette g�r den for performance, men faktisk har det ogs� den bonus at hvis en sort fejler,
	 *  s� har vi failure atomicity.
	 *  Bogen n�vner lidt flere m�der at sikrer dette p�,
	 *  men de er lidt hipster og ikke s� alment programmerings v�sentligt(side 279, nederst - 280 �verst).
	 *  
	 *  og selF g�r man efter atomicity, men i nogle tilf�lde som f.eks
	 *  n�r der bliver smidt en currentModificationException, s� skal man nok lade v�re med at
	 *  genbruge objektet, fordi flere tr�de har haft gang i det, der er ikke nogen mulighed for at garantere 
	 *  objektet ikke er blevet genbrugt.
	 *  
	 *  
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{

	}

}
