package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * The remote interface defines the methods
 * that a client can call remotely. it's what the client will use as the class type for your
 * service. Both the Stub and the actual service will implement this!
 * 
 * Det her er da f�rste gang vi bruger et interface, og s� extender en klasse,  tror man m� n�d til at se lidt p� det som vores
 * Observer pattern . . . hvor det er en smule irreterende at det er en klasse man skal extende istedet for et interface, 
 * grunden til dette var bla. at hvis man har en klasse som extender Observable s� kan man jo ikke subclass den andre ting,
 * og det er vel det samme med dette - p� trods af at man m�ske ikke ville subclasse den her, vi kender jo ikke det her pattern s� godt endnu.
 * 
 * En vild tanke kunne v�re om vores Observable interface kunne extende  Observable .. og s� kunne vores subclasse bare implementere 
 * det interface,, men det tror jeg da ikke er muligt? det ville v�re for vildt :) 
 */

/**
 * Vi skal smide remote Exceptions, fordi vi skal
 * anerkende at vi g�re det over internettet og der kan ske alt muligt.
 * 
 * 
 * 
 * @author DenLilleMand
 */
public interface MyRemote extends Remote
{
	public String sayHello() throws RemoteException;
	
}
