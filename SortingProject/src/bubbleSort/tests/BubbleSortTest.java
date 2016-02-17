package bubbleSort.tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

import bubbleSort.BubbleSort;

public class BubbleSortTest {

	@Test
	public void test() 
	{
		//Arrange 
		Random random = new Random();
		int[] intArray = new int[100];
		for(int i = 0; i < intArray.length-1; i++)
		{
			intArray[i] = random.nextInt(100);
		}
		//Act
		BubbleSort.bubbleSort(intArray);
		
		
		//Assert
		System.out.println(Arrays.toString(intArray));
		
		
	}

}
