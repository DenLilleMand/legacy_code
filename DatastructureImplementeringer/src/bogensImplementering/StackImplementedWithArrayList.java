package bogensImplementering;
import java.util.ArrayList;

public class StackImplementedWithArrayList {
	private ArrayList<Object> pool = new ArrayList<Object>();

	public StackImplementedWithArrayList() {
	}

	public StackImplementedWithArrayList(int n) {
		pool.ensureCapacity(n);
	}

	public void clear() {
		pool.clear();
	}

	public boolean isEmpty() {
		return pool.isEmpty();
	}
//
//	public Object topEl() {
//		if (isEmpty())
//			throw new java.util.EmptyStackException();
//		return pool.lastElement();
//	}

	public Object pop() {
		if (isEmpty())
			throw new java.util.EmptyStackException();
		return pool.remove(pool.size() - 1);
	}

	public void push(Object el) {
		pool.add(el);
	}

	public String toString() {
		return pool.toString();
	}
}
