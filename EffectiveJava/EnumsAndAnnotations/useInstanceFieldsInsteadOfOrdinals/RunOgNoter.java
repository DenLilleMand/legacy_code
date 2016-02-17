package useInstanceFieldsInsteadOfOrdinals;

public class RunOgNoter 
{
	/**
	 * Use instance fields instead of ordinals
	 * 
	 * tl;dr;
	 * 
	 * 
	 * -------------
	 * Noter:
	 * ordinal() som vi kan se i kode eksempel 1, er åbenbart en metode
	 * alle enums har, som returnere deres associerede int værdi, dette har alle enums.
	 * Men dette eksempel er et velligeholdelses mareridt, fordi hvis 
	 * der bliver reordered(ikke helt sikker, på hvad
	 * de mener med reordered endnu, det er tydeligvis ikke ved compiletime, som vi kan se i klassen
	 * Run der er i den her pakke, den returnere det rigtige tal hver gang) enumsne så går vores numberOfMusicians() metoden
	 *  i eksempel 1, 
	 * Okay okay, så pointen med dette kode eksempel i 1eren er at alle disse enums faktisk har deres associcerede int pga.
	 * de faktisk decideret hører til denne int, f.eks er der kun 1 musiker i en SOLO, 2 i en DUET osv,
	 * det havde jeg ikke lige set - så bogens pointe er at hvis man vil lave det sådan her,
	 * så skal man jo tydeligvis fylde en masse dummy ting ind, hvis der bare ikke er nogen ting som hører
	 * til 6, og man kan heller ikke tilføje 2 ting til den samme int værdi, hvilket man også kunne
	 * forestille sig kunne forekomme.
	 * Så det bogen er kommet hjem til er at man aldrig skal få fat i en int værdi
	 * associeret med en enum med ordinal(), vi skal i stedet sætte den værdi oppe i et felt,
	 * hvilket giver os kode eksempel 2.
	 * 
	 * Enum specificationen siger bla. om ordinal() metoden at den er lavet til
	 * general purpose programming som f.eks bliver brugt i EnumSet og EnumMap,
	 * så hvis man ikke er i gang med at lave en Collection eller lign. så skal man undgå
	 * denne metode.
	 * 
	 * 
	 * @param args
	 */
	public static void main(String [] args)
	{
		/**
		 * Kode eksempel 1:
		 */
		//Abuse of ordinal to derive an associated value - DON't DO THIS!
		public enum Ensemble
		{
			SOLO, DUET, TRIO, QUARTET, QUINTET, SEXTET, SEPTET , OCTET , NONET , DECTET;
			public int numberOfMusicians() {return ordinal() +1;}
		}
		
		/**
		 * Kode eksempel 2:
		 */
		
		public enum Ensemble
		{
			SOLO(1), DUET(2), TRIO(3), QUARTET(4), QUINTET(5), SEXTET(6), SEPTET(7) , OCTET(8) , NONET(9) , DECTET(10),
			TRIPLE_QUARTET(12);
			
			private final int numberOfMusicians;
			Ensemble(int size) {this.size = numberOfMusicians;}
			public int numberOfMusicians() {return numberOfMusicians;}
		}
	}
}
