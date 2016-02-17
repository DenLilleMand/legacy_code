package opgave1;

public class Opgave1 
{
	public static void main(String[] args) 
	{
		printEvenNumbers(12);
	}
	
	public static void printEvenNumbers(int value)
	{
		for(int i = 0; i < value+1; i++)
		{
			if(i == 0)
				continue;
			if(i%2 == 0)
			System.out.print("{" + i +"}");			
		}
	}

}
