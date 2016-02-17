package bubbleSort;

public class BubbleSort 
{
	public static void bubbleSort(int[] intArray)
	{
		int tmp;
		boolean didSort = true;
		while(didSort)
		{
			didSort = false;
			for(int i = 0; i < intArray.length-1;i++)
			{
				if(intArray[i] > intArray[i+1])
				{
					tmp = intArray[i];
					intArray[i] = intArray[i+1];
					intArray[i+1] = tmp;
					didSort = true;
				}
			}
		}
	}
}
