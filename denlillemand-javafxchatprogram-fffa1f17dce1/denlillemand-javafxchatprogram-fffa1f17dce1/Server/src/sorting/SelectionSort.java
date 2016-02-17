package sorting;
/**
 * Class for sorting an array of Comparable objects from smallest to largest.
 * 
 * The time efficiency of selection sort
Selection sort is O(n2) regardless of the initial order of the entries in an array. Although the
sort requires O(n2) comparisons, it performs only O(n) swaps. Thus, the selection sort
requires little data movement.
 */
public class SelectionSort 
{
	public static void main(String[] args)
	{
		
	}
	/**
	 * n an integer > 0
	 * @param array
	 * @param n
	 */
	public static <T extends Comparable<? super T>> void selectionSort(T[] array) 
	{
		for (int index = 0; index < array.length - 1; index++) 
		{
			int indexOfNextSmallest = getIndexOfSmallest(array, index, array.length - 1);
			swap(array, index, indexOfNextSmallest);
		}
	}

	private static <T extends Comparable<? super T>> int getIndexOfSmallest(T[] array, int first, int last) 
	{
		T min = array[first];
		int indexOfMin = first;
		for (int index = first + 1; index <= last; index++) 
		{
			if (array[index].compareTo(min) < 0) 
			{
				min = array[index];
				indexOfMin = index;
			} 
				
		} 
		return indexOfMin;
	}

	private static void swap(Object[] array, int i, int j) 
	{
		Object temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	} 
}