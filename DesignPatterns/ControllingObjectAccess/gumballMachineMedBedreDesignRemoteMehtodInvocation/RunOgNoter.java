package gumballMachineMedBedreDesignRemoteMehtodInvocation;

/**
 * Den officielle definition af State pattern:
 * "The State Pattern allows an object to alter its behavior
 * when its internal state changes. The object will appear to change
 * its class"
 * 
 * Der er også et diagram nederst på side 417 om dette.
 * 
 * Det har åbenbart præcis det samme
 * klasse diagram som Strategy Pattern,
 * og de 2 minder også super meget om hinanden,
 * den eneste forskel på dem er deres hensigt.
 * på den måde at Strategy pattern er et flexibilt alternativ
 * til at subclasse ting, ved at bruge composition. 
 * 
 * State bruger så også bare et fælles interface for nogle klasser,
 * et state objekt sådan at man kan ligge hvilken som helst opførsel ind
 * istedet for en anden. 
 * 
 * Der er faktisk nogle rigtig gode ting på side 419,
 * mhs. til at hvis vi havde referener i vores behavior klasser
 * som f.eks NoQuarterState, så ville vi tilføje dependencies 
 * imellem vores klasser og vi ville fjerne  det design princip
 * fra vores kode som hedder "Closed for modification, but open for 
 * extension", fordi hver gang vi fik et nyt State, så skulle en instans af det jo tilføjes
 * i alle klasserne.
 * 
 * En anden ting som står er bla. at det er et ligesom et observer Pattern i den forstand
 * at hvis vi ændre State udenfor vores contexts(State klassernes) viden, så mister vi noget
 * gennemskuelighed...
 * Desuden så må vores state klasser heller ikke ændre vores
 * Contexts state, det er ene og alene contexts eget ansvar ... dette betyder også at
 * andre klasser end vores context heller ikke må få adgang til vores state klasser,
 * det ville ikke være godt design. 
 * 
 * Men faktisk, hvis vi havde en masse context klasser(som f.eks vores GumballMachine),
 * så ville det være i orden at de alle sammen deltes om de samme state klasser,
 * men man kunne forestille sig at noget synchronization sammen med nogle volatile variabler 
 * eller static ville skulle implementeres i dette tilfælde.
 * 
 * 
 * 
 * 
 * @author DenLilleMand
 */
public class RunOgNoter {

	public static void main(String[] args) 
	{

	}

}
