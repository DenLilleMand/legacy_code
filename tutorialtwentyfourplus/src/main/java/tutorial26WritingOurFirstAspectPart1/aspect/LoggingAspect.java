package tutorial26WritingOurFirstAspectPart1.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
/** ved at give en klasse Aspect annotationen, kan vi lave
 * en klasses metoder til 'advices'. husk den linje der hedder
 * 	<aop:aspectj-autoproxy />  ovre i vores .xml fil. */







import tutorial26WritingOurFirstAspectPart1.model.Circle;


/**Wildcards er stjerne(*) annotationen.  */
@Aspect
public class LoggingAspect 
{
	/** Best practice er at kombinere PointCut's
	 * som det her(denne bliver kun kaldt hvis begge gælder, og faktisk
	 * kan vi bytte  '&&'  ud med 'and' og vice versa selvfølgelig.):
	 */
	@Before("allGetters() and allMethodsInClass()")
	public void adviceThreeBestPractice()
	{
		System.out.println("hitting that best practice up ! ");
	}
	
	
	/**Det er selvfølgelig  */
	@Before("args(name)")
	public void adviceThreeArgumentPassed(String name)
	{
		System.out.println(name);
	}
	
	/**Det er selvfølgelig bare en der bliver kaldt bagefter vores metode*/
	@After("args(name)")
	public void adviceThreeArgumentPassedAfterAnnotation(String name)
	{
		System.out.println(name);
	}
	
	/**dette er en metode der bliver kaldt efter vores metode returnerer, og vi viser også her
	 * hvordan vi tage imod den String som bliver returneret af metoden, og kan kalde ting på den her. man kan også
	 * lave typen til typen 'Object' istedet for String, og så griber den alle.  */
	@AfterReturning(pointcut="args(name)", returning="returnString")
	public void adviceThreeArgumentPassedAfterReturningAnnotation(String name, String returnString)
	{
		System.out.println("here is the returnString:" + returnString);
		System.out.println(name);
	}
	
	/**Det er selvfølgelig en metode der bliver kaldt efter en exception er blevet smidt.
	 * Vi kan også gribe exceptionen her og gøre noget ved den.  */
	@AfterThrowing(pointcut="args(name)", throwing="ex")
	public void adviceThreeArgumentPassedAfterThrowingExceptionAnnotation(String name, RuntimeException ex)
	{
		ex.printStackTrace();
		System.out.println(name);
	}
	
	/**Vores Around annotation, skal take ProceedingJoinPoint som parameter.
	 * man kan se hvordan vi kan kalde en metode hele vejen igennem. i stedet
	 * for at lave 4 seperate Advices. Dette er også ThreadSafe, det er @before i kombination
	 * med @After ikke.  Det her er nærmest en kombination af ALLE 
	 * de andre annotations, bare i en... */
	@Around("allGetters()") 
	public Object myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint)
	{
		Object returnValue = null;
		try 
		{
			System.out.println("!!!Before advice!");
			returnValue = proceedingJoinPoint.proceed();
			System.out.println("After returning");
		} catch (Throwable e) 
		{
			System.out.println("After throwing!");
			e.printStackTrace();
		}
		System.out.println("After finally");
		return returnValue;
	}
	
	@Around("@annotation(tutorial26WritingOurFirstAspectPart1.Loggable)") 
	public Object myAroundAdviceForLoggableAnnotation(ProceedingJoinPoint proceedingJoinPoint)
	{
		Object returnValue = null;
		try 
		{
			System.out.println("!!!Before advice!");
			returnValue = proceedingJoinPoint.proceed();
			System.out.println("After returning");
		} catch (Throwable e) 
		{
			System.out.println("After throwing!");
			e.printStackTrace();
		}
		System.out.println("After finally");
		return returnValue;
	}
	
	
	@Before("allMethodsInClass()")
	public void loggingAdviceJoinPoint(JoinPoint jp)
	{
		System.out.println(jp.toString());
		/**sådan her får man adgang til et objekt igennem JoinPoint. 
		 * så kan man ændre objektet. Det her er den klasse som vi 
		 * kalder metoderne på som bliver givet tilbage til os. */
		if(jp.getTarget() instanceof Circle)
		{
			Circle circle = (Circle)jp.getTarget();
			/** */
		}
	}
	
	
	
	@Before("execution(* get*())")
	public void loggingAdviceOne()
	{
		System.out.println("Running advice one");
	}
	
	@Before("allGetters()")
	public void loggingAdviceTwo()
	{
		System.out.println("Running advice two");
	}
	
	@Before ("allMethodsInClass()")
	public void herpderp()
	{
		System.out.println("all methods in class");
	}
	
	/**allGetters() og allMethodsInClass() metoden er en dummy metode,
	 * vi har faktisk kun brug for vores annotation,
	 * så vi kun skal skrive det 1 gang, lidt ligesom arv. nu kan de
	 * andre annotations henvise direkte til denne. så vi ikke har duplicate kode.*/
	@Pointcut("execution(* get*())")
	public void allGetters(){ }
	
	@Pointcut("within(tutorial26WritingOurFirstAspectPart1.model.*)")
	public void allMethodsInClass(){ }
	
	

	
	
	
//---------------------------------------------En masse eksempler: --------------------	
//	/**
//	 * Man ville faktisk bare kunne skrive : @Before("execution(public String getName())") 
//	 * hvis den skulle ramme alle metoder i hele vores projekt der har den her signatur,
//	 * men vi selvfølgelig gerne specificere en klasse som vi gør i det her eksempel.
//	 */
//	@Before("execution(public String tutorial26WritingOurFirstAspectPart1.model.Circle.getName())")
//	public void loggingAdvice()
//	{
//		System.out.println("Advice run. get method called");
//	}
//	
//	/** Wild card annotation, den fanger alle metoder der starter med 'public String get' */
//	@Before("execution(public String get*())")
//	public void loggingAdviceWithWildCard()
//	{
//		System.out.println("Advice run. wildcard annotation triggered it.");
//	}
//	/**
//	 * Denne tager imod en vilkårig mængde af argumenter fra 1 og opefter.
//	 */
//	@Before("execution(public String get*(*))")
//	public void loggingAdviceWithWildCardMethodAndWildCardArgumentsFromOneToMany()
//	{
//		System.out.println("Advice run. wildcard annotation triggered it.");
//	}
//	
//	/** Denne her tager imod en vilkårlig mængde af argumenter, også 0 */
//	@Before("execution(public String get*(..))")
//	public void loggingAdviceWithWildCardMethodAndAnyMatchOfArguments()
//	{
//		System.out.println("Advice run. wildcard annotation triggered it.");
//	}
//	
//	
//	/** her skal man ligge mærke til directory på vej imod vores klasse,
//	 * denne her godtager alle klassers getName() metode i pakken model. */
//	@Before("execution(public String tutorial26WritingOurFirstAspectPart1.model.*.getName())")
//	public void loggingAdviceWithWildCardMethodAllWithinOnePackage()
//	{
//		System.out.println("Advice run. wildcard annotation triggered it.");
//	}
//	
}
