package strategy;

public abstract class Duck 
{
	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;
	
	
	public Duck() 
	{
	
	}
	
	/*
	 * Sådan at vi kan ændre typen på implementationen ved runtime, sådan at vi kan fjerne en MallardDucks
	 * vinger hvis det er sådan vi har implementeret en MallardDuck. 
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