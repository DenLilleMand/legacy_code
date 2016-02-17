package bubbleSort;

public class BubbleSort {
	public static void main(String [ ] args)
	{
		
	}
	
	
	/****************************************************************************
	 * Author: Isai Damier
	 * Title: Bubblesort
	 * Project: geekviewpoint
	 * Package: algorithms
	 *
	 * Statement:
	 *   Given a disordered list of integers (or any other items),
	 *   rearrange the integers in natural order.
	 *
	 * Sample Input: {8,5,3,1,9,6,0,7,4,2,5}
	 * Sample Output: {0,1,2,3,4,5,5,6,7,8,9}
	 *
	 *Time Complexity of Solution:
	 *   Best O(n^2); Average O(n^2); Worst O(n^2).
	 *
	 * Approach:
	 *   Bubblesort is an elementary sorting algorithm. The idea is to imagine
	 *   bubbling the smallest elements of a (vertical) array to the top; then
	 *   bubble the next smallest; then so on until the entire array is sorted.
	 *   Bubble sort is worse than both insertion sort and selection sort. It
	 *   moves elements as many times as insertion sort (bad) and it takes as
	 *   long as selection sort (bad). On the positive side, bubble sort is easy
	 *   to understand. Also there are highly improved variants of bubble sort.
	 *
	 *   1] For each element at index i from 0 to n, loop
	 *   2] For each element at index k, from n to i exclusive, loop
	 *   3] If the element at k is less than that at k-1, swap them.
	 *
	 ***************************************************************************/
	 public void bubblesort(int[] array) 
	 {
		 for (int i = 0, k; i < array.length - 1; i++) 
		 {
			 for (k = array.length - 1; k > i; --k) 
			 {
				 if (array[k] < array[k - 1]) 
				 {
					 swap(array, k, k - 1);
				 }
			 }
		 }
	}
	 
	private void swap(int[] array, int a, int b) 
	{
	  int tmp = array[a];
	  array[a] = array[b];
	  array[b] = tmp;
	}
}
