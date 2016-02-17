package macroCommand;

import commandPatternMedArrays.Command;

public class HottubOnCommand implements Command
{
	Hottub tub;
	
	public HottubOnCommand(Hottub hottub)
	{
		this.tub = hottub;
	}
	
	@Override
	public void undo() 
	{
		
	}

	@Override
	public void execute() 
	{
		
	}
}
