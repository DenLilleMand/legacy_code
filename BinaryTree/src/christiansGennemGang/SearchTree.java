package christiansGennemGang;

public class SearchTree<T extends Comparable<T>> implements ISearchTree<Object>
{
	private TreeNode<T> root;
	
	
	//Overloading
	public void add(T data) 
	{
		root = add(root,data);
	}
	
	private TreeNode<T> add(TreeNode<T> root, T data)
	{
		if(root == null)
		{
			return root = new TreeNode(data);
		}
		else
		{
			int compare = data.compareTo(root.data);
			switch(compare)
			{
			case 0:
				//do something if they're equal
				break;
			case -1:
				root.leftNode = add(root.leftNode,data);
				break;
			case 1:
				root.rightNode = add(root.rightNode,data);
				break;
			}
		}
		return root;
	}

	
	public void remove(Object t) 
	{
		
	}
	
	public boolean contains(T data) 
	{
		return contains(root,data);
	}

	private boolean contains(TreeNode<T> root,T data) 
	{
		boolean result = false;
		if(root == null)
		{
			System.out.println("this is where we went");
			return result;
		}
		else
		{
			switch(data.compareTo(root.data))
			{
				case 0:
					return true;
				case 1:
					return contains(root.rightNode,data);
				case -1:
					return contains(root.leftNode,data);
					
			}
		}
		return result;
	}

	public int size() 
	{
		return 0;
		
	}
}
