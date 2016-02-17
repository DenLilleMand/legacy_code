package builderPattern;

public interface Builder<T> 
{
	public T build();
	Tree buildTree(Builder<? extends Node> nodeBuilder) {...}
}

/**
 * Methods that take a Builder instance would
 * typically constrain the builder's type parameter
 * using a bounded wildcard type. For example, here is a 
 * method that builds a tree using a client-provided Builder
 * instance to build each node:
 * 
 *  man kan se buildTree metoden ovenfor.
 * 
**/

