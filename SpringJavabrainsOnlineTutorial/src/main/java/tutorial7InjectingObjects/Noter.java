package tutorial7InjectingObjects;

public class Noter {
	/**
	 * tl;dr: godt at læse om:
	 * http://programmers.stackexchange.com/questions/92393/what-does-the-spring-framework-do-should-i-use-it-why-or-why-not
	 * 
	 * Noter:
	 * 
	 * vi har 3 Pointer objekter i vores Triangle klasse,
	 * og hvis vi ikke brugte Spring, så ville vi skulle initialisere 
	 * dem alle sammen, der er meget initialisering i den her klasse.
	 * 
	 * Men nu har vi Spring, så vi har tænkt os at bruge det til at 
	 * initialisere dem alle sammen(Point objekter).
	 * 
	 * Der er ekstra noter under tutorial 7 i vores spring.xml fil, 
	 * men det er vigtigt at forstå, at vi faktisk bare kan lade intialiseringen
	 * fortsætte som en spiral, sådan at alle vores beans inde i andre beans, og kan have
	 * deres egne referencer til beans og initialisere dem.
	 * 
	 * 
	 * 
	 *
	 *
	 */
}
