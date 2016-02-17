package simpleFactory;

public class NYPizzaStore extends PizzaStore
{
	/**
	 * Vi skal implementere createPizza(String item); metoden fordi vi extender PizzaStore,
	 * og denne returnere så et konkret implementation af en NYPizza
	 */
	@Override
	public Pizza createPizza(String item) 
	{
		/**
		 * specific implementation of a NY Pizza . 
		 */
		if(item.equals("Cheese"))
		{
			return new NYStyleCheesePizza();
		}
		else if(item.equals("clam"))
		{
			return new NYStyleClamPizza();
		}
		else if(item.equals("pepperoni"))
		{
			return  new NYStylePepperoniPizza();
		} else return null;
		
	}

}
