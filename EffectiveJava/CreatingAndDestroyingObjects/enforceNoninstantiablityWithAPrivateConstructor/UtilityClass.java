package enforceNoninstantiablityWithAPrivateConstructor;

/**
 * side 42, Attemping to enforce non-
 * instantiability by making a class abstract does
 * not work' The class can be subclassed and the subclass instantiated.
 * Furthermore, it misleads the user into thinking the class was designed for 
 * inheritance. There is, however a simple idiom(design princip) 
 * to ensure noninstantiability. A default constructor is 
 * generated only if a class contains no explicit constructors. so a class
 * can be made noninstantiable by including a private constructor:
 * 
 * som så er vist i den her klasse:
 * @author DenLilleMand
 *
 */
/**
 * Men nogle klasser er jo lavet til at lave
 * subclasses, så dette er blot en guide til hvis man 
 * vil vise at en klasse ikke er lavet til arv, så
 * skal man gøre sådan her istedet for at lave den abstract,
 * og det giver jo fin mening.
 * En af de ting som der blev forklaret tidligere i design patterns
 * var at det kun var hvis man havde en non-private constructor at man
 * ville kunne subclasse, og det er selF fordi hvis man extender en klasser
 * så arver man også constructoren, og hvis den eneste constructor der er givet
 * er private(tror ikke man kan blande public/private constructors)
 * men det er hvertfald derfor, og i den her context betyder det nemlig at 
 * når man bruger en private constructor for at vise at klassen
 * ikke kan subclasses, så er det fysik umuligt. ^^ måske er den pointe
 * lidt søgt og giver sig selv, men der er nok mere til det -
 * kan evt. genopfriske på side 42.
 * @author DenLilleMand
 *
 */
public class UtilityClass 
{
	//Suppress default constructor for noninstantiability
	private UtilityClass()
	{
		throw new AssertionError();
	}
	
	//Remainder omitted
}
