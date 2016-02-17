package egetForsøg;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestPerson 
{

	@Test(expected=MyIllegalArgumentException.class)
	public void test_firstName_MyIllegalArgumentException() 
	{
		//Arrange
		Person person = Person.newInstance();
		
		//Act
		person.setFirstName("herpderpherpderpherpderpherpderpherpderpherpderpherpderpherpderpherpderpherpderpherpderpherpderpherpderpherpderpherpderp");
		//Assert
	}
	
	//ikke helt sikker på hvordan @Rule fungerer i samarbejde med ens test condition.
//	@Rule
//	public ExpectedException thrown= ExpectedException.none();
	@Test(expected=MyIllegalArgumentException.class)
	public void test_lastName_MyIllegalArgumentException() 
	{
		//Arrange
		Person person = Person.newInstance();
		
		//Act
		//haha-åbenbart så kan jeg catche, den exception som min unitTest opdager,
		//så jeg catcher den før den rammer den sidste linje, ergo - selvom mit kode
		//smider den forventede metode, så vil junit ikke tage sig af det.
//		try
//		{
			person.setLastName("herpderpherpderpherpderpherpderpherpderpherpderpherpderpherpderpherpderpherpderpherpderpherpderp");	
//		} catch(MyIllegalArgumentException e)
//		{
//			System.out.println("Off by: " + e.getOffBy());
//		}
		//Assert
	}
	
	@Test
	public void test_addresse_MyIllegalArgumentException()
	{
		//Arrange
				Person person = Person.newInstance();
				
				//Act
				person.setAddresse("herpderp111");
				//Assert
	}
	
	@Test
	public void test_cpr_void() 
	{
		//Arrange
		Person person = Person.newInstance();
		//Act
		person.setCpr("060491-9091");
		
		String cpr = person.getCpr();
		char[] cprArray = cpr.toCharArray();
		for(int i = 0; i < cprArray.length; i++)
		{
			//48-57
			int ascii = (int) cprArray[i];
			if(i == 6 && ascii == 45)
			{
				continue;
			}
			if(ascii < 48 || ascii > 57)
			{
				fail("doesn't work"); 
			}
		}
	}
	
}
