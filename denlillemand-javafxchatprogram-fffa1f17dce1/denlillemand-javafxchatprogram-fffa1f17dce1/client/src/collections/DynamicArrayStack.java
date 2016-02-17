package collections;

import exceptions.StackIsEmptyException;
import exceptions.StackIsFullException;
/**
 * Ideen bagved min implementering af Stacken er at vi allokere et nyt array
	 * med size*1.4 hver gang vi rammer max size. og så resetter vi front. 
	 * indtil vi rammer size. så bliver front++  det betyder at vi får nogle null
	 * pladser i starten af vores array når de er blevet poppet. men det betyder
	 * også at vi undgår kompleksiteten af et rundt array samt at vi 
	 * resetter alle null pladser hver gang vi rammer max size på vores stack.
 * @author denlillemand
 *
 * @param <T>
 */
public class DynamicArrayStack<T> 
{
	public int size;
	public T[] internalArray = null;
	public static final int HUNDRED = 100;
	public static final int NINETY = 90;
	public static final int NOT_SET = -1;
	public int front = 0;
	public static final String STACK_IS_EMPTY ="Stack is empty!";
	
	@SuppressWarnings("unchecked")
	public DynamicArrayStack(int n)
	{
		if(n < 10)
		{
			throw new IllegalArgumentException();
		}
		size = n;
		internalArray = (T[]) new Object[size];
	}
	
	/**
	 * 
	 * @param element
	 * @throws StackIsFullException - if the stack is full.
	 */
	public void push(T element)
	{
		double doublefront = front;
		double doubleSize = size;
		int percentageOfElementsVersusSize = (int) Math.floor(doublefront / doubleSize * HUNDRED);
		if(percentageOfElementsVersusSize >= NINETY)
		{
			int increaseArraySize =(int) Math.floor(doubleSize*1.20);
			@SuppressWarnings("unchecked")
			T[] newInternalArray = (T[]) new Object[increaseArraySize];
			System.arraycopy(internalArray, 0, newInternalArray, 0, internalArray.length-front);
			internalArray = newInternalArray;
			size = increaseArraySize;
		}
		internalArray[front++] = element;
	}
	
	/**
	 * Okay. Så faktisk skal elementerne poppes af fra back af. Siden
	 * vi lige nu er i gang med at lave en queue implementering. 
	 * Man ligger på + tager af samme sted i stacks. faktisk
	 * så er 'back' mængden af elementer vi har i arrayed og ikke front.
	 * 
	 * @return front element - and removes it from the stack.
	 * @throws StackIsEmptyException - if the stack is empty
	 */
	public T pop() throws StackIsEmptyException
	{
		if(isEmpty())
		{
				throw new StackIsEmptyException(STACK_IS_EMPTY);
		}
		if(front >=10)
		{
			if(internalArray.length > front)
			{
				@SuppressWarnings("unchecked")
				T[] newInternalArray = (T[]) new Object[front];
				System.arraycopy(internalArray, 0, newInternalArray, 0, internalArray.length-1);
				internalArray = newInternalArray;
				size = front;
			}
		}
		return internalArray[front--];
	}
	
	
//	public T pop() throws StackIsEmptyException
//	{
//		if(isEmpty())
//		{
//			throw new StackIsEmptyException(STACK_IS_EMPTY);
//		}
//		double doubleSize = size;
//		double doubleBack = back;
//		int percentageOfElementsVersusSize = (int) Math.floor(doubleBack / doubleSize * HUNDRED);
//		if(percentageOfElementsVersusSize >= NINETY)
//		{
//			double  herpderp = doubleSize/25 >= 1 ? 25/doubleSize : doubleSize/25;
//			System.out.println("herpderp:" + herpderp);
//			int decreasedSize = (int) Math.floor(herpderp*size);
//			System.out.println("decreasedSize:" + decreasedSize);
//			
//			System.out.println("oldSize:" + size );
//			@SuppressWarnings("unchecked")
//			T[] newInternalArray = (T[]) new Object[decreasedSize];
//			System.arraycopy(internalArray, 0, newInternalArray, 0, decreasedSize);
//			front = FRONT_RESET;
//			back = Math.abs(back-front);
//			internalArray = newInternalArray;
//			size = decreasedSize;
//		}
//		return internalArray[front--];
//	}
	
	/**
	 * @return First element in the stack or null if empty, but doesn't remove it from stack.
	 */
	public T peek() throws StackIsEmptyException
	{
			if(isEmpty())
			{
				throw new StackIsEmptyException(STACK_IS_EMPTY);
			}
			return internalArray[front];			
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isEmpty()
	{
		return internalArray[front] == null;
	}
	
	
	public boolean isFull()
	{
		return front >= size-1;
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < internalArray.length; i++)
		{
			sb.append("[").append(internalArray[i] + " number:" + i).append("] ");
		}
		return sb.toString();
	}
}
