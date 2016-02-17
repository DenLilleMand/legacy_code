package opg4.stack;

public interface IMyLinkedList<T> {

	boolean isEmpty();

	void clear();

	T addFirst(T t);

	T getFirst();

	T peek();

}
