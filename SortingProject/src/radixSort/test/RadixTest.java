package radixSort.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;


import radixSort.RadixSort;
import bubbleSort.BubbleSort;

public class RadixTest {

	@Test
	public void test_RADIXSORTHERPDERP_EXPECTINGAWESOME() 
	{
		int[] test = { 10, 1, 30, 156 };

		RadixSort sorter = RadixSort.createInstance();
		// we choose 3, because we have 156 with 3 digits
		sorter.radixSort(test, 3);

		System.out.println(Arrays.toString(test));

	}

}
