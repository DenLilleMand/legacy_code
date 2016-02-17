package simpleFactory;

public class PizzaEksempel 
{
	public Pizza orderPizza(String type)
	{
		Pizza pizza;
		if(type.equals("Cheese"))
		{
			pizza = new CheesePizza();
		}
		else if(type.equals("Greek"))
		{
			pizza = new GreekPizza();
		}
		else if(type.equals("Pepperoni"))
		{
			pizza = new PepperoniPizza();
		}
		/*
		 * Så når vi skulle udvide vores kartotek af pizzaer så ville vi skulle ind og redigere
		 * i den her klasse for at gøre det, så ville vi modificere istedet for at extende
		 * og gå imod design principperne.
		 */
		
		/**
		 * de her ting er dem som ikke ændre sig, så de skal forblive som de er, de her 4 
		 * ting sker nemlig lige meget hvilken Pizza det er vi har med at gøre.
		 */
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		
		return pizza;
	}
	
	
	
	
}
