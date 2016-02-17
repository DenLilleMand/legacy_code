package makeDefensiveCopiesWhenNeeded;

public class RunOgNoter {

	/**
	 * tl;dr;
		fra bogen: 'If a class has mutable components that it gets from 
		or returns to its clients, the class must defensively copy these components.
		If the cost of the copy would be prohibitive and the class trusts its clients not to
		modify the components inappropriately, then the defensive copy may be replaced by documentation
		outlining the client's responsibility not to modify the affected components'
		men der er mere til det end dette - det har også noget at gøre med at de ting man giver ind som parameter til en klasse,
		selvom det er en immutable klasse der har nogle final felter, så kan man stadig ændrer dem ved at ændre på det objekt man i sin tid
		gav ind som parameter, dette gælder også for constructors selF, så derfor laver man static factory methods, og kalder clone()
		på de objekter man tager ind som parameter, det betyder vel også at vi ikke bare kan give et objekt ind som parameter og så arbejde videre med det
		, desuden ved vi jo alligevel ikke helt med de her objekter hvad der sker hvis man begynder at redigere i dem løbende imens de er i en
		arrayliste, set og whatnot .. så det er måske værd at undersøge.
	 * ----------
	 * Noter:
	 * Vi har lavet en klasse der hedder Period, 
	 * og den ser okay ud, ligner et normal immutable klasse
	 * i den forstand at vi ingen public fields har eller noget,
	 * den mangler måske bare lige en static factory method og en
	 * private constructor sådan at vi ikke kan lave den til en
	 * superklasse. men der er huller i dens design, nemlig er
	 * Date et mutable objekt, som vi giver ind som parameter, 
	 * og fordi vi referer ting by reference kan vi ændre felterne 
	 * vi giver ind som parameter, check evt. vores klasse
	 * HowToRuinPeriodClass klassen i den her pakke.
	 * Og det som er mest vildt er at det virker til at vi nærmest
	 * overrider den der final parameter, fordi vi indirekte kan redigere i feltet
	 * pga. vores non-final reference.
	 * 
	 * SÅ(!) hvordan forsvarre vi vores variabler fra den her slags angreb?
	 * det kan man se i klassen PeriodWithDefensiveCopiesOfParameters.
	 * 
	 * Der er endnu et angreb muligt skrevet nedenfor i 
	 * kode eksempel 1. for at forsvarre imod dette angreb så
	 * laver vi også vores getter metoder om til ting der laver defensive kopier,
	 * som i kode eksempel 2.
	 * 
	 * I kode eksempel 2 kunne man potentielt, bruge clone() fordi
	 * konstruktøren har sikret sig at vi bruger java.util.Date klassen,
	 * men det er faktisk bedre at bruge en static factory metode,
	 * af grunde specificeret i det afsnit i vores Noter hvor vi havde om
	 * static factory metoder.
	 * 
	 * mange af de her kode eksempler har jo med immutable klasser at gøre(jeg 
	 * tror at vi burde skrive mange mange flere af disse, sammenlignet med hvor mange 
	 * klasser vi har der fjoller).
	 * 
	 * Men at tage copier kan også bruges i mutable klasser,
	 * f.eks hvis vi har en klasse der tager imod en arraylist,
	 * så skal vi spørge os selv om, om den arraylist kan klare at dens objekt skifter værdier
	 * løbende, og hvis den ikke kan det, så laver vi en clone() af den,
	 * men vi skal jo være obs på at vi så lige pludselig nærmest
	 * parser by value + by reference på kryds og tværs, jeg er ikke sikker på hvad
	 * reglerne er for dette men det lyder farligt hvis man ikke holder tungen lige i munden.
	 * 
	 * anyway, der er selF en performance penalty, ved dette, som vi også har tænkt tidligere, at 
	 * vi bliver ved med at lave masser af objekter, nu når vi er super hyped på Singletons,
	 * så det er ikke altid godkendt at clone ens return value heller,
	 * hvis det f.eks kun er en client i ens egen pakke der har adgang til ens klasse, kan det godt
	 * være man kan lade være, men så er det vigtigt at man skrive oppe i ens documentation
	 * at man under ingenomstændigheder må redigere og så det 
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
