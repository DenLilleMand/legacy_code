package dictionaryChristiansGennemgang;

public interface IDictionary<Key, Value> 
{
	public void add(Key key, Value value);
	public void remove(Key key);
	public Value getValue(Key key);
	public boolean contains(Key key);
	public boolean isEmpty();
	public int getSize();
	public void clear();
}

