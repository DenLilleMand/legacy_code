package bubbleSort;

import java.util.Arrays;

public class MinBubbleSort {
	//visuelisering: http://www.ee.ryerson.ca/~courses/coe428/sorting/bubblesort.html
	public static void main(String[] args)
	{
		int[] array = {20,40,10,5,10,55,100,90,80};
		bubbleSort(array);
		System.out.println(Arrays.toString(array));
	}
	
	public static void bubbleSort(int[] array)
	{
		int i;
		int j;
		int temp;
		for (i = array.length - 1; i > 0; i--) 
		{
			boolean swapped = false;
			for (j = 0; j < i; j++) //i løbet af 1 iteration af denne flytter vi den højeste ned 
									//i den anden ende, det er garanteret, så derfor kan vi tælle det
									//ydre loop ned 1 gang for hver iteration i stedet for at kører
									//en while(swapping). 
			{
				if (array[j] > array[j + 1]) 
				{
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					swapped = true;
				}
			}
			if(!swapped)
			{
				break;
			}
		}
	}
}
