package favorGenericTypes;

public class Stack<E>
{
		private E[]elements;
		private int size = 0;
		private static final int DEFAULT_INITIAL_CAPACITY = 16;
		
		public Stack()
		{
			elements = new E[DEFAULT_INITIAL_CAPACITY];
		}
		
		public void push(E e)
		{
			ensureCapacity();
			elements[size++] = e;
		}
		
		public E pop()
		{
			if(size == 0)
			{
				throw new EmptyStackException();
			}
			E result = elements[--size];
			elements[size] = null; // Eliminate obsolete reference
			return result;
		}
		...//no changes in isEmpty or ensureCapacity(andre metoder fra side 147).
		
		
		
	
	
	
	
	
	
	
}
