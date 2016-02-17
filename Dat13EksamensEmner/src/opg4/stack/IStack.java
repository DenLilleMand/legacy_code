package opg4.stack;

public interface IStack<T> {
	public boolean isEmpty();
	public void popAll();
	public void push(T t) throws StackException;
	public T pop() throws StackException;
	public T peek() throws StackException;
}
