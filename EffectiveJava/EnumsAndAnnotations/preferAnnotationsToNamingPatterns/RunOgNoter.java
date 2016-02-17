package preferAnnotationsToNamingPatterns;

public class RunOgNoter 
{
	/**
	 * Prefer annotations to naming patterns
	 * 
	 * 
	 * tl;dr;
	 * 
	 * 
	 * 
	 * 
	 * -----------------------
	 * Noter:
	 * Naming patterns er noget som f.eks JUnit(måske stadig?)
	 * bruger til at vide hvilke metoder der skal testes,
	 * og dette kan skabe flere problemer så som at man kalder 
	 * en metode for testBlabla bare fordi det er det den hedder,
	 * og så bliver den testet når den ikke skulle, måske prøver
	 * man at kalde en klasse for  testBlabla og håber på at den
	 * kører alle metoderne - det program der skal bruge det, brokker
	 * sig ikke, men de bliver ikke testet - og så nok umiddelbart
	 * mest væsentlige - hvis man staver test forkert så bliver
	 * den aldrig testet og det giver en falsk form for sikkerhed.
	 * 
	 * med annotations kan vi lade være med at ændre på navnene på 
	 * metoder men i stedet bare tagge ligesom med warnings, de
	 * metoder som skal undersøges, og hvis man sætter et tag et 
	 * forkert sted så får vi en compile besked.
	 * 
	 * i kode eksempel 1 viser vi bare en helt standard
	 * marker annotation, og i kode eksempel 2 
	 * viser vi et program der har fået disse marker annotations implementeret.
	 * Så man må gå udfra at sådan noget som JUnit og sikkert også andre programmer til at
	 * teste forskellige ting i software, kan bruge de her annotations til at vide hvilken
	 * metode de skal teste- det er vel meget nice :).
	 * Har lavet en klasse som hedder RunTests som viser et lidt test eksempel
	 * som tydeligvis gør brug af annotations med linjen  if(m.isAnnotationPresent(Test.class))
	 * hvorefter den invoker en metode.
	 * 
	 * de bedste runner tools tager et fuldt kvalificeret klasse navn
	 * på kommando linjen og kører alle de Test annoterede metoder reflectivt
	 * ved at kalde Method.invoke  
	 * 
	 * De metoder som bliver testet korrekt hvor de går galt, 
	 * smider en InvocationTargetException og hvis de
	 * smider en anden exception end den, så må annotationen være
	 * sat forkert eller lign. mere om dette på side 194.
	 * anyway, i kode eksempel 3, vil vi så se hvordan man kan gå videre med de metoder
	 * der smider den exception som vi gerne vil have at de smider.
	 * Kan se dette i den modified version af vores RunTest klasse, hvordan den smider en specifik
	 * exception, og så kører vi videre og undersøger den.
	 * 
	 * Der kommer efter dette nogle eksempler
	 *	med arrays og what not der også skal testes ved hjælp af disse
	 *annotations, men jeg tror virkelig det først er noget der giver mening efter man har skrevet sin første 
	 *JUnit test. 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		/**
		 * Kode eksempel 1:
		 */
		//Marker annotation type declaration
		import java.lang.annotation.*;

		/**
		 * Indicates that the annotated method is a test method.
		 * Use only on parameterless static methods.
		 */
		@Retention(RetentionPolicy.RUNTIME)
		@Target(ElementType.METHOD)
		public @interface Test
		{
			
		}
		
		/**
		 * Kode eksempel 2:
		 */
		//Program containing marker annotations
		public class Sample
		{
			@Test public static void m1() {} //Test should pass
			public static void m2() {}
			@Test public static void m3() { throw new RuntimeException("BOOM");} //Test should fail
			
			public static void m4() {}
			@Test public void m5() {} //INVALID USE: nonstatic method
			public static void m6(){}
			@Test public static void m7() {  //test should fail
				throw new RuntimeException("Crash");
			}
			public static void m8() {}
			
		}
		
		/**
		 * Kode eksempel 3:
		 */
		//Annotation type with a parameter
		import java.lang.annotation.*;
		/**
		 *  Indicates that the annotated method is a test method that
		 *  must throw the designated exception to succeed.
		 */
		@Retention(RetentionPolicy.RUNTIME)
		@Target(ElementType.METHOD)
		public @interface ExceptionTest
		{
			Class<? extends Exception> value();
		}
		
		/**
		 * Kode eksempel 4:
		 * (som vi kan se her giver vi jo nærmest vores exception 
		 * en parameter ind, det er i samarbejde med kode eksempel 3 at dette er muligt,
		 * læs mere om dette på side 194-195).
		 */
		//Program containing annotations with a parameter
		public class Sample2
		{
			@ExceptionTest(ArithmeticException.class)
			public static void m1() 
			{//Test should pass
				int i = 0;
				i = i / i;
			}
			
			@ExceptionTest(ArithmeticException.class)
			public static void m2()
			{//Should fail(wrong exception)
				int[] a = new int [0];
				int i = a[1];
			}
			
			@ExceptionTest(ArithmeticException.class)
			public static void m3() {} // Should fail (no exception)
		}
		
	}

}
