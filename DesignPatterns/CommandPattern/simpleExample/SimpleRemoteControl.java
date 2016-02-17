package simpleExample;
/**
 * Det her simple eksempel p� et Command Pattern
 * har ikke den her med i klassediagrammet p� side 211,
 * men bliver hovedsageligt brugt til at pr�ve at hj�lpe lightImplementation &
 * garageImplementation pakkerne som pr�ver at lave et
 * command pattern som jeg ikke helt synes fungere ordentligt eller forst�r.
 * @author DenLilleMand
 *
 */
public class SimpleRemoteControl 
{
	Command slot;
	
	public SimpleRemoteControl()
	{
		
	}
	
	public void setCommand(Command command)
	{
		slot = command;
	}
	
	public void buttonWasPressed()
	{
		slot.execute();
	}
}
