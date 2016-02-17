package tutorial26WritingOurFirstAspectPart1;

public class Noter 
{
	/**
	 * Noter:
	 * Der står for det meste noter i klasserne.
	 * 
	 * men en ting er at vores Triangle og Circle klasse begge implementerede et tomt interface,
	 * ikke noget som var med i vores tutorial, men noget jeg bare ville prøve, så fik vi en fejl
	 * fra Spring. og jeg ved sku ikke helt hvad det går ud på :)
	 * 
	 * 
	 * Performance wise er den her rigtig god:
	 * http://stackoverflow.com/questions/433475/performance-impact-of-using-aop
	 * 
	 * De foreslår AspectJ fordi den laver sin weaving ved compiletime og ikke ved run-time
	 * som spring AOP åbenbart gør ...  
	 * 
	 * men folk synes generalt at AOP's overhead er okay, men at man let kan skyde sig selv i foden
	 * elegant.
	 * 
	 * der er noget med naming conventions, fordi de her AOP annotations
	 * fungerer meget bedre hvis f.eks getters og setters hedder noget med getXXX og setXXX tydeligvis,
	 * hvis alle metoder hedder noget nonsens er det svært at ramme dem med AOP programming. 
	 * 
	 * Vi er helt oppe på tutorial 32 nu, 
	 * og jeg har ikke opdateret det, jeg laver et nyt projekt
	 * lige så snart hans tutorials går over til data
	 * laver jeg nogle nye pakker. men lige nu har 26-32 kunne være i 
	 * de her 3 pakker fordi det meste har været udvidelser til vores annotations 
	 * i vores aspect klasse.
	 * 
	 * 
	 */
}
