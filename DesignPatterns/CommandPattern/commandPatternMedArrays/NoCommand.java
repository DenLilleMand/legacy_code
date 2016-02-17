package commandPatternMedArrays;

public class NoCommand implements Command {

	@Override
	public void undo() {
		System.out.println("UNdoing that we clicked a thing that did nothing..."
				+ " ...wait what!");

	}

	@Override
	public void execute() {
		System.out.println("Executing a NoCommand slot intentionally, no object to be found here.");

	}

}
