package simpleExample;

/**
 * Vi laver det her CommandPattern over et Diner eksempel fra bogen,
 * s� alle klasserne/metoder har f�et tildelt deres tilsvarende. 
 * ca side 206 i bogen ... 
 * 
 * The command Pattern officielle definition:"The command Pattern encapsulates a request
 * as an object, thereby letting you parameterize other objects with different requests, queue or log requests and support undoable 
 * operations."
 * 
 * Der kommer til at v�re nogle forskellige implementationer
 * af CommandPattern, s� vi m� lige kigge p� om der kan laves
 * en ny pakke pr. implementation eller et nyt projekt. 
 * Det virker til at der er det standard commandPattern som bare kr�ver
 * et commandinterface der bliver implementeret af en klasse som f.eks LightInGarage,
 * den kr�ver s� at man har en execute() metode, og s� giver man rimelig 
 * simpelt bare en dockingKlasse(CommandPattern blabla) ind som parameter og kalder 
 * execute p� den, hvor docking klassen er ligeglad med typen ... eller ogs� er det
 * lidt anderledes, men det er det Det ligner p� side 210.
 * Okay s� man har en Command klasse, som tager imod en parameter som f.eks LightInGarage som f�r,
 * den klasse man s� giver ind som parameter har s� en action metode,
 * som bliver kaldt igennem command klassens execute() metode. og s� bagefter
 * kan man s�tte den til en remoteControl slot. 
 * 
 * Der er 'The meta Command Pattern' der tillader en at lave macros af kommandoer so man kan execute() flere kommandoer
 * samtidigt.  og s� skal vi ogs� l�rer at implementere queues, logs og undo operationer.
 * 
 * 
 * 
 * @author DenLilleMand
 */
public class Run 
{
	public static void main(String [] args)
	{
		
	}
}
