//package noterOgRun;
//
//import factoryPattern.CheesePizza;
//import factoryPattern.GreekPizza;
//import factoryPattern.PepperoniPizza;
//import factoryPattern.Pizza;
//
//public class SimplePizzaFactory {
///**
// * en af de andre grunde til at vi har fjernet det her stykke kode ud af vores OrderPizzaClass
// * er at vi ikke ved om der er andre klasser der ogs� skal bruge et pizza object, evt.
// * en menu klasse som skal bruge priserne eller lign.
// * Den her metode er ikke statisk, s�dan at vi skal oprette et object af SimplePizzaFactory,
// * fordi hvis den var statisk createPizza metoden s� ville vi ikke kunne subclasse den.
// * Men normalt ville man jo lave den statisk, det tror jeg ogs� vi kommer til at se n�r vi pr�ver 
// * at implementere et rigtigt FactoryPattern. 
// * SimpleFactory er et 'programming idiom' men ikke er pattern. 
// * og grunden til at vi har det med her, er at det ofte bliver brugt. 
// * @param type
// * @return
// */
//	public static Pizza createPizza(String type)
//	{
//		Pizza pizza = null;
//		if(type.equals("Cheese"))
//		{
//			pizza = new CheesePizza();
//		}
//		else if(type.equals("Greek"))
//		{
//			pizza = new GreekPizza();
//		}
//		else if(type.equals("Pepperoni"))
//		{
//			pizza = new PepperoniPizza();
//		}
//		return pizza;
//	}
//	
//	
//}
