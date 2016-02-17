package singleton;
/**
 * Bogen er �benbart meget 
 * bestemt overfor hvilken slags singleton
 * implementation der er den bedste, s� p� trods
 * af at vi havde fundet en ny smart synchronized m�de
 * at g�re det p� i head first design patterns,
 * s� kan det godt v�re vi skal k�rer med den her, siden
 * Gosling trodsalt har brug for den her bog :) .
 * jeg har lavet et enum som hedder 'BestSingletonImplementation'
 * hvor man kan se hvordan man g�r ... men man ser det ikke
 * i brug, s� en dag n�r der er internet m� man lige teste.
 * en af grundene til at dette er den bedste m�de at g�re det p�
 * er at det er sikret imod reflection + Serialization, noget vi ikke har h�rt om
 * s� meget er at man faktisk laver et nyt objekt under Serialization og det er noget
 * man godt kan kode sig ud af i vores generalle implementationer,
 * men man f�r det gratis fixet med den her enum implementation.
 * @author DenLilleMand
 *
 */
public class NoterOgRun 
{

	public static void main(String[] args) 
	{

	}

}
