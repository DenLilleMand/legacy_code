package noterOgRun;

import concretePizzaFactories.NYPizzaStore;
import abstractFactories.PizzaStore;
import abstractProduct.Pizza;

/**
 * S� det her er factory pattern, jeg regner med at det kommer til at
 * ligne vores SimpleFactory en lille smule, bortset fra at factory
 * klassens create metode bliver lavet statisk - og lidt andre ting. 
 * 
 * Det virker til at man har en Super klasse ligesom vores PizzaStore er en abstract super klasse i vores
 * SimpleFactory, s� har vi nogle klasser som hedder "concrete creators" der er dem som f.eks i simpleFactory
 * extender PizzaStore og som tager sig af at lave den konkrete instansiering. 
 * 
 * Der er s� vores Creator klasser som f.eks i SimpleFactory best�r af PizzaStore, NewYorkPizzaStore og ChicagoPizzaStore)
 * Ved siden af det - s� har vi product klasserne som i SimpleFactory er vores pizzaer og de
 * forskellige klasser der extender Pizza. Alle de ting som extender Pizza er de konkrete produkter.
 * 
 * Side 134 & 136 i 'head first design patterns' virker til at have et meget godt billed over det.
 * 
 * 'The Factory Method Pattern' Definition: Defines an interface for creating an object
 * ,but lets subclasses decide which class to instantiate. Factory Method lets a class defer instantiation
 * to subclasses.
 * 
 * Der bliver bla. brugt et Design princip her som hedder "Dependency Inversion Principle" og
 * dens definition lyder :"Depend upon abstractions. Do not depend upon concrete classes".
 * 
 * Abstract Factory og Factory Method minder meget om hinanden, 
 * Factory Method bruger arv til at lave sine objekter imens Abstract Factory
 * bruger composition til det.  
 * 
 * For at lave objekter med Factory Method s� skal man extende en klasse og @Override 
 * en factory method. Den her factory method laver s� selF objekter, det er det
 * som det hele g�r ud p�, at man bruger en subclass til at lave objekterne, p� den m�de
 * beh�ver 'Clienten' ikke at kende noget til alle de forskellige implementationer
 * men blot den abstrakt type. Sagt p� en anden m�de s� holder vi clients decoupled
 * fra konkrete typer.
 * 
 * Det samme g�r Abstract Factory, bare p� en anden m�de -
 * Den giver en abstract type til at lave en familie af produkter. Subklasser
 * af denne type definere s� hvordan disse produkter produceres.
 * for at bruge en Factory instansiere man den og giver den ind som parameter i en klasse
 * der er skrevet til at tage imod det. S� ligesom Factory method s� er klienterne decoupled fra det
 * konkrete produkt de bruger.
 * 
 * Det g�r at Abstract Factory ogs� gruppere relatere produkter,
 * som Factory Method ikke g�r. Hvis vi skal tilf�je nye produkter,
 * s� skal vi dog �ndre i Abstract Factories interface, hvilket ikke er optimalt.
 * Men det er fordi Abstract Factory bare har s�dan et stort cartotek 
 * af objekt familier den skal holde styr p�-  hvorimod Factory Method
 * Kun skal lave 1 slags type...   Desuden bruger Abstract Factory faktisk 
 * Factory Method til at lave sine objekter. 
 * 
 * konklusionen er at man skal bruge Abstract Factory n�r man har familier af produkter
 * der skal h�nge sammen. og sikrer sig at ens klienter laver produkter der h�rer sammen.
*
*S� er der Factory method som skal bruges n�r vi skal decouple klient koden
*fra vores konkrete klasser vi skal instansiere.  Og hvis man ikke ved forud 
*om man skal extende kartoteket af klasser s� kan man subclasse FactoryMethod og s� implementere dens
*factory metode.   
*
*Det pr�ves forklaret p� side 162 Jeg er ikke helt sikker
*p� hvad der er Abstract Factory og hvad der er Factory Method
*i vores implementation her, men man burde nok have delt dem op hvis
*jeg havde vidst fra starten af at de ikke hang sammen.
 * 
 * side 162 forklare Abstract Factory
 * side 163 forklare Factory Pattern. 
 * 
 * hvor man ogs� kan se hvordan de 2 bruger hinanden,
 * eller hvertfald hvordan Abstract Factory bruger Factory Method.
 * 
 * @author DenLilleMand
 *
 */
//public class Run 
//{
//	public static void main(String [] args)
//	{
//		PizzaStore pizzaStore = new NYPizzaStore();
//		Pizza pizza = pizzaStore.orderPizza("pepperoni");
//	}
//}
