package rmi;
import java.rmi.*;
import java.rmi.server.*;

public class MyServiceImpl extends UnicastRemoteObject implements MyRemote
{

	public MyServiceImpl() throws RemoteException {}
	
	@Override
	public String sayHello() throws RemoteException 
	{		
		return "Server says, 'Hey'";
	}
	
	public static void main(String [] args)
	{
		try
		{
			MyRemote service = new MyServiceImpl();
			/**
			 * Det er s�dan her vi registrerer en 'ting'
			 * hos RMI registry, men jeg troede faktisk at vi skulle
			 * binde den til en metode... s� vi m� lige se hvordan 
			 * vi specificere en metode i kaldet.
			 */
			Naming.rebind("Remote Hello", service);
		}catch(Exception ex) {}
	}
	
	

}
