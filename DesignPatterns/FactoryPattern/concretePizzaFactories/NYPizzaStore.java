package concretePizzaFactories;

import concreteIngredientFactory.NewYorkIngredientFactory;
import concreteProductsPizza.CheesePizza;
import abstractFactories.PizzaStore;
import abstractProduct.Pizza;

public class NYPizzaStore extends PizzaStore
{
	/**
	 * Vi skal implementere createPizza(String item); metoden fordi vi extender PizzaStore,
	 * og denne returnere så et konkret implementation af en NYPizza
	 */
	Pizza pizza = null;
	NewYorkIngredientFactory ingredientFactory = new NewYorkIngredientFactory();
	
	@Override
	public Pizza createPizza(String item) 
	{
		/**
		 * Specific implementation of a NY Pizza . 
		 */
		if(item.equals("Cheese"))
		{
			pizza = new CheesePizza(ingredientFactory);
			pizza.setName("NewYork style cheese pizza");
		}
		else if(item.equals("clam"))
		{
			pizza = new CheesePizza(ingredientFactory);
			pizza.setName("New York style Clam pizza");
		}
		else if(item.equals("pepperoni"))
		{
			pizza = new CheesePizza(ingredientFactory);
			pizza.setName("NewYork style Pepperoni pizza");
		} 
		return pizza;
	}

}
