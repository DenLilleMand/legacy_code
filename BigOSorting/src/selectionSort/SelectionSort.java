package selectionSort;

public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public class Sort {
		
		public void exchange(int[] numbers, int i, int j)
		{
			int local = numbers[i];
			numbers[i] = numbers[j];
			numbers[j] = local;
		}
		
		public void selectionSort(int[] numbers)
		{
			for (int i=0; i < numbers.length; i++)
			{
				int value = i;
				
				for(int j=i+1; j < numbers.length; j++)
				{
					if (numbers[j] < numbers[value])
					{
						value = j;
					}
				}
				exchange(numbers, i, value);
			}
		}
	}

}
