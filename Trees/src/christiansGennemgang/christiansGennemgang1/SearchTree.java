package christiansGennemgang.christiansGennemgang1;

import christiansGennemgang.TreeNode;

public class SearchTree 
{
	SearchTreeNode root;
	
	public SearchTree(int value)
	{
		this.root = new SearchTreeNode(value);
	}
	
	public void deleteWithOneChild(int value)
	{
		deleteWithOneChild(value, root);
	}
	
	private void deleteWithOneChild(int value,SearchTreeNode node)
	{
		if(node == null)
			return;
		if(value == node.value)
		{
			if(node.right != null)
			{
				node = node.right;
			}
			else if(node.left != null)
			{
				node = node.left;
			}
			else 
			{
				node = null;				
			}
		}
		if(node.value > value)
		{
			deleteWithOneChild(value,node.right);
		}
		else if(node.value< value)
		{
			deleteWithOneChild(value,node.left);
		}
	}
	
	
	
	public void delete(int value)
	{
		root = delete(value, root);
	}
	
	private SearchTreeNode delete(int value,SearchTreeNode node)
	{
		if(node == null)
			return null;
		if(value == node.value)
		{
			System.out.println(node.value);
			node = null;
			
		}
		else if(node.value > value)
		{
			node.right = delete(value,node.right);
		}
		else if(node.value< value)
		{
			node.left = delete(value,node.left);
		}
		return node;
	}
	
	public void preOrder(SearchTreeNode incNode)
	{
		if(incNode == null)
		{
			return;
		}
		System.out.println(incNode.value);
		preOrder(incNode.left);
		preOrder(incNode.right);
	}
	public void add(int value)
	{
		root = add(root, value);
	}
	
	private SearchTreeNode add(SearchTreeNode node, int value)
	{
		if(node == null)
			node = new SearchTreeNode(value);
		else if(node.value > value)
		{
			node.right = add(node.right,value );
		}
		else if(node.value< value)
		{
			node.left = add(node.left,value);
		}
		return node;
		
	}
	
	public boolean contains(int value)
	{
		return contains(root,value);
	}
	private boolean contains(SearchTreeNode node, int value)
	{
		if(node == null)
			return false;
		if(value == node.value)
		{
			return true;
		}
		if(node.value > value)
		{
			return contains(node.right,value);
		}
		else if(node.value< value)
		{
			return contains(node.left,value);
		}
		return false;
	}
}
