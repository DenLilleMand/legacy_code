package singletonPattern;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class BreakingSingleton {

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
	
	
	/**
	 * Pointen er vel også at hvis man har et Singleton objekt der implementere Serializable
	 * så skal man sørge for at objektet bliver Serialized ligesom enums dvs.
	 * at gemme navnet på klassen og intet andet.(Ved ikke helt hvordan man programmere
	 * sig til det her, men Enums har tydeligvis den funktionalitet.)
	 * @throws Exception
	 */
	@Test
	public void StandardSingleton_AgainstSerialization_Failure() throws Exception
	{
		//Arrange
		Singleton state = Singleton.getSingleton();

		//act
		objectOut.writeObject(state);
		Singleton newState = (Singleton) objectIn.readObject();
		
		//assert
		assertNotEquals(state,newState);
	}
	
	/**
	 * Hvis man undersøger dette er det fordi Enums har defensivt overridet deres
	 * read/resolve metoder(vist nok) - som gør at Serialization ikke serialisere nogle
	 * af enum objektets felter. Dvs. at når vi skal deserialize objektet er det eneste vi får
	 * op en String med Navnet  på vores enum klasse i det her tilfælde "EnumSingleton" . 
	 * Og den enum - har adgang til samme objekt som den havde med vores gamle objekt
	 *  før vi Serialized det, og derfor er de ens.
	 * Så dvs. at hvis man f.eks skal skrive en enum til med writeObject(enum)
	 * så skal man først trække alle felternes værdier ud, wrappe de værdier i et 
	 * Serializable objekt.  og så sende det af sted.
	 * @throws Exception
	 */
	@Test
	public void enumSingleton_AgainstSerialization_success() throws Exception
	{
		
				//Arrange
				EnumSingleton enumState = EnumSingleton.getInstance();
				
				//act
				objectOut.writeObject(enumState);
				EnumSingleton newState = (EnumSingleton) objectIn.readObject();
				
				//assert
				assertEquals(enumState,newState);
	}

}
