package homeThreaterFacadeExample;
/**
 * Den officielle definition af 'The Facade Pattern'
 * :"The Facade Pattern provides a unified interface to a set of interfaces in a subsystem.
 * Facade defines a higher-level interface that makes the subsystem easier to use."
 * Husk at interfaces ikke altid er typen 'Interface' i java, men kan også bare være
 * en samling af metoder... 
 * Man skal huske med patterns at Definition er det vigtigste - 
 * sådan at man ikke prøver at presse en firkant igennem et rundt hul,
 * og i Facade Patterns tilfælde er det vigtigt at det bliver brugt til at 
 * forsimple en given mængde klasser i et sub-system. 
 * 
 * hvilket man kan se på side 268. 
 * og det er tydeligt at vores HomeTheaterFacade jo ikke er et
 * interface, men fordi den indeholder en masse metoder fra andre klasser af,
 * så bliver det et interface.
 * 
 * Der er også et nyt Design Princip her:"Principle of Least Knowledge
 * - talk only to your immediate friends"
 * 
 * det bliver faktisk forklaret rigtig godt på side 269-
 * og det handler om at man ikke bare skal tænke på arkitekturen, men også
 * hvilke klasser der bruger hvilke objekter - fordi nu flere 'dependencies' objekterne i klasserne
 * har - nu sværerer er det at forstå vores program og at velligeholde det.
 * 
 * der er 4 guidelines til at hjælpe en til at overholde dette:
 * Hvis man tager et vilkårligt objekt, så fra hvilken som helst metode i det her objekt-
 * så må vi kun kalde metoder der hører til:
 * 1. Objektet selv.
 * 2. Objects passed ind som parameter til en metode.
 * 3. et hvert object some bliver instansieret eller skabes i klassen.
 * 4. Enhver component af objektet(Think of a component as any object that is referenced
 * by an instance variable. In other words think of this as a HAS-A relationship).
 * 
 * Dette betyder blandt andet at man ikke må kalde metoder på et objekt som er blevet returneret til os-
 * fordi så taler vi med et andet Objects sub-del og dermed øger vi hvor mange Objekter vi kender til.
 * Istedet for burde man bede objektet om at gøre arbejdet for en - sådan at man ikke behøver at kende til 
 * detaljerne. der står mere om det på side 270 - jeg ved ikke
 * helt om jeg forstår hvor man ellers skulle bede objektet om det, måske
 * mener de at hvis man har brug for at få returnet et objekt så burde man allerede have 
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

		homeTheater.watchMovie("Hitlers forår");
		homeTheater.endMovie();
	}
}
