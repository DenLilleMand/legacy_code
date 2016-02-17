package bogensImplementering;

public class StackImplementedWithLinkedList {

	private java.util.LinkedList<Object> list = new java.util.LinkedList<Object>();

	public StackImplementedWithLinkedList() {
	}

	public void clear() {
		list.clear();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public Object topEl() {
		if (isEmpty())
			throw new java.util.EmptyStackException();
		return list.getLast();
	}

	public Object pop() {
		if (isEmpty())
			throw new java.util.EmptyStackException();
		return list.removeLast();
	}

	public void push(Object el) {
		list.addLast(el);
	}

	public String toString() {
		return list.toString();
	}
}
