package tutorial5ApplicationContextAndPropertyInitialization;

import tutorial4WritingCodeUsingTheBeanFactory.Shape;
/**
 * vi implementere Shape interface fra vores anden pakke der bruger
 * præcis det samme interface, lad os håbe at interfaced ikke ændre sig :D
 * @author DenLilleMand
 *
 *
 */
public class Triangle implements Shape
{
	
	private String type;
	
	public String getType() 
	{
		return type;
	}

	public void setType(String type) 
	{
		this.type = type;
	}

	public void draw()
	{
		System.out.println(getType() + " Triangle drawn");
	}
}
