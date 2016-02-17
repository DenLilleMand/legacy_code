package simpleFactory;

public class Run 
{
	/**
	 * N�glen til denne simpleFactory(som IKKE er factoryPattern men en lille guideline)
	 * er at vi igen skal kigge p� den del af vores kode som kommer til at �ndre sig, og s�
	 * sepererer det fra de dele som ikke �ndrer sig. Den del som ikke �ndrer sig skal bla
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
