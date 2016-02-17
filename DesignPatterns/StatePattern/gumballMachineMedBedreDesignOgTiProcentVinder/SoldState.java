package gumballMachineMedBedreDesignOgTiProcentVinder;

public class SoldState implements State{

	GumballMachine gumballMachine;
	
	public SoldState(GumballMachine gumballMachine)
	{
		this.gumballMachine = gumballMachine;
	}
	
	@Override
	public void insertQuarter() {
		System.out.println("Please wait, we're allready giving you a gumball");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("sorry, you already turned the crank");
	}

	@Override
	public void turnCrank() {
		System.out.println("Turning twice doesn't get you another gumball!");
		
	}

	@Override
	public void dispense() {
		gumballMachine.releaseBall();
		if(gumballMachine.getCount() > 0)
		{
			gumballMachine.setState(gumballMachine.getNoQuarterState());
		}
		else
		{
			System.out.println("Oops, out of gumballS!");
			gumballMachine.setState(gumballMachine.getSoldOutState());
		}	
	}
	
	public String toString()
	{
		return "Sold State";
	}

}
