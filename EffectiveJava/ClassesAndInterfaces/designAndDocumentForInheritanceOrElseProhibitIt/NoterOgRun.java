package designAndDocumentForInheritanceOrElseProhibitIt;
/**
 * Design and document for inheritance or else prohibit it-
 * side 110 start den. 
 * 
 * stikord: constructor/private/protected, non-final
 * 
 * når man subclasser, og initialisere klassen,
 * så bliver super constructoren kaldt først,
 * dvs. at hvis man kommer til at kalde nogle @Override
 * metoder i superens constructor som subclassen har
 * en custom implementation af, så kan man sagtens få en null
 * pointer, hvilket giver fødsel til den regel der hedder at man
 * aldrig referer til @Override metoder i constructors. 
 * 
 * Man skal jo gøre klassen så lidt mutable som muligt,
 * så man skal ikke lave for mange fields protected, der skal 
 * selF være et par fordi det skal være effektivt at subclasse,
 * men den bedste måde at tjekke på hvilke felter der skal være private
 * og hvilke der skal være protected er ved at få andre programmører
 * til at subclasse ens klasse, der er det magiske tal 3 gange-skal de prøve at
 * subclasse den, og hvis de ikke har brugt et bestemt felt nogle af gangene kan man
 * overveje om det ikke skal være et protected felt.
 * 
 * 
 * udover dette - så kræver kode generalt jo kommentarer, men når man bygger en klasse til 
 * arv, så er det vigtigt at man ikke bare skriver hvad metoden gør,
 * men også skriver hvordan den er blevet implementeret, hvilket bryder med den kommentar regel
 * som lyder at man ikke skal skrive hvordan det sker, men blot hvad der sker. 
	men det er der ikke så meget at gøre ved.
	
	igen følte bogen at der var brug for at understrege hvordan man sørger for at
	folk ikke subclasser ens klasse,  man kan lave den final,
	eller også kan man lave alle ens constructors private/package-private(default),
	og så selF lave en factory method hvis det bliver nødvendigt.
	
	
 * @author DenLilleMand
 *
 */
public class NoterOgRun 
{

	public static void main(String[] args) 
	{
	}

}
