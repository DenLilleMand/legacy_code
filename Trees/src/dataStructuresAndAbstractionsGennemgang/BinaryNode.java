package dataStructuresAndAbstractionsGennemgang;

class BinaryNode<T> implements BinaryNodeInterface<T> 
{
	private T data;
	private BinaryNode<T> left;
	private BinaryNode<T> right;

	public BinaryNode() 
	{
		this(null); 
	} 

	public BinaryNode(T dataPortion) 
	{
		this(dataPortion, null, null); 
	}

	public BinaryNode(T dataPortion, BinaryNode<T> leftChild, BinaryNode<T> rightChild) 
	{
		data = dataPortion;
		left = leftChild;
		right = rightChild;
	} 

	public T getData() 
	{
		return data;
	} 

	public void setData(T newData) 
	{
		data = newData;
	} 

	public BinaryNodeInterface<T> getLeftChild() 
	{
		return left;
	} 

	public void setLeftChild(BinaryNodeInterface<T> leftChild) 
	{
		left = (BinaryNode<T>) leftChild;
	} 

	public boolean hasLeftChild() 
	{
		return left != null;
	} 

	public boolean isLeaf() 
	{
		return (left == null) && (right == null);
	} 

	@Override
	public BinaryNodeInterface<T> getRightChild() 
	{
		return null;
	}

	@Override
	public void setRightChild(BinaryNodeInterface<T> rightChild) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean hasRightChild() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getNumberOfNodes() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public BinaryNodeInterface<T> copy() 
	{
		BinaryNode<T> newRoot = new BinaryNode<T>(data);
		if (left != null)
		{
			newRoot.left = (BinaryNode<T>) left.copy();			
		}
		if (right != null)
		{
			newRoot.right = (BinaryNode<T>) right.copy();			
		}
		return newRoot;
	} 
}