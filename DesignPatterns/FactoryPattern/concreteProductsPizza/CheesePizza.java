package concreteProductsPizza;

import abstractFactories.PizzaIngredientFactory;
import abstractProduct.Pizza;
/**
 * F�r havde vi en specifik cheesePizza til hver afdeling rundt omkring
 * pga. de forskellige ingredienser folk brugte, men nu pga. vores
 * pizzaIngredientFactory s� er pizza klassen ligeglad med ingredienserne,
 * men skal bare bekymrer sig om at tage et ingrediens factory
 * objekt ind.
 * @author DenLilleMand
 *
 */
public class CheesePizza extends Pizza 
{
	PizzaIngredientFactory pizzaIngredientFactory;
	
	public CheesePizza(PizzaIngredientFactory pizzaIngredientFactory)
	{
		this.pizzaIngredientFactory = pizzaIngredientFactory;
	}
	
	@Override
	public void prepare() 
	{
		System.out.println("Preparing: " + name);
		dough = pizzaIngredientFactory.createDough();
		sauce = pizzaIngredientFactory.createSauce();
		cheese = pizzaIngredientFactory.createCheese();
	}

}
