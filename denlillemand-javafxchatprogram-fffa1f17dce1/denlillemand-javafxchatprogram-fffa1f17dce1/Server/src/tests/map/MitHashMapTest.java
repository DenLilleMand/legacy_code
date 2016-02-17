/**
 * 
 */
package tests.map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import map.MitHashMap;
import map.ObjectNotReadyForHashMap;
import map.ObjectReadyForHashMap;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author denlillemand
 *
 */
public class MitHashMapTest 
{
	MitHashMap<String,String> hashMap;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception 
	{
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception 
	{
		hashMap = new MitHashMap<String,String>(11);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception 
	{
		
	}

	@Test
	public void testmitHashMap_putMethod_success() 
	{
		//Arrange
		@SuppressWarnings("unchecked")
		MitHashMap<String,String> mockedHashMap = mock(MitHashMap.class);
		
		stub(mockedHashMap.get(anyString())).toReturn("woah");
		
		//act
		String value = hashMap.put("hey", "woah");
		
		//assert
		assertEquals("putMethod failure", mockedHashMap.get("hey"),value);
		
	}

	@Test
	public void testmitHashMap_getMethod_success() 
	{
		//Arrange
		hashMap.put("hey", "woah");
		
		//act
		String value = hashMap.get("hey");
		
		//assert
		assertEquals("Det virkede!",value,"woah");
	}
	
	
	@Test
	public void testmitHashMap_MyOwnObject_success() 
	{
		ObjectReadyForHashMap key = new ObjectReadyForHashMap("hey");
		ObjectReadyForHashMap value = new ObjectReadyForHashMap("denlillemand");
		
		MitHashMap<ObjectReadyForHashMap,ObjectReadyForHashMap> readyHashMap 
		= new MitHashMap<ObjectReadyForHashMap,ObjectReadyForHashMap>(20);
		
		//act
		ObjectReadyForHashMap value1 = readyHashMap.put(key,value);
		
		ObjectReadyForHashMap returnedValue = readyHashMap.get(key);
		//assert
		assertEquals("Det virkede!",value1,returnedValue);
	}
	
	
	@Test
	public void testmitHashMap_objectNotOverrideingHashcode_failure() 
	{
		//Arrange
		ObjectNotReadyForHashMap key = new ObjectNotReadyForHashMap("hey",5000);
		ObjectNotReadyForHashMap value = new ObjectNotReadyForHashMap("denlillemand",5000);
		
		MitHashMap<ObjectNotReadyForHashMap,ObjectNotReadyForHashMap> readyHashMap = new MitHashMap<ObjectNotReadyForHashMap,ObjectNotReadyForHashMap>(20);
		
		
		//act
		ObjectNotReadyForHashMap returnedValue = readyHashMap.put(key,value);
		System.out.println("returned value:" + returnedValue);
		ObjectNotReadyForHashMap copiedValue = new ObjectNotReadyForHashMap(returnedValue.getName(),5000);
		System.out.println("copied value:" + copiedValue);
		ObjectNotReadyForHashMap finalValue = readyHashMap.get(key);
		System.out.println("final Value:" + finalValue);
		//assert
		assertNotEquals("Det virkede ikke",copiedValue,finalValue);
	}
}
