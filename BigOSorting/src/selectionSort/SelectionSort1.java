package selectionSort;

public class SelectionSort1 {
	public void selectionSort(int[] theArray) {

		for (int x = 0; x < theArray.length; x++) {
			int minimum = x;

			for (int y = x; y < theArray.length; y++) {

				// To change direction of sort just change
				// this from > to <

				if (theArray[minimum] > theArray[y]) {
					minimum = y;
				}
			}

			swapValues(theArray,x, minimum);

		}

	}

	public void swapValues(int[] theArray, int indexOne, int indexTwo) {

		int temp = theArray[indexOne];
		theArray[indexOne] = theArray[indexTwo];
		theArray[indexTwo] = temp;

	}

}
