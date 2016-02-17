package skolearbejde;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class CatVariantFactoryTest {
	@Test
	/**test_hvad man tester for_ hvad outputet er */
	public void test_CorrectType_Equals()
	{
				//Arrange
				CatVariant cat = CatVariantFactory.newInstance(CatVariants.LYNX);
				
				//Act
				
				//Assert
				assertEquals(CatVariants.LYNX, cat.getType());
	}
	
	@Test
	public void test() 
	{
		fail("Not yet implemented");
	}

}
