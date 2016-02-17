package strategy;
/*
pointen med strategy patternet er at alle de her klasser som extender, selvom det ikke er vist med kode,
burde ikke extende Duck ... istedet burde de implementere de interfaces de har brug for . . .
s� hvis der er en Duck der kan flyve s� skal den implementere Flyable interface, og hvis det s� er en talende 
Duck s� skal den ogs� implementere Quack interface ....    fordi hvis vi extender, s� f�r alle vehicles metoderne
fra super klassen, og s� skal vi sidde og @Override dem bagefter.
men fordi interfaces ikke kan indeholde kode, s� betyder det at vi skal sidde og skrive specifikke metoder
for hver gang en Duck gerne vil quacke ... s� det er et nyt problem der opst�r -- og det kan fixes ved:

	vi bruger det OO design principel som lyder :"Identify the aspects of your application that vary
(changes) and seperate them from what stays the same" ...

Vi laver en klasse for hver metode, en klasse for quack() og en klasse til fly()

vi bruger ogs� det OO principel der lyder :" Program to an interface, not an implementation":

ud fra det principel er det v�rd at vise nogle code brackets der forklare forskellen:
Programming to an implementation ville v�re:
Dog d = new Dog();
d.bark();

imens at programmere til en interface/supertype:
Animal animal = new Dog();
animal.makeSound();

og endnu bedre end at hardcode instansieringen af sub-typen f.eks new Dog() ind i koden, 
s� assign det konkrete implementere object ved runtime 

a = getAnimal();
animal.makeSound();

Hvis man s� vores program fra oven, som man kan p� side 25 i head first design bogen,
s� ville man kunne s�tte enten  "is-a", "Has-a" eller "implements" tags p� alle pilene imellem klasserne, dette bringer os videre
til det n�ste design princip som siger :"Favor composition over inheritance". composition er f.eks i vores
Duck super klasse, n�r man har 2 instanser af f.eks interfaces, istedet for at implementere begge 2(hvilket
jeg ikke ved hvor meget mening ville give). Men der er selF fordele og ulemper ved det hele, men det bliver
ihvertfald brugt i andre design patterns, skal pr�ve at vende tilbage til det n�r jeg har l�st mere.. 

Fordelene ved at bruge composition istedet for arv, er specifikt at man kan skifte et objekts adf�rd i runtime,
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
