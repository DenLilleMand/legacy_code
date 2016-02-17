package designPrincipDontCallMeIllCallYou;
/**
 * bliver introduceret for et nyt design princip p� side 301
 * som definitionen lyder:"Dont call us, we'll call you"
 * 
 * princippet er til for at undg� det der hedder
 * dependency rot,
 * dependency rot er n�r man har high-level components
 * afh�nger af low-level components som er afh�ngige af high-level
 * components som er afh�ngig af sidel�ns components som afh�nger
 * af low-level components osv. (eksempel taget lidt langt ud)
 * n�r det sker i et system, s� er det ikke let at forst� arkitekturen,
 * s� det her design princip g�r ud p� at 
 * tillade low-level componenter til at hook sig selv ind i systemet,
 * men high-level components bestemmer selv hvorn�r der er brug for dem og hvordan.
 * (side 301)
 * Grunden til at den her pakke er i under EncapsulatingAlgorithms er at 
 * Template Method faktisk har en forbindelse til 'dont call us, we'll call you'
 * - princippet, dette kan man se p� side 302.
 * CaffieneBeverage er vores high-level component, den har kontrol over
 * algoritmen for opskriften og kalder subclasses kun n�r der er brug for dem for at implementere
 * en metode.
 * 
 * (der er ogs� andre Patterns der bruger dette princip - bla 'The factory method' og 'Observer Pattern',
 * der er selF flere -- m�ske Command pattern? er ikke helt sikker :))
 * 
 * Der st�r bla. at subclasses selF kommer til at kalde metoder oppe i hiarkiet,
 * alts�  low-level components der kalder high-level components, og der st�r at det kan man ikke
 * undg�, men man vil gerne pr�ve at undg� circul�re kald imellem disse niveauer.
 * hvordan end det skal tolkes.
 * 
 * faktisk er paint() metoden i JFrame en hook() metode.. den g�r ingenting hvis man ikke @Overrider den. 
 * 
 * hos en applet er init() metoden faktisk ogs� en hook . LOL
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
