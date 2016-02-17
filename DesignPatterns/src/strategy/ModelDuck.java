package strategy;

//En klasse lavet for at vise flexibiliteten ved dette design pattern.
public class ModelDuck extends Duck
{
	public ModelDuck()
	{
		flyBehavior = new FlyNoWay();
		quackBehavior = new Quack();
	}
	

	@Override
	public void display() 
	{
		System.out.println("Im a model duck!");
		
	}

}
