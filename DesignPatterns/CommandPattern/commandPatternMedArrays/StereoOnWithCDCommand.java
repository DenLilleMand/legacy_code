package commandPatternMedArrays;

public class StereoOnWithCDCommand implements Command {

	Stereo stereo;
	public StereoOnWithCDCommand(Stereo stereo)
	{
		this.stereo = stereo;
	}
	@Override
	public void undo() {
		stereo.off();
		//mb undo sound level aswell herpderp
		//mb push out cd
		
	}

	@Override
	public void execute() {
		stereo.on();
		stereo.setCD();
		stereo.setVolume(11);
		
	}

}
