package tutorial12UsingApplicationContextAware;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import tutorial4WritingCodeUsingTheBeanFactory.Shape;
import tutorial7InjectingObjects.Point;
/**
 * @author DenLilleMand
 *eksempel på constructor injection.
 *
 */
public class Triangle implements Shape, ApplicationContextAware, BeanNameAware
{
	private List<Point> pointList;
	private ApplicationContext context = null;
	
	public void draw()
	{
		for(Point p: pointList)
		{
			System.out.println(p);
		}
	}

	public List<Point> getPointList() 
	{
		return pointList;
	}

	public void setPointList(List<Point> pointList) 
	{
		this.pointList = pointList;
	}

	public void setApplicationContext(ApplicationContext context) throws BeansException 
	{
		this.context = context;
	}

	public void setBeanName(String name) 
	{
		System.out.println("Bean name: " + name);
	}


}
