package simpleExample;

/**
 * Vi laver det her CommandPattern over et Diner eksempel fra bogen,
 * så alle klasserne/metoder har fået tildelt deres tilsvarende. 
 * ca side 206 i bogen ... 
 * 
 * The command Pattern officielle definition:"The command Pattern encapsulates a request
 * as an object, thereby letting you parameterize other objects with different requests, queue or log requests and support undoable 
 * operations."
 * 
 * Der kommer til at være nogle forskellige implementationer
 * af CommandPattern, så vi må lige kigge på om der kan laves
 * en ny pakke pr. implementation eller et nyt projekt. 
 * Det virker til at der er det standard commandPattern som bare kræver
 * et commandinterface der bliver implementeret af en klasse som f.eks LightInGarage,
 * den kræver så at man har en execute() metode, og så giver man rimelig 
 * simpelt bare en dockingKlasse(CommandPattern blabla) ind som parameter og kalder 
 * execute på den, hvor docking klassen er ligeglad med typen ... eller også er det
 * lidt anderledes, men det er det Det ligner på side 210.
 * Okay så man har en Command klasse, som tager imod en parameter som f.eks LightInGarage som før,
 * den klasse man så giver ind som parameter har så en action metode,
 * som bliver kaldt igennem command klassens execute() metode. og så bagefter
 * kan man sætte den til en remoteControl slot. 
 * 
 * Der er 'The meta Command Pattern' der tillader en at lave macros af kommandoer so man kan execute() flere kommandoer
 * samtidigt.  og så skal vi også lærer at implementere queues, logs og undo operationer.
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
