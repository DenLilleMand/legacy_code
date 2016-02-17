package gumballMachineMedBedreDesignRemoteMehtodInvocation;

public class GumballMonitor 
{
	GumballMachineRemote machine;
	
	public GumballMonitor(GumballMachineRemote machine)
	{
		this.machine = machine;
	}
	
	public void report()
	{
		try
		{
			System.out.println("Gumball Machine: " + machine.getLocation());
			System.out.println("Current inventory: " + machine.getCount());
			System.out.println("Current State: " + machine.getState().toString());
			
		}catch(Exception e) {e.printStackTrace();}
	}
}
