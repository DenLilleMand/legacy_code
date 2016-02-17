package tutorial4WritingCodeUsingTheBeanFactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class DrawingApp {
	
	public static void main(String[] args) 
	{
		/**Noget jeg fandt i min Spring ting- import org.springframework.util.Assert;
		 * giver os muligheden for at skrive Assert.notNull(Object) - virker nice. */
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
		Shape shape = (Shape) factory.getBean("triangle");
		shape.draw();
	}

}
