package nyGennemgangFraChristian;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/**

 * @author DenLilleMand
 *
 */


public class CarTest 
{
	private Car car;
	
	/**
	 * Kalder den her metode før hver test
	 */
	@Before
	public void setUp()
	{
		car = new Car();
	}
	
	

	@Test
	public void testSetHeight_validInput_Equals() 
	{
		//Arrange
		//act
		car.setHeight(0.5);
		//assert  ("fejlbesked", hvad man regner med den giver, får den værdi, hvor stor forskel der må være på de 2)
		assertEquals("0.5 did not pass!",0.5, car.getHeight(),0.0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetHeight_invalidInput_Equals()
	{
		//Arrange
		Car car = new Car();
		//act
		car.setHeight(0.4);
		//assert (vores assert sker ovenover vores metode i vores @test annotation)
	}
	

	/**-----------------length test med valid input-----------------------------*/
	@Test
	public void testSetLength_valid_Equals()
	{
		//Arrange
		//- gør vi oppe i setup metoden
		//act
		car.setLength(2.1);
		//assert  ("fejlbesked", hvad man regner med den giver, får den værdi, hvor stor forskel der må være på de 2)
		assertEquals("2.1 did not pass!",2.1, car.getLength(),0.0);
	}
	
	@Test
	public void test_SetLength_valid_Equals1()
	{
		//Arrange
		//- gør vi oppe i setup metoden
		//act
		car.setLength(2.0);
		//assert  ("fejlbesked", hvad man regner med den giver, får den værdi, hvor stor forskel der må være på de 2)
		assertEquals("2.0 did not pass!",2.0, car.getLength(),0.0);
	}
	
	@Test
	public void test_SetLength_valid_Equals2()
	{
		//Arrange
		//- gør vi oppe i setup metoden
		//act
		car.setLength(99999.0);
		//assert  ("fejlbesked", hvad man regner med den giver, får den værdi, hvor stor forskel der må være på de 2)
		assertEquals("2.0 did not pass!",99999.0, car.getLength(),0.0);
	}
	
	/**-----------------length tests med invalid input-----------------------------*/
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetLength_InvalidInput_Equals1()
	{
		//Arrange
		//- gør vi oppe i setup metoden
		//act
		//HAHA - efter så mange 9 taller som der er her, runder den automatisk op. 
		//men det er vel faktisk okay
		car.setLength(1.99999999999999999);
		//assert (vores assert sker oppe i vores @Test annotation)
		System.out.println(car.getLength()); //den her returnere 2.0  pga oprundingen, så det er vel okay :D
		
	}
	
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetLength_invalidInput_Equals1()
	{
		//Arrange
		//- gør vi oppe i setup metoden
		//act
		car.setLength(-2);
		//assert (vores assert sker oppe i vores @Test annotation)
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetLength_invalidInput_Equals2()
	{
		//Arrange
		//- gør vi oppe i setup metoden
		//act
		car.setLength(-999999999);
		//assert (vores assert sker oppe i vores @Test annotation)
	}
	

}
