package gumballMachineMedBedreDesignRemoteMehtodInvocation;

public class WinnerState implements State{
	transient GumballMachine gumballMachine;
	
	public WinnerState(GumballMachine gumballMachine)
	{
		this.gumballMachine = gumballMachine;
	}
	
	
	@Override
	public void insertQuarter() {
		System.out.println("Cannot win w/o inserting quarter");
		
	}

	@Override
	public void ejectQuarter() {
		System.out.println("Cannot eject a quarter after winning");
		
	}

	@Override
	public void turnCrank() {
		System.out.println("You've just won - why did you turn the crank you greedy little fuck");
	}

	@Override
	public void dispense() {
		System.out.println("YOURE A WINNER! - You get two gumballs for your quarter!");
		gumballMachine.releaseBall();
		if(gumballMachine.getCount() == 0)
		{
			gumballMachine.setState(gumballMachine.getSoldOutState());
		}
		else 
		{
			gumballMachine.releaseBall();
			if(gumballMachine.getCount() == 0)
			{
				gumballMachine.setState(gumballMachine.getNoQuarterState());
			}
			else
			{
				System.out.println("Oops, out of gumballs!");
				gumballMachine.setState(gumballMachine.getSoldOutState());
			}
		}
	}

}
