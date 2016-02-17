package decorator;

/**
 * I vores decorator pattern kommer vi til at bruge det design princip som lyder :"Classes should be open
 * for extension, but closed for modification". Dette design princip ville tage for lang tid, og tilføje
 * for meget abstraktion til vores kode hvis vi tilføjede det over alt, men man burde som minimum tilføje
 * det der hvor vores design ofte ændre sig. Og man ved hvilke dele af sit design der ændrer sig meget 
 * igenne erfaring - og at kende sit domæne godt.
 * 
 * Definitionen på 'The Decorator Pattern':"attaches additional responsibilities to an object dynamically.
 * Decorators provide a flexible alternative to subclassing for extending functionality"
 * 
 * At Beverage er en abstract klasse er ikke nødvendigvis den bedste måde at gøre det på, det her eksempel
 * var mere for at vise hvordan man kunne extende koden hvis nu vores superklasse var abstract,
 * man ville måske gøre det med et interface fra starten af hvis man selv skulle lave det. Men der er ikke lige
 * nogle eksempler nu her ^^ .. 
 * 
 * i Javas I/O API bliver der også massivt brugt decorator pattern, det kan man f.eks se ved at der er 
 * en FileInputStream  som bliver wrapped i en BufferedInputStream som måske bliver wrapped i en LineNumber-
 * InputStream. 
 * 
 * BufferedInputStream og LineNumberInputStream extender begge FilerInputStream som opererer som en abstract
 * decorator klasse.
 * 
 * vi kan også have en abstract Decorator - hvilket bare betyder at der er en masse andre konkrete decorators
 * der har brug for en masse fælles decorator varertegn så hvorfor ikke subclass dem. 
 * @author DenLilleMand
 */


public class Run 
{
		public static void main(String [] args)
		{
			Beverage beverage = new Espresso();
			System.out.println(beverage.getDescription() + " £" + beverage.cost());
			
			Beverage beverage2 = new DarkRoast();
			beverage2 = new Mocha(beverage2);
			beverage2 = new Mocha(beverage2);
			beverage2 = new Whip(beverage2);
			System.out.println(beverage2.getDescription() + " £" + beverage2.cost());
			
			Beverage beverage3 = new HouseBlend();
			beverage3 = new Soy(beverage3);
			beverage3 = new Mocha(beverage3);
			beverage3 = new Whip(beverage3);
			System.out.println(beverage3.getDescription() + " £" + beverage3.cost());
		}
}
