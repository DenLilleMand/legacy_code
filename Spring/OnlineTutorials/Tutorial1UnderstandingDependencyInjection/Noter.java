package Tutorial1UnderstandingDependencyInjection;

public class Noter 
{
	/**
	 * Dependency Injection:
	 * Som man kan se i vores klasser ville man måske oftest kalde 
	 * Triangle direkte, men det er en fejl, vi vil gerne gøre vores kode
	 * så fleksible som muligt, så vi laver en slags wrapper klasse
	 * til vores Triangle, og gør vores objekt mere generisk efter dette.
	 * 
	 * i princippet er det vi gjort, er at fjerne en dependency fra 
	 * den klasse der tegner, dvs. at den ikke ved hvad den tegner, den tegner bare
	 * og det er godt fordi så kan vi bare udskifte det objekt med et andet
	 * og klassen vil stadig bare tegne.
	 * 
	 * så det er derfor det hedder "dependency injection" - fordi vi laver
	 * en injection af det interface som den har en dependency hos, hvilket
	 * i det her tilfælde udelukkende er Shape interfacet.
	 * 
	 */
}
