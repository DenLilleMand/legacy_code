package opg5.Trees;

public class MyTree<T> implements ITree<T> {

	private TreeNode<T> root;
	
	@Override
	public void add(T t) {
		if(root == null)
		{
			root = new TreeNode<T>(t);
		}
		else
		{
			root.attach(t);
		}
	}
	
	@Override
	public void preOrder() {
		if(root == null)
		{
			System.out.println("tree is empty");
		}
		else{
			root.printPreOrder();
		}
	}

	@Override
	public void inOrder() {
		if(root == null)
		{
			System.out.println("tree is empty");
		}
		else{
			root.printInOrder();
		}
	}

	@Override
	public void postOrder() {
		if(root == null)
		{
			System.out.println("tree is empty");
		}
		else{
			root.printPostOrder();
		}
	}

	@Override
	public int count() {
		if(root == null)
		{
			return 0;
		}
		return root.count();
	}

	@Override
	public int height() {
		if(root == null)
		{
			return 0;
		}
		return root.height();
	}

	@Override
	public boolean isBalanced() {
		if(root == null)
		{
			return true;
		}
		else if(root.getLeft() == null)
		{
			if(root.getRight() == null)
			{
				return true;
			}
			else
			{
				if(root.getRight().height() > 1)
				{
					return false;
				}
				else{
					return true;
				}
			}
		}
		else
		{
			if(root.getRight() == null)
			{
				if(root.getLeft().height() > 1)
				{
					return false;
				}
				else
				{
					return true;
				}
			}
			else{
				if(root.getLeft().height() - root.getRight().height() >1 ||root.getRight().height() - root.getLeft().height() > 1)
				{
					return false;
				}
				else
				{
					return true;
				}
			}
		}
	}

}
