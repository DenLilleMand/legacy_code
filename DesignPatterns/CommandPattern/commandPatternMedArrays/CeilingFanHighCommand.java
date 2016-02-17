package commandPatternMedArrays;
/**
 * Det her er implementationen af at Skifte ens ceiling fan til
 * HIGH speed, inklusiv en undoButton, faktisk burde all 4 speeds
 * HIGH, MEDIUM,LOW og OFF alle sammen have en klasse, men de andre
 * ville ligne den her på en prik - så cba.
 * @author DenLilleMand
 *
 */
public class CeilingFanHighCommand implements Command{

	CeilingFan ceilingFan;
	int prevSpeed;
	public CeilingFanHighCommand(CeilingFan command)
	{
		this.ceilingFan = command;
	}
	@Override
	public void undo() {
		switch(prevSpeed)
		{
		case CeilingFan.HIGH:
			ceilingFan.high();
			break;
		case CeilingFan.MEDIUM:
			ceilingFan.medium();
			break;
		case CeilingFan.LOW:
			ceilingFan.low();
			break;
		case CeilingFan.OFF:
			ceilingFan.off();
			break;
		}
		
		
	}

	@Override
	public void execute() {
		prevSpeed = ceilingFan.getSpeed();
		ceilingFan.high();
		
	}

}
