package obeyTheGeneralContractWhenOverridingEquals;

public class NoterOgRun 
{
	/**
	 * okay, haha ... vi er virkelig noobs,
	 * det havde jeg slet ikke tænkt på. 
	 * Åbenbart så er Object klassen lavet til at
	 * man skal extende den, og selvom vi bruger den
	 * til at lave "flexible".
	 * metoder som equals, hashCode, toString,clone og finalize 
	 * har alle sammen 'general contracts' fordi de er designed til
	 * at blive @Override. men hvis man ikke overholder
	 * deres generalle kontrakt så kan klasser som HashMap og Hashset
	 * fejle. finalize bliver ikke diskuteret i det her 
	 * kapitel fordi det blev det, i det sidste.  
	 * Men de vil prøve at vise os hvornår man skal
	 * extende Object.
	 
	 Equals - den eneste måde at undgå problemer at at aldrig
	 @Override den her metode, der er nogle regler dog, f.eks skal man
	 slet ikke gøre det hvis man har med en klasse at gøre som er 'inherently unique'
	 og det giver jo fin mening, fordi så skal den jo bare kunne tjekke på om den er 
	 .equals(sig-selv). 
	 
	 reglerne for hvornår man ikke skal @Override
	 er når en SuperKlasse allerede har @Override equals
	 og den samme opførsel giver mening for ens sub-class.
	 
	 et sidste tilfælde er at hvis klassen er privat
	 eller package-private og man er sikker på at metoden
	 aldrig vil blive invoked() så kan man @Override den og smide en AssertionError() (slags exception, side 57)
	 og det er bare for en sikkerheds skyld.
	 
	 
	 Så hvornår SKAL vi så @Override equals metoden? og det er når
	 Objektet har en sans for 'logical equality' der udskeller sig fra 
	 den basale objekt identitet && noget andet der skal være sandt er 
	 at superklassen selF heller ikke allerede har @Override en der giver mening
	 for ens subclass.
	 anyway, dette er ofte tilfældet for hvad der hedder 'value classes'
	 f.eks Integer og Date klasserne der er tættere på at repræsentere en værdi
	 end at repræsentere en objekt værdi.
	 
	 der står bare noget mere med at f.eks så går en programmør ud fra at når han bruger
	 '==' så sammenligner han på værdi og ikke på objektets identitet, 
	 så det gør det vel ekstra vigtigt at have adgang
	 til java's source code sådan at man kan se
	 hvordan equals metoden er implementeret. f.eks klasser som 
	 den singleton enum vi havde lavet i den anden pakke for den her bog, der
	 burde man altid bare tjekke på objektets identitet fordi der kun er 1 af den, 
	 der er værdien og identiteten det samme.
	 
	 Der er en kontrakt, som er hvad man skal overholde når man @Overrider
	 equals metoden nederst på side 57, jeg har ikke tænkt mig at skrive det ned her.
	 den siger bla. at hvis man ikke er et matematisk geni så kan det virke lidt skræmmende,
	 men at hvis man nu @Overrider equals så må man for guds skyld
	 ikke ignorerer det fordi det giver defektive klasser. Og
	 med den slags fejl kan det være super super svært at finde ud af hvor crashet kommer fra.
	 og dette forekommer selF oftest med Collection klasserne fordi de bruger
	 equals og regner blindt med at den overholder kontrakten. 
	 på side 58 starter en mere lenghty forklaring på kontrakten der ser
	 forståelig ud.
	 
	 Den første giver faktisk fin mening, handler om hvordan at man kan lave en 
	 klasse der sammenligner Strings og er ligeglad med hvad de kalder symmetri, 
	 og det gør man ved at String.equals() metoden ikke kender til ens klasse,
	 så det betyder at hvis man siger voresString.equals(string) så 
	 returner den true, men omvendt hvis man tager deres String.equals(voresString)
	 så vil den returne false... så på den måde har vi overskredet symmetrien.
	 og dette er ikke for vores skyld, det er mere eller mindre at vi ingen fucking anelse
	 har om en collection returner true eller false når den sorter eller laver andre ting.
	 på side 59 nederst, er der et kode eksempel der forklare hvordan man skal gøre
	 i stedet, for at fixe det.
	 
	 senere foreslår den en reel ting, at man ikke mixer klassen
	 TimeStamp og Dates, der er en warning label disse klasser, og de
	 må under ingen omstændigheder være i samme collection, side 64 øverst forklare.
	 
	 der er noget med java.net.URL klassens equals
	 metode, fordi dens equal  når den sammenligner IP
	 addresser oversat fra et hostname, så kan det kræve netværksforbindelse,
	 dette har givet reele problemer i virkeligheden.
	 Jeg tror hvertfald det er det den siger, nederst på side 64.
	 
	 man skal desuden sikrer sig at et objekt ikke kan være .equals(null)
	 og return true... den skal altid return false,  at returne en
	 NullPointerException er desuden også dårlig skik her så vidt jeg forstår.
	 og det ved vi jo fra vores eget brug, at hvis en equals metode smider en nullPointerException
	 hver gang, så kan vi ikke bruge den til noget.
	 
	 nederst på side 65 er der nogle steps/gode råd til at lave en
	 høj kvalitet equals metode.
	 
	 
	 
	 
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{

	}

}
