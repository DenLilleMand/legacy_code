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
	 * ordinal() som vi kan se i kode eksempel 1, er �benbart en metode
	 * alle enums har, som returnere deres associerede int v�rdi, dette har alle enums.
	 * Men dette eksempel er et velligeholdelses mareridt, fordi hvis 
	 * der bliver reordered(ikke helt sikker, p� hvad
	 * de mener med reordered endnu, det er tydeligvis ikke ved compiletime, som vi kan se i klassen
	 * Run der er i den her pakke, den returnere det rigtige tal hver gang) enumsne s� g�r vores numberOfMusicians() metoden
	 *  i eksempel 1, 
	 * Okay okay, s� pointen med dette kode eksempel i 1eren er at alle disse enums faktisk har deres associcerede int pga.
	 * de faktisk decideret h�rer til denne int, f.eks er der kun 1 musiker i en SOLO, 2 i en DUET osv,
	 * det havde jeg ikke lige set - s� bogens pointe er at hvis man vil lave det s�dan her,
	 * s� skal man jo tydeligvis fylde en masse dummy ting ind, hvis der bare ikke er nogen ting som h�rer
	 * til 6, og man kan heller ikke tilf�je 2 ting til den samme int v�rdi, hvilket man ogs� kunne
	 * forestille sig kunne forekomme.
	 * S� det bogen er kommet hjem til er at man aldrig skal f� fat i en int v�rdi
	 * associeret med en enum med ordinal(), vi skal i stedet s�tte den v�rdi oppe i et felt,
	 * hvilket giver os kode eksempel 2.
	 * 
	 * Enum specificationen siger bla. om ordinal() metoden at den er lavet til
	 * general purpose programming som f.eks bliver brugt i EnumSet og EnumMap,
	 * s� hvis man ikke er i gang med at lave en Collection eller lign. s� skal man undg�
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
