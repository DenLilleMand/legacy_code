package bubbleSort;

public class BubbleSort1 {
	public static void main(String[] args) {
		int[] array = new int[20];
		
		bubbleSort(array);
		
	}

	public static void bubbleSort(int array[]) 
	{
		int i;
		int j;
		int temp;
		for (i = array.length - 1; i > 0; i--) 
		{
			for (j = 0; j < i; j++) 
			{
				if (array[j] > array[j + 1]) 
				{
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}
}
