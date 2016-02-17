package binaryTreeImplementation;

class Node<T> 
{
    private T key;
    private Node<T> left, right;
 
    public Node(T key, Node<T> left, Node<T> right) 
    {
        this.key = key;
        this.left = left;
        this.right = right;
    }
    
    /**Brug for en metode der via rekursion, går alle nodes igennem 
     * og ser hvor vores key hører til.
     * 
     *  Hvilke muligheder er der her, vi skal have tjekket 
     *  højre og venstre Node. og så skal vi have 
     *  */
    
    public Node<T> returnCorrectNode()
    {
    	Node<T> correctNode = null;
//    	/** under over 0 (højre)  */
//    	if(key.compareTo(key > 0)
//    	{
//    		
//    	}
//    	/** under 0 (venstre)  */
//    	else if(key.compareTo(getKey()) < 0)
//    	{
//    		
//    	}
//    	/** duplicate   */
//    	else if(key.compareTo(key == 0)
//    	{
//    		throw new RuntimeException("Cannot have duplicate keys");
//    	}
		return correctNode;
    }
    
    public T getKey() 
    {
    	return key; 
    }
    public Node<T> getLeft() 
    { 
    	return left; 
    }
    public Node<T> getRight() 
    { 
    	return right; 
    }
 
    public void setKey(T newK) 
    { 
    	key = newK; 
    }
    
    public void setLeft(Node<T> newL) 
    { 
    	left = newL; 
    }
    
    public void setRight(Node<T> newR) 
    { 
    	right = newR; 
    }
}