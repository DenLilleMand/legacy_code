package gumballMachineMedBedreDesignRemoteMehtodInvocation;

public class SoldOutState implements State
{
	transient GumballMachine gumballMachine;
	public SoldOutState(GumballMachine gumballMachine) {
		this. gumballMachine = gumballMachine;
	}

	@Override
	public void insertQuarter() 
	{
		System.out.println("You can't insert a quarter, the machine is sold out");
		//ejectQuarter();
	}

	@Override
	public void ejectQuarter() 
	{		
		System.out.println("You can't eject you haven't inserted a quarter");
	}

	@Override
	public void turnCrank() 
	{	
		System.out.println("We're out of gumballs, dont crank it lol");
	}

	@Override
	public void dispense() 
	{
		System.out.println("Cannot dispense when we're sold out");
	}
	
	public void refill(int count)
	{
		gumballMachine.refill(count);
		gumballMachine.setState(gumballMachine.getNoQuarterState());
	}
	
	public String toString()
	{
		return "Sold Out State";
	}

}
