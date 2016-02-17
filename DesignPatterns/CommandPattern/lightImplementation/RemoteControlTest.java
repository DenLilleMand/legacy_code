package lightImplementation;

/**
 * skal over i den klasse der hedder RemoteLoader for at se et fungerende
 * eksempel.
 * @author DenLilleMand
 *
 */

public class RemoteControlTest 
{
	public static void main(String[] args) 
	{
		SimpleRemoteControl remote = new SimpleRemoteControl();
		Light light = new Light();
		
		LightOnCommand lightOn = new LightOnCommand(light);
		
		remote.setCommand(lightOn);
		remote.buttonWasPressed();
	}
}
