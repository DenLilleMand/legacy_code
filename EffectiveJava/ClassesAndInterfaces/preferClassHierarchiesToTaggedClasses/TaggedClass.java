package preferClassHierarchiesToTaggedClasses;
/**
 * dette er tydeligvis en Tagged Class
 * og dårlig pga. mange ting, som man kan læse om i vores noter +
 * side 123.
 * @author DenLilleMand
 *
 */
public class TaggedClass {
	enum Shape{RECTANGLE,CIRCLE}
	
	//Tag field - the shape of this figuire
	final Shape shape;
	
	//these fields are used only if shape is RECTANGLE
	double length;
	double width;
	
	//this field is used only if shape is CIRCLE
	double radius;
	
	//Constructor for circle
	TaggedClass(double radius)
	{
		shape = Shape.CIRCLE;
		this.radius = radius;
	}
	
	//constructor for RECTANGLE
	TaggedClass(double length, double width)
	{
		shape = Shape.RECTANGLE;
		this.length = length;
		this.width = width;
	}
	
	double area()
	{
		switch(shape)
		{
		case RECTANGLE:
			return length * width;
		case CIRCLE: 
			return Math.PI * (radius * radius);
		default:
			throw new AssertionError();
		}
	}
}
