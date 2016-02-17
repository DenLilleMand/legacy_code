package binaryTreeImplementation;

import interfaces.IBinaryTree;
/**Giver mere mening hvis vores */
public class BinaryTree<T extends Comparable<T>> implements IBinaryTree
{	
    private Node<T> root; 
    
 
    public BinaryTree() 
    { 
    	root = null; 
    } 
    
    /**
     * Okay, så når vi får et tal ind, så skal den automatisk sortere det,
     * man kan evt. give et hvilket som helst tal ind, og så afhængig af 
     * om det næste tal er højere eller lavere vil den så blive tilføjet
     * til højre eller venstre node. 
     * 
     * compareTo() metoden:
     * the value 0 if this Integer is equal to the argument Integer; 
     * a value less than 0 if this Integer is numerically less than
     *  the argument Integer; and a value greater than 0 if this Integer 
     *  is numerically  greater than the argument Integer (signed comparison).
     *  hvilket betyder at den returnere et tal under 0 hvis den er mindre end
     *  og returnere et højere tal hvis den er over. 
     * @param key
     * @throws Exception
     */
    public void insert(T key) throws Exception 
    { 
    	if(root == null)
    	{
    		root = new Node(key,null,null);
    	}
    	/** under over 0 (højre)  */
    	else if(key.compareTo(root.getKey()) > 0)
    	{
    		
    	}
    	/** under 0 (venstre)  */
    	else if(key.compareTo(root.getKey()) < 0)
    	{
    		
    	}
    	/** duplicate   */
    	else if(key.compareTo(root.getKey()) == 0)
    	{
    		throw new RuntimeException("Cannot have duplicate keys");
    	}
    }
    
    

    public void delete(T key) 
    {
    	
    }

     
    private boolean lookup(Node<T> n, T key) 
    {
        if (n == null) 
        {
            return false;
        }
        
        if (n.getKey().equals(key)) 
        {
            return true;
        }
        
        if (key.compareTo(n.getKey()) < 0) 
        {
            return lookup(n.getLeft(), key);
        }
        
        else 
        {
            return lookup(n.getRight(), key);
        }
    }
      

    public boolean lookup(T key) 
    { 
    	  return lookup(root, key);
    }

    /**
     * //print - left - right   
     * 60-20-10-40-30-50-70
     */
	@Override
	public void preOrder() 
	{
		
	}
	
	/**
	 * //left-right-print
		//10-30-50-40-20-70-60 
	 */
	@Override
	public void postOrder() 
	{	
		
	}
	
	/**
	 * 10-20-30-40-50-60-70
	 */
	@Override
	public void inorder() 
	{	
		
	}
}