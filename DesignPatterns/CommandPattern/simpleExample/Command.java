package simpleExample;
/**
 * Command declares an interface for all commands.
 * As you allready know, a command is invoked through
 * it's execute() method, which asks a receiver to perform
 * an action. You'll also notice this interface has an undo()
 * method, which we'll cover a bit later in the chapter'
 * @author DenLilleMand
 *
 */
public interface Command 
{
	public void undo();
	public void execute();
}
