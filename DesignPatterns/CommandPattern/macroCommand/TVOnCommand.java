package macroCommand;

import commandPatternMedArrays.Command;

public class TVOnCommand implements Command
{
	TV tv;
	public TVOnCommand(TV tv)
	{
		this.tv = tv;
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
