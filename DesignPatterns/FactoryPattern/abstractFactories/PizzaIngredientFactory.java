package abstractFactories; 

import concreteIngredient.Cheese;
import concreteIngredient.Clams;
import concreteIngredient.Pepperoni;
import pizzaAttributs.Dough;
import pizzaAttributs.Sauce;
/**
 * De her metoder er faktisk nogle som hedder Factory Methods, der er ofte de her 
 * factory methods inde i en Abstract Factory Class. Dvs. alle dem som hedder
 * noget med create,   dem som ikke hedder create er ikke nødvendigvis Factory Methods.
 * @author DenLilleMand
 *
 */
public interface PizzaIngredientFactory 
{
	public Dough createDough();
	public Sauce createSauce();
	public Cheese createCheese();
	public String[] createVeggies();
	public Pepperoni createPepperoni();
	public Clams createClams();
}
