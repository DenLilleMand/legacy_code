
public class TreeNode<T> implements ITreeNode {

	ITreeNode<T> left;
	ITreeNode<T> right;
	private T data;
	
	public TreeNode(T t)
	{
		data = t;
	}
	
	@Override
	public void attachLeft(ITreeNode t) 
	{
		left = t;
	}

	@Override
	public void attachRight(ITreeNode t) 
	{
		right = t;
	}
	
}
