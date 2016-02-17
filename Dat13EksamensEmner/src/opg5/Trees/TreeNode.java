package opg5.Trees;

public class TreeNode<T> implements ItreeNode<T> {

	private ItreeNode<T> left;
	private ItreeNode<T> right;
	private T data;
	
	public TreeNode(T t)
	{
		setData(t);
	}
	
	@Override
	public void attach(T t) {
		int i = t.toString().compareTo(data.toString());
		if(i == 0)
		{
			return;
		}
		else if(i < 0)
		{
			if(left == null)
			{
				left = new TreeNode<T>(t);
			}
			else
			{
				left.attach(t);
			}
		}
		else if(i > 0)
		{
			if(right == null)
			{
				right = new TreeNode<T>(t);
			}
			else
			{
				right.attach(t);
			}
		}
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
@Override
	public int count() {
		if(left == null)
		{
			if(right == null)
			{
				return 1;
			}
			else
			{
				return 1 + right.count();
			}
		}
		else{
			if(right == null)
			{
				return 1 + left.count();
			}
			else{
				return 1 + left.count() + right.count();
			}
		}
		
	}

	@Override
	public int height() {
	
	if(left == null && right == null)
	{
		return 1;
	}
	else if(left == null)
	{
		return 1 + right.height();
	}
	else if(right == null)
	{
		return 1 + left.height();
	}
	else
	{
		if(left.height() > right.height())
		{
			return 1 + left.height();
		}
		else{
			return 1 + right.height();
		}
	}
	}

	public ItreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(ItreeNode<T> left) {
		this.left = left;
	}

	public ItreeNode<T> getRight() {
		return right;
	}

	public void setRight(ItreeNode<T> right) {
		this.right = right;
	}
@Override
	public void printInOrder() {
		if(left != null)
		{
			left.printInOrder();
		}
		System.out.println(data.toString());
		if(right != null)
		{
			right.printInOrder();
		}
	}
@Override	
	public void printPreOrder() {
		System.out.println(data.toString());
		if(left != null)
		{
			left.printInOrder();
		}
		if(right != null)
		{
			right.printInOrder();
		}
	}
@Override
	public void printPostOrder() {
		if(left != null)
		{
			left.printInOrder();
		}
		if(right != null)
		{
			right.printInOrder();
		}
		System.out.println(data.toString());
	}
}
