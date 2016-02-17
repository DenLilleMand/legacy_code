package simpleExample;
/**
 * Det her simple eksempel på et Command Pattern
 * har ikke den her med i klassediagrammet på side 211,
 * men bliver hovedsageligt brugt til at prøve at hjælpe lightImplementation &
 * garageImplementation pakkerne som prøver at lave et
 * command pattern som jeg ikke helt synes fungere ordentligt eller forstår.
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
