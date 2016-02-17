package gumballMachineMedBedreDesignRemoteMehtodInvocation;

import java.util.Random;

public class HasQuarterState implements State
{
	transient GumballMachine gumballMachine;
	transient Random randomWinner = new Random(System.currentTimeMillis());
	
	public HasQuarterState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	@Override
	public void insertQuarter() 
	{
		System.out.println("You can't insert another quarter!");
	}

	@Override
	public void ejectQuarter() 
	{
		System.out.println("Quarter returned");
		gumballMachine.setState(gumballMachine.getNoQuarterState());
	}

	/**
	 * Virker til at vi er nogle r�vhuller og kun lader folk vinde
	 * i vores lille gumball spil med 10% chance, hvis vi har mere end 1 
	 * gumball - istedet for f.eks at give personen pengene tilbage +
	 * den ene kugle :)
	 */
	@Override
	public void turnCrank() 
	{
		System.out.println("You turned...");
		int winner = randomWinner.nextInt(10);
		if((winner == 0) && (gumballMachine.getCount() > 1))
		{
			gumballMachine.setState(gumballMachine.getWinnerState());
		}
		else
		{
			gumballMachine.setState(gumballMachine.getSoldState());
		}
	}

	@Override
	public void dispense() 
	{
		System.out.println("No gumball dispensed");
	}
	
	public String toString()
	{
		return "Has Quarter State";
	}

}
