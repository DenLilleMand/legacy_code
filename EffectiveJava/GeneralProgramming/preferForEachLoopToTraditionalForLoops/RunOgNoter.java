package preferForEachLoopToTraditionalForLoops;

public class RunOgNoter {
	/**
	 * tl;dr;
	 * 
	 * 
	 * -----------------
	 * Noter:
	 * Se kode eksempel 1, viser hvordan de plejede at iterer over
	 * for-loops, men de er ikke perfekte, både iteratoren
	 * og indexed er rent clutter, og videre så
	 * repræsentere de mulighed for fejl, 
	 * variablen og indexed forekommer 3 gange i hvert loop,
	 * hvilket giver en 2 muligheder for at få dem forkert,
	 * og hvis man gør så er der ingen garanti for om compileren
	 * opdager det(afhænger af om man er kommet til at bruge en variable,
	 * der faktisk passer ind, fordi hvis du  prøver at bruge en ukendt,
	 * får du jo helt sikkert en fejl).
	 * 
	 * Kan se det bedste idiom for at itererer i kode eksempel 2.
	 * rimelig standard, men som vi ved, så har vi jo brug for Iterators for at fjerne 
	 * ting, så.
	 * 
	 * prøver at lege lidt med nogle for-loops, hvad de kan printe osv.
	 * på side 236, og bogens pointe er bare at
	 * hvis man skal lave nested iterationer så er det
	 * bedst at gøre det som kode eksempel 3.
	 * 
	 * nok den her sektions bedste råd,
	 * implementer Iterable, sådan at man kan bruge sit
	 * kode eksempel 3, loop på ens type- uden Iterable er det
	 * ikke muligt.
	 * 
	 * men som bogen også ved, så er der 3 ting der ikke fungerer med for-each loopet
	 * i kode eksempel 3, 
	 * 
	 * 1. Filtering -- 'If you need to traverse a collection and remove selected elements,
	 * then you need to use an explicit iterator so that you can call it's remove method'
	 * 2.Transforming 'If you need to traverse a list or array and replace some 
	 * or all of the values of it's elements, then you need the list iterator or array index
	 * in order to set the value to an element'
	 * 3.Parallel iteration--'If you need to traverse multiple collections in parallel 
	 * then you need to explicit control over the iterator or index variable, so that all iterators
	 *  or index variables can be advanced in lockstep(as demonstrated unintentionally in the buggy card and dice examples above).'
	 * @param args
	 */
	public static void main(String[] args) 
	{
		/**
		 * Kode eksempel 1:
		 */
		//No longer the preferred idiom to iterate over a collection!
		for(Iterator i = c.iterator(); i.hasNext(); )
		{
			doSomething(Element) i.next()); // (No generics before 1.5)
		}
		
		//No longer the preferred idiom to iterate over an array!
		for(int i = 0; i < a.length; i++)
		{
			doSomething([i]);
		}
		
		/**
		 * Kode eksempel 2:
		 */
		for(Element e : elements)
		{
			doSomething(e);
		}
		/**
		 * Kode eksempel 3:
		 */
		for(Suit suit : suits)
		{
			for(Rank rank : ranks)
			{
				deck.add(new Card(suit,rank));
			}
		}
		/**
		 * Kode eksempel 4:
		 * (bare et interessersant brug af for-loopet,
		 * i et andet kapitel).
		 */
		double funds = 1.00;
		int itemsBought = 0;
		for(double price = .10; funds >=price; price += .10)
		{
			funds -= price;
			itemsBought++;
		}
		System.out.println(itemBought + " items bought.");
		System.out.println("Change: $" + funds);
	}

}
