package dataAbstractionsBogen.sortingArray;

public class SortArray {
	public static <T extends Comparable<? super T>> void sort(T[] a, int n) {
		for (int index = 0; index < n - 1; index++) {
			int indexOfNextSmallest = getIndexOfSmallest(a, index, n - 1);
			swap(a, index, indexOfNextSmallest);
			// Assertion: a[0] <= a[1] <= . . . <= a[index] <= all other
			// a[i]
		} // end for
	} // end selectionSort

	private static <T extends Comparable<? super T>> int getIndexOfSmallest(
			T[] a, int first, int last) {
		T min = a[first];
		int indexOfMin = first;
		for (int index = first + 1; index <= last; index++) {
			if (a[index].compareTo(min) < 0) {
				min = a[index];
				indexOfMin = index;
			} // end if
				// Assertion: min is the smallest of a[first] through a[index].
		} // end for
		return indexOfMin;
	} // end getIndexOfSmallest

	/**
	 * Swaps the array entries a[i] and a[j].
	 * 
	 * @param a
	 *            an array of objects
	 * @param i
	 *            an integer >= 0 and < a.length
	 * @param j
	 *            an integer >= 0 and < a.length
	 */
	private static void swap(Object[] a, int i, int j) {
		Object temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	/** Recursive sort: */
	public static <T extends Comparable<? super T>> void selectionSort(T[] a,
			int n) {
		selectionSort(a, 0, n - 1); // invoke recursive method
	} // end selectionSort
	
//	Algorithm selectionSort(a, n)
//	// Sorts the first n entries of an array a.
//	for (index = 0; index < n - 1; index++)
//	{
//	indexOfNextSmallest = the index of the smallest value among
//	a[index], a[index + 1], . . . , a[n - 1]
//	Interchange the values of a[index] and a[indexOfNextSmallest]
//	// Assertion: a[0] 􀂔 a[1] 􀂔 . . . 􀂔 a[index], and these are the smallest
//	// of the original array entries. The remaining array entries begin at a[index + 1].
//	}
}