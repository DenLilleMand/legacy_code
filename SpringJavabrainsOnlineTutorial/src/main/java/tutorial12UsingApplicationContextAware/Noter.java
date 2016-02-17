package tutorial12UsingApplicationContextAware;

public class Noter 
{
	/**
	 * Noter:
	 * Grunden til at man vil implementere ApplicationContextAware interfaced
	 * i en klasse som Triangle, er pga. Triangle er en singleton,
	 * så er pointA,B,C også singletons effektivt, så dvs. at hvis vi vil 
	 * lave et nyt pointa,b, eller c objekt så skal vi have fat i context,
	 * og måden man får fat i context på er at implementere det her interface
	 * som blot giver en én setter metode.
	 * 
	 * så er der BeanNameAware interfaced, og det ved jeg faktisk ikke hvad der er godt for.
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
}
