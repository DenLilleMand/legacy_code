package makeDefensiveCopiesWhenNeeded;

public class RunOgNoter {

	/**
	 * tl;dr;
		fra bogen: 'If a class has mutable components that it gets from 
		or returns to its clients, the class must defensively copy these components.
		If the cost of the copy would be prohibitive and the class trusts its clients not to
		modify the components inappropriately, then the defensive copy may be replaced by documentation
		outlining the client's responsibility not to modify the affected components'
		men der er mere til det end dette - det har ogs� noget at g�re med at de ting man giver ind som parameter til en klasse,
		selvom det er en immutable klasse der har nogle final felter, s� kan man stadig �ndrer dem ved at �ndre p� det objekt man i sin tid
		gav ind som parameter, dette g�lder ogs� for constructors selF, s� derfor laver man static factory methods, og kalder clone()
		p� de objekter man tager ind som parameter, det betyder vel ogs� at vi ikke bare kan give et objekt ind som parameter og s� arbejde videre med det
		, desuden ved vi jo alligevel ikke helt med de her objekter hvad der sker hvis man begynder at redigere i dem l�bende imens de er i en
		arrayliste, set og whatnot .. s� det er m�ske v�rd at unders�ge.
	 * ----------
	 * Noter:
	 * Vi har lavet en klasse der hedder Period, 
	 * og den ser okay ud, ligner et normal immutable klasse
	 * i den forstand at vi ingen public fields har eller noget,
	 * den mangler m�ske bare lige en static factory method og en
	 * private constructor s�dan at vi ikke kan lave den til en
	 * superklasse. men der er huller i dens design, nemlig er
	 * Date et mutable objekt, som vi giver ind som parameter, 
	 * og fordi vi referer ting by reference kan vi �ndre felterne 
	 * vi giver ind som parameter, check evt. vores klasse
	 * HowToRuinPeriodClass klassen i den her pakke.
	 * Og det som er mest vildt er at det virker til at vi n�rmest
	 * overrider den der final parameter, fordi vi indirekte kan redigere i feltet
	 * pga. vores non-final reference.
	 * 
	 * S�(!) hvordan forsvarre vi vores variabler fra den her slags angreb?
	 * det kan man se i klassen PeriodWithDefensiveCopiesOfParameters.
	 * 
	 * Der er endnu et angreb muligt skrevet nedenfor i 
	 * kode eksempel 1. for at forsvarre imod dette angreb s�
	 * laver vi ogs� vores getter metoder om til ting der laver defensive kopier,
	 * som i kode eksempel 2.
	 * 
	 * I kode eksempel 2 kunne man potentielt, bruge clone() fordi
	 * konstrukt�ren har sikret sig at vi bruger java.util.Date klassen,
	 * men det er faktisk bedre at bruge en static factory metode,
	 * af grunde specificeret i det afsnit i vores Noter hvor vi havde om
	 * static factory metoder.
	 * 
	 * mange af de her kode eksempler har jo med immutable klasser at g�re(jeg 
	 * tror at vi burde skrive mange mange flere af disse, sammenlignet med hvor mange 
	 * klasser vi har der fjoller).
	 * 
	 * Men at tage copier kan ogs� bruges i mutable klasser,
	 * f.eks hvis vi har en klasse der tager imod en arraylist,
	 * s� skal vi sp�rge os selv om, om den arraylist kan klare at dens objekt skifter v�rdier
	 * l�bende, og hvis den ikke kan det, s� laver vi en clone() af den,
	 * men vi skal jo v�re obs p� at vi s� lige pludselig n�rmest
	 * parser by value + by reference p� kryds og tv�rs, jeg er ikke sikker p� hvad
	 * reglerne er for dette men det lyder farligt hvis man ikke holder tungen lige i munden.
	 * 
	 * anyway, der er selF en performance penalty, ved dette, som vi ogs� har t�nkt tidligere, at 
	 * vi bliver ved med at lave masser af objekter, nu n�r vi er super hyped p� Singletons,
	 * s� det er ikke altid godkendt at clone ens return value heller,
	 * hvis det f.eks kun er en client i ens egen pakke der har adgang til ens klasse, kan det godt
	 * v�re man kan lade v�re, men s� er det vigtigt at man skrive oppe i ens documentation
	 * at man under ingenomst�ndigheder m� redigere og s� det 
	 * 'givne felt'.
	 * 
	 * 
	 *
	 * 
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
		
		Date start = new Date();
		Date end = new Date();
		Period p = new Period(start,end);
		p.end().setYear(78); //Modifies internals of p!
	
	
		/**
		 * Kode eksempel 2:
		 */
		//repaired accessors - make defensive copies of internal fields
	 	public Date start()
	 	{
		 return new Date(start.getTime());
	 	}
	 
	 	public Date end()
	 	{
	 		return new Date(end.getTime());
	 	}
	
	
	}
	

}
