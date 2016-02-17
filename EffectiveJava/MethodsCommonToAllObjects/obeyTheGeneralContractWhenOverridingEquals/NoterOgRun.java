package obeyTheGeneralContractWhenOverridingEquals;

public class NoterOgRun 
{
	/**
	 * okay, haha ... vi er virkelig noobs,
	 * det havde jeg slet ikke t�nkt p�. 
	 * �benbart s� er Object klassen lavet til at
	 * man skal extende den, og selvom vi bruger den
	 * til at lave "flexible".
	 * metoder som equals, hashCode, toString,clone og finalize 
	 * har alle sammen 'general contracts' fordi de er designed til
	 * at blive @Override. men hvis man ikke overholder
	 * deres generalle kontrakt s� kan klasser som HashMap og Hashset
	 * fejle. finalize bliver ikke diskuteret i det her 
	 * kapitel fordi det blev det, i det sidste.  
	 * Men de vil pr�ve at vise os hvorn�r man skal
	 * extende Object.
	 
	 Equals - den eneste m�de at undg� problemer at at aldrig
	 @Override den her metode, der er nogle regler dog, f.eks skal man
	 slet ikke g�re det hvis man har med en klasse at g�re som er 'inherently unique'
	 og det giver jo fin mening, fordi s� skal den jo bare kunne tjekke p� om den er 
	 .equals(sig-selv). 
	 
	 reglerne for hvorn�r man ikke skal @Override
	 er n�r en SuperKlasse allerede har @Override equals
	 og den samme opf�rsel giver mening for ens sub-class.
	 
	 et sidste tilf�lde er at hvis klassen er privat
	 eller package-private og man er sikker p� at metoden
	 aldrig vil blive invoked() s� kan man @Override den og smide en AssertionError() (slags exception, side 57)
	 og det er bare for en sikkerheds skyld.
	 
	 
	 S� hvorn�r SKAL vi s� @Override equals metoden? og det er n�r
	 Objektet har en sans for 'logical equality' der udskeller sig fra 
	 den basale objekt identitet && noget andet der skal v�re sandt er 
	 at superklassen selF heller ikke allerede har @Override en der giver mening
	 for ens subclass.
	 anyway, dette er ofte tilf�ldet for hvad der hedder 'value classes'
	 f.eks Integer og Date klasserne der er t�ttere p� at repr�sentere en v�rdi
	 end at repr�sentere en objekt v�rdi.
	 
	 der st�r bare noget mere med at f.eks s� g�r en programm�r ud fra at n�r han bruger
	 '==' s� sammenligner han p� v�rdi og ikke p� objektets identitet, 
	 s� det g�r det vel ekstra vigtigt at have adgang
	 til java's source code s�dan at man kan se
	 hvordan equals metoden er implementeret. f.eks klasser som 
	 den singleton enum vi havde lavet i den anden pakke for den her bog, der
	 burde man altid bare tjekke p� objektets identitet fordi der kun er 1 af den, 
	 der er v�rdien og identiteten det samme.
	 
	 Der er en kontrakt, som er hvad man skal overholde n�r man @Overrider
	 equals metoden nederst p� side 57, jeg har ikke t�nkt mig at skrive det ned her.
	 den siger bla. at hvis man ikke er et matematisk geni s� kan det virke lidt skr�mmende,
	 men at hvis man nu @Overrider equals s� m� man for guds skyld
	 ikke ignorerer det fordi det giver defektive klasser. Og
	 med den slags fejl kan det v�re super super sv�rt at finde ud af hvor crashet kommer fra.
	 og dette forekommer selF oftest med Collection klasserne fordi de bruger
	 equals og regner blindt med at den overholder kontrakten. 
	 p� side 58 starter en mere lenghty forklaring p� kontrakten der ser
	 forst�elig ud.
	 
	 Den f�rste giver faktisk fin mening, handler om hvordan at man kan lave en 
	 klasse der sammenligner Strings og er ligeglad med hvad de kalder symmetri, 
	 og det g�r man ved at String.equals() metoden ikke kender til ens klasse,
	 s� det betyder at hvis man siger voresString.equals(string) s� 
	 returner den true, men omvendt hvis man tager deres String.equals(voresString)
	 s� vil den returne false... s� p� den m�de har vi overskredet symmetrien.
	 og dette er ikke for vores skyld, det er mere eller mindre at vi ingen fucking anelse
	 har om en collection returner true eller false n�r den sorter eller laver andre ting.
	 p� side 59 nederst, er der et kode eksempel der forklare hvordan man skal g�re
	 i stedet, for at fixe det.
	 
	 senere foresl�r den en reel ting, at man ikke mixer klassen
	 TimeStamp og Dates, der er en warning label disse klasser, og de
	 m� under ingen omst�ndigheder v�re i samme collection, side 64 �verst forklare.
	 
	 der er noget med java.net.URL klassens equals
	 metode, fordi dens equal  n�r den sammenligner IP
	 addresser oversat fra et hostname, s� kan det kr�ve netv�rksforbindelse,
	 dette har givet reele problemer i virkeligheden.
	 Jeg tror hvertfald det er det den siger, nederst p� side 64.
	 
	 man skal desuden sikrer sig at et objekt ikke kan v�re .equals(null)
	 og return true... den skal altid return false,  at returne en
	 NullPointerException er desuden ogs� d�rlig skik her s� vidt jeg forst�r.
	 og det ved vi jo fra vores eget brug, at hvis en equals metode smider en nullPointerException
	 hver gang, s� kan vi ikke bruge den til noget.
	 
	 nederst p� side 65 er der nogle steps/gode r�d til at lave en
	 h�j kvalitet equals metode.
	 
	 
	 
	 
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{

	}

}
