package commandPatternMedArrays;

public class Stereo 
{
	String location;
	public Stereo(String location) 
	{
		this.location = location;
	}

	public void on() {
		System.out.println("Turning Stereo ON");
		
	}
	
	public void off()
	{
		System.out.println("Turning stereo off");
	}

	public void setCD() {
		System.out.println("setting CD");
		
	}

	public void setVolume(int i) 
	{
		System.out.println("Setting volume to: " + i);
		
	}

}
