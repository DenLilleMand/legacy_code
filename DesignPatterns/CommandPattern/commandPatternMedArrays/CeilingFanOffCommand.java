package commandPatternMedArrays;

public class CeilingFanOffCommand implements Command
{
	CeilingFan ceilingFan;
	
	public CeilingFanOffCommand(CeilingFan ceilingFan)
	{
		this.ceilingFan = ceilingFan;
	}
	
	
	@Override
	public void undo() 
	{
		ceilingFan.on();
	}

	@Override
	public void execute() 
	{
		ceilingFan.off();
	}
}
