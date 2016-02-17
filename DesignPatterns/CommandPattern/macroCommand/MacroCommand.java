package macroCommand;

import commandPatternMedArrays.Command;

public class MacroCommand implements Command
{
	Command[] commands;
	public MacroCommand(Command[] commands)
	{
		this.commands = commands;
	}

	/**
	 * hvis vi f.eks ville kunne trykke på vores undo() knap flere gange, så er det også meget simpelt,
	 * så ville man bare have en arraylist med commandObjekter man kunne trykke undo() på istedet for. 
	 */
	@Override
	public void undo() 
	{
		for(int i = 0; i < commands.length; i++)
		{
			commands[i].undo();
		}
	}

	@Override
	public void execute() 
	{
		for(int i = 0; i < commands.length; i++)
		{
			commands[i].execute();
		}
	}

}
