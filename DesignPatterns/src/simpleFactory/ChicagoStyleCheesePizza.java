package simpleFactory;

public class ChicagoStyleCheesePizza extends Pizza 
{
	public ChicagoStyleCheesePizza()
	{
		name = "Chicago Cheese Pizza";
		dough = "Thin";
		sauce = "RedWine Sauce on a PIZZA WHAT!";
		
		toppings.add("the Worst toppings fcking ever! WUT");
	}
	/**
	 * Overrideing cut because we're cutting this Pizza differently
	 */
	@Override
	public void cut()
	{
		System.out.println("Cutting it into squares");
	}
}
