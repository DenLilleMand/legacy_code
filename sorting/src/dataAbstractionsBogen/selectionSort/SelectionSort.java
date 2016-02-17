package dataAbstractionsBogen.selectionSort;

public class SelectionSort {
	private static final int[] numbers = { 8, 2, 1, 4, 5, 3, 6, 7 };

	public static void main(String[] args) 
	{
		selectionSort(numbers);
	}

	public static void selectionSort(int[] numbers) 
	{
		for (int j = 0; j <= numbers.length-1; j++) 
		{
			int value = j;
			for (int i = j+1; i < numbers.length; i++) //vi plusser j med 1, fordi 
			{
				if (numbers[i] < numbers[value]) 
				{
					value = i;						
				}
			}
			
			int tempValue = numbers[value];
			numbers[value] = numbers[j];
			numbers[j] = tempValue;
		}
		
		for(int i = 0; i < numbers.length; i++)
		{
			System.out.println("number:" + numbers[i]);
		}

	}
}
