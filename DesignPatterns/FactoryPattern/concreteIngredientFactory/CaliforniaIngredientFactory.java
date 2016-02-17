package concreteIngredientFactory;

import concreteIngredient.Cheese;
import concreteIngredient.Clams;
import concreteIngredient.Pepperoni;
import abstractFactories.PizzaIngredientFactory;
import pizzaAttributs.Dough;
import pizzaAttributs.Sauce;

public class CaliforniaIngredientFactory implements PizzaIngredientFactory{

	/**
	 * Alle de her metoder ville så returne en specifik 
	 * implementation af Californias specielle ingredienser.
	 */
	@Override
	public Dough createDough() {
		return null;
	}

	@Override
	public Sauce createSauce() {
		return null;
	}

	@Override
	public Cheese createCheese() {
		return null;
	}

	@Override
	public String[] createVeggies() {
		return null;
	}

	@Override
	public Pepperoni createPepperoni() {
		return null;
	}

	@Override
	public Clams createClams() {
		return null;
	}

}
