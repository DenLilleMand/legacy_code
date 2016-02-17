package gumballMachineMedBedreDesignRemoteMehtodInvocation;

public class GumballMachine {
	
	/**
	 * Der mangler måske nogle metoder som vi enten ikke har haft brug for 
	 * eller som vi implementere løbende som f.eks getters
	 */
	
	State soldOutState;
	State noQuarterState;
	State hasQuarterState;
	State soldState;
	State winnerState;
	
	String location;
	/**
	 * Jeg tror at man burde lave et observer
	 * pattern omkring det her State, og så
	 * tilføje hvad der skal ske ved et state skifte igennem det.
	 * 
	 */
	State state;
	int count = 0;
	
	public GumballMachine(String location,int numberGumballs)
	{
		soldOutState = new SoldOutState(this);
		noQuarterState = new NoQuarterState(this);
		hasQuarterState = new HasQuarterState(this);
		soldState = new SoldState(this);
		winnerState = new WinnerState(this);
		state = soldState;
		this.count = numberGumballs;
		this.location = location;
		if(numberGumballs > 0)
		{
			state = noQuarterState;
		}
	}
	
	public String getLocation()
	{
		return location;
	}
	
	public State getHasQuarterState() 
	{
		return hasQuarterState;
	}
	
	public void ejectQuarter()
	{
		state.ejectQuarter();
	}
	
	public void insertQuarter()
	{
		state.insertQuarter();
	}
	
	public void turnCrank()
	{
		state.turnCrank();
		state.dispense();
	}


	public void setState(State state) 
	{
		this.state = state;
	}
	
	public void releaseBall()
	{
		System.out.println("A gumball comes rolling out the slot...");
		if(count  != 0)
		{
			count = count-1;
		}
	}
	
	public int getCount()
	{
		return count;
	}

	public State getNoQuarterState() {
		return noQuarterState;
	}

	public State getSoldOutState() {
		return soldOutState;
	}

	public State getSoldState() {
		return soldState;
	}
	
	public void refill(int count)
	{
		this.count = count;
		System.out.println("You just refilled");
	}

	public State getWinnerState() {
		return winnerState;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder("GumballMachine, count: ");
		sb.append(getCount());
		sb.append(". State: " + state.toString());
		return sb.toString();
	}

	public State getState() {
		return state;
	}
}
