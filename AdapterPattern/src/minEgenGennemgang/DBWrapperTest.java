package minEgenGennemgang;

import static org.junit.Assert.*;

import org.junit.Test;

public class DBWrapperTest {

	@Test
	public void test() {
		//Arrange
		DBWrapper db = new DBWrapper();
		Student student = new Student("Gunnar hermansen");
		StudentAdapterStudentDTO adapter = new StudentAdapterStudentDTO(student);
		
		//Act
		String firstName = db.saveFirstNameToDatabase(adapter);
		
		
		//assert
		assertEquals("Didn't work herpderp", firstName, "Gunnar");
		
	}

}
