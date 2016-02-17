package concreteIngredientFactory;

import abstractFactories.PizzaIngredientFactory;
import concreteIngredient.Cheese;
import concreteIngredient.Clams;
import concreteIngredient.FrozenClam;
import concreteIngredient.Mozzerella;
import concreteIngredient.Pepperoni;
import concreteIngredient.PlumTomatoSauce;
import concreteIngredient.SlicedPepperoni;
import pizzaAttributs.Dough;
import pizzaAttributs.Sauce;
import pizzaAttributs.ThickCrustDough;

public class ChicagoIngredientFactory implements PizzaIngredientFactory{

	@Override
	public Dough createDough() 
	{
		return new ThickCrustDough();
	}

	@Override
	public Sauce createSauce() 
	{
		return new PlumTomatoSauce();
	}

	@Override
	public Cheese createCheese() 
	{
		return new Mozzerella();
	}

	@Override
	public String[] createVeggies() 
	{
		String[] veggies = {"Vegetables", "Tomatoes" , "Pickles"};
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
		return new FrozenClam();
	}

}
