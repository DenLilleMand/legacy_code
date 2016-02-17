package opg2.hashing;

public class Entry<K, V> {

	private Entry<K, V> next;
	private K key;
	private V value;
	
	public Entry(K key, V v)
	{
		this.key= key;
		this.value=value;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public Entry<K, V> getNext() {
		return next;
	}

	public void setNext(Entry<K, V> next) {
		this.next = next;
	}
}
