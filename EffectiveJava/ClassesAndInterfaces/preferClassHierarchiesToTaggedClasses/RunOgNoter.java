package preferClassHierarchiesToTaggedClasses;

/**
 * Prefer class hierarchies to tagged classes:
 * 
 * tl;dr;
 * 'Tagged classes are rarely apropiate. If you're tempted
 * to write a class with a explicit tag field, think about whether
 * the tag could be eliminated and the class replaced by a hierarchy. When 
 * you encounter an existing class with a tag field, consider refactoring it into a hierarchy'
 * ----
 * Noter:
 * Starter p� side 123 med at vise hvad en tagged
 * klasse indeb�rer. vi har copieret koden ind i vores
 * TaggedClass klasse som er i den her pakke.
 * Og der er en masse d�rlige ting i de her tagged klasser,
 * man kan se  at de er 
 *	"clutted" med enum declarations, tag fields og switch statements.
 *	l�sbarheden er videre skrumpet fordi
 *flere implementation er smidt sammen i en enkelt klasse  
 *og s� er vores memory footprint st�rre
 *fordi vi har felter som tilh�rer andre varianter af denne klasse.
 * vores felter kan ikke blive lavet final hvis ikke vores
 * constructors initialisere irrelevante felter sammen med
 * deres egne relevante felter, som resulterer i mere boiler plate kode.
 * 
 * programmet vil ogs� fejle ved runtime hvis man initialisere de forkerte felter,
 * med ingen hj�lp fra compileren. Udover dette s� er der
 * lidt design pattern theory over det her, fordi man kan ikke tilf�je endnu en variant
 * til denne klasse uden at modificere dens source fil. 
 * 
 * Der er dog et alternativ til dette i java, og det hedder et klasse hierarki,
 * og hvis vi ikke kan huske de andre kapitler, s� m� vi godt subclasse
 * s� l�nge vi holder det indenfor package scope(relativt iforhold til programm�rernes ansvar,
 * alts� s�dan at andre programm�rer ikke pr�ver at bruge ens superKlasse p� kryds og tv�rs af pakker)
 * og s� betyder det ogs� noget om subclassen har et IS-A forhold til den klasse som den skal extende.
 * og i det her tilf�lde, med Shape som superklasse, der er Circle og Rectangle jo det samme som en Shape,
 * s� der er et klasse hieraki optimalt.
 * 
 * N�r de taler om klasse hierarkiet s� er det rimelig by the book, kan se 
 * klasse eksemplerne p� side 125, det er rimelig standard logik indenfor arv,
 * at man skal beholde de metoder som alle subclasses skal arve og evt. lave en konkret implementation af dem,
 * og alle de metoder som subclasses skal have en af men med egen implementation laver man bare abstract . 
 * osv. osv. 
 * 
 * 
 * 
 * 
 * @author DenLilleMand
 */
public class RunOgNoter 
{

	public static void main(String[] args) 
	{

	}

}
