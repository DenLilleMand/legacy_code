package abstractProduct;

import java.util.ArrayList;

import pizzaAttributs.Dough;
import pizzaAttributs.Sauce;
import concreteIngredient.Cheese;
import concreteIngredient.Clams;
import concreteIngredient.Pepperoni;


public abstract class Pizza {
	protected String name;
	protected Dough dough;
	protected Sauce sauce;
	protected ArrayList<String> toppings = new ArrayList<String>();
	protected String[] veggies;
	protected Cheese cheese;
	protected Pepperoni pepperoni;
	protected Clams clam;
	
	public abstract void prepare(); // denne metode er abstrakt og det er
									//i den vi kommer til at samle de grøntsager
									//som vi laver igennem vores factories.

	public void bake() 
	{
		System.out.println("Bake for 25 minutes at 350");
	}

	public void cut() 
	{	
		System.out.println("Cutting the pizza into diagonal");
	}

	public void box() 
	{
		System.out.println("Place pizza in official pizzaStore box");	
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
		
	}
}
