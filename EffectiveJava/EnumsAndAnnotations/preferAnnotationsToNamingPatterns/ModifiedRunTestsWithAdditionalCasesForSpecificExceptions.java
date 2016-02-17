package preferAnnotationsToNamingPatterns;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ModifiedRunTestsWithAdditionalCasesForSpecificExceptions 
{

	public static void main(String[] args) 
	{
		int tests = 0;
		int passed = 0;
		
		Class testClass = Class.forName(args[0]);
		for(Method m : testClass.getDeclaredMethods())
		{
			if(m.isAnnotationPresent(Test.class))
			{
				tests++;
				try
				{
					m.invoke(null);
					passed++;
				}catch(InvocationTargetException wrappedExc)
				{
					Throwable exc = wrappedExc.getCause();
					Class<? extends Exception> excType = m.getAnnotation(ExceptionTest.class).value();
					if(excType.isInstance(exc))
					{
						passed++;
					}
					else
					{
						System.out.printf("Test %s failed: expected %s, got %s%n",
								m,excType.getName(), exc);
					}
				}
				catch(Exception exc)
				{
					System.out.println("INVALID @Test: " + m);
				}
			
			}
		}
		System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);
	}

}
