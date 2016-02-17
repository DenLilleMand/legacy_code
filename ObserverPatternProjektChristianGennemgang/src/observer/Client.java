package observer;

public class Client implements Observer{

	@Override
	public void update(String transactions) 
	{
		System.out.println("Client received transaction: " + transactions);
	}

}
