package strategy;
/*
pointen med strategy patternet er at alle de her klasser som extender, selvom det ikke er vist med kode,
burde ikke extende Duck ... istedet burde de implementere de interfaces de har brug for . . .
så hvis der er en Duck der kan flyve så skal den implementere Flyable interface, og hvis det så er en talende 
Duck så skal den også implementere Quack interface ....    fordi hvis vi extender, så får alle vehicles metoderne
fra super klassen, og så skal vi sidde og @Override dem bagefter.
men fordi interfaces ikke kan indeholde kode, så betyder det at vi skal sidde og skrive specifikke metoder
for hver gang en Duck gerne vil quacke ... så det er et nyt problem der opstår -- og det kan fixes ved:

	vi bruger det OO design principel som lyder :"Identify the aspects of your application that vary
(changes) and seperate them from what stays the same" ...

Vi laver en klasse for hver metode, en klasse for quack() og en klasse til fly()

vi bruger også det OO principel der lyder :" Program to an interface, not an implementation":

ud fra det principel er det værd at vise nogle code brackets der forklare forskellen:
Programming to an implementation ville være:
Dog d = new Dog();
d.bark();

imens at programmere til en interface/supertype:
Animal animal = new Dog();
animal.makeSound();

og endnu bedre end at hardcode instansieringen af sub-typen f.eks new Dog() ind i koden, 
så assign det konkrete implementere object ved runtime 

a = getAnimal();
animal.makeSound();

Hvis man så vores program fra oven, som man kan på side 25 i head first design bogen,
så ville man kunne sætte enten  "is-a", "Has-a" eller "implements" tags på alle pilene imellem klasserne, dette bringer os videre
til det næste design princip som siger :"Favor composition over inheritance". composition er f.eks i vores
Duck super klasse, når man har 2 instanser af f.eks interfaces, istedet for at implementere begge 2(hvilket
jeg ikke ved hvor meget mening ville give). Men der er selF fordele og ulemper ved det hele, men det bliver
ihvertfald brugt i andre design patterns, skal prøve at vende tilbage til det når jeg har læst mere.. 

Fordelene ved at bruge composition istedet for arv, er specifikt at man kan skifte et objekts adfærd i runtime,
og at man kan enkapsulere en familie af metoder(algoritmer), 

den officielle definition af Strategy Pattern er  :"Defines a family of algorithms, encapsulates each one,
and makes them interchangeable. Strategy lets the algorithm vary independently from clients that use it."
*/

public class Run 
{
	public static void main(String [] args)
	{
		Duck mallard = new MallardDuck();
		mallard.performQuack();
		mallard.performFly();
	}
}
