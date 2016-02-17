package favorCompositionOverInheritance;

public class RunOgNoter 
{
	/**
	 * Favor composition over inheritance:
	 * Ligesom det de talte om i vores design bog,
	 * 
	 * 
	 * egen korte beskrivelse af hvad jeg har læst:
	 * 
	 * forstår endelig composition over inheritance, jeg synes ikke at
	 * design bogen forklarede det helt så simpelt,
	 * Det som er det meget simple og essentielle er at istedet for at subclasse
	 * en evt. ny klasse man vil lave, så er det bedre at lave et 
	 * private field med en reference til den klasse man ellers havde tænkt
	 * sig at extende, og så bare kalde metoderne på det,  og så ved jeg at man
	 * tænker med det samme på vores SuperLogGui som selF sætter en masse componenter osv.
	 * men der tænker jeg at man meget simpelt ville kunne have lavet en metode der bare returner
	 * en component som f.eks background panel efter alle objekterne var sat.
	 * 
	 * men altså, det er jo noget helt andet med javaFX- så vi får at se :)
	 * 
	 * bortset fra dette så skal det siges at der ikke umiddelbart er noget galt i at extende
	 * en klasse som er lavet til at blive extended, med god documentation for hvad den gør,
	 * problemet opstår når man begynder at extende concrete klasser på kryds og tværs af pakker,
	 * både for applicationens complexitet, men også pga. hvis en superklasse bliver altered
	 * i en senere release så risikere man at breake subclassen. 
	 * En risiko kunne også være hvis en collection gik udfra at en given add-metode havde styr
	 * på de objekter der blev tilføjet, men så lige pludselig kommer der en ny add metode fra superklassen
	 * og så breaker den ens collection hvis den bliver brugt.
	 * 
	 * man skal også spørge sig selv hver gang man overvejer om man skal bruge
	 * composition istedet for inheritance, om de 2 klasser har et IS-A relationship, 
	 * eller om subclassen bare er en mindre del af implementationen, og hvis man ikke kan svarer
	 * ærligt at i alle tilfælde har subclasses et IS-A forhold til sin super klasse,
	 * så burde man bruge composition istedet for...
	 * 
	 * en ting er at hvis superklassen man har tænkt sig at extende har nogle fatale
	 * implementations fejl, eller bugs i sig -- og man så har lyst til overhovedt at extende den,
	 * fordi det vil bleede over i ens egen implementation.
	 * 
	 * et meget søgt bug som jeg har valgt at tage med i noterne for sjov,
	 * at at hvis en superklasse tilfældigvis i en release får en metode
	 * som har samme signature som en af de metoder man selv har udvidet subclassen med,
	 * så vil vores metode @Override den.  og hvis det ikke er den præcise signatur, f.eks
	 * en anderledes retur type, så vil vores program ikke compile :) 
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{

	}

}
