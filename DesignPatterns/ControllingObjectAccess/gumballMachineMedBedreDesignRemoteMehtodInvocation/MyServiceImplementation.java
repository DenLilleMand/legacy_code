/**
 * This is the class that does the Real Work.
 * It has the real implementation of the remote methods defined
 * in the remote interface.
 * it's the object that the client wants to call methods on(e.g., out GumballMachine!).
 *
 *
 *På side 448 eller 449 der starter der en guide
 *til hvad man skal gøre for at sætte sin RMI op til at fungerer,
 *de efterfølgende noter er lavet på¨baggrund af disse trin.
 *
 *
 *Åbenbart så kommer den her klasse til at have 2 hjælpe klasser,
 *igennem noget som hedder 'rmic', det betyder at den laver en
 *MyServiceImplementation_Stub.class & en MyServiceImplementation_Skel.class automatisk,
 *så længe vi fortæller den at vi gerne vil bruge 'rmic',
 *'rmic' bliver shipped med vores helt almindelige java pakke,
 *så vi skal bare fortælle den at det er det vi har lyst til, det håber
 *jeg da kommer til at fremgå af koden,  man behøver ikke at kende source koden
 *eller ændre i koden på disse 2 klasser, de gør det hele automatisk(Hvilket er et underligt
 *råd fordi det vel ikke kan skade at kende den API der er bag ved ens applikation).
 *
 *Vi skal blot starte vores RMI registry, som man skal gøre i en seperat terminal
 *
 *
 */
package gumballMachineMedBedreDesignRemoteMehtodInvocation;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
/**
 * OBS: Husk at der bliver brugt Serialization, så hvis man bruger
 * javas egne klasser/primitive er det ikke noget problem,
 * men hvis man bruger sine egne typer skal skal man huske at implementere
 * Serializeable/lad være med at lave dem statiske/transient osv.
 * 
 * @author DenLilleMand
 *
 */
public class MyServiceImplementation implements MyRemote{

	@Override
	public String sayHello() throws RemoteException 
	{
		return "Hello";
	}
	/**
	 * Bliver vist ordentligt på side 455 hvordan det her
	 * fungere.
	 * @throws MalformedURLException
	 * @throws RemoteException
	 * @throws NotBoundException
	 */
	public void lookUp() throws MalformedURLException, RemoteException, NotBoundException
	{
		MyRemote service = (MyRemote) Naming.lookup("rmi://127.0.0.1/RemoteHello");
	}
	
	
}
