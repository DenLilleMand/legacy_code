package concretePizzaFactories;

import concreteIngredientFactory.ChicagoIngredientFactory;
import concreteProductsPizza.CheesePizza;
import abstractFactories.PizzaStore;
import abstractProduct.Pizza;


/**
 * Den seneste implementation der ser sådan her ud, har en rigtig god forklaring på
 * side 155.
 * @author DenLilleMand
 */
public class ChicagoStylePizzaStore extends PizzaStore
{
	Pizza pizza = null;
	ChicagoIngredientFactory ingredientFactory = new ChicagoIngredientFactory();

	/**
	 * Burde self være en switch-case.
	 */
	@Override
	public Pizza createPizza(String item) 
	{
		if(item.equals("Cheese"))
		{
			pizza = new CheesePizza(ingredientFactory);
			pizza.setName("Chicago style cheese pizza");
		}
		else if(item.equals("clam"))
		{
			pizza = new CheesePizza(ingredientFactory);
			pizza.setName("Chicago style Clam pizza");
		}
		else if(item.equals("pepperoni"))
		{
			pizza = new CheesePizza(ingredientFactory);
			pizza.setName("Chicago style Pepperoni pizza");
		} 
		return pizza;
	}

}
