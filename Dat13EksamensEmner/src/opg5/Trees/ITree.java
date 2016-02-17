package opg5.Trees;

public interface ITree<T> {

	public void preOrder();
	public void inOrder();
	public void postOrder();
	
	public void add(T t);
	public int count();
	public int height();
	
	public boolean isBalanced();
}
