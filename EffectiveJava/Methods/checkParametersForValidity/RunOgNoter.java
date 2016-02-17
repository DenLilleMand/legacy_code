package checkParametersForValidity;

public class RunOgNoter {

	/**
	 * tl;dr;
	 * Kod metoder til at finde fejl hurtigst muligt(evt. vha checks p� parametre).
	 * 
	 * hver gang man skriver en metode eller en konstrukt�r s� 
	 * skal man t�nke over hele forholdsregler eksisterer omkring parameterne,
	 * man b�r dokumentere disse forholdsregler og g�re noget ved dem
	 * , ved at implementere checks i starten af metoden, og det er vigtigt at g�re dette til en vane.
	 * Det lidt arbejde det kr�ver vil blive betalt tilbage med renter f�rste gang et tjek ikke godkender.
	 * 
	 * ----------
	 * Noter:
	 * N�r man laver en metode, s� skal man dokumentere
	 * hvilke slags parameter den tager imod. Og man skal ogs� 
	 * lave checks p� om disse parametre er valide, fordi man vil finde fejl
	 * hurtigst muligt n�r en bracket af kode k�rer, vi gider ikke at finde fejlen
	 * pga. et eller andet objekts felt er blevet komprimeret, eller en underlig
	 * exception bliver smidt 1000 linjer senere i koden.
	 * 
	 * Det er ogs� en god ide at bruge @throws tag p�
	 * hvilken Exception en metode smider i documentationen.
	 * 
	 * i kode eksempel 1 kan vi se hvordan en typisk metode ser ud.
	 * 
	 * Det er vigtigt at n�r man er den person der har ansvaret for en pakke, at man s� 
	 * selvf�lgelig sikrer sig at folk for det f�rste ved hvad de skal give ind som parameter,
	 * og for det andet at de ikke for lov til at smide noget forkert ind, 
	 * hvilket evt. peger mere og mere p� at en pakke ikke er en Control pakke/mediator pakke osv.
	 * men at en pakke er en gruppe af klasser som oftest har private constructors
	 * og what not, og s� har den samling af klasser som selF har et forhold et samarbejde
	 * og f�lles giver de noget information til en klasse som s� er det man kalder for en API,
	 * hvor andre klasser kan tale med den api, og den st�r s� for at kalde de metoder man m�.
	 * Men hvordan man inddeler et projekt rent visuelt i disse ved jeg ikke, siden
	 * det ogs� kunne v�re nice visuelt at indele ens projekt i arkitektur.
	 * 
	 * i kode eksempel 2 ser man assertions, hvilket er f�rste gang jeg ser s�dan nogle,
	 * man skal bare lige v�re obs p� at man skal enable dem ved at kalde 
	 * '-ea (or -enableassertions) flag to the java
		interpreter' hvilket der ikke bliver givet et eksempel p� hvordan man g�r.
	 * 
	 * Det er vigtigt at tjekke parametre som skal bruges med det samme,
	 * men det er endnu vigtigere at tjekke de parametre som bliver stored i et field
	 * og som m�ske bliver brugt senere af et stykke kode et andet sted i programmet.
	 * og dermed g�r det sv�rt at debugge dens oprindelse.
	 * Dette kunne f.eks v�re en ArrayList eller mange andre ting.
	 * 
	 * Der er dog undtagelser hvor det ikke giver mening at tjekke 
	 * parametrene, og det er n�r det at tjekke parametrene ville v�re upraktisk
	 * eller meget performance h�ftigt samtidig med at tjekket p� parameteren alligevel
	 * ville v�re en del af computationen, f.eks hvis man skal s�ge en arraylist igennem,
	 * hvor alle objekterne skal v�re Comparable, og man s� rammer noget der ikke er,
	 * s� ville det smide en ClassCastException, det ville f.eks v�re et spild at lave en forud
	 * analysering af arraylisten for at finde ud af dette, siden vi finder ud af det alligevel.
	 * 
	 *  
	 * 
	 * 
	 * @param arg
	 */
	public static void main(String[] args) 
	{
		/**
		 * Kode eksempel 1:
		 * Documentationen er ogs� relevant for eksemplet.
		 */
		
		/**
		 * Returns a BigInteger whose value is (this mod m). This method
		 * differs from the remainder method in that it always returns a 
		 * non-negative BigInteger.
		 * 
		 * @param m the modulus, which must be positive
		 * @return this mod m
		 * @throws ArithmeticException if m is less than or equal to 0
		 */
		public BigInteger mod(BigInteger m)
		{
			if(m.signum() <= 0)
				throw new ArithmeticException("Modulus <= 0: " + m)
			...//do the computation
		}
		
		/**
		 * Kode eksempel 2:
		 * (WOW! har aldrig set keyworded 'assert' f�r,  det er �benbart
		 * et sanity check der smider en AssertionError hvis den fejler(HVIS! man har slået
		 * det til, så det betyder at det er i developing fasen at man bruger assert - 
		 * og muligvis også for readability af en metode).
		 * der bliver bare tilf�jet at hvis det her returner false s� smider den
		 * som sagt en assertion error . ehm .. men at hvis man er mere interesseret i assertions
		 * at man s� kan tjekke Sun's tutorial[Assertions]
		 */
		
		//Private helper function for a recursive sort
		private static void sort(long a[], int offset, int length)
		{
			assert a != null;
			assert offset >= 0 && offset <= a.length;
			assert length >= 0 && length <= a.length - offset;
			... //Do the computation
		}
		
		
	}

}
