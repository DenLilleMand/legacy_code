package strategy;
/*
 * En klasse som simulere hvordan man kan ændrer et objects metoder ved runtime. 
 */
public class MiniDuckSimulator 
{
	public static void main(String [] args)
	{
		Duck mallard = new MallardDuck();
		mallard.performQuack();
		mallard.performFly();
		
		Duck model = new ModelDuck();
		model.performFly();
		model.setFlyBehavior(new FlyRocketPowered());
		model.performFly();
	}
}
