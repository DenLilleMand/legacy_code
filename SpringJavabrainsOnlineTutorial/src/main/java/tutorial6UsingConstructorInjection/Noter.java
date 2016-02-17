package tutorial6UsingConstructorInjection;

public class Noter 
{
	/**
	 * Noter:
	 * Using constructor injection:
	 * Den måde vi satte ting på i det forrige kapitel, hedder 
	 * "setter injection" - fordi spring.xml filen bruger vores 
	 * setter metode i Triangle til at sætte værdien(Hvilket også vil sige
	 * at man skal være obs på hvis man ikke har nogen setters til ens
	 * variable, ved ikke hvad der så sker.)
	 * 
	 * men det er tydeligvis ikke det vi har om i det her kapitel.
	 * 
	 * vi har også om flere constructors her, hvis vi nu f.eks har 2 constructors
	 * i klassen, så fungere det faktisk præcis som i java, den constructor der
	 * har de tilsvarende argumenter vil altid blive valgt,
	 * så hvis vi sletter en af de constructor-arg tags der er i vores spring.xml
	 * fil, sådan at der kun er 1 tilbage, så vil vores constructor med 1 
	 * argument blive valgt over den anden osv.
	 * 
	 * Og det man måske ligger mærke til er at i vores spring.xml fil, skriver vi 
	 * udelukkende value='vilkårlig værdi' - uden at specificere hvilken type
	 * vores værdi er af, men så klog er Spring at den selv regner det ud.
	 * 
	 * husk også at både ints og strings begge er encapsuleret af ""
	 * 
	 * anyway- nu når vi har 3 constructors, og 2 af dem tager kun 1 parameter, betyder
	 * det at vi bliver tvunget til at tilføje type="int"  eller type="java.lang.String"
	 * 
	 * i stedet for at skrive hvilken type den skal lede efter i parameteren, har den faktisk
	 * også den mulighed at specificere indexet på parameterne,
	 * så man ville skrive 
	 * 
	 *
	 * 
	 * 
	 * 
	 */
}
