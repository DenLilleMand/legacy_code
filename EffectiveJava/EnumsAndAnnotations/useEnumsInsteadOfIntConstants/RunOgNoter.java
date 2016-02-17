package useEnumsInsteadOfIntConstants;

public class RunOgNoter 
{
	/**
	 * 
	 * tl;dr;
	 * enums er nice! - de er i princippet nogle final singleton
	 * klasser man kan g�re med hvad man har lyst til, kan give dem metoder,
	 * og fields(s� l�nge fieldsne er final fordi det er enums gemick)-
	 * De har en god performance, og de leaker ikke ud i ens API p� den m�de
	 * at de bliver compilet med client(client som i klasser der skal bruge dette enum)
	 *  kode, det betyder at man kan �ndre en enums v�rdi uden at recompile noget kode som allerede k�rer.
	 *  deres performance kan sammenlignes med int constanter, s� man kan bruge n�r som helst
	 *  man har brug for et fixed par constanter, f.eks dage, planeter.
	 *  
	 *  enums er lavet for at overg� de konstante enum typer,
	 *  og de er langt bedre i den forstand at de er lettere at l�se,
	 *  og de er mere kraftfulde. de BEH�VER ikke at have en constructor, fields og metoder
	 *  men man kan tilf�je det hvis man har brug for at tilf�je noget data.
	 *  
	 *  og s� skal man huske at overveje sit strategy enum pattern hvis enums deler
	 *  noget opf�rsel men afviger p� en enkelt metode eller lidt mere end det.
	 * ----------------
	 * Noter:
	 * To familier blev tilf�jet 
	 *	til sproget i release 1.5. en ny klasse kaldet
	 *'enum type' og en ny slags interface some hedder 'annotation type'.
	 *	
	 *
	 *	'An 'enumerated type' is a type whose legal values consist of a fixed set of constants, such as
	 *	seasons of the year, the planets in the solar system, or the suits in a deck of playing cards.
	 *before enum types were added to the language, a common pattern for representing enumerated types was to declare a group
	 *of named int constants, one of each member of the type(Kode eksempel 1, the int enum pattern-severely deficient!)
	 * 
	 * der er ingen type-safety i dette pattern,
	 * og det giver ikke meget rum til lette l�sninger.
	 * 
	 * compileren er ligeglad med om man giver en metode en appelsin eller et �ble,
	 * Der er ogs� folk som bruger det som hedder 'the String enum pattern'
	 * som er endnu v�rre, bare lad v�re :) f.eks er det en forf�rdelig ide
	 * fordi det afh�nger af String comparisons, og der er ikke nogen let m�de at finde ud af hvor mange
	 * Strings der er i ens pattern, folk kan lave en typografisk fejl som giver en run-time fejl.
	 *	og ligesom med int enum pattern, s� hvis man �ndrer det, s� skal hele servicen recompiles til den nye v�rdi,
	 *	ellers ved man ikke hvad de k�rer p�(jeg er ikke helt sikker p� hvor s�gt det er,
	 *fordi selF skal man recompile ens server&Client n�r ny kode bliver tilf�jet?) .
	 *
	 *anyway, pointen er at Enums er blevet lavet for at g�re de opgaver som disse patterns havde
	 *lettere - og tilf�je mere funktionalitet, jeg synes at bogen ligger lidt op til at vi
	 *kan finde ud af hvor mange variabler der er i et enum osv.
	 *Kode eksempel 2 viser den simpleste form for enum.
	 * 
	 * i c/c++/c# er enums n�sten blot int v�rdier,
	 * imens de ligner hinanden og den enum type i java, s�
	 * er javas en full fletched klasse som er meget mere kraftfuld end dem
	 * i de andre sprog.
	 * 
	 * Ideen bag ved enums er simple,
	 * 'They are classes that export one instance for each enumeration constant via a public
	 * static final field. Enum types are effectively final, by virtue of having no accessible constructors.
	 * Because clients can neither create instances of an enum type nor extend it, there can be no
	 * instances, but the declared enum constants. In other words, enum types are instance-controlled. They are a generalization of singletons.
	 * which are essentially single-element enums. For readers familiar with the first edition
	 * of this book, enum types provide linguistic support for the typesafe enum pattern.
	 * 
	 * hmm, s� de er instance controlled ligesom vi har l�rt at g�re, n�r man returner et statisk field af et eller andet objekt,
	 * men hvordan man kan bruge dem til at lave rigtige objekter til singletons har vi ikke helt fundet ud af endnu :)
	 * 
	 * Enums sikrer sig ligesom Generics at vi fanger bugs ved compile-time, s� vidt jeg forst�r
	 * godtager den null, og s� udelukkende en af de konstanter som er med i dens enum type.
	 * S� igen - compileTime > run-time(tydeligvis).
	 * 
	 * Enum typer med de samme navne det okay sammen, og jeg tror n�r de siger enum TYPER,
	 * s� mener de ligesom i kode eksempel 2, de navne der er inde i vores brackets,
	 * og grunden de giver er at de er i et name space for sig selv, 
	 * ligesom at 2 metoder i hver deres klasse ogs� kan hedde det samme.
	 * 
	 * Det vi talte om tidligere som jeg satte sp�rgsm�l tegn ved, var om man ikke burde
	 * skulle compile hele programmet selvom det var en enum type man tilf�jet istedet for en int i et 
	 * int enum pattern, men �benbart s� det den forklare er at Enum typen ikke bleeder ud i dens clients(Clients er
	 * de klasser som bruger enumet??) -fordi den har et lag imellem sig og bliver ikke compilet ind i clienten
	 * ligesom et int enum pattern ville blive, s� vi kan �ndre det l�bende uden de store problemer.
	 * 
	 * til sidst, giver de ogs� den fordel at de kan laves om til printbare Strings ved at kalde
	 * deres toString() metode.
	 * 
	 * Enums implementere ogs� et h�jt niveau af alle Objekt klassens metoder, og implementere interfaces som 
	 * Comparable og Serializable, deres Serialized form er ogs� designet til at modst�
	 * de fleste �ndringer til enum typen(hvad end det betyder?, m�ske at man kan caste en enum til en anden enum
	 * selvom de er anderledes, til et hvis niveau).
	 * 
	 * S�(!) hvorfor ville man tilf�je metoder og fields til en enum type?
	 * F�rst og fremmest har man m�ske lyst til at tilf�je noget data til ens constanter.
	 * Vores Apple og Orange typer, har m�ske brug for en metode der returnere farven af frugten, eller
	 * en som returnere et billed af det. Man kan give en enum type hvilken som helst metode som virker
	 * brugbar. En enum kan starte dens liv som en simple
	 * samling af konstanter og senere udvikle sig til en 
	 * fuldt udrustet abstraktion.
	 * 
	 * kig p� kode eksempel 3 for et bud p� en 
	 * rig-samling af enums.
	 * 
	 * Det er relativt let at skrive en enum type som Planet.
	 * for at associere data med en enum konstant, s� deklare instans felterne, skriv en constructor
	 * der tager dataen og s�tter den ind i felterne.
	 * 
	 * Enums er pr. natur immutable, s� alle felter skal v�re final,
	 * de kan godt v�re public, men det er bedre at lave dem private og give public accessors
	 * (og det giver mening nu hvorfor getters og setters er s�dan et hit, fordi hvis man har direkte adgang
	 * til en variable kan man jo bare s�tte den til noget nyt, men man kan ikke skrive
	 * 'getVariable() == 2' osv.
	 * 
	 * i kode eksempel 4 viser vi hvordan vi kan bruge vores Planet enum
	 * 
	 * Ligesom alle andre klasser, s� hvis man ikke har en rigtig god grund til at lave en metode public, s� lav den private eller
	 * package-private(default).
	 * 
	 * et Enum returnere et array med alle dens 'enum typer', med den f�rste p� index[0]
	 * 
	 * Hvis et Enum er nogenlunde brugbart s� burde det v�re toplevel i hierarkiet, f.eks bruger BigDecimal det enum som hedder RoundingMode,
	 * og hvis man har brug for disse funktionalitet ville man foresl� at genbruge dette enum, s� det g�r vores API mere flexible.
	 * 
	 * Kode eksempel 5, viser hvordan man kan have forskellig adf�rd internt hos de forskellige enum typer, 
	 * Dette kodeeksempel kan man s�tte sp�rgsm�lstegn ved, hvor godt det g�r hvis man tilf�jer endnu en enum type
	 * og glemmer at tilf�je den til swith casen(hvor compileren ikke vil advarer en),
	 * samt at det generalt ikke er specielt p�n kode.
	 * Der er dog en bedre l�sning end kode eksempel 5, nemlig det vi ser i kode eksempel 6.
	 * Hvor vi @Overrider en metode i hver af de der enum typer.
	 * I dette tilf�lde, selvom vi selF gerne vil finde alle de gode ting ved det,
	 * s� er det vel rimelig sv�rt at glemme at implementere apply metoden, fordi den er declared
	 * hos alle de andre enum typer, lige ved siden af der hvor man tilf�jer sin nye.
	 * Udover dette s� har vi en konkret l�sning p� dette ved at have tilf�jet en abstract metode,
	 * som SKAL @Overrides, s� compileren vil bede os om det lige meget hvad.
	 * 
	 * Konstant specifikke metoder kan kombineres med konstant specifikt data,
	 * det ser man i kode eksempel 7.
	 * 
	 * koden i eksempel 8 er uben�gtely pr�cis, men den er farlig fra et 
	 * velligeholdelses perspektiv, og den er farlig
	 * fordi vi igen kan tilf�je en enum type til klassen, uden at f� en compile-time error.
	 * hvilket senere kunne v�re en runtime error eller i det her
	 * tilf�lde m�ske en bestemt holiday, som g�r ind som en default dag.
	 * anyway - vi er ikke glade for den her kode, s� vi vil pr�ve at 
	 * blive tvunget til at tilf�je en computation hver gang i laver et nyt enum,
	 * og der undre det mig lidt at vi ikke bare har en abstract metode,
	 * men det er m�ske fordi vi igen s� er ude i noget med et switch statement,  hvad man dog ville kunne
	 * g�re var at have 2 abstract methods, en for hver type dag, og s� @Override den med en exception
	 * det var vi jo lavet noget kode i design patterns der minder om.
	 * anyway - bogen har sin egen ide, der hedder at implementere en 'strategy enum' som man
	 * giver ind til ens enum i parameteren og den st�r s� for ens computation,
	 * har lavet kode eksemplet i kode stykke 9.
	 * Var sku et rimelig langt kode eksempel, m�ske er det bedre at f�lge det i bogen,
	 * p� side 179.
	 * anyway, med et private enum der virker til at h�rer til en slags innerclass,
	 * og som bliver givet ind som parameter og st�r for ens computation, og det
	 * g�r s�dan at man f�r besked ved compile-time n�r man laver en fejl, det virker som
	 * et rimelig effektivt pattern- som vel kan bruges hver gang
	 * man har nogle konstanter der skal indeholde nogle forskellige computations,
	 * ellers har de jo bare alle sammen de samme konkrete metoder implementeret, 
	 * men det virker til at hver gang man har lyst til at lave en abstract metode som de 
	 * alle sammen skal overholde, fordi de ville have en forskellig implementation, s� burde man implementere
	 * dette fordi ellers skulle de i gang med switch cases for at finde sin egen - s� en regel m� v�re
	 * at hver gang man for lyst til at lave en abstract metode til enums, s� brug et 
	 * enum strategy pattern i stedet for.
	 * 
	 * Der bliver sluttet af med at fort�lle hvad man S� kan bruge switch cases p� enums til,
	 * nu n�r vi ikke kan bruge dem til individuel opf�rsel, og det bliver vist p� side 180,
	 * det virker ikke s�rlig brugbart.
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		/**
		 * kode eksempel 1:
		 */
		
		public static final int APPLE_FUJI = 0;
		public static final int APPLE_PIPPIN = 1;
		public static final int APPLE_GRANNY_SMITH = 2;
		
		public static final int ORANGE_NAVEL = 0;
		public static final int ORANGE_TEMPLE = 1;
		public static final int ORANGE_BLOOD = 2;
		
		
		/**
		 * Kode eksempel 2:
		 */
		
		public enum Apple{FUJI,PIPPIN, GRANNY_SMITH}
		public enum Orange{NAVEL,TEMPLE,BLOOD}
		
		/**
		 * Kode eksempel 3:
		 */
		
		//Enum type with data and behavior
		public enum Planet
		{
			MERCURY(3.293,23293);
			VENUS(22424,2424);
			EARTH(24242,242424);
			MARS(23211,121212);
			JUPITER(1212004,2424024);
			SATURN(12030, 843240);
			URANUS(210310,3509350);
			NEPTUNE(12129,12912);
		
			private final double mass;	//In kilograms
			private final double radius //In meters
			private final double surfaceGravity; //In m/ s^2
		
			//universal gravitational constant in m^3 / kg s^2
			private static final double G = 6.67300E-11;
			
			//Constructor
			Planet(double mass, double radius)
			{
				this.mass = mass;
				this.radius = radius;
				surfaceGravity = G * mass / (radius * radius);
			}
			
			public double mass() { return mass;}
			public double radius {return radius;}
			public double surfaceGravity{return surfaceGravity;}
			
			public double surfaceWeight(double mass)
			{
				return mass * surfaceGravity; //F = ma
			}
		}
	}
	
	/**
	 * Kode eksempel 4:
	 *(Jeg tror ikke at man skal f� kode til at give mening s�dan rigtigt, tror bare at man skal se de 3 linjer som adskilte
	 *m�der at bruge vores information fra enums p�, fordi vi bruger ikke rigtig de 2 doubles mass/earthWeight)
	 */
	
	public class WeightTable
	{
		public static void main(String[] args)
		{
			double earthWeight = Double.parseDouble(args[0]);
			double mass = earthWeight / Planet.EARTH.surfaceGravity();
			for(Planet p : Planet.values())
			{
				System.out.printf("Weight on %s is %f%n",p,p.surfaceWeight(mass));
			}
		}
	}
	
	/**
	 * Kode eksempel 5:
	 */
	
	//Enum type that switches on its own value - questionable
	public enum Operation
	{
		PLUS,MINUS,TIMES,DIVIDE;
		
		//Do the arithmetic op represented by this constant
		double apply(double x, double y)
		{
			switch(this)
			{
			case PLUS: return x + y;
			case MINUS: return x -y;
			case TIMES: return x *y;
			case DIVIDE: return x / y;
			
			}
			throw new AssertionError("Unknown op: " + this);
		}
	
		/**
		 * Kode eksempel 6:
		 */
	
		public enum Operation
		{
			PLUS{ double apply(double x, double y){return x + y;}},
			MINUS{ double apply(double x, double y){return x + y;}},
			TIMES{ double apply(double x, double y){return x + y;}},
			DIVIDE{ double apply(double x, double y){return x + y;}};
			
			abstract double apply(double x, double y);
		}
		
		/**
		 * Kode eksempel 7:
		 */
		//Enum type with constant specific class bodies and data
		public enum Operation
		{
			PLUS("+")
			{
				double apply(double x, double y){return x + y;}
			}
			MINUS("-")
			{
				double apply(double x, double y){return x + y;}
			}
			TIMES("*")
			{
				double apply(double x, double y){return x + y;}
			}
			DIVIDE("/")
			{
				double apply(double x, double y){return x + y;}
			}
			
			private final String symbol;
			Operation(String symbol) {this.symbol = symbol;}
			@Override public String toString(){return symbol;}
			
			abstract double apply(double x, double y);
		}
	}
	
	/**
	 * Kode eksempel 8:
	 */
	
	//Enum that switches on its value to share code - questionable
	enum PayrollDay
	{
		MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY;
		
		private static final int HOURS_PER_SHIFT = 8;
		
		double pay(double hoursWorked, double payRate)
		{
			double basePay = hoursWorked * payRate;
			double overtimePay; // Calculate overtime pay
			
			/**
			 * WOOT(!)- 2 cases kan blive sammenlagt til det
			 * samme metode kald, det burde vi da g�re i vores Oikosprojekt
			 * for readability.
			 */
			switch(this)
			{
			case SATURDAY: case SUNDAY: overtimePay = hoursWorked * payRate / 2;
			default : //Wekkdays
				overtimePay = hoursWorked<= HOURS_PER_SHIFT ? 0 : (hoursWorked - HOURS_PER_SHIFT) * payRate / 2;
				break;
			}
			return basePay + overtimePay;
		}
		
		
		/**
		 * Kode eksempel 9:
		 */
		//The strategy enum pattern
		enum PayrollDay
		{
			MONDAY(PayType.WEEKDAY), TUESDAY(PayType.WEEKDAY),
			WEDNESDAY(PayType.WEEKDAY), THURSDAY(PayType.WEEKDAY),
			FRIDAY(PayType.WEEKDAY),SATURDAY(PayType.WEEKEND), SUNDAY(PayType.WEEKEND);
		
			private final PayType payType;
			PayrollDay(PayType payType) {this.payType = payType;}
		
			double pay(double hoursWorked, double payRate)
			{
				return payType.pay(hoursWorked, payRate);
			}
			
			//The strategy enum type
			private enum PayType
			{
				WEEKDAY
				{
					double overtimePay(double hours, double payRate)
					{
						return hours <= HOURS_PER_SHIFT ? 0 : (hours - HOURS_PER_SHIFT) * payRate / 2;
					}
				},
				WEEKEND 
				{
					double overtimePay(double hours, double payRate)
					{
						return hours * payRate / 2;
					}
				};
				private static final int HOURS_PER_SHIFT = 8;
				
				abstract double overtimePay(double hrs, double payRate);
				
				double pay(double hoursWorked, double payRate)
				{
					double basePay = hoursWorked * payRate;
					return basePay + overtimePay(hoursworked, payRate);
				}
			}
		}
		
	}
	
	
}
