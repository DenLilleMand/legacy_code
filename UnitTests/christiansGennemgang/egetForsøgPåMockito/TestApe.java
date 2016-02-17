package egetForsøgPåMockito;

import org.junit.Test;
import org.mockito.Mockito;

public class TestApe 
{
	@Test
	public void test() 
	{
		//arrange
		Banana banana = Mockito.mock(Banana.class);
		Ape ape = new Ape(banana);
		
		//act
		ape.run(2);
		
		//assert
		Mockito.verify(banana,Mockito.times(1)).doSomething();
		
	}

}
