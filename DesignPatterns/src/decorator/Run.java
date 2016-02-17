package decorator;

/**
 * I vores decorator pattern kommer vi til at bruge det design princip som lyder :"Classes should be open
 * for extension, but closed for modification". Dette design princip ville tage for lang tid, og tilf�je
 * for meget abstraktion til vores kode hvis vi tilf�jede det over alt, men man burde som minimum tilf�je
 * det der hvor vores design ofte �ndre sig. Og man ved hvilke dele af sit design der �ndrer sig meget 
 * igenne erfaring - og at kende sit dom�ne godt.
 * 
 * Definitionen p� 'The Decorator Pattern':"attaches additional responsibilities to an object dynamically.
 * Decorators provide a flexible alternative to subclassing for extending functionality"
 * 
 * At Beverage er en abstract klasse er ikke n�dvendigvis den bedste m�de at g�re det p�, det her eksempel
 * var mere for at vise hvordan man kunne extende koden hvis nu vores superklasse var abstract,
 * man ville m�ske g�re det med et interface fra starten af hvis man selv skulle lave det. Men der er ikke lige
 * nogle eksempler nu her ^^ .. 
 * 
 * i Javas I/O API bliver der ogs� massivt brugt decorator pattern, det kan man f.eks se ved at der er 
 * en FileInputStream  som bliver wrapped i en BufferedInputStream som m�ske bliver wrapped i en LineNumber-
 * InputStream. 
 * 
 * BufferedInputStream og LineNumberInputStream extender begge FilerInputStream som opererer som en abstract
 * decorator klasse.
 * 
 * vi kan ogs� have en abstract Decorator - hvilket bare betyder at der er en masse andre konkrete decorators
 * der har brug for en masse f�lles decorator varertegn s� hvorfor ikke subclass dem. 
 * @author DenLilleMand
 */


public class Run 
{
		public static void main(String [] args)
		{
			Beverage beverage = new Espresso();
			System.out.println(beverage.getDescription() + " �" + beverage.cost());
			
			Beverage beverage2 = new DarkRoast();
			beverage2 = new Mocha(beverage2);
			beverage2 = new Mocha(beverage2);
			beverage2 = new Whip(beverage2);
			System.out.println(beverage2.getDescription() + " �" + beverage2.cost());
			
			Beverage beverage3 = new HouseBlend();
			beverage3 = new Soy(beverage3);
			beverage3 = new Mocha(beverage3);
			beverage3 = new Whip(beverage3);
			System.out.println(beverage3.getDescription() + " �" + beverage3.cost());
		}
}
