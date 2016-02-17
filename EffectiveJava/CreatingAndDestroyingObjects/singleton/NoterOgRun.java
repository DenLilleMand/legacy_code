package singleton;
/**
 * Bogen er åbenbart meget 
 * bestemt overfor hvilken slags singleton
 * implementation der er den bedste, så på trods
 * af at vi havde fundet en ny smart synchronized måde
 * at gøre det på i head first design patterns,
 * så kan det godt være vi skal kører med den her, siden
 * Gosling trodsalt har brug for den her bog :) .
 * jeg har lavet et enum som hedder 'BestSingletonImplementation'
 * hvor man kan se hvordan man gør ... men man ser det ikke
 * i brug, så en dag når der er internet må man lige teste.
 * en af grundene til at dette er den bedste måde at gøre det på
 * er at det er sikret imod reflection + Serialization, noget vi ikke har hørt om
 * så meget er at man faktisk laver et nyt objekt under Serialization og det er noget
 * man godt kan kode sig ud af i vores generalle implementationer,
 * men man får det gratis fixet med den her enum implementation.
 * @author DenLilleMand
 *
 */
public class NoterOgRun 
{

	public static void main(String[] args) 
	{

	}

}
