package bubbleSort;

public class Bubblesort2 {
	public void bubbleSort(int[] theArray) {

		// i starts at the end of the Array
		// As it is decremented all indexes greater
		// then it are sorted

		for (int i = theArray.length - 1; i > 1; i--) {

			// The inner loop starts at the beginning of
			// the array and compares each value next to each
			// other. If the value is greater then they are
			// swapped

			for (int j = 0; j < i; j++) {

				// To change sort to Descending change to <

				if (theArray[j] > theArray[j + 1]) {

					swapValues(theArray, j, j + 1);

				}

			}

		}

	}

	public void swapValues(int[] theArray, int indexOne, int indexTwo) {

		int temp = theArray[indexOne];
		theArray[indexOne] = theArray[indexTwo];
		theArray[indexTwo] = temp;

	}
}
