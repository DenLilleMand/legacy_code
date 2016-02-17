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
	 * I denne sektion er der mange små ting, som ikke helt kunne blive til en hel
	 * sektion på egen hånd, så der er måske nogle ting der ikke helt hænger sammen.
	 * 
	 *-- Choose method names carefully- hvis man er i tvivl
	 * så kig på de naming conventions der er i den pakke man er i,
	 * og så langsomt udvid scope, ellers kig i selve javas biblioteker.
	 * 
	 *--Don't go overboard in providing convenience methods.
	 * - de mener bare at alle metoder skal man lærer, dokumentere,
	 * bruge, teste og velligholde - så lav ikke for mange der ikke trækker sin egen
	 * vægt. Dette er også sandt for interfaces hvor masser af interfaces gør livet svært for 
	 * andre programmører. Hvis man er i tvivl om man skal implementere en metode,
	 * så lad være.
	 * 
	 * --Avoid long parameter lists- sigt efter 4 parametre eller mindre,
	 * Hvis mange af ens metoder bryder med dette så er det ikke let at bruge ens 
	 * API, (herpderp vi laver bare builder pattern woop woop.
	 * 
	 * 
	 * --Long sequences of identically typed parameters are especially harmful.
	 * folk kan ikke huske orderen af parameterne, og når de kommer til at skrive 
	 * dem forkert så vil deres program stadig compile og kører.
	 * (they just wont do what their authors intended).
	 * 
	 * Der er 3 teknikker til at gøre en metodes parametre mindre, en er at bryde den op i flere metoder,
	 * hver af dem tager så et subset af de parametre. Hvis dette bliver gjort ofte og på en ligeglad facon 
	 * så kan man ende op med for mange metoder. Men det kan også hjælpe en med at reducere metode mængden
	 * ved at forhøje orthogonalitetn(wut?). det bliver forklaret hvad det betyder her,
	 * så copy paster lige:'For example, consider the java.util.List interface. It does not provide
	 * methods to find the first or last index of an element in a sublist, both of which would
	 *  require three parameters. Instead it provides the sublist method, which takes two parameters 
	 *  and returns a view of a sublist. This method can be combined with the indexOf or lastIndexof methods,
	 *  each of which has a single parameter, to yield the desired functionality. Moreover, the subList method can be combined
	 *  with any method that operates on a List instance to perform arbitrary computations on sublists. 
	 *  The resulting API has a very high power-to-weight ratio.
	 *  
	 *  En anden løsning på bare parametre er at lave noget som hedder
	 *  Helper klasser, normalt er disse 'static helper klasse, og det virker til at 
	 *  det er en klasse som indeholder alle de her parametre som fields, og så giver man bare den
	 *  "helper klasse" ind som parameter i stedet for, men altså,
	 *  jeg synes stadig bedst om mit builder pattern dog.'
	 * 
	 * nå okay, den tredje løsning er et builder pattern,
	 * den siger ikke herpderp, dette er den bedste løsning, men det bliver denne løsning
	 * vi kører med :), jeg kan godt se pointen i helper objektet, men det er jo ikke pæn kode.
	 * 
	 * --For parameter types, favor interfaces over classes,
	 * f.eks kan man bruge Map istedet for HashMap og så kan man også give den
	 * en masse andre slags maps ind som parameter, og det skal man selF gøre hvis man
	 * kan finde ud af at skrive en generisk metode, men det giver jo ingen mening at gøre dette,
	 * hvis ens metode kun fungerer med et HashMap så er det jo netop vigtigt at det forbliver udelukkende
	 * dette input.
	 * 
	 *
	 * --Prefer two-element enum types to boolean parameters.
	 * Enums er som regelt mere sigende, og det er lettere at skrive når ens IDE
	 * ligesom eclipse har support for auto complete, og så kan man også tilføje flere muligheder senere.
	 * der er et kode eksempel på side 213 nederst. - 
	 * Det de prøver at sige er at det er lettere at skrive,udvide(med metoder,fields etc.) osv. 
	 * end med booleans.
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
	}

}
