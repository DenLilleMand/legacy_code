package gumballMachineMedBedreDesignOgTiProcentVinder;

public class GumballMonitor {
	GumballMachine machine;
	
	public GumballMonitor(GumballMachine machine)
	{
		this.machine = machine;
	}
	
	public void report()
	{
		System.out.println("Gumball Machine: " + machine.getLocation());
		System.out.println("Current inventory: " + machine.getCount());
		System.out.println("Current State: " + machine.getState().toString());
	}
}
