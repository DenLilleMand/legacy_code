package opg3.dictionary;

public interface IDictionary<Key, Value> {
	public void add(Key key, Value value) throws Exception;
	public Value remove(Key key);
	public Value getValue(Key key);
	public boolean contains(Key key);
	public boolean isEmpty();
	public int getSize();
	public void clear();
}
