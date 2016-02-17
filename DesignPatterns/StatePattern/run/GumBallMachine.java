package run;
public class GumBallMachine {
	public final static int SOLD_OUT = 0;
	public final static int NO_QUARTER = 1;
	public final static int HAS_QUARTER = 2;
	public final static int SOLD = 3;

	int state = SOLD_OUT;
	int count = 0;

	public GumBallMachine(int count) {
		this.count = count;
		if (count > 0) {
			state = NO_QUARTER;
		}
	}

	public void insertQuarter() 
	{

		if (state == HAS_QUARTER) {
			System.out.println("You can't insert another quarter");
		} else if (state == SOLD_OUT) {
			System.out
					.println("You can't insert a quarter, the machine is sold out");
		} else if (state == SOLD) {
			System.out
					.println("Please wait, we're allready giving you a gumball");
		} else if (state == NO_QUARTER) {
			System.out.println("state = HAS_QUARTER");
			System.out.println("You inserted a quarter");
		}
	}
	
	public void ejectQuarter()
	{
		if(state == HAS_QUARTER)
		{
			System.out.println("Quarter returned");
		}
		else if(state == NO_QUARTER)
		{
			System.out.println("you haven't inserted a quarter");
		}
		else if(state == SOLD)
		{
			System.out.println("Sorry, you allready turned the crank");
		}
		else if(state == SOLD_OUT)
		{
			System.out.println("You can't eject, you haven't inserted a quarter yet");
		}
	}
	
	public void turnCrank()
	{
		if(state == SOLD)
		{
			System.out.println("Turning twice doesn't get you another gumball!");
		}
		else if(state == NO_QUARTER)
		{
			System.out.println("You turned but theres no quarter!");
		}
		else if(state == SOLD_OUT)
		{
			System.out.println("You turned but there are no gumballs");
		}
		else if(state == HAS_QUARTER)
		{
			System.out.println("You turned...");
			state = SOLD;
			dispense();
		}
	}
	
	public void dispense()
	{
		if(state == SOLD)
		{
			System.out.println("A gumball comes rolling out the slot");
			count = count -1;
			if(count == 0)
			{
				System.out.println("Oops, out of gumballs!");
			}
			else 
			{
				state = NO_QUARTER;
			}
		}
		else if(state == NO_QUARTER)
		{
			System.out.println("You need to pay first");
		}
		else if(state == SOLD_OUT)
		{
			System.out.println("No gumball dispensed");
		}
		else if(state == HAS_QUARTER)
		{
			System.out.println("No gumball dispensed");
		}
	}
	
	/**
	 * Tilføj andre metoder som toString() & refill() her . 
	 */
	
}
