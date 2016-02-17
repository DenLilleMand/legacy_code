package opgave13;

public class Opgave13 {

	public static void main(String[] args) 
	{
		System.out.println(salary(1000, 5000));
	}
	
	public static int salary(int salary, int grossSales)
	{
		return (int) ((salary) + (0.05 * grossSales)); 
	}

}
