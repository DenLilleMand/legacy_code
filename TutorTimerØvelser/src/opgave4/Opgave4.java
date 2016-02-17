package opgave4;

public class Opgave4 
{
	public static void main(String [] args)
	{
		printDecrSquare(8, 4);
	}
	
	/**Write a method called printDecrSquare that accepts a maximum and minimum integer and prints a
	 * square of lines of decreasing numbers. The first line should start with the maximum,
	 * and each line that follows should start with the next-lower number. The sequence of numbers on a line
	 * wraps back to the maximum after it hits the minimum. For example, the call */
	public static void printDecrSquare(int maximum, int minimum)
	{
		int difference = maximum-minimum+1;
		int[] numbers = new int[difference];
		int counter = 0;
		
		for(int i =0; i < difference; i++)
		{
			numbers[i] = maximum-counter;
			counter++;
		}

		for(int j = 0; j <= difference; j++)
		{
			for(int k = 0; k <=numbers.length-1; k++)
			{
				System.out.print(numbers[k]);
			}
			System.out.println();
		}
	}
	
}
