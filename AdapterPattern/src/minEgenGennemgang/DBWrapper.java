package minEgenGennemgang;

public class DBWrapper 
{
		public String saveLastNameToDatabase(IStudentDto studentDto)
		{
			return studentDto.getLastName();
		}
		
		public String saveFirstNameToDatabase(IStudentDto studentDto)
		{
			return studentDto.getFirstName();
		
		}
}
