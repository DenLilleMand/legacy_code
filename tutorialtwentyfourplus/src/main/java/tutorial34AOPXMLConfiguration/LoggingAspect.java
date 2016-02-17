package tutorial34AOPXMLConfiguration;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect 
{
	//@annotation(tutorial26WritingOurFirstAspectPart1.Loggable
	@Around("allGetters()") 
	public Object myAroundAdviceForLoggableAnnotation(ProceedingJoinPoint proceedingJoinPoint)
	{
		Object returnValue = null;
		try 
		{
			System.out.println("WOAHWOAH");
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
}
