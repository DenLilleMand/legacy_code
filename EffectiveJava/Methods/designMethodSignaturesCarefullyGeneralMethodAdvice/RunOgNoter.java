package designMethodSignaturesCarefullyGeneralMethodAdvice;

public class RunOgNoter {

	/**
	 * Design method signatures carefully
	 * 
	 * tl;dr;
	 * 
	 * 
	 * -----------------------------------
	 * Noter:
	 * I denne sektion er der mange sm� ting, som ikke helt kunne blive til en hel
	 * sektion p� egen h�nd, s� der er m�ske nogle ting der ikke helt h�nger sammen.
	 * 
	 *-- Choose method names carefully- hvis man er i tvivl
	 * s� kig p� de naming conventions der er i den pakke man er i,
	 * og s� langsomt udvid scope, ellers kig i selve javas biblioteker.
	 * 
	 *--Don't go overboard in providing convenience methods.
	 * - de mener bare at alle metoder skal man l�rer, dokumentere,
	 * bruge, teste og velligholde - s� lav ikke for mange der ikke tr�kker sin egen
	 * v�gt. Dette er ogs� sandt for interfaces hvor masser af interfaces g�r livet sv�rt for 
	 * andre programm�rer. Hvis man er i tvivl om man skal implementere en metode,
	 * s� lad v�re.
	 * 
	 * --Avoid long parameter lists- sigt efter 4 parametre eller mindre,
	 * Hvis mange af ens metoder bryder med dette s� er det ikke let at bruge ens 
	 * API, (herpderp vi laver bare builder pattern woop woop.
	 * 
	 * 
	 * --Long sequences of identically typed parameters are especially harmful.
	 * folk kan ikke huske orderen af parameterne, og n�r de kommer til at skrive 
	 * dem forkert s� vil deres program stadig compile og k�rer.
	 * (they just wont do what their authors intended).
	 * 
	 * Der er 3 teknikker til at g�re en metodes parametre mindre, en er at bryde den op i flere metoder,
	 * hver af dem tager s� et subset af de parametre. Hvis dette bliver gjort ofte og p� en ligeglad facon 
	 * s� kan man ende op med for mange metoder. Men det kan ogs� hj�lpe en med at reducere metode m�ngden
	 * ved at forh�je orthogonalitetn(wut?). det bliver forklaret hvad det betyder her,
	 * s� copy paster lige:'For example, consider the java.util.List interface. It does not provide
	 * methods to find the first or last index of an element in a sublist, both of which would
	 *  require three parameters. Instead it provides the sublist method, which takes two parameters 
	 *  and returns a view of a sublist. This method can be combined with the indexOf or lastIndexof methods,
	 *  each of which has a single parameter, to yield the desired functionality. Moreover, the subList method can be combined
	 *  with any method that operates on a List instance to perform arbitrary computations on sublists. 
	 *  The resulting API has a very high power-to-weight ratio.
	 *  
	 *  En anden l�sning p� bare parametre er at lave noget som hedder
	 *  Helper klasser, normalt er disse 'static helper klasse, og det virker til at 
	 *  det er en klasse som indeholder alle de her parametre som fields, og s� giver man bare den
	 *  "helper klasse" ind som parameter i stedet for, men alts�,
	 *  jeg synes stadig bedst om mit builder pattern dog.'
	 * 
	 * n� okay, den tredje l�sning er et builder pattern,
	 * den siger ikke herpderp, dette er den bedste l�sning, men det bliver denne l�sning
	 * vi k�rer med :), jeg kan godt se pointen i helper objektet, men det er jo ikke p�n kode.
	 * 
	 * --For parameter types, favor interfaces over classes,
	 * f.eks kan man bruge Map istedet for HashMap og s� kan man ogs� give den
	 * en masse andre slags maps ind som parameter, og det skal man selF g�re hvis man
	 * kan finde ud af at skrive en generisk metode, men det giver jo ingen mening at g�re dette,
	 * hvis ens metode kun fungerer med et HashMap s� er det jo netop vigtigt at det forbliver udelukkende
	 * dette input.
	 * 
	 *
	 * --Prefer two-element enum types to boolean parameters.
	 * Enums er som regelt mere sigende, og det er lettere at skrive n�r ens IDE
	 * ligesom eclipse har support for auto complete, og s� kan man ogs� tilf�je flere muligheder senere.
	 * der er et kode eksempel p� side 213 nederst. - 
	 * Det de pr�ver at sige er at det er lettere at skrive,udvide(med metoder,fields etc.) osv. 
	 * end med booleans.
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
	}

}
