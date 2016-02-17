package commandPatternMedArrays;

public class RemoteControl 
{
	Command[] onCommands;
	Command[] offCommands;
	Command undoCommand; //i den her variable gemmer vi den sidste command udført sådan
						 //at vi kan undo
	/**
	 * Vi fylder den op med noget som hedder et null Object, det er noget man tilføjer hvis man
	 * ikke har lyst til at håndtere null værdier i ens applikation.  man kan se at vi tilføjer objekterne
	 * til alle slots, og når vi så kører programmet overskriver vi bare de slots vi har brug for.
	 * Men vi har faktisk også et null-Check nu -- så det er lidt overkill . Faktisk er der mange
	 * null-object implementationer i forskellige design patterns vi kommer til at lærer om senere.
	 * Og nogen vil endda henvise til det som et design pattern i sig selv.
	 * 
	 * Definition af denne klasses funktionalitet:
	 * "The RemoteControl manages a set of command
	 * Objects, one per button. When a button is pressed, the
	 * corresponding ButtonWasPushed() method is called, which invokes the 
	 * execute() method on the command. That is the full extent of the remote's knowledge
	 * of the classes it's invoking as the Command object decouples the remote from the classes
	 * doing the actual home-automation work."
	 */
	public RemoteControl()
	{
		onCommands = new Command[7];
		offCommands = new Command[7];

		Command noCommand = new NoCommand();
		for(int i = 0; i < 7; i++)
		{
			onCommands[i] = noCommand;
			offCommands[i] = noCommand;
		}
		undoCommand = noCommand;
	}
	
	public void setCommand(int slot, Command onCommand, Command offCommand)
	{
		onCommands[slot] = onCommand;
		offCommands[slot] = offCommand;
	}
	
	public void undoButtonWasPushed()
	{
		System.out.println("undoButtonWasPushed");
		undoCommand.undo();
	}

	/**
	 * har ikke brug for de 2 næste if(!= null) checks pga. vores
	 * Null-Object design pattern(Hvis det kan kaldes et pattern, check
	 * lige op på det).
	 * @param slot
	 */
	public void onButtonWasPushed(int slot)
	{
	//	if(onCommands[slot] != null)
	//	{
			onCommands[slot].execute();			
	//	}
		undoCommand = onCommands[slot];
	}
	
	public void offButtonWasPushed(int slot)
	{
//		if(onCommands[slot] != null)
//		{
			offCommands[slot].execute();			
	//	}
		undoCommand = offCommands[slot];
		
	}
	
	public String toString()
	{
		StringBuffer stringBuff = new StringBuffer();
		stringBuff.append("\n----- Remote Control ----\n");
		for(int i = 0; i < onCommands.length; i++)
		{
			stringBuff.append("[slot "+ i + "] " + onCommands[i].getClass().getName()
				+ "    " + offCommands[i].getClass().getName() + "\n");
		}
		return stringBuff.toString();
	}
}