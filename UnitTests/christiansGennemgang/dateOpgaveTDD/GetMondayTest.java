package dateOpgaveTDD;

import java.text.ParseException;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class GetMondayTest {
	
	private GetMonday getMonday;
	
	
	@Before
	public void setup()
	{
		getMonday = new GetMonday();
	}

	@Test
	public void test_validInput_boolean()
	{
		//arrange
		//i vores setup class
		Date date = new Date();
		try 
		{
			date = getMonday.getMonday(date);
			System.out.println(date.toString());
		} catch (ParseException e) 
		{
			e.printStackTrace();
		}
		//act
		
		//assert
	
	}

}
