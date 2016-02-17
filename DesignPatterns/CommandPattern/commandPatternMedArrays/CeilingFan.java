package commandPatternMedArrays;

public class CeilingFan
{
	public static final int HIGH = 3;
	public static final int MEDIUM = 2;
	public static final int LOW = 1;
	public static final int OFF = 0;
	
	String location;
	int speed;
	
	public CeilingFan(String location)
	{
		this.location = location;
		speed = OFF;
		System.out.println("Constructor was ran, and we start off with 'OFF' speed");
	}
	
	public void high()
	{
		speed = HIGH;
		System.out.println("Speed set to HIGH");
	}
	
	public void medium()
	{
		speed = MEDIUM;
		System.out.println("Speed set to MEDIUM");
	}
	
	public void low()
	{
		System.out.println("Speed set to LOW");
		speed = LOW;
	}
	
	public int getSpeed()
	{
		return speed;
	}
	


	
	public void on()
	{
		System.out.println("Ceilingfan has been turned on");
	}
	
	public void off()
	{
		System.out.println("Ceilingfan has been turned off and speed = OFF");
		speed = OFF;
	}
	
}
