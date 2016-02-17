package linkedList;

public class OrderedLinkedList {
	
	/**
	 * The insert() method takes three arguments: the array a[], the number n of elements that are already
sorted in the array, and the new element x to be inserted among them. The preconditions at line 2 specify
that the first n elements of the array are in ascending order and that the array has room for at least one
more element. The postconditions at line 3 specify that the array is still in ascending order and that x has
been successfully inserted among them.
	 * @param array
	 * @param size
	 * @param inputInt
	 */
	public void insert(int[] array, int size, int inputInt) 
	{
		 // preconditions: a[0] <= ... <= a[n-1], and n < a.length;
		 // postconditions: a[0] <= ... <= a[n], and x is among them;
		 int i = 0;
		 while (i < size && array[i] <= inputInt) 
		 {
			 ++i;
		 }
		 /**
		  * i er vores index, men vi skal også flytte alle dem der er foran først,
		  * så derfor kører vi fra 'i' i det første array til  'size-i' i det andet
		  * hele tiden for at gøre plads, til en enkelt insertion. Det er jo klart
		  * at vi skal kører size-i  fordi det er den længde der er tilbage af arrayed,
		  * efter vi fandt hvilket index insertionen skulle være på.
		  * 
		  * 
		  */
		 System.arraycopy(array, i, array, i+1, size-i); // copies a[i..n) into a[i+1..n+1)
		 array[i] = inputInt;
	}
}
