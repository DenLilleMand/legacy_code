package mockito;

public class SimulateNormalOperation 
{
	public static void main(String[] args) 
	{
		Student s = new Student();
		DBWrapperStudent db = new DBWrapperStudent();
		StudentController sc = new StudentController(db);	
		sc.saveStudent(s);
	}
}
