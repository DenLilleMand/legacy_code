package opgave2;
public class Opgave2 
{
	public static void main(String [] args)
	{
		printPowersOf10(3);
	}
	public static void printPowersOf10(int value)
	{
		int originalValue = 100000;
		for(int i = 5; i >= value; i--)
		{
			System.out.println(originalValue);
			originalValue /= 10;
		}
	}
}
