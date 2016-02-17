package commandPatternMedArrays;

import garageImplementation.GarageDoor;

public class GarageDoorUpCommand implements Command{
	GarageDoor garageDoor;
	
	public GarageDoorUpCommand(GarageDoor garageDoor)
	{
		this.garageDoor = garageDoor;
	}
	
	@Override
	public void undo() 
	{
		garageDoor.down();
	}

	@Override
	public void execute() 
	{
		garageDoor.up();
		
	}

}
