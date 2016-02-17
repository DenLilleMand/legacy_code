package commandPatternMedArrays;

public class StereoOffCommand implements Command
{
	Stereo stereo;
	public StereoOffCommand(Stereo stereo) 
	{
		this.stereo = stereo;
	}
	
	@Override
	public void undo() 
	{
		stereo.on();
		
	}
	@Override
	public void execute() 
	{
		stereo.off();
		
	}

}
