package observer;

public class Boss implements Observer{

	@Override
	public void update(String transactions) 
	{
		System.out.println("Boss received transactions: " + transactions);
	}

}
