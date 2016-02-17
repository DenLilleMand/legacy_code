package nyGennemgangFraChristian;
/**
 * Eksempel på TestDrivenDevelopment.
 * @author DenLilleMand
 *
 */
public class Car 
{
	private double height;
	private double length;
	
	public Car()
	{
		
	}
	
	public double getHeight() 
	{
		return height;
	}
	
	
	public void setHeight(double height) 
	{
		if(height < 0.5) {throw new IllegalArgumentException();}
		this.height = height;
	}
	
	public double getLength() 
	{
		return length;
	}
	
	public void setLength(double length) 
	{
		if(length < 2) {throw new IllegalArgumentException();}
		this.length = length;
	}
	
	
	
	
}
