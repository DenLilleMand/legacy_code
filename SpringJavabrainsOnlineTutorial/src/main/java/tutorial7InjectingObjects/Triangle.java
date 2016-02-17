package tutorial7InjectingObjects;

import tutorial4WritingCodeUsingTheBeanFactory.Shape;
/**
 * @author DenLilleMand
 *eksempel på constructor injection.
 *
 */
public class Triangle implements Shape
{
	private Point pointA;
	private Point pointB;
	private Point pointC;
	
	
	public void draw()
	{
		System.out.println(""+pointA +""+ pointB + pointC);
	}
	
	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

}
