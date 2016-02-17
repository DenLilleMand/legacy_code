package collections;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exceptions.StackIsEmptyException;
import exceptions.StackIsFullException;

public class ArrayStackTest {
	DynamicArrayStack<String> arrayStack;
	@Before
	public void setup()
	{
		//Arrange
		arrayStack = new DynamicArrayStack<String>(20);
	}
	
	@Test
	public void test_push_() throws StackIsEmptyException {
		
		
		//Act
		for(int i = 0; i < 30; i++)
		{
			arrayStack.push("what");
		}	
		System.out.println("pushing:"+arrayStack.toString());
//		for(int j = 0; j < 20; j++)
//		{
			arrayStack.pop();
			arrayStack.pop();
			arrayStack.pop();
			arrayStack.pop();
	//	}
		System.out.println("popping:"+arrayStack.toString());
		
		//Assert
		
		
		
	}

}
