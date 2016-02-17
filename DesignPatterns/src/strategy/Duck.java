package strategy;

public abstract class Duck 
{
	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;
	
	
	public Duck() 
	{
	
	}
	
	/*
	 * S�dan at vi kan �ndre typen p� implementationen ved runtime, s�dan at vi kan fjerne en MallardDucks
	 * vinger hvis det er s�dan vi har implementeret en MallardDuck. 
	 */
	public void setQuackBehavior(QuackBehavior qb)
	{
		this.quackBehavior = qb;
	}
	
	public void setFlyBehavior(FlyBehavior fb)
	{
		this.flyBehavior = fb;
	}
	
	/*
	 * Den her metode erstatter quack()
	 */
	public void performQuack()
	{
		quackBehavior.quack();
	}
	
	/*
	 * Den her metode erstatter fly()
	 */
	public void performFly()
	{
		flyBehavior.fly();
	}
	
	public void swim()
	{
		System.out.println("All ducks float, even decoys!");
	}
	
	public abstract void display();

}