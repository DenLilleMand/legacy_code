package opgave3;

public class Opgave3 
{
	public static void main(String [] args)
	{
		int base = 5;
		int power = 6;
		printPowersOfN(base,power);
	}
	
	public static void printPowersOfN(int base, int power)
	{
		for(int i = 0; i <= power; i++)
		{
			System.out.println((int)Math.pow(base,i));
		}
	}
}
