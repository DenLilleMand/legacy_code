package lightImplementation;

public class Light {
	String location;
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Light(String location)
	{
		this.location = location;
	}
	
	public void on()
	{
		System.out.println("Light has been turned on");
	}
	
	public void off()
	{
		System.out.println("Light has been turned off");
	}
}
