package tutorial6UsingConstructorInjection;

import tutorial4WritingCodeUsingTheBeanFactory.Shape;
/**
 * @author DenLilleMand
 *eksempel på constructor injection.
 *
 */
public class Triangle implements Shape
{
	
	private String type;
	private int height;
	
	public int getHeight() {
		return height;
	}
	/**
	 * en masse constructors for at lege med spring.
	 * @param type
	 * @param height
	 */

	public Triangle(String type, int height)
	{
		this.type = type;
		this.height = height;
	}
	
	public Triangle(String type)
	{
		this.type = type;
	}
	
	public Triangle(int height)
	{
		this.height = height;
	}
	
	public String getType() 
	{
		return type;
	}


	public void draw()
	{
		System.out.println(getType() + " Triangle drawn");
		System.out.println(getHeight() + " Triangle height");
	}
}
