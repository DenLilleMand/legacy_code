package mockito;

import org.junit.Test;
import org.mockito.Mockito;

public class TestStudentController 
{
	/**
	 * Vi mangler åbenbart at hente nogle flere jar filer ind.
	 */
	@Test
	public void test() 
	{	
		//arrange(den første del her, og hvis noget i arrange er det samme for ALLE vores 
		//testcases- og jeg tænker at dette kommer til at forekomme ofte, fordi lige så snart man 
		//tester mere end 2 metoder i den samme testCase er der allerede 10 test metoder fordi vi bruger
		//'regression test')
		
		Student s = new Student();
		//Mock - Fake - ikke en "rigtig" DBWrapperStudent, men en fake.
		DBWrapperStudent db = Mockito.mock(DBWrapperStudent.class);
		StudentController controller = new StudentController(db);
		
		
		//act
		controller.saveStudent(s);
		
		//assert
		Mockito.verify(db,Mockito.times(1)).save();
		
		
		
	}

}
