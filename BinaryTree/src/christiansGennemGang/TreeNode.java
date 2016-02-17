package christiansGennemGang;

public class TreeNode<T> {
	T data;
	TreeNode rightNode;
	TreeNode leftNode;
	
	
	public TreeNode(T data)
	{
		this.data = data;
	}


	public TreeNode getRightNode() {
		return rightNode;
	}


	public void setRightNode(TreeNode rightNode) {
		this.rightNode = rightNode;
	}


	public TreeNode getLeftNode() {
		return leftNode;
	}


	public void setLeftNode(TreeNode leftNode) {
		this.leftNode = leftNode;
	}
	
	

}
