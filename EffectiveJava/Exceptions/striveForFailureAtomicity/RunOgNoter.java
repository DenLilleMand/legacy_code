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
	 * Okay, så den her sektion omhandler 
	 * 'failure atomicity', det går ud på at når 
	 * man smider et objekt ind i en metode, og den så fejler,
	 * hvis objektet er immutable, så er atomicity gratis, men hvis
	 * det er mutable så kan det være at vores metode når at ændre objektet
	 * før den fejler, Dette kan skade vores program når vi så
	 * recover fra denne her situation, hvis objektet er et State objekt(worst case?),
	 * anyway - måden man kan undgå dette på er som sagt enten kun at give metoder immutable objekter,
	 * men det kommer ikke til at ske, så en anden måde er at 
	 * checke inputtet og så smide en exception før objektet når at blive ændret.
	 * 
	 *  på side 279 er der et godt eksempel på et seriøst real-life problem
	 *  med dette, som omhandler en stack, igen er det muligvis noget der kommer
	 *  til at give mere mening efter vi har læst data abstractions bogen.
	 *  
	 *  En interessersant ting er at f.eks Collections.sort smider alle sine input lister ind i arrays,
	 *  før den begynder at sorte - dette gør den for performance, men faktisk har det også den bonus at hvis en sort fejler,
	 *  så har vi failure atomicity.
	 *  Bogen nævner lidt flere måder at sikrer dette på,
	 *  men de er lidt hipster og ikke så alment programmerings væsentligt(side 279, nederst - 280 øverst).
	 *  
	 *  og selF går man efter atomicity, men i nogle tilfælde som f.eks
	 *  når der bliver smidt en currentModificationException, så skal man nok lade være med at
	 *  genbruge objektet, fordi flere tråde har haft gang i det, der er ikke nogen mulighed for at garantere 
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
