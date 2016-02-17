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
 * Starter på side 123 med at vise hvad en tagged
 * klasse indebærer. vi har copieret koden ind i vores
 * TaggedClass klasse som er i den her pakke.
 * Og der er en masse dårlige ting i de her tagged klasser,
 * man kan se  at de er 
 *	"clutted" med enum declarations, tag fields og switch statements.
 *	læsbarheden er videre skrumpet fordi
 *flere implementation er smidt sammen i en enkelt klasse  
 *og så er vores memory footprint større
 *fordi vi har felter som tilhører andre varianter af denne klasse.
 * vores felter kan ikke blive lavet final hvis ikke vores
 * constructors initialisere irrelevante felter sammen med
 * deres egne relevante felter, som resulterer i mere boiler plate kode.
 * 
 * programmet vil også fejle ved runtime hvis man initialisere de forkerte felter,
 * med ingen hjælp fra compileren. Udover dette så er der
 * lidt design pattern theory over det her, fordi man kan ikke tilføje endnu en variant
 * til denne klasse uden at modificere dens source fil. 
 * 
 * Der er dog et alternativ til dette i java, og det hedder et klasse hierarki,
 * og hvis vi ikke kan huske de andre kapitler, så må vi godt subclasse
 * så længe vi holder det indenfor package scope(relativt iforhold til programmørernes ansvar,
 * altså sådan at andre programmører ikke prøver at bruge ens superKlasse på kryds og tværs af pakker)
 * og så betyder det også noget om subclassen har et IS-A forhold til den klasse som den skal extende.
 * og i det her tilfælde, med Shape som superklasse, der er Circle og Rectangle jo det samme som en Shape,
 * så der er et klasse hieraki optimalt.
 * 
 * Når de taler om klasse hierarkiet så er det rimelig by the book, kan se 
 * klasse eksemplerne på side 125, det er rimelig standard logik indenfor arv,
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
