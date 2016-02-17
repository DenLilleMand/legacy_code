package state;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SingletonTest 
{
	public static final String fileName = "test.ser";
	FileOutputStream fileOut = null;
	ObjectOutputStream objectOut = null;
	FileInputStream fileIn = null;
	ObjectInputStream objectIn = null;
	
	@After
	public void tearDownFileConnections() throws Exception
	{
		fileOut.close();
		objectOut.close();
		fileIn.close();
		objectIn.close();
	}
	
	@Before
	public void setupTest() throws Exception
	{
		fileOut = new FileOutputStream(fileName,false);
		objectOut = new ObjectOutputStream(fileOut);
		fileIn = new FileInputStream(fileName);
		objectIn = new ObjectInputStream(fileIn);
	}
	
	
	
	@Test
	public void StandardSingleton_AgainstSerialization_Failure() throws Exception
	{
		//Arrange
		State state = State.getInstance();

		//act
		objectOut.writeObject(state);
		State newState = (State) objectIn.readObject();
		
		//assert
		assertNotEquals(state,newState);
	}
	
	@Test
	public void enumSingleton_AgainstSerialization_success() throws Exception
	{
				//Arrange
				EnumState enumState = EnumState.getInstance();
				
				//act
				objectOut.writeObject(enumState);
				EnumState newState = (EnumState) objectIn.readObject();
				
				//assert
				assertEquals(enumState,newState);
	}

}
