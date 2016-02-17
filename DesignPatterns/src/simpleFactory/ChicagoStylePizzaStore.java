package simpleFactory;

public class ChicagoStylePizzaStore extends PizzaStore{


	@Override
	public Pizza createPizza(String item) 
	{
		if(item.equals("Cheese"))
		{
			return new ChicagoStyleCheesePizza();
		}
		else if(item.equals("clam"))
		{
			return new ChicagoStyleClamPizza();
		}
		else if(item.equals("pepperoni"))
		{
			return  new ChicagoStylePepperoniPizza();
		} else return null;
	}

}
