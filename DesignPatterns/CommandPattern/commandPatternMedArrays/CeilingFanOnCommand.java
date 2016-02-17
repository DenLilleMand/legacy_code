package commandPatternMedArrays;

public class CeilingFanOnCommand implements Command
{
	CeilingFan ceilingFan;
	
	public CeilingFanOnCommand(CeilingFan ceilingFan)
	{
		this.ceilingFan = ceilingFan;
	}
	
	
	@Override
	public void undo() 
	{
		ceilingFan.off();
	}

	@Override
	public void execute() 
	{
		ceilingFan.on();
	}

}
