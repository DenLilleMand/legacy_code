package christiansGennemGangAdapterPattern.unittests;

import static org.junit.Assert.*;

import org.junit.Test;

import christiansGennemGangAdapterPattern.Computer;
import christiansGennemGangAdapterPattern.Disk;
import christiansGennemGangAdapterPattern.Monitor;

public class ComputerTest {

	@Test
	public void test() {
		Computer computer = new Computer();
		computer = new Disk(computer);
		computer = new Monitor(computer);  //i princippet er vores computer der kommer ind som parameter
										   //her en Disk, så inde i monitor. så man skal se det
										   //som noget der bare hele tiden bliver appended.
		
		//act
		String result = computer.description();
		System.out.println(result);
		
		assertEquals("Description fails","You bought a computer and a disk and a monitor", result );
	}

}
