package tutorial7InjectingObjects;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import tutorial4WritingCodeUsingTheBeanFactory.Shape;

public class DrawingApp 
{
	/**
	 * 
	 */
	public static void main(String[] args)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Shape shape = (Shape) context.getBean("triangle");
		shape.draw();
	}
	
	
}
