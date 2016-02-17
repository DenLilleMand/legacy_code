package minimizeMutability;

import java.math.BigInteger;
/**
 * tldr; resist the urge to write a set method
 * for every get method. Classes should be immutable
 * unless there's a very good reason to make them
 * mutable. Immutable classes provide many advantages, and their
 * only disadvantage is the potential for performance
 * problems under certain circumstances.
 * You should always make small value objects, such as
 * PhoneNumber  and Complex immutable.
 * there are several classes in the java Platform libraries, such as
 * java.util.Date and java.awt.Point that should have been Immutable,
 * but aren't. You should seriously consider making larger value objects,
 *  such as String and BigInteger immutable as well. You should provide
 *  a public mutable companion class for your immutable class only once you've
 *  confirmed that it's necessary to achive satisfactory performance.
 *  
 *  bogen indrømmer dog at det ikke er praktisk for nogle klasser at være helt immutable,
 *  men så handler det om at lave dem så lidt mutable som muligt.
 *  
 *  side 102(nederst) - 103 har mere.
 * @author DenLilleMand
 *
 */
public class RunOgNoter 
	public static void main(String[] args) 
	{
		/**
		 * hvordan man laver en immutable
		 * klasse, man kan følge de råd der er på side 
		 * 96.
		 * kode stykke 1 er en immutable klasse 
		 */
		
	}
	

	
	/**
	 * //code 1(følgende klasse er et eksempel på hvordan en immutable
	//klasse ser ud.)på side 98 er der faktisk en meget
	 * interessersant forklaring på denne kode, man kan jo se at hver kan man
	 * multiplyer/dividere osv. så returnere den et nyt objekt
	 * istedet for at ændre den interne information. Og det er et
	 * pattern der bliver brugt på de mest trivielle functionelle
	 * klasser.
	 * på side 99 foreslår den også 
	 * at man kunne tilføje disse 3 + flere
	 * felter til den uden problemer:
	 * 
	 * public static final Complex ZERO = new Complex(0,0);
	 * public static final Complex ONE = new Complex(1,0);
	 * public static final Complex I = new Complex(0,1);
	 * 
	 * man må lige kigge på koden for at det giver mening .
	 * men det leder os hvertfald hen på at man kan give sådan en her klasse
	 * nogle static factory metoder der returnere en bestemt slags variant af denne
	 * klasse uden nogen problemer, for selvfølgelig at undgå flere objekter end der er brug
	 * for.
	 * @author DenLilleMand
	 *
	 */
	/**
	 * vi har tilføjet en static factory method,
	 * valueOf() og lavet constructoren private
	 * for at undgå folk subclasser vores immutable klasse.
	 * fulgte guidelines på side 101.
	 * @author DenLilleMand
	 *
	 */
	public class Complex
	{
		private final double re;
		private final double im;
		
		private Complex(double re, double im)
		{
			this.re = re;
			this.im = im;
		}
		
		//Accessors with no corresponding mutators
		public double realPart() {return re;}
		public double imaginaryPart() {return im;}
		
		//static factory method i kombination med
		//med private constructor for at undgå subclassing.
		//den brokker sig fordi det her er en inner-class vi skriver noter i :)
		//static skal åbenbart være top-hierarchi ...
		public static Complex valueOf(double re, double im)
		{
			return new Complex(re,im);
		}
		
		public Complex add(Complex c)
		{
			return new Complex(re + c.re, im + c.im);
		}
		
		public Complex subtract(Complex c)
		{
			return new Complex(re - c.re, im - c.im);
		}
		
		public Complex multiply(Complex c)
		{
			return new Complex(re * c.re - im * c.im, re * c.im + im * c.re);
		}
		
		public Complex divide(Complex c)
		{
			double tmp = c.re * c.re + c.im * c.im;
			return new Complex((re * c.re + im *c.im) / tmp,
					(im * c.re - re * c.im) / tmp);
		}
		
		@Override public boolean equals(Object o)
		{
			if(o == this)
				return true;
			if(!(o instanceof Complex))
				return false;
			Complex c = (Complex) o;
			//see page 43 to find out why we use compare
			//instead of ==
			return Double.compare(re, c.re) == 0 &&
					Double.compare(im, c.im) == 0;
		}
		
		@Override public int hashCode()
		{
			int result = 17 + hashDouble(re);
			result = 31 * result + hashDouble(im);
			return result;
		}
		
		private int hashDouble(double val)
		{
			long longBits = Double.doubleToLongBits(re);
			return (int) (longBits ^ (longBits >>> 32));
		}
		
		@Override public String toString()
		{
			return "(" + re + " + " + im + "i)";
		}
	}
	
	/**
	 * En anden løsning som ikke er ofte brugt, men som ofte er den bedste(Dette kapitel handler
	 * jo om hvordan man minimere mutability, og det der er værd at kigge på er bla. at folk ikke kan
	 * extende den her klasse pga. dens private constructor. 
	 * Det er også muligt at optimere dens performance i senere releases
	 * (uden at break andre klasser, fordi dens indre implementation er private. Hvilket forvirre mig lidt
	 *	fordi den her klasse selF godt kan breake resten af programmet
	 *	hvis vi ændre klassens funktionalitet, men åbenbart
	 *synes dem der har skrevet bogen kun at hvis fields er public
	 *så kan ting breake til højre og venstre.. og det er måske rigtigt.) 
	 * :
	 */
	
	class Complex1
	{
		private final double re;
		private final double im;
		
		private Complex1(double re, double im)
		{
			this.re = re;
			this.im = im;
		}
		/**
		 * kan ikke declares static pga. det er en inner class, hvilket det jo ikke normalt ville være :)
		 * @return
		 */
		public static Complex valueOf()
		{
			return new Complex(re,im);
		}
		
		/**
		 * Den her factory method er lavet til at
		 * returnere en Polar Complex, hvad end det er,
		 * men pointen er at vi kan specificere hvad den her
		 * metode gør, fordi vi bruger en factory
		 * i stedet for en constructor.
		 * som ville hedde det samme.
		 * @param r
		 * @param theta
		 * @return
		 */
		public static Complex valueOfPolar(double r, double theta)
		{
			return new Complex(r*Math.cos(theta),
					r * Math.sin(theta));
		}
		
		/**
		 * en sjov lille security detalje er det her stykke kode:
		 */
		
		public static BigInteger safeInstance(BigInteger val)
		{
			if(val.getClass() != BigInteger.class)
			{
				return new BigInteger(val.toByteArray());
			}
			return val;
		}
		/**
		 * og det er et sjovt stykke kode fordi BigInteger og 
		 * BigDecimal ikke blev lavet final da de blev lavet, 
		 * og det er bla. grunden til at man ikke bare kan ændre dem til final,
		 * er jo selF fordi masser af java software afhænger af at kunne
		 * extende deres egen BigDecimal,
		 * men det er faktisk en security threat, 
		 * fordi hvis ens application modtager data
		 * fra en tilfældig client, som selv
		 * kan bestemme hvad personen vil sende,
		 * og vi modtager en af de her klasser
		 * så har client effektivt kunne @Override
		 * alle metoderne i BigDecimal til at f.eks slette
		 * ting i databasen, lave et while(true) loop der dræber vores app
		 * osv.
		 */
		
		//remainder omitted
		
		/**
		 * 
		 * i immutable classes, må man godt have et enkelt felt brugt til at cache et heavy computation
		 * resultat, præcis fordi den er immutable så computationen
		 * ville give det samme resultat hver gang.
		 * 
		 * En anden ting man skal være obs på er at 
		 * hvis ens immutable klasse implementere Serializable,
		 * og har et felt der referer til et mutable objekt,
		 * så skal man give et explicit readObject eller readResolve
		 * metode, eller bruge ObjectOutputStream.writeUnshared() og
		 * ObjectInputStream.readUnshared metoder.  ellers kunne en angriber lave
		 * en mutable instants af vores ikke-så immutable klasse. dette begreb bliver
		 * forklaret nærmere i Item 76 i bogen.
		 * 
		 * 
		 */
	}

}
