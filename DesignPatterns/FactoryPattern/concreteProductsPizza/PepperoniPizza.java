package concreteProductsPizza;

import abstractFactories.PizzaIngredientFactory;
import abstractProduct.Pizza;

public class PepperoniPizza extends Pizza
{
	PizzaIngredientFactory ingredientFactory;
	public PepperoniPizza(PizzaIngredientFactory ingredientFactory)
	{
		this.ingredientFactory = ingredientFactory;
	}
	
	@Override
	public void prepare() 
	{
		System.out.println("Preparing: " + name);
		sauce = ingredientFactory.createSauce();
		cheese = ingredientFactory.createCheese();
		dough = ingredientFactory.createDough();
	}

}