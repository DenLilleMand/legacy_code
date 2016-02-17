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
	 * det er en hård opgave hos interfaces, og bedre med Arv) is deemed more important than flexibility and power.
	 * Under these circumstances, you should use an abstract class to define the type, but only if you
	 * understand and can accept the limtations. If you export a nontrivial interface, you
	 * should strongly consider providing a skeletal implementation to go with it.
	 * Finally you should design all of your public(sidenote:kan 
	 * interfaces være private?)  interfaces with the utmost care and test them thoroughly by writing
	 * multiple implementations.
	 * 
	 * -----------
	 * der er 2 typer der tillader at man laver flere implementationer,
	 * det er interfaces og abstract classes, 
	 * 
	 * den store forskel på de 2 er at abstract classes kan indeholde
	 * konkrete implementationer imens interfaces blot indeholder signaturer.
	 * og en mere vigtig forskel på de 2 er at man skal subclasse en
	 * abstract klasse, iforhold til at man kan nøjes med at implementere et interface.
	 * 
	 * en ting som yderligere taler imod abstract classes er at de er relativt dårlige
	 * til at indikere typer, fordi man kun kan extende en enkelt klasse,
	 * imens man kan implementere så mange interfaces som man har lyst til,
	 * OG man kan implementere interfaces på kryds og tværs af pakker imens, man
	 * så vidt jeg forstod kun må subclasse abstract klasser som er inden for sin egen pakke,
	 * mest af alt i den forstand at den er under kontrollen af den sammen gruppe programmører(hvilket
	 * nok ikke har noget med packagescope at gøre, før om mange år :) ) 
	 * 
	 * Interfaces er også langt mere fleksible på den måde at man løbende kan implementere
	 * dem hvis det bliver til en requirement, i modsætning til abstract classes.
	 * hvis man vil tilføje endnu en abstract class, så er den eneste mulighed at få fat i en af de klasser
	 * som er højere oppe i type hiarkiet og så få den til at extende klassen,
	 * dette er dog fatalt på den åbenlyse måde at alle vores klasser uden den specifikke
	 * højt-niveau type også kommer til at implementere denne klasse, man kunne også forestille
	 * sig performance og læsbarheds mæssigt ville det være en katastrofe zone.
	 * det var f.eks vigtigt at Comparable blev lavet som et interface,
	 * siden at det var et interface der kom i en senere release og skulle implementeres
	 * i en masse klasser. 
	 * 
	 * Design patterns som 'The Iterator Pattern/Composition pattern' afhænger også af interfaces,
	 * fordi en klasse kun kan have 1 parent, når den extender - men hvis man bruger interfaces giver
	 * det nogle suplement typer.   og man kan selF både extende + implementere et interface
	 * og så stadig bruge disse patterns, men uden interfaces ville composition/Iterator pattern 
	 * ville ikke være muligt.
	 * 
	 * Man kan se i vores interfaces der er lavet i denne pakke, at et type Hiarchy som 
	 * en abstract klasse ville skabe  ville slet ikke passe ind, fordi en Singer 
	 * kan også godt være en SongWriter og omvendt, og hiarket er ikke logisk inddelt.
	 * 
	 * og jeg går udfra at siden vi extender så behøver vi ikke at vise vi extender dem,
	 * men når man så implementere det her interface så får man metoder fra alle 3 interfaces.
	 * det er også super fedt at vi kan have singer og songwriter hver for sig med deres metoder,
	 * men så kan vi også lave et tredje interface der extender det - og så tilføje nogle ekstra
	 * metoder som passer til begge typer-
	 * 
	 * der er noget som hedder skeletal implementation, som er lavet til arv,
	 * det er åbenbart en abstract klasse, som implementere et interface, hvorefter den laver
	 * de konkrete implementationer alle de steder hvor de er nødvendigt, og lader de metoder som
	 * skal @Overrides være, det virker til at bogen er en fortaler for denne måde at gøre tingene på,
	 * på trods af at det involvere arv - så længe man overholder de andre regler for hvornår man skal arve,
	 * IS-A forholdet mellem klasserne gælder stadig osv. (side 118-119 er der kode eksempel).
	 * selvom kode eksemplerne ikke har nogen kommentarer mhs. til documentation, så som sagt, gælder
	 * alle Arv reglerne stadig - at man både skal specificere som altid  'hvad' en metode gør,
	 * og så fordi det er Arv skal man også skrive 'hvordan' den gør det.
	 * 
	 * den her skeletal implementation , man skal holde for øje at den er genial fordi interfaces
	 * netop har det problem at man ikke kan tilføje konkrete implementationer i det,
	 * det er netop det som en skeletal, implementation hjælper en med at overkomme, 
	 * og så  bytter man det faktum at man må nød til at subclasse.
	 * 
	 *  
	 *  Arv har den ene store fordel over interfaces at det er langt lettere at udvide en abstract klasse
	 *  iforhold til et interface, i den forstand at hvis man tilføjer endnu en metode i et interface 
	 *  så skal man også tilføje en konkret implementation i alle de klasser som implementere det -
	 *  og dermed breaker det alle klasserne indtil de har den metode.
	 *  Det skal dog siges at i denne sammenhæng så er problemet der jo ikke hvis ens skeletal implementation
	 *  implementere denne metode simultant(men det er jo igen arv der bliver brugt til at overkomme dette
	 *  problem).
	 *  
	 *  Dette bringer os til det fokus punkt der lyder: man skal have så mange programmører som muligt
	 *  til at implementere ens interface før man udgiver det og lader ting implementere det,
	 *  fordi når et interface først er ude, hvis der er lavet fejl i det og alle klasser allerede afhænger af
	 *  dens kontrakt så er det ikke muligt at lave om uden at breake andre klasser. 
	 *  Så bed kollegaer om at teste det.
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
