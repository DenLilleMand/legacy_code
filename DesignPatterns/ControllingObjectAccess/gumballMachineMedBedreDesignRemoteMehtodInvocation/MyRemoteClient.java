package gumballMachineMedBedreDesignRemoteMehtodInvocation;

import java.rmi.Naming;

public class MyRemoteClient {

	public static void main(String[] args) 
	{
		new MyRemoteClient().go();
	}
	
	/**
	 * Der st�r noget p� side 456, om hvordan man kan bruge noget som hedder
	 * dynamic class loading, til at skaffe den der  client Stub,
	 * det er noget som man i mindre programmer bare sender, men hvis der
	 * er mange ting som skal sendes, s� kan man bruge dette... det er dog
	 * lidt sv�rerer - (taler lidt flyvsk om dette, fordi det her pattern giver ingen
	 * mening for mig indtil videre- tror ikke det er s� sv�rt, men jeg har sv�rt
	 * ved at skelne imellem Server klasserne og Client klasserne lige nu, jeg tror
	 * de minder meget om hinanden ... 
	 * 
	 * p� side 457 st�r der de 3 ting som programm�rer
	 * oftest g�r forkert n�r 
	 * de pr�ver at lave RMI :
	 * 
	 * 1: Forget to start rmiregistry before starting remote service(when the service is registered 
	 * using Naming.rebind(), the rmiregistry must be running!).
	 * 2. Forget to make arguments and return types serializable(you won't know until runtime;
	 * this is not something the compiler will detect).
	 * 3.forget to give the stub class to the client.
	 * 
	 * 
	 */
	public void go()
	{
		try
		{
			//man kan godt bruge hostname istedet for ip, og s� skal man bruge
			//navnet brugt til at bind/rebind.. 
			MyRemote service = (MyRemote) Naming.lookup("rmi://127.0.0.1/RemoteHello");
			
			//kan se hvordan den her metode bare ligner en normal metode,
			//bortset fra at den lige skal tage sig af exception.
			String s = service.sayHello();
			System.out.println(s);
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
