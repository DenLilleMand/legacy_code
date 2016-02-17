package tutorial34AOPXMLConfiguration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import tutorial26WritingOurFirstAspectPart1.ShapeService;

public class AppMain 
{
	public static void main(String[] args) 
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("springTutorial34Plus.xml");
		/** Jeg ved sku ikke helt, faktisk burde vi ikke skulle caste objektet når vi har angivet klassen
		 * som parameter nr 2, men det virker ^^*/
		ShapeService shapeService = (ShapeService) ctx.getBean("shapeService",ShapeService.class);
		System.out.println("Name:" + shapeService.getCircle().getName());
		shapeService.getCircle().setName("herpderp");
	}

}
