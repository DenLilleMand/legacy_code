package homeThreaterFacadeExample;
/**
 * Den officielle definition af 'The Facade Pattern'
 * :"The Facade Pattern provides a unified interface to a set of interfaces in a subsystem.
 * Facade defines a higher-level interface that makes the subsystem easier to use."
 * Husk at interfaces ikke altid er typen 'Interface' i java, men kan ogs� bare v�re
 * en samling af metoder... 
 * Man skal huske med patterns at Definition er det vigtigste - 
 * s�dan at man ikke pr�ver at presse en firkant igennem et rundt hul,
 * og i Facade Patterns tilf�lde er det vigtigt at det bliver brugt til at 
 * forsimple en given m�ngde klasser i et sub-system. 
 * 
 * hvilket man kan se p� side 268. 
 * og det er tydeligt at vores HomeTheaterFacade jo ikke er et
 * interface, men fordi den indeholder en masse metoder fra andre klasser af,
 * s� bliver det et interface.
 * 
 * Der er ogs� et nyt Design Princip her:"Principle of Least Knowledge
 * - talk only to your immediate friends"
 * 
 * det bliver faktisk forklaret rigtig godt p� side 269-
 * og det handler om at man ikke bare skal t�nke p� arkitekturen, men ogs�
 * hvilke klasser der bruger hvilke objekter - fordi nu flere 'dependencies' objekterne i klasserne
 * har - nu sv�rerer er det at forst� vores program og at velligeholde det.
 * 
 * der er 4 guidelines til at hj�lpe en til at overholde dette:
 * Hvis man tager et vilk�rligt objekt, s� fra hvilken som helst metode i det her objekt-
 * s� m� vi kun kalde metoder der h�rer til:
 * 1. Objektet selv.
 * 2. Objects passed ind som parameter til en metode.
 * 3. et hvert object some bliver instansieret eller skabes i klassen.
 * 4. Enhver component af objektet(Think of a component as any object that is referenced
 * by an instance variable. In other words think of this as a HAS-A relationship).
 * 
 * Dette betyder blandt andet at man ikke m� kalde metoder p� et objekt som er blevet returneret til os-
 * fordi s� taler vi med et andet Objects sub-del og dermed �ger vi hvor mange Objekter vi kender til.
 * Istedet for burde man bede objektet om at g�re arbejdet for en - s�dan at man ikke beh�ver at kende til 
 * detaljerne. der st�r mere om det p� side 270 - jeg ved ikke
 * helt om jeg forst�r hvor man ellers skulle bede objektet om det, m�ske
 * mener de at hvis man har brug for at f� returnet et objekt s� burde man allerede have 
 * en instans af det objekt alligevel...
 * 
 * 
 * @author DenLilleMand
 *
 */
public class HomeTheaterTestDrive {
	public static void main(String [] args)
	{
		//instantiate components here
		Amplifier amp = new Amplifier();
		Tuner tuner = new Tuner();
		DvdPlayer dvd = new DvdPlayer();
		CdPlayer cd = new CdPlayer();
		Projector projector = new Projector();
		Screen screen = new Screen();
		TheaterLights lights = new TheaterLights();
		PopcornPopper popper = new PopcornPopper();
		
		HomeTheaterFacade homeTheater = new HomeTheaterFacade(amp,tuner,dvd,cd,projector,screen,lights,popper);

		homeTheater.watchMovie("Hitlers for�r");
		homeTheater.endMovie();
	}
}
