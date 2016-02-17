package simpleFactory;

public class Run 
{
	/**
	 * Nøglen til denne simpleFactory(som IKKE er factoryPattern men en lille guideline)
	 * er at vi igen skal kigge på den del af vores kode som kommer til at ændre sig, og så
	 * sepererer det fra de dele som ikke ændrer sig. Den del som ikke ændrer sig skal bla
	 * encapsuleres. 
	 */

	public static void main(String [] args)
	{
		PizzaStore chicagoPizza = new ChicagoStylePizzaStore();
		PizzaStore newyorkPizza = new NYPizzaStore();
		
		Pizza pizza = chicagoPizza.orderPizza("Cheese");
		Pizza pizza1 = newyorkPizza.orderPizza("Cheese");
	}
}
