package macroCommand;

import garageImplementation.GarageDoor;
import garageImplementation.GarageDoorOpenCommand;
import commandPatternMedArrays.CeilingFan;
import commandPatternMedArrays.CeilingFanOffCommand;
import commandPatternMedArrays.CeilingFanOnCommand;
import commandPatternMedArrays.Command;
import commandPatternMedArrays.GarageDoorDownCommand;
import commandPatternMedArrays.Stereo;
import commandPatternMedArrays.StereoOffCommand;
import lightImplementation.Light;
import lightImplementation.LightOffCommand;
import lightImplementation.LightOnCommand;

public class MacroCommandTest 
{
	public static void main(String [] args)
	{
		Light light = new Light("Living Room");
		GarageDoor garageDoor = new GarageDoor("Garage?");
		Stereo stereo = new Stereo("Living Room");
		CeilingFan ceilingFan = new CeilingFan("Living Room");
		
		LightOnCommand lightOn = new LightOnCommand(light);
		LightOffCommand lightOff = new LightOffCommand(light);
		
		
		StereoOnCommand stereoOn = new StereoOnCommand(stereo);
		StereoOffCommand stereoOff = new StereoOffCommand(stereo);
		
		CeilingFanOnCommand ceilingFanOn = new CeilingFanOnCommand(ceilingFan);
		CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(ceilingFan);
		
		GarageDoorOpenCommand garageDoorOpen = new GarageDoorOpenCommand(garageDoor);
		GarageDoorDownCommand garageDoorDown = new GarageDoorDownCommand(garageDoor);
		
		Command[] partyOn = {lightOn,stereoOn, ceilingFanOn,garageDoorOpen};
		Command[] partyOff = {lightOff,stereoOff,ceilingFanOff,garageDoorDown};
		
		MacroCommand macroPartyOn = new MacroCommand(partyOn);
		macroPartyOn.execute();
		MacroCommand macroPartyOff = new MacroCommand(partyOff);
		macroPartyOn.undo();
		
		/**
		 * efter den her bracket kode er macroPartyOn og macroPartyOff jo bare normale Command objekter,
		 * så det betyder at vi kan tilføje den til vores fjernbetjening over i RemoteLoader.
		 * 
		 */
	}
}
