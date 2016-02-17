package gumballMachineMedBedreDesignOgTiProcentVinder;

/**
 * Den officielle definition af State pattern:
 * "The State Pattern allows an object to alter its behavior
 * when its internal state changes. The object will appear to change
 * its class"
 * 
 * Der er ogs� et diagram nederst p� side 417 om dette.
 * 
 * Det har �benbart pr�cis det samme
 * klasse diagram som Strategy Pattern,
 * og de 2 minder ogs� super meget om hinanden,
 * den eneste forskel p� dem er deres hensigt.
 * p� den m�de at Strategy pattern er et flexibilt alternativ
 * til at subclasse ting, ved at bruge composition. 
 * 
 * State bruger s� ogs� bare et f�lles interface for nogle klasser,
 * et state objekt s�dan at man kan ligge hvilken som helst opf�rsel ind
 * istedet for en anden. 
 * 
 * Der er faktisk nogle rigtig gode ting p� side 419,
 * mhs. til at hvis vi havde referener i vores behavior klasser
 * som f.eks NoQuarterState, s� ville vi tilf�je dependencies 
 * imellem vores klasser og vi ville fjerne  det design princip
 * fra vores kode som hedder "Closed for modification, but open for 
 * extension", fordi hver gang vi fik et nyt State, s� skulle en instans af det jo tilf�jes
 * i alle klasserne.
 * 
 * En anden ting som st�r er bla. at det er et ligesom et observer Pattern i den forstand
 * at hvis vi �ndre State udenfor vores contexts(State klassernes) viden, s� mister vi noget
 * gennemskuelighed...
 * Desuden s� m� vores state klasser heller ikke �ndre vores
 * Contexts state, det er ene og alene contexts eget ansvar ... dette betyder ogs� at
 * andre klasser end vores context heller ikke m� f� adgang til vores state klasser,
 * det ville ikke v�re godt design. 
 * 
 * Men faktisk, hvis vi havde en masse context klasser(som f.eks vores GumballMachine),
 * s� ville det v�re i orden at de alle sammen deltes om de samme state klasser,
 * men man kunne forestille sig at noget synchronization sammen med nogle volatile variabler 
 * eller static ville skulle implementeres i dette tilf�lde.
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
