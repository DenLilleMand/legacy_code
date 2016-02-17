//package noterOgRun;
//
//import concreteProductsPizza.CheesePizza;
//import concreteProductsPizza.PepperoniPizza;
//import abstractProduct.Pizza;
//
//
//
//public class PizzaEksempel 
//{
//	public Pizza orderPizza(String type)
//	{
//		Pizza pizza = null;
//		if(type.equals("Cheese"))
//		{
//			pizza = new CheesePizza();
//		}
//		else if(type.equals("Pepperoni"))
//		{
//			pizza = new PepperoniPizza();
//		}
//		/*
//		 * S� n�r vi skulle udvide vores kartotek af pizzaer s� ville vi skulle ind og redigere
//		 * i den her klasse for at g�re det, s� ville vi modificere istedet for at extende
//		 * og g� imod design principperne.
//		 */
//		
//		/**
//		 * de her ting er dem som ikke �ndre sig, s� de skal forblive som de er, de her 4 
//		 * ting sker nemlig lige meget hvilken Pizza det er vi har med at g�re.
//		 */
//		pizza.prepare();
//		pizza.bake();
//		pizza.cut();
//		pizza.box();
//		
//		return pizza;
//	}
//	
//	
//	
//	
//}
