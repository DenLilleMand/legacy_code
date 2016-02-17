package dataStructuresAndAbstractionsGennemgang;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinaryTree<T> implements BinaryTreeInterface<T> {
	private BinaryNodeInterface<T> root;

	public BinaryTree() {
		root = null;
	}

	public BinaryTree(T rootData) {
		root = new BinaryNode<T>(rootData);
	}

	public BinaryTree(T rootData, BinaryTree<T> leftTree,
			BinaryTree<T> rightTree) {
		privateSetTree(rootData, leftTree, rightTree);
	}

	public void setTree(T rootData) {
		root = new BinaryNode<T>(rootData);
	}

	public void setTree(T rootData, BinaryTreeInterface<T> leftTree,BinaryTreeInterface<T> rightTree) 
	{
		privateSetTree(rootData, (BinaryTree<T>) leftTree,
				(BinaryTree<T>) rightTree);
	}

	private void privateSetTree(T rootData, BinaryTree<T> leftTree,BinaryTree<T> rightTree) 
	{
		root = new BinaryNode<T>(rootData);
		if ((leftTree != null) && !leftTree.isEmpty())
		{
			root.setLeftChild(leftTree.root.copy());			
		}
		if ((rightTree != null) && !rightTree.isEmpty())
		{
			root.setRightChild(rightTree.root.copy());			
		}
	}

	@Override
	public T getRootData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumberOfNodes() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public Iterator<T> getPreorderIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> getPostorderIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> getInorderIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> getLevelOrderIterator() {
		// TODO Auto-generated method stub
		return null;
	}
}