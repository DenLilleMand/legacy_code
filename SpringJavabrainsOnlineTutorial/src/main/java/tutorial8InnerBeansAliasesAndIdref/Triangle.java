package tutorial8InnerBeansAliasesAndIdref;

import java.util.List;

import tutorial4WritingCodeUsingTheBeanFactory.Shape;
import tutorial7InjectingObjects.Point;
/**
 * @author DenLilleMand
 *eksempel på constructor injection.
 *
 */
public class Triangle implements Shape
{
	private List<Point> pointList;
	
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


}
