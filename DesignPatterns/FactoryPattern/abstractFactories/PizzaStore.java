package abstractFactories;

import abstractProduct.Pizza;



public abstract class PizzaStore 
{
//	SimplePizzaFactory factory;
	/**
	 * Der er mange led i det her, f.eks ville man bruge vores factory til at returne 
	 * et Pizza objekt som det er nu, men nu har bogen så fået den ide at udvide vores Pizza
	 * franchise til nogle andre byer, så vi skal have en abstract metode der hedder createPizza
	 * som man kan se nedenfor... det er en metode som udelukkende er kommet af at vi skal udvide.
	 * men det ville jo nok være bedst at have gjort det sådan fra starten - anyway man kan se
	 * at vi bruger den abstrakte metode nu, i stedet for at bruge den metode på vores factory
	 * som hedder createPizza(String type);
	 * @param factory
	 */
//	public PizzaStore(SimplePizzaFactory factory)
//	{
//		this.factory = factory;
//	}
	
	public final Pizza orderPizza(String type)
	{	
		Pizza pizza;
		pizza = createPizza(type);
		
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		
		return pizza;
	}

	public abstract Pizza createPizza(String string);
}
