package sorting;

public class InsertionSort<T extends Comparable<T>> 
{
	public void insertionsort(T[] data) 
	{
		for (int i = 1, j; i < data.length; i++) 
		{
			T temp = data[i];
			for (j = i; j > 0 && temp.compareTo(data[j - 1]) < 0; j--)
			{
				data[j] = data[j - 1];				
			}
			data[j] = temp;
		}
	}
}
