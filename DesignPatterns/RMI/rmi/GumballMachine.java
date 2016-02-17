package rmi;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * The gumballMachine is our remote service; it's
 * going to expose a remote interface for
 * the client to use.
 * @author DenLilleMand
 *
 */
public class GumballMachine extends UnicastRemoteObject implements GumballMachineRemote 
{

	String location;
	int count;
	State state;
	
	public GumballMachine(String location, int numberGumballs) throws RemoteException 
	{
		this.location = location;
		count = numberGumballs;
	
	}

	@Override
	public int getCount() throws RemoteException 
	{
		return count;
	}

	@Override
	public String getLocation() throws RemoteException 
	{
		return location;
	}

	@Override
	public State getState() throws RemoteException 
	{
		return state;
	}

}
