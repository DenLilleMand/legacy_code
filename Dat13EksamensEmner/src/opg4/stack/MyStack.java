package opg4.stack;

public class MyStack<T> implements IStack<T> {

	private MyLinkedList<T> internalArray = new MyLinkedList<T>();
	
	@Override
	public boolean isEmpty() {
		return internalArray.isEmpty();
	}

	@Override
	public void popAll() {
		// da der ikke skal returneres noget, rydder vi den med Clear();
		internalArray.clear();
	}

	@Override
	public void push(T t) throws StackException {
		internalArray.addFirst(t);
		
	}

	@Override
	public T pop() throws StackException {
		return internalArray.getFirst();
	}

	@Override
	public T peek() throws StackException {
		return internalArray.peek();
	}

}
