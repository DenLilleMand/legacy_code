package gennemgang;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestTriangleCalculator 
{
	@Test
	public void test() 
	{
		//Arrange
		TriangleCalculator tc = new TriangleCalculator();
		
		//Act
		double c = tc.calculateHypot(3.0,4.0);
		
		//Assert
		assertEquals("herpderp fejlede", 5.0, c, 0.0);
		
	}
	
	
	@Test
	public void test_ValidSmallNumbers_Equals()
	{
		//Arrange
		TriangleCalculator tc = new TriangleCalculator();
		
		//Act
		double c = tc.calculateHypot(35, 612);
		
		//Assert
		assertEquals("Large numbers failed",613, c, 0.0);
	}
	
	@Test(expected=NumberFormatException.class)
	public void test_InvalidLarge_ThrowsInvalidNumberException()
	{
		//Arrange
		TriangleCalculator tc = new TriangleCalculator();
		
		//Act
		double c = tc.calculateHypot(-35, -612);
		
		//Assert
		
		
	}
}
