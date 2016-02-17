package minEgenGennemgang;

public class StudentAdapterStudentDTO implements IStudentDto{
	private Student student;
	private String firstName;
	private String lastName;
	
	public StudentAdapterStudentDTO(Student student)
	{
		this.student = student;
		String[] parts = student.getName().split(" ");
		firstName = parts[0]; 
		lastName = parts[1]; 
	}

	@Override
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}

	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public String getLastName() {
		return lastName;
	}
	
	

}
