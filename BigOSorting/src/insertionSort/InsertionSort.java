package insertionSort;

public class InsertionSort {

	public static void main(String[] args) 
	{

	}

	public void insertionsort(Object[] data) 
	{
		for (int i = 1, j; i < data.length; i++) 
		{
			Comparable tmp = (Comparable) data[i];
			for (j = i; j > 0 && tmp.compareTo(data[j - 1]) < 0; j--)
			{
				data[j] = data[j - 1];				
			}
			data[j] = tmp;
		}
	}

}
