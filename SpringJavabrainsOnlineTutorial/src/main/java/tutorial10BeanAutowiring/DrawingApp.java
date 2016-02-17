package tutorial10BeanAutowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import tutorial4WritingCodeUsingTheBeanFactory.Shape;

public class DrawingApp 
{
	public static void main(String[] args)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("spring10.xml");
		Shape shape = (Shape) context.getBean("triangle");
		shape.draw();
	}	
}
