package collections.tree;

public interface Tree<T> 
{
		public void attach(T t);
		public int count();
		public int height();
		public void printInOrder();
		public void printPreOrder();
		public void printPostOrder();
}

