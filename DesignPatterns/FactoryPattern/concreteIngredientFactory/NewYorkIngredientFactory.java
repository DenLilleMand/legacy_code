package concreteIngredientFactory;

import abstractFactories.PizzaIngredientFactory;
import concreteIngredient.Cheese;
import concreteIngredient.Clams;
import concreteIngredient.FreshClams;
import concreteIngredient.MarianaSauce;
import concreteIngredient.Pepperoni;
import concreteIngredient.ReggianoCheese;
import concreteIngredient.SlicedPepperoni;
import pizzaAttributs.Dough;
import pizzaAttributs.Sauce;
import pizzaAttributs.ThickCrustDough;

public class NewYorkIngredientFactory implements PizzaIngredientFactory 
{

	@Override
	public Dough createDough() 
	{
		return new ThickCrustDough();
	}

	@Override
	public Sauce createSauce() 
	{
		return new MarianaSauce();
	}

	@Override
	public Cheese createCheese() 
	{
		return new ReggianoCheese();
	}

	@Override
	public String[] createVeggies() 
	{
		String[] veggies = {"Potatoes", "carrots", "some other vegetable"};
		return veggies;
	}

	@Override
	public Pepperoni createPepperoni() 
	{
		return new SlicedPepperoni();
	}

	@Override
	public Clams createClams() 
	{
		return new FreshClams();
	}

}
