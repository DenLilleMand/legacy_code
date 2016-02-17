
public interface ListInterface<T> {
	T getIndex(int i);
	void remove(int index);
	void add(int index, T newEntry);
}
