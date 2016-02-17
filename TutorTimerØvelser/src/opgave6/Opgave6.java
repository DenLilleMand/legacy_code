package opgave6;

public class Opgave6 
{
	public static void main(String  [] args)
	{
		System.out.println(smallerAbsVal(-8,2));
	}
	
	public static int smallerAbsVal(int value, int value2)
	{
		if(Math.abs(value) < Math.abs(value2))
			return value;
		return value2;
	}
}
