package useEnumsInsteadOfIntConstants;

public class RunOgNoter 
{
	/**
	 * 
	 * tl;dr;
	 * enums er nice! - de er i princippet nogle final singleton
	 * klasser man kan gøre med hvad man har lyst til, kan give dem metoder,
	 * og fields(så længe fieldsne er final fordi det er enums gemick)-
	 * De har en god performance, og de leaker ikke ud i ens API på den måde
	 * at de bliver compilet med client(client som i klasser der skal bruge dette enum)
	 *  kode, det betyder at man kan ændre en enums værdi uden at recompile noget kode som allerede kører.
	 *  deres performance kan sammenlignes med int constanter, så man kan bruge når som helst
	 *  man har brug for et fixed par constanter, f.eks dage, planeter.
	 *  
	 *  enums er lavet for at overgå de konstante enum typer,
	 *  og de er langt bedre i den forstand at de er lettere at læse,
	 *  og de er mere kraftfulde. de BEHØVER ikke at have en constructor, fields og metoder
	 *  men man kan tilføje det hvis man har brug for at tilføje noget data.
	 *  
	 *  og så skal man huske at overveje sit strategy enum pattern hvis enums deler
	 *  noget opførsel men afviger på en enkelt metode eller lidt mere end det.
	 * ----------------
	 * Noter:
	 * To familier blev tilføjet 
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
	 * og det giver ikke meget rum til lette løsninger.
	 * 
	 * compileren er ligeglad med om man giver en metode en appelsin eller et æble,
	 * Der er også folk som bruger det som hedder 'the String enum pattern'
	 * som er endnu værre, bare lad være :) f.eks er det en forfærdelig ide
	 * fordi det afhænger af String comparisons, og der er ikke nogen let måde at finde ud af hvor mange
	 * Strings der er i ens pattern, folk kan lave en typografisk fejl som giver en run-time fejl.
	 *	og ligesom med int enum pattern, så hvis man ændrer det, så skal hele servicen recompiles til den nye værdi,
	 *	ellers ved man ikke hvad de kører på(jeg er ikke helt sikker på hvor søgt det er,
	 *fordi selF skal man recompile ens server&Client når ny kode bliver tilføjet?) .
	 *
	 *anyway, pointen er at Enums er blevet lavet for at gøre de opgaver som disse patterns havde
	 *lettere - og tilføje mere funktionalitet, jeg synes at bogen ligger lidt op til at vi
	 *kan finde ud af hvor mange variabler der er i et enum osv.
	 *Kode eksempel 2 viser den simpleste form for enum.
	 * 
	 * i c/c++/c# er enums næsten blot int værdier,
	 * imens de ligner hinanden og den enum type i java, så
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
	 * hmm, så de er instance controlled ligesom vi har lært at gøre, når man returner et statisk field af et eller andet objekt,
	 * men hvordan man kan bruge dem til at lave rigtige objekter til singletons har vi ikke helt fundet ud af endnu :)
	 * 
	 * Enums sikrer sig ligesom Generics at vi fanger bugs ved compile-time, så vidt jeg forstår
	 * godtager den null, og så udelukkende en af de konstanter som er med i dens enum type.
	 * Så igen - compileTime > run-time(tydeligvis).
	 * 
	 * Enum typer med de samme navne det okay sammen, og jeg tror når de siger enum TYPER,
	 * så mener de ligesom i kode eksempel 2, de navne der er inde i vores brackets,
	 * og grunden de giver er at de er i et name space for sig selv, 
	 * ligesom at 2 metoder i hver deres klasse også kan hedde det samme.
	 * 
	 * Det vi talte om tidligere som jeg satte spørgsmål tegn ved, var om man ikke burde
	 * skulle compile hele programmet selvom det var en enum type man tilføjet istedet for en int i et 
	 * int enum pattern, men åbenbart så det den forklare er at Enum typen ikke bleeder ud i dens clients(Clients er
	 * de klasser som bruger enumet??) -fordi den har et lag imellem sig og bliver ikke compilet ind i clienten
	 * ligesom et int enum pattern ville blive, så vi kan ændre det løbende uden de store problemer.
	 * 
	 * til sidst, giver de også den fordel at de kan laves om til printbare Strings ved at kalde
	 * deres toString() metode.
	 * 
	 * Enums implementere også et højt niveau af alle Objekt klassens metoder, og implementere interfaces som 
	 * Comparable og Serializable, deres Serialized form er også designet til at modstå
	 * de fleste ændringer til enum typen(hvad end det betyder?, måske at man kan caste en enum til en anden enum
	 * selvom de er anderledes, til et hvis niveau).
	 * 
	 * Så(!) hvorfor ville man tilføje metoder og fields til en enum type?
	 * Først og fremmest har man måske lyst til at tilføje noget data til ens constanter.
	 * Vores Apple og Orange typer, har måske brug for en metode der returnere farven af frugten, eller
	 * en som returnere et billed af det. Man kan give en enum type hvilken som helst metode som virker
	 * brugbar. En enum kan starte dens liv som en simple
	 * samling af konstanter og senere udvikle sig til en 
	 * fuldt udrustet abstraktion.
	 * 
	 * kig på kode eksempel 3 for et bud på en 
	 * rig-samling af enums.
	 * 
	 * Det er relativt let at skrive en enum type som Planet.
	 * for at associere data med en enum konstant, så deklare instans felterne, skriv en constructor
	 * der tager dataen og sætter den ind i felterne.
	 * 
	 * Enums er pr. natur immutable, så alle felter skal være final,
	 * de kan godt være public, men det er bedre at lave dem private og give public accessors
	 * (og det giver mening nu hvorfor getters og setters er sådan et hit, fordi hvis man har direkte adgang
	 * til en variable kan man jo bare sætte den til noget nyt, men man kan ikke skrive
	 * 'getVariable() == 2' osv.
	 * 
	 * i kode eksempel 4 viser vi hvordan vi kan bruge vores Planet enum
	 * 
	 * Ligesom alle andre klasser, så hvis man ikke har en rigtig god grund til at lave en metode public, så lav den private eller
	 * package-private(default).
	 * 
	 * et Enum returnere et array med alle dens 'enum typer', med den første på index[0]
	 * 
	 * Hvis et Enum er nogenlunde brugbart så burde det være toplevel i hierarkiet, f.eks bruger BigDecimal det enum som hedder RoundingMode,
	 * og hvis man har brug for disse funktionalitet ville man foreslå at genbruge dette enum, så det gør vores API mere flexible.
	 * 
	 * Kode eksempel 5, viser hvordan man kan have forskellig adfærd internt hos de forskellige enum typer, 
	 * Dette kodeeksempel kan man sætte spørgsmålstegn ved, hvor godt det går hvis man tilføjer endnu en enum type
	 * og glemmer at tilføje den til swith casen(hvor compileren ikke vil advarer en),
	 * samt at det generalt ikke er specielt pæn kode.
	 * Der er dog en bedre løsning end kode eksempel 5, nemlig det vi ser i kode eksempel 6.
	 * Hvor vi @Overrider en metode i hver af de der enum typer.
	 * I dette tilfælde, selvom vi selF gerne vil finde alle de gode ting ved det,
	 * så er det vel rimelig svært at glemme at implementere apply metoden, fordi den er declared
	 * hos alle de andre enum typer, lige ved siden af der hvor man tilføjer sin nye.
	 * Udover dette så har vi en konkret løsning på dette ved at have tilføjet en abstract metode,
	 * som SKAL @Overrides, så compileren vil bede os om det lige meget hvad.
	 * 
	 * Konstant specifikke metoder kan kombineres med konstant specifikt data,
	 * det ser man i kode eksempel 7.
	 * 
	 * koden i eksempel 8 er ubenægtely præcis, men den er farlig fra et 
	 * velligeholdelses perspektiv, og den er farlig
	 * fordi vi igen kan tilføje en enum type til klassen, uden at få en compile-time error.
	 * hvilket senere kunne være en runtime error eller i det her
	 * tilfælde måske en bestemt holiday, som går ind som en default dag.
	 * anyway - vi er ikke glade for den her kode, så vi vil prøve at 
	 * blive tvunget til at tilføje en computation hver gang i laver et nyt enum,
	 * og der undre det mig lidt at vi ikke bare har en abstract metode,
	 * men det er måske fordi vi igen så er ude i noget med et switch statement,  hvad man dog ville kunne
	 * gøre var at have 2 abstract methods, en for hver type dag, og så @Override den med en exception
	 * det var vi jo lavet noget kode i design patterns der minder om.
	 * anyway - bogen har sin egen ide, der hedder at implementere en 'strategy enum' som man
	 * giver ind til ens enum i parameteren og den står så for ens computation,
	 * har lavet kode eksemplet i kode stykke 9.
	 * Var sku et rimelig langt kode eksempel, måske er det bedre at følge det i bogen,
	 * på side 179.
	 * anyway, med et private enum der virker til at hører til en slags innerclass,
	 * og som bliver givet ind som parameter og står for ens computation, og det
	 * gør sådan at man får besked ved compile-time når man laver en fejl, det virker som
	 * et rimelig effektivt pattern- som vel kan bruges hver gang
	 * man har nogle konstanter der skal indeholde nogle forskellige computations,
	 * ellers har de jo bare alle sammen de samme konkrete metoder implementeret, 
	 * men det virker til at hver gang man har lyst til at lave en abstract metode som de 
	 * alle sammen skal overholde, fordi de ville have en forskellig implementation, så burde man implementere
	 * dette fordi ellers skulle de i gang med switch cases for at finde sin egen - så en regel må være
	 * at hver gang man for lyst til at lave en abstract metode til enums, så brug et 
	 * enum strategy pattern i stedet for.
	 * 
	 * Der bliver sluttet af med at fortælle hvad man SÅ kan bruge switch cases på enums til,
	 * nu når vi ikke kan bruge dem til individuel opførsel, og det bliver vist på side 180,
	 * det virker ikke særlig brugbart.
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
	 *(Jeg tror ikke at man skal få kode til at give mening sådan rigtigt, tror bare at man skal se de 3 linjer som adskilte
	 *måder at bruge vores information fra enums på, fordi vi bruger ikke rigtig de 2 doubles mass/earthWeight)
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
			 * samme metode kald, det burde vi da gøre i vores Oikosprojekt
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
