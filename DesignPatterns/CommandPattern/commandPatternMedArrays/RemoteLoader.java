package commandPatternMedArrays;

import garageImplementation.GarageDoor;
import lightImplementation.Light;
import lightImplementation.LightOffCommand;
import lightImplementation.LightOnCommand;
/**
 * The RemoteLoader creates a number of command
 * Objects that are loaded into the slots of the Remote Control. Each Command Object
 * encapsulates a request of a home automation device.
 * En lignende definition kan findes på side 219 i bogen, 
 * samt vil jeg tilføje de tilsvarende beskrivelser til resten af de involverede klasser.
 * 
 * 
 * 
 * 
 * @author DenLilleMand
 */
public class RemoteLoader {

	public static void main(String[] args) 
	{
		RemoteControl remoteControl = new RemoteControl();
		Light livingRoomLight = new Light("Living Room");
		Light kitchenLight = new Light("kitchen Light");
		CeilingFan ceilingFan = new CeilingFan("Living room");
		GarageDoor garageDoor = new GarageDoor("");
		Stereo stereo = new Stereo("Living Room");
		
		LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
		LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
		
		LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
		LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);
		
		CeilingFanOnCommand ceilingFanOn = new CeilingFanOnCommand(ceilingFan);
		CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(ceilingFan);
		
		GarageDoorUpCommand garageDoorUp = new GarageDoorUpCommand(garageDoor);
		GarageDoorDownCommand garageDoorDown = new GarageDoorDownCommand(garageDoor);
		
		StereoOnWithCDCommand stereoOnWithCD = new StereoOnWithCDCommand(stereo);
		StereoOffCommand stereoOff = new StereoOffCommand(stereo);
		
		remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
		remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff);
		remoteControl.setCommand(3, ceilingFanOn, ceilingFanOff);
		remoteControl.setCommand(3, stereoOnWithCD, stereoOff);
		
		System.out.println("Printing remoteControl: " +remoteControl);
		
		remoteControl.onButtonWasPushed(0);
		remoteControl.undoButtonWasPushed();
		remoteControl.onButtonWasPushed(0);
		System.out.println("Printing remoteControl: " + remoteControl);
		remoteControl.onButtonWasPushed(0);
		remoteControl.onButtonWasPushed(1);
		remoteControl.onButtonWasPushed(1);
		remoteControl.onButtonWasPushed(2);
		remoteControl.onButtonWasPushed(2);
		remoteControl.onButtonWasPushed(3);
		remoteControl.onButtonWasPushed(3);
		
		
	
	
	
	}
}