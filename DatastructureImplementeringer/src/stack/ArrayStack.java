package stack;

/**
 * Konventioner: Recalling that arrays start at index 0 in Java, when the stack
 * holds elements from data[0] to data[t] inclusive, it has size t +1. By
 * convention, when the stack is empty it will have t equal to −1 (and thus has
 * size t +1, which is 0). A complete Java implementation based on this strategy
 * is given in Code Fragment 6.2 (with Javadoc comments omitted due to space
 * considerations).
 * 
 * @author denlillemand
 *
 */
public class ArrayStack<E> implements Stack<E> {

	public static final int CAPACITY = 1000; // default array capacity
	private E[] data; // generic array used for storage
	private int top = -1; // index of the top element in stack

	public ArrayStack() 
	{
		this(CAPACITY);
	} 

	@SuppressWarnings("unchecked")
	public ArrayStack(int capacity) { // constructs stack with given capacity
		data = (E[]) new Object[capacity]; // safe cast; compiler may give
											// warning
	}

	public int size() {
		return (top + 1);
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public void push(E e) throws IllegalStateException {
		if (size() == data.length)
			throw new IllegalStateException("Stack is full");
		data[++top] = e; // increment t before storing new item
	}

	public E top() {
		if (isEmpty())
			return null;
		return data[top];
	}
	/**
	 * one interesting aspect involving the implementation of
the pop method in Code Fragment 6.2. We set a local variable, answer, to reference
the element that is being popped, and then we intentionally reset data[t] to null at
line 22, before decrementing t. The assignment to null was not technically required,
as our stack would still operate correctly without it.
Our reason for returning the cell to a null reference is to assist Java’s garbage
collection mechanism, which searches memory for objects that are no longer actively
referenced and reclaims their space for future use. (For more details, see
Section 15.1.3.) If we continued to store a reference to the popped element in our
array, the stack class would ignore it (eventually overwriting the reference if more
elements get added to the stack). But, if there were no other active references to the
element in the user’s application, that spurious reference in the stack’s array would
stop Java’s garbage collector from reclaiming the element.
	 */
	public E pop() {
		if (isEmpty())
			return null;
		E answer = data[top];
		data[top] = null; // dereference to help garbage collection
		top--;
		return answer;
	}

}
