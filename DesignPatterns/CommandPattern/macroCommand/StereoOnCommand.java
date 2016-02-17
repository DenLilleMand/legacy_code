package macroCommand;

import commandPatternMedArrays.Command;
import commandPatternMedArrays.Stereo;

public class StereoOnCommand implements Command
{
	Stereo stereo;
	
	public StereoOnCommand(Stereo stereo)
	{
		this.stereo = stereo;
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
