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
	 * it is first used' ment på den måde at hvis vi initializer den for hurtigt så 
	 * er den bare clutter, både performance mæssigt og for læsbarhedens skyld,
	 * og hvis en variable bliver kaldt for tidligt kan det også være katastrofalt.
	 * 
	 * 
	 * 'Nearly every local variable declaration should contain an initializer,'
	 * Hvis man ikke har nok information til at initialisere ens variable, så burde man
	 * vente med at gøre det til man har.   (så dvs. ikke flere variable = null) agtige 
	 * initialiseringer.
	 * 
	 * der er en undtagelser mhs. til dette, og det er et try-catch statement, 'If a variable
	 *  is initialized by a method that throws a checked exception, it must be initialized inside a try block.
	 *  If the value must be used outside of the try block, then it must be declared before the try block, where
	 *  it cannot yet be "sensibly initialized"'
	 *  
	 *  hvilket bringer os videre til at man altid burde foretrække
	 *  for-each loop i stedet for f.eks et while loop,
	 *  pga. objekternes scope er præcis hvad det skal være i et for-loop,
	 *  selF givet at man ikke skal bruge variablen bagefter, fordi nogle gange
	 *  skal man jo tydeligvis bruge en while() loop,
	 *  kode eksempel 1 viser et helt standard for-each der er det bedste at gå efter.
	 * 
	 * Før 1.5 var kode eksempel 2, det foretrukne(måske?), anyway, problemet med det er som man kan se,
	 * er koden blive copy pastet skal det forestille - og de begge compiler stadig fordi Iteratoren <i> bare 
	 * kører videre i det her scope, imens 
	 * et traditionelt for-loop eller et for-each loop begge ikke ville compile i den her situation, fordi det er uden for deres
	 * scope. man kan se disse i kode eksempel 3.
	 * 
	 * så deres pointe indtil videre er at man skal kigge på disse
	 * loops, og så se på om copy paste fejlen kan forekomme, og der er det mere eller mindre bedre
	 * at tage et almindeligt for-loop, men altså, det vigtige er jo at det er bedre i readability,
	 * og at det har nogle bedre begrænsninger på scope, jeg synes at det her copy-paste er en smule søgt.
	 * 
	 * en interessersant variation af et for-loop vi ikke har set før,
	 * kan man se i kode eksempel 4.
	 * 
	 * En anden pointe er 'Keep methods small and focused' på den måde at hvis vi prøver at minimere 
	 * variablers scope, så hvis f.eks en lokal variable er i midten af et scope der også håndtere en anden variable som intet
	 * har med den at gøre, så er det dårlig opdeling af metoder.
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
