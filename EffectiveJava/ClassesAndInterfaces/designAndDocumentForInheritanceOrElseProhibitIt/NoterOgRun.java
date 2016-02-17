package designAndDocumentForInheritanceOrElseProhibitIt;
/**
 * Design and document for inheritance or else prohibit it-
 * side 110 start den. 
 * 
 * stikord: constructor/private/protected, non-final
 * 
 * n�r man subclasser, og initialisere klassen,
 * s� bliver super constructoren kaldt f�rst,
 * dvs. at hvis man kommer til at kalde nogle @Override
 * metoder i superens constructor som subclassen har
 * en custom implementation af, s� kan man sagtens f� en null
 * pointer, hvilket giver f�dsel til den regel der hedder at man
 * aldrig referer til @Override metoder i constructors. 
 * 
 * Man skal jo g�re klassen s� lidt mutable som muligt,
 * s� man skal ikke lave for mange fields protected, der skal 
 * selF v�re et par fordi det skal v�re effektivt at subclasse,
 * men den bedste m�de at tjekke p� hvilke felter der skal v�re private
 * og hvilke der skal v�re protected er ved at f� andre programm�rer
 * til at subclasse ens klasse, der er det magiske tal 3 gange-skal de pr�ve at
 * subclasse den, og hvis de ikke har brugt et bestemt felt nogle af gangene kan man
 * overveje om det ikke skal v�re et protected felt.
 * 
 * 
 * udover dette - s� kr�ver kode generalt jo kommentarer, men n�r man bygger en klasse til 
 * arv, s� er det vigtigt at man ikke bare skriver hvad metoden g�r,
 * men ogs� skriver hvordan den er blevet implementeret, hvilket bryder med den kommentar regel
 * som lyder at man ikke skal skrive hvordan det sker, men blot hvad der sker. 
	men det er der ikke s� meget at g�re ved.
	
	igen f�lte bogen at der var brug for at understrege hvordan man s�rger for at
	folk ikke subclasser ens klasse,  man kan lave den final,
	eller ogs� kan man lave alle ens constructors private/package-private(default),
	og s� selF lave en factory method hvis det bliver n�dvendigt.
	
	
 * @author DenLilleMand
 *
 */
public class NoterOgRun 
{

	public static void main(String[] args) 
	{
	}

}
