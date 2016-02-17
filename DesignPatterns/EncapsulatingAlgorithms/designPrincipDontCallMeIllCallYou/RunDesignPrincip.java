package designPrincipDontCallMeIllCallYou;
/**
 * bliver introduceret for et nyt design princip på side 301
 * som definitionen lyder:"Dont call us, we'll call you"
 * 
 * princippet er til for at undgå det der hedder
 * dependency rot,
 * dependency rot er når man har high-level components
 * afhænger af low-level components som er afhængige af high-level
 * components som er afhængig af sidelæns components som afhænger
 * af low-level components osv. (eksempel taget lidt langt ud)
 * når det sker i et system, så er det ikke let at forstå arkitekturen,
 * så det her design princip går ud på at 
 * tillade low-level componenter til at hook sig selv ind i systemet,
 * men high-level components bestemmer selv hvornår der er brug for dem og hvordan.
 * (side 301)
 * Grunden til at den her pakke er i under EncapsulatingAlgorithms er at 
 * Template Method faktisk har en forbindelse til 'dont call us, we'll call you'
 * - princippet, dette kan man se på side 302.
 * CaffieneBeverage er vores high-level component, den har kontrol over
 * algoritmen for opskriften og kalder subclasses kun når der er brug for dem for at implementere
 * en metode.
 * 
 * (der er også andre Patterns der bruger dette princip - bla 'The factory method' og 'Observer Pattern',
 * der er selF flere -- måske Command pattern? er ikke helt sikker :))
 * 
 * Der står bla. at subclasses selF kommer til at kalde metoder oppe i hiarkiet,
 * altså  low-level components der kalder high-level components, og der står at det kan man ikke
 * undgå, men man vil gerne prøve at undgå circulære kald imellem disse niveauer.
 * hvordan end det skal tolkes.
 * 
 * faktisk er paint() metoden i JFrame en hook() metode.. den gør ingenting hvis man ikke @Overrider den. 
 * 
 * hos en applet er init() metoden faktisk også en hook . LOL
 * 
 * 
 * 
 * 
 * @author DenLilleMand
 *
 */
public class RunDesignPrincip 
{

	public static void main(String[] args) {
		
	}

}
