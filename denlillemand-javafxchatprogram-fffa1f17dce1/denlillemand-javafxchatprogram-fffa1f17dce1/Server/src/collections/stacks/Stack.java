package collections.stacks;

import exceptions.StackIsEmptyException;

public interface Stack<T> {
	public T pop();
	public T peek() throws StackIsEmptyException;
	public void push(T element);
	public boolean isEmpty();
	public int size();
}
