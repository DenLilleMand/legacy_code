package favorCompositionOverInheritance;

public class RunOgNoter 
{
	/**
	 * Favor composition over inheritance:
	 * Ligesom det de talte om i vores design bog,
	 * 
	 * 
	 * egen korte beskrivelse af hvad jeg har l�st:
	 * 
	 * forst�r endelig composition over inheritance, jeg synes ikke at
	 * design bogen forklarede det helt s� simpelt,
	 * Det som er det meget simple og essentielle er at istedet for at subclasse
	 * en evt. ny klasse man vil lave, s� er det bedre at lave et 
	 * private field med en reference til den klasse man ellers havde t�nkt
	 * sig at extende, og s� bare kalde metoderne p� det,  og s� ved jeg at man
	 * t�nker med det samme p� vores SuperLogGui som selF s�tter en masse componenter osv.
	 * men der t�nker jeg at man meget simpelt ville kunne have lavet en metode der bare returner
	 * en component som f.eks background panel efter alle objekterne var sat.
	 * 
	 * men alts�, det er jo noget helt andet med javaFX- s� vi f�r at se :)
	 * 
	 * bortset fra dette s� skal det siges at der ikke umiddelbart er noget galt i at extende
	 * en klasse som er lavet til at blive extended, med god documentation for hvad den g�r,
	 * problemet opst�r n�r man begynder at extende concrete klasser p� kryds og tv�rs af pakker,
	 * b�de for applicationens complexitet, men ogs� pga. hvis en superklasse bliver altered
	 * i en senere release s� risikere man at breake subclassen. 
	 * En risiko kunne ogs� v�re hvis en collection gik udfra at en given add-metode havde styr
	 * p� de objekter der blev tilf�jet, men s� lige pludselig kommer der en ny add metode fra superklassen
	 * og s� breaker den ens collection hvis den bliver brugt.
	 * 
	 * man skal ogs� sp�rge sig selv hver gang man overvejer om man skal bruge
	 * composition istedet for inheritance, om de 2 klasser har et IS-A relationship, 
	 * eller om subclassen bare er en mindre del af implementationen, og hvis man ikke kan svarer
	 * �rligt at i alle tilf�lde har subclasses et IS-A forhold til sin super klasse,
	 * s� burde man bruge composition istedet for...
	 * 
	 * en ting er at hvis superklassen man har t�nkt sig at extende har nogle fatale
	 * implementations fejl, eller bugs i sig -- og man s� har lyst til overhovedt at extende den,
	 * fordi det vil bleede over i ens egen implementation.
	 * 
	 * et meget s�gt bug som jeg har valgt at tage med i noterne for sjov,
	 * at at hvis en superklasse tilf�ldigvis i en release f�r en metode
	 * som har samme signature som en af de metoder man selv har udvidet subclassen med,
	 * s� vil vores metode @Override den.  og hvis det ikke er den pr�cise signatur, f.eks
	 * en anderledes retur type, s� vil vores program ikke compile :) 
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{

	}

}
