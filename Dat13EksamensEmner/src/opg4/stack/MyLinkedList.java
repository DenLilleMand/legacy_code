package opg4.stack;

public class MyLinkedList<T> implements IMyLinkedList<T> {
	
	private LinkListEntry<T> root;
	
	@Override
	public boolean isEmpty() {
		if(root == null)
		{
			return true;
		}
		else
			return false;
	}
	@Override
	public void clear() {
		root = null;
		
	}
	@Override
	public T addFirst(T t)
	{
		if(root == null)
		{
			root = new LinkListEntry<T>(t,null,null);
			return root.getT();
		}
		else{
			root = new LinkListEntry<T>(t,null,root);
			return root.getT();
		}
		
	}
	@Override
	public T getFirst() {
		if(root == null)
		{
			return null;
		}
		else if (root.getNext() == null)
		{
			LinkListEntry<T> temp = root;
			root = null;
			return temp.getT();
		}
		else{
			LinkListEntry<T> temp  = root;
			root = root.getNext();
			root.setPrev(null);
			return temp.getT();
		}
	}
	@Override
	public T peek() {
		return root.getT();
	}

}
