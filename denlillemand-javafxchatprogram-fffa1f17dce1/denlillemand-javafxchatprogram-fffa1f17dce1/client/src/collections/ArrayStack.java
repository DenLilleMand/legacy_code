package collections;


import exceptions.StackIsEmptyException;

public class ArrayStack<E> implements Stack<E>
{
	public static final String STACK_IS_EMPTY ="Stack is empty!";
	private int size;
	private int top = 0;
	public E[] internalArray = null;
	
	
	@SuppressWarnings("unchecked")
	public ArrayStack(int n)
	{
		this.size = n;
		internalArray = (E[]) new Object[size];
	}
	
	private void ensureCapacity() 
	{
		 int current = internalArray.length; 
		 if (top+1 > current)
		 {
		     @SuppressWarnings("unchecked")
		     E[] newInternalArray = (E[]) new Object[Math.max(current * 2, size+1)];
		     System.arraycopy(internalArray, 0, newInternalArray, 0, size);
		     internalArray = newInternalArray;
		 }
	}

	
	private void trimToSize() 
	{
		if (top != internalArray.length)
		{
			@SuppressWarnings("unchecked")
			E[] newInternalArray = (E[]) new Object[size];
			System.arraycopy(internalArray, 0, newInternalArray, 0, size);
			internalArray = newInternalArray;
		}
	}
	

	@Override
	public E pop() 
	{
		
		trimToSize();
		//Skal fjerne et element
		E element = internalArray[top++];
		
		
		return element;
	}
	

	
	@Override
	public void push(E element) 
	{
		     if (size == internalArray.length)
		     {
		    	 ensureCapacity();		    	 
		     }
		     internalArray[top++] = element;
	}

	@Override
	public E peek() throws StackIsEmptyException
	{
		if(isEmpty())
		{
			throw new StackIsEmptyException(STACK_IS_EMPTY);
		}
		return internalArray[top];
	}

	@Override
	public boolean isEmpty() 
	{
		return internalArray[top] == null;
	}

	@Override
	public boolean isFull() 
	{
		return top >= size-1;
	}

	@Override
	public int size() {
		return size;
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < internalArray.length; i++)
		{
			sb.append("[").append(internalArray[i]).append("] ");
		}
		return sb.toString();
	}

	
	
	
}
