package garageImplementation;

public class GarageDoor 
{
	String location;
	public GarageDoor(String location)
	{
		this.location = location;
	}
	public void up()
	{
		System.out.println("Garage door up");
	}
	
	public void down()
	{
		System.out.println("Garage door down");
	}
	
	public void stop()
	{
		System.out.println("stop");
	}
	
	public void lightOn()
	{
		System.out.println("Garage light on");
	}
	
	
	public void lightOff()
	{
		System.out.println("Garage light off");
	}
	
}
