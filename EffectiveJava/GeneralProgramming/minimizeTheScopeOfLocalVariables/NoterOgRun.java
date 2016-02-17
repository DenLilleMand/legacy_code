package minimizeTheScopeOfLocalVariables;

public class NoterOgRun {
	
	/**
	 * Minimize the scope of local variables
	 * tl;dr;
	 * 
	 * 
	 * -----------------
	 * Noter:
	 * 'The most powerful technique for minimizing the scope of local variable is to declare it where
	 * it is first used' ment p� den m�de at hvis vi initializer den for hurtigt s� 
	 * er den bare clutter, b�de performance m�ssigt og for l�sbarhedens skyld,
	 * og hvis en variable bliver kaldt for tidligt kan det ogs� v�re katastrofalt.
	 * 
	 * 
	 * 'Nearly every local variable declaration should contain an initializer,'
	 * Hvis man ikke har nok information til at initialisere ens variable, s� burde man
	 * vente med at g�re det til man har.   (s� dvs. ikke flere variable = null) agtige 
	 * initialiseringer.
	 * 
	 * der er en undtagelser mhs. til dette, og det er et try-catch statement, 'If a variable
	 *  is initialized by a method that throws a checked exception, it must be initialized inside a try block.
	 *  If the value must be used outside of the try block, then it must be declared before the try block, where
	 *  it cannot yet be "sensibly initialized"'
	 *  
	 *  hvilket bringer os videre til at man altid burde foretr�kke
	 *  for-each loop i stedet for f.eks et while loop,
	 *  pga. objekternes scope er pr�cis hvad det skal v�re i et for-loop,
	 *  selF givet at man ikke skal bruge variablen bagefter, fordi nogle gange
	 *  skal man jo tydeligvis bruge en while() loop,
	 *  kode eksempel 1 viser et helt standard for-each der er det bedste at g� efter.
	 * 
	 * F�r 1.5 var kode eksempel 2, det foretrukne(m�ske?), anyway, problemet med det er som man kan se,
	 * er koden blive copy pastet skal det forestille - og de begge compiler stadig fordi Iteratoren <i> bare 
	 * k�rer videre i det her scope, imens 
	 * et traditionelt for-loop eller et for-each loop begge ikke ville compile i den her situation, fordi det er uden for deres
	 * scope. man kan se disse i kode eksempel 3.
	 * 
	 * s� deres pointe indtil videre er at man skal kigge p� disse
	 * loops, og s� se p� om copy paste fejlen kan forekomme, og der er det mere eller mindre bedre
	 * at tage et almindeligt for-loop, men alts�, det vigtige er jo at det er bedre i readability,
	 * og at det har nogle bedre begr�nsninger p� scope, jeg synes at det her copy-paste er en smule s�gt.
	 * 
	 * en interessersant variation af et for-loop vi ikke har set f�r,
	 * kan man se i kode eksempel 4.
	 * 
	 * En anden pointe er 'Keep methods small and focused' p� den m�de at hvis vi pr�ver at minimere 
	 * variablers scope, s� hvis f.eks en lokal variable er i midten af et scope der ogs� h�ndtere en anden variable som intet
	 * har med den at g�re, s� er det d�rlig opdeling af metoder.
	 * 
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		/**
		 * Kode eksempel 1:
		 */
		for(Element e : collection)
		{
			doSomething(e);
		}
		
		/**
		 * Kode eksempel 2:
		 */
		Iterator<Element> i = c.iterator();
		while(i.hasNext())
		{
			doSomething(i.next());
		}
		...//et andet eksempel med misbrug:
		Iterator<Element> i2 = c2.iterator();
		while(i.hasNext()) // BUG!
		{
			doSomethingElse(i2.next());
		}
		
		/**
		 * Kode eksempel 3:
		 */
		for(Iterator<Element> i = c.iterator()); i.hasNext(); )
		{
			doSomething(i.next());
		}
		...
		//Compile-time error - cannot find symbol i
		for(Iterator<Element> i2 = c2.iterator; i.hasNext();)
		{
			doSomething(i2.next());
		}
		
		/**
		 * Kode eksempel 4:
		 */
		for(int i = 0; n = expensiveComputation(); i < n; i++)
		{
			doSomething(i);
		}
	}

}
