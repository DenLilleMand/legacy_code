package preferInterfacesToAbstractClasses;

public class NoterOgRun 
{
	/**
	 * 
	 * Prefer interfaces to abstract classes.
	 * 
	 * 
	 * tl;dr;
	 * To summerize, and interface is generally the best way to define
	 * a type that permits multiple implementations. An exception to this rule is that case
	 * where ease of evolution(evolution i den forstand at abstract klassen skal udvides senere, forklaret nedenfor hvorfor
	 * det er en h�rd opgave hos interfaces, og bedre med Arv) is deemed more important than flexibility and power.
	 * Under these circumstances, you should use an abstract class to define the type, but only if you
	 * understand and can accept the limtations. If you export a nontrivial interface, you
	 * should strongly consider providing a skeletal implementation to go with it.
	 * Finally you should design all of your public(sidenote:kan 
	 * interfaces v�re private?)  interfaces with the utmost care and test them thoroughly by writing
	 * multiple implementations.
	 * 
	 * -----------
	 * der er 2 typer der tillader at man laver flere implementationer,
	 * det er interfaces og abstract classes, 
	 * 
	 * den store forskel p� de 2 er at abstract classes kan indeholde
	 * konkrete implementationer imens interfaces blot indeholder signaturer.
	 * og en mere vigtig forskel p� de 2 er at man skal subclasse en
	 * abstract klasse, iforhold til at man kan n�jes med at implementere et interface.
	 * 
	 * en ting som yderligere taler imod abstract classes er at de er relativt d�rlige
	 * til at indikere typer, fordi man kun kan extende en enkelt klasse,
	 * imens man kan implementere s� mange interfaces som man har lyst til,
	 * OG man kan implementere interfaces p� kryds og tv�rs af pakker imens, man
	 * s� vidt jeg forstod kun m� subclasse abstract klasser som er inden for sin egen pakke,
	 * mest af alt i den forstand at den er under kontrollen af den sammen gruppe programm�rer(hvilket
	 * nok ikke har noget med packagescope at g�re, f�r om mange �r :) ) 
	 * 
	 * Interfaces er ogs� langt mere fleksible p� den m�de at man l�bende kan implementere
	 * dem hvis det bliver til en requirement, i mods�tning til abstract classes.
	 * hvis man vil tilf�je endnu en abstract class, s� er den eneste mulighed at f� fat i en af de klasser
	 * som er h�jere oppe i type hiarkiet og s� f� den til at extende klassen,
	 * dette er dog fatalt p� den �benlyse m�de at alle vores klasser uden den specifikke
	 * h�jt-niveau type ogs� kommer til at implementere denne klasse, man kunne ogs� forestille
	 * sig performance og l�sbarheds m�ssigt ville det v�re en katastrofe zone.
	 * det var f.eks vigtigt at Comparable blev lavet som et interface,
	 * siden at det var et interface der kom i en senere release og skulle implementeres
	 * i en masse klasser. 
	 * 
	 * Design patterns som 'The Iterator Pattern/Composition pattern' afh�nger ogs� af interfaces,
	 * fordi en klasse kun kan have 1 parent, n�r den extender - men hvis man bruger interfaces giver
	 * det nogle suplement typer.   og man kan selF b�de extende + implementere et interface
	 * og s� stadig bruge disse patterns, men uden interfaces ville composition/Iterator pattern 
	 * ville ikke v�re muligt.
	 * 
	 * Man kan se i vores interfaces der er lavet i denne pakke, at et type Hiarchy som 
	 * en abstract klasse ville skabe  ville slet ikke passe ind, fordi en Singer 
	 * kan ogs� godt v�re en SongWriter og omvendt, og hiarket er ikke logisk inddelt.
	 * 
	 * og jeg g�r udfra at siden vi extender s� beh�ver vi ikke at vise vi extender dem,
	 * men n�r man s� implementere det her interface s� f�r man metoder fra alle 3 interfaces.
	 * det er ogs� super fedt at vi kan have singer og songwriter hver for sig med deres metoder,
	 * men s� kan vi ogs� lave et tredje interface der extender det - og s� tilf�je nogle ekstra
	 * metoder som passer til begge typer-
	 * 
	 * der er noget som hedder skeletal implementation, som er lavet til arv,
	 * det er �benbart en abstract klasse, som implementere et interface, hvorefter den laver
	 * de konkrete implementationer alle de steder hvor de er n�dvendigt, og lader de metoder som
	 * skal @Overrides v�re, det virker til at bogen er en fortaler for denne m�de at g�re tingene p�,
	 * p� trods af at det involvere arv - s� l�nge man overholder de andre regler for hvorn�r man skal arve,
	 * IS-A forholdet mellem klasserne g�lder stadig osv. (side 118-119 er der kode eksempel).
	 * selvom kode eksemplerne ikke har nogen kommentarer mhs. til documentation, s� som sagt, g�lder
	 * alle Arv reglerne stadig - at man b�de skal specificere som altid  'hvad' en metode g�r,
	 * og s� fordi det er Arv skal man ogs� skrive 'hvordan' den g�r det.
	 * 
	 * den her skeletal implementation , man skal holde for �je at den er genial fordi interfaces
	 * netop har det problem at man ikke kan tilf�je konkrete implementationer i det,
	 * det er netop det som en skeletal, implementation hj�lper en med at overkomme, 
	 * og s�  bytter man det faktum at man m� n�d til at subclasse.
	 * 
	 *  
	 *  Arv har den ene store fordel over interfaces at det er langt lettere at udvide en abstract klasse
	 *  iforhold til et interface, i den forstand at hvis man tilf�jer endnu en metode i et interface 
	 *  s� skal man ogs� tilf�je en konkret implementation i alle de klasser som implementere det -
	 *  og dermed breaker det alle klasserne indtil de har den metode.
	 *  Det skal dog siges at i denne sammenh�ng s� er problemet der jo ikke hvis ens skeletal implementation
	 *  implementere denne metode simultant(men det er jo igen arv der bliver brugt til at overkomme dette
	 *  problem).
	 *  
	 *  Dette bringer os til det fokus punkt der lyder: man skal have s� mange programm�rer som muligt
	 *  til at implementere ens interface f�r man udgiver det og lader ting implementere det,
	 *  fordi n�r et interface f�rst er ude, hvis der er lavet fejl i det og alle klasser allerede afh�nger af
	 *  dens kontrakt s� er det ikke muligt at lave om uden at breake andre klasser. 
	 *  S� bed kollegaer om at teste det.
	 *  
	 * 
	 * 
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{

	}

}
