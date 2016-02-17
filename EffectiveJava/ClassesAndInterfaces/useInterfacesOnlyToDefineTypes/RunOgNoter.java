package useInterfacesOnlyToDefineTypes;

/**
 * Use Interfaces only to define types.
 * 
 * tl;dr;
 * 'Do not use interfaces to export constants,
 * only use them to define types'
 * 
 * Jeg har på fornemmelsen at når vi bruger interfaces 
 * som vi gjore i Oikos projektet uden at bruge dem som
 * deciderede typer- så bruger man ikke interfaces
 * som de var lavet til. det eneste gode argument
 * for den slags brug er at folk kan lave forskellige
 * dele af et projekt simultant uden at have den deciderede 
 * implementation af metoder, men blot signaturen... 
 * --------
 * noter:
 * Det første bogen hakker ned på er et interface som 
 * hedder PhysicalConstant som jeg har lavet her i vores pakke,
 * problemet med at implementere et interface, som dette er at 
 * det leaker ud i vores API, hvis alle subclasser af den klasse
 * som evt. implementere det her interface får også de her konstanter leaket ud i sig.
 * Hvis i en senere version af klassen, den lige pludselig ikke har brug for at
 * implementere dette interfaces, så skal den stadig gøre det fordi vi skal sikrer
 * binær kompabilitet(Hvad jeg tror de mener med dette er hvis man skriver class.getClass() ==
 * class.getAnotherClass() af samme type, så skal de helst returnere true, men hvis den ene 
 * returnere et interface så passer de binære tal ikke og returner false.. har selF ikke test dette,
 * men vil prøve nedenfor.
 * 
 * anyway, de bedste alternativer til at implementere constanter igennem et interface,
 * et enten at lave det til en enum type, som senere vil blive diskuteret og formentlig give
 * mere mening når du læser dette næste gang.
 * 
 * og så en løsning som jeg har tilføjet en klasse med som hedder
 * PhysicalConstantsGoodVersion(som er hvad man kalder for en utilityKlasse).
 * 
 * LOL - på side 122, noget som vi hvertfald ikke har set før,
 * fordi vi ville skulle skrive PhysicalConstantsGoodVersion.variableNavn
 * og det måske ville blive lidt trist til sidst, så hvis vi har tænkt os at lave
 * mange af denne slags kald så giver det adgang til at bruge noget som hedder
 * en 'static import' har tilføjet en klasse som hedder Test for 
 * at vise dette, læg mærke til importen.
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
	 * ved ikke lige hvordan man sammenligner klasserne på deres
	 * binære tal som bogen taler om, måske har det noget med hashCode at gøre?
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
