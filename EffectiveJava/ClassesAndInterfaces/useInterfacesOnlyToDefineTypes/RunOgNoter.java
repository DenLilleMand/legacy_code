package useInterfacesOnlyToDefineTypes;

/**
 * Use Interfaces only to define types.
 * 
 * tl;dr;
 * 'Do not use interfaces to export constants,
 * only use them to define types'
 * 
 * Jeg har p� fornemmelsen at n�r vi bruger interfaces 
 * som vi gjore i Oikos projektet uden at bruge dem som
 * deciderede typer- s� bruger man ikke interfaces
 * som de var lavet til. det eneste gode argument
 * for den slags brug er at folk kan lave forskellige
 * dele af et projekt simultant uden at have den deciderede 
 * implementation af metoder, men blot signaturen... 
 * --------
 * noter:
 * Det f�rste bogen hakker ned p� er et interface som 
 * hedder PhysicalConstant som jeg har lavet her i vores pakke,
 * problemet med at implementere et interface, som dette er at 
 * det leaker ud i vores API, hvis alle subclasser af den klasse
 * som evt. implementere det her interface f�r ogs� de her konstanter leaket ud i sig.
 * Hvis i en senere version af klassen, den lige pludselig ikke har brug for at
 * implementere dette interfaces, s� skal den stadig g�re det fordi vi skal sikrer
 * bin�r kompabilitet(Hvad jeg tror de mener med dette er hvis man skriver class.getClass() ==
 * class.getAnotherClass() af samme type, s� skal de helst returnere true, men hvis den ene 
 * returnere et interface s� passer de bin�re tal ikke og returner false.. har selF ikke test dette,
 * men vil pr�ve nedenfor.
 * 
 * anyway, de bedste alternativer til at implementere constanter igennem et interface,
 * et enten at lave det til en enum type, som senere vil blive diskuteret og formentlig give
 * mere mening n�r du l�ser dette n�ste gang.
 * 
 * og s� en l�sning som jeg har tilf�jet en klasse med som hedder
 * PhysicalConstantsGoodVersion(som er hvad man kalder for en utilityKlasse).
 * 
 * LOL - p� side 122, noget som vi hvertfald ikke har set f�r,
 * fordi vi ville skulle skrive PhysicalConstantsGoodVersion.variableNavn
 * og det m�ske ville blive lidt trist til sidst, s� hvis vi har t�nkt os at lave
 * mange af denne slags kald s� giver det adgang til at bruge noget som hedder
 * en 'static import' har tilf�jet en klasse som hedder Test for 
 * at vise dette, l�g m�rke til importen.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * @author DenLilleMand
 *
 */
public class RunOgNoter {
	
	/**
	 * ved ikke lige hvordan man sammenligner klasserne p� deres
	 * bin�re tal som bogen taler om, m�ske har det noget med hashCode at g�re?
	 * som vi ingen anelse har om hvad betyder endnu.
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Class1 class1 = new Class1();
		Class2 class2 = new Class2();
	
		System.out.println(class1.getClass().equals(class2.getClass()));
		
		
	}

}
