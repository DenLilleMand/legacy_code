package mockito;

public class StudentController 
{
	private DBWrapperStudent db;
	
	/**
	 * normalt ville man tage imod et interface, så den her klasse ville
	 * kunne supporte flere forskellige.
	 * @param db
	 */
	public StudentController(DBWrapperStudent db)
	{
		this.db = db;
	}
	
	public void saveStudent(Student s)
	{
		if(s.validateStudent())
		{
			db.save();
		}
	}

}
