package baristiaExample;
/**
 * vi har f�et som opgave p� side 284 -
 * at fixe den duplicate kode vi har i vores 2 klasser Tea og Coffee-
 * 
 * Det g�r man selF ved at lave evt. en klasse som hedder 
 * CaffineBeverage - og ligge alle metoder derop som de deler, og de metoder
 * som de ikke deler har de bare selv..
 * men det jeg tror at de pr�ver at vise os noget andet end det.
 *
 * Okay - s� udover at vi extender klasse CaffieneBeverage -
 * s� har Te og Kaffe ogs� den samme algoritme til at lave deres produkt,
 * dvs. at de begge 2 starter med at koge, og f�lger derfra skridt 2-3-4 sammen.
 * s� pga. Dette kan vi g�re noget smart som f�lger:
 * 
 * Der er faktisk en masse fede argumentationer for hvorfor man burde bruge en template
 * metode p� side 293 - mange af dem er selF givet p� forh�nd, men andre er gode.
 * Den sammenligner den gamle version hvor vi ikke havde en abstract klasse imellem
 * coffee/tea, samt den version hvor prepare Recipe bare er en abstract metode oppe i 
 * CaffeineBeverage istedet for en template algorithm som den er nu.
 * 
 * faktisk prompter det her os til at lave en pakke i det her projekt som hedder
 * 'theTemplateMethodPattern' - pga. side 294 -- s� ser vi hvor det tager os hen.
 * 
 * @author DenLilleMand
 *
 */
public class Run 
{
	/**
	 * F�lger den test p� side 292.
	 * @param args
	 */
	public static void main(String[] args) 
	{
			Tea tea = new Tea();
			tea.prepareRecipe();
	}

}
