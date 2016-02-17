package map;

import java.util.Collection;
import java.util.Set;

public interface Map<K,V> {
	int size();

	boolean isEmpty();

	boolean containsKey(K key);

	boolean containsValue(V value);

	V get(K key);

	V put(K key, V value);

	V remove(K key);

	void putAll(Map<K,V> map);

	void clear();

	public Set<K> keySet();

	public Collection<V> values();

	public Set<Entry<K,V>> entrySet();

	public interface Entry<K,V> {
		K getKey();

		V getValue();

		V setValue(V value);

		boolean equals(Object o);

		int hashCode();
	}

	boolean equals(Object o);

	int hashCode();
}