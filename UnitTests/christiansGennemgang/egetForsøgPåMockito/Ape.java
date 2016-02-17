package egetForsøgPåMockito;

public class Ape 
{
	private Banana banana;
	
	public Ape(Banana banana)
	{
		this.banana = banana;
	}
	
	public void run(int a)
	{
		if(a > 0)
		{
			banana.doSomething();
		}
	}
}
