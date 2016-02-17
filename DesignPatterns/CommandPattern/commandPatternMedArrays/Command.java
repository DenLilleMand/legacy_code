package commandPatternMedArrays;

/**
 * Definitionen fra side 219:"
 * All RemoteControl commands implement the Command
 * interface, which consists of one method:execute() Commands encapsulate a set of actions on a specific vendor class.
 * The remote invokes these actions by calling the execute() method."
 * Kan s� tilf�je at vi ogs� har undo() fordi de sagde i starten at vi havde 
 * t�nkt os at implementere en undo() funktionalitet.
 * @author DenLilleMand
 *
 */
public interface Command 
{

		public void undo();
		public void execute();

}
