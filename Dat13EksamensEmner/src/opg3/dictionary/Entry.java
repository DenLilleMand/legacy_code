package opg3.dictionary;

public class Entry<K, V> {

	private K key;
	private V value;
	
	public Entry(K key, V v)
	{
		this.key = key;
		this.value = v;
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
}
