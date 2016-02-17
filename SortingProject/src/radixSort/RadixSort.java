package radixSort;

import java.util.Arrays;
import java.util.LinkedList;

public class RadixSort 
{

	@SuppressWarnings("unchecked")
	/** linked lists er også queues. */
	private LinkedList<Integer>[] counter = new LinkedList[] 
			{
			new LinkedList<Integer>(), new LinkedList<Integer>(),
			new LinkedList<Integer>(), new LinkedList<Integer>(),
			new LinkedList<Integer>(), new LinkedList<Integer>(),
			new LinkedList<Integer>(), new LinkedList<Integer>(),
			new LinkedList<Integer>(), new LinkedList<Integer>() 
			};


	public static RadixSort createInstance() {
		return new RadixSort();
	}

	public void radixSort(int[] array, int maxDigitSymbols) 
	{
		int mododulus = 10;
		int devide = 1;
		for (int i = 0; i < maxDigitSymbols; i++, devide *= 10, mododulus *= 10) 
		{
			// System.out.println(Arrays.toString(array));
			for (int j = 0; j < array.length; j++) 
			{
				int bucket = (array[j] % mododulus) / devide;
				counter[bucket].add(array[j]);
			}
			int pos = 0;
			for (int j = 0; j < counter.length; j++) 
			{
				Integer value = null;
				while ((value = counter[j].poll()) != null) /**poll metoden fjerner toppen fra queuen,
				 											hvilket i det her tilfælde ville være de 4 0er i 00004 f.eks.*/
				{
					// System.out.println(value);
					array[pos++] = value;
				}
			}
		}

	}



}
