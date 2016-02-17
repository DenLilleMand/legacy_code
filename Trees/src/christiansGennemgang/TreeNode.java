package christiansGennemgang;

import interfaces.IBinaryTree;

public class TreeNode<T> implements IBinaryTree
{
	TreeNode<T> left;
	TreeNode<T> right;
	public static int amountOfNodes = 0;
	public static int amountOfLeftNodes = 0;
	public static int amountOfRightNodes = 0;
	
	T value;
	
	public TreeNode(T t)
	{
		value = t;
	}
	
	public void attachLeft(TreeNode<T> newNode)
	{
		left = newNode;
	}
	
	public void attachRight(TreeNode<T> newNode)
	{
		right = newNode;
	}
	
	public T getValue()
	{
		return value;
	}
	
	
	
	
	public int returnAmountOfNodes()
	{
		amountOfNodes++;
		if(left != null)
		{
			left.returnAmountOfNodes();	
		}
		if(right != null)
		{
			right.returnAmountOfNodes();	
		}
		return amountOfNodes;
	}

	public int returnHeightOfTree(TreeNode<T> t)
	{
		if(t == null)
		{
			return 0;
		}
		int herpderp =  1 + Math.max(returnHeightOfTree(t.left), returnHeightOfTree(t.right));
		System.out.println("current result:" +herpderp);
		return herpderp;
	}
	
	public boolean isBalanced(TreeNode<T> t)
	{
		if(returnHeightOfTree(t.left) - returnHeightOfTree(t.right) > 1 || returnHeightOfTree(t.right) - returnHeightOfTree(t.left) > 1)
		{
			return false;			
		}
		return true;
	}
	
	/**
	 * //left-right-print
		//10-30-50-40-20-70-60 
	 */
	
	public void postOrder() 
	{	
		if(left != null)
		{
			left.postOrder();	
		}
		if(right != null)
		{
			right.postOrder();		
		}
		System.out.println(value);
	}

	 /**
     * print - left - right   
     * 60-20-10-40-30-50-70
     */
	public int numberOfNodes(TreeNode<T> rootNode)
	{
		if(rootNode == null)
		{
			return 0;
		}
		int nodes = 1;
		nodes = nodes + numberOfNodes(rootNode.left);
		nodes = nodes + numberOfNodes(rootNode.right);
		return nodes;
	}

	
	
	/** så kan man lave den her metode, bare hvor den udregner,  */
	public void preOrder(TreeNode<T> incNode)
	{
		if(incNode == null)
		{
			return;
		}
		System.out.println(incNode.value);
		preOrder(incNode.left);
		preOrder(incNode.right);
		/** -----------------------------
		System.out.println("root: " + value)
		if(left != null)
		{
			System.out.println("left value:" + left.getValue());
			left.printPreOrder();	
		}
		if(right != null)
		{
			System.out.println("right value:" + right.getValue());
			right.printPreOrder();		
		}
		 */
	}
	
	/**
	 * 10-20-30-40-50-60-70
	 */
	public void inorder() 
	{	
		if(left != null)
		{
			left.inorder();
		}
		System.out.println(value);
		if(right != null)
		{
			right.inorder();
		}
		
	}

	
}
