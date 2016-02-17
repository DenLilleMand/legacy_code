package binaryTrees;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

import Tree.Position;
import Tree.Tree;

/**
 * Concrete implementation of a binary tree using a node-based, linked
 * structure.
 */
public class LinkedBinaryTree<E> implements Tree<E> {
	// ---------------- nested Node class ----------------
	protected static class Node<E> implements Position<E> {
		private E element; // an element stored at this node
		private Node<E> parent; // a reference to the parent node (if any)
		private Node<E> left; // a reference to the left child (if any)
		private Node<E> right; // a reference to the right child (if any)

		/** Constructs a node with the given element and neighbors. */
		public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
			element = e;
			parent = above;
			left = leftChild;
			right = rightChild;
		} // accessor methods

		public E getElement() {
			return element;
		}

		public Node<E> getParent() {
			return parent;
		}

		public Node<E> getLeft() {
			return left;
		}

		public Node<E> getRight() {
			return right;
		} // update methods

		public void setElement(E e) {
			element = e;
		}

		public void setParent(Node<E> parentNode) {
			parent = parentNode;
		}

		public void setLeft(Node<E> leftChild) {
			left = leftChild;
		}

		public void setRight(Node<E> rightChild) {
			right = rightChild;
		}
	} // ----------- end of nested Node class -----------

	/** Factory function to create a new node storing element e. */
	protected Node<E> createNode(E e, Node<E> parent, Node<E> left,
			Node<E> right) {
		return new Node<E>(e, parent, left, right);
	}

	// LinkedBinaryTree instance variables
	protected Node<E> root = null; // root of the tree
	private int size = 0; // number of nodes in the tree

	// constructor
	public LinkedBinaryTree() {
	} // constructs an empty binary tree
		// nonpublic utility

	/** Validates the position and returns it as a node. */
	protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
		if (!(p instanceof Node))
			throw new IllegalArgumentException("Not valid position type");
		Node<E> node = (Node<E>) p; // safe cast
		if (node.getParent() == node) // our convention for defunct node
			throw new IllegalArgumentException("p is no longer in the tree");
		return node;
	}

	// accessor methods (not already implemented in AbstractBinaryTree)
	/** Returns the number of nodes in the tree. */
	public int size() {
		return size;
	}

	/** Returns the root Position of the tree (or null if tree is empty). */
	public Position<E> root() {
		return root;
	}

	/** Returns the Position of p's parent (or null if p is root). */
	public Position<E> parent(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return node.getParent();
	}

	/** Returns the Position of p's left child (or null if no child exists). */
	public Position<E> left(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return node.getLeft();
	}

	/** Returns the Position of p's right child (or null if no child exists). */
	public Position<E> right(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return node.getRight();
	}

	// update methods supported by this class
	/**
	 * Places element e at the root of an empty tree and returns its new
	 * Position.
	 */
	public Position<E> addRoot(E e) throws IllegalStateException {
		if (!isEmpty())
			throw new IllegalStateException("Tree is not empty");
		root = createNode(e, null, null, null);
		size = 1;
		return root;
	}

	/**
	 * Creates a new left child of Position p storing element e; returns its
	 * Position.
	 */
	public Position<E> addLeft(Position<E> p, E e)
			throws IllegalArgumentException {
		Node<E> parent = validate(p);
		if (parent.getLeft() != null)
			throw new IllegalArgumentException("p already has a left child");
		Node<E> child = createNode(e, parent, null, null);
		parent.setLeft(child);
		size++;
		return child;
	}

	/**
	 * Creates a new right child of Position p storing element e; returns its
	 * Position.
	 */
	public Position<E> addRight(Position<E> p, E e)
			throws IllegalArgumentException {
		Node<E> parent = validate(p);
		if (parent.getRight() != null)
			throw new IllegalArgumentException("p already has a right child");
		Node<E> child = createNode(e, parent, null, null);
		parent.setRight(child);
		size++;
		return child;
	}

	/**
	 * Replaces the element at Position p with e and returns the replaced
	 * element.
	 */
	public E set(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> node = validate(p);
		E temp = node.getElement();
		node.setElement(e);
		return temp;
	}

	/** Attaches trees t1 and t2 as left and right subtrees of external p. */
	public void attach(Position<E> p, LinkedBinaryTree<E> t1,
			LinkedBinaryTree<E> t2) throws IllegalArgumentException {
		Node<E> node = validate(p);
		if (isInternal(p)) {
			throw new IllegalArgumentException("p must be a leaf");
		}
		size += t1.size() + t2.size();
		if (!t1.isEmpty()) { // attach t1 as left subtree of node
			t1.root.setParent(node);
			node.setLeft(t1.root);
			t1.root = null;
			t1.size = 0;
		}
		if (!t2.isEmpty()) { // attach t2 as right subtree of node
			t2.root.setParent(node);
			node.setRight(t2.root);
			t2.root = null;
			t2.size = 0;
		}
	}

	/** Removes the node at Position p and replaces it with its child, if any. */
	public E remove(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		if (numChildren(p) == 2)
			throw new IllegalArgumentException("p has two children");
		Node<E> child = (node.getLeft() != null ? node.getLeft() : node
				.getRight());
		if (child != null)
			child.setParent(node.getParent()); // child’s grandparent becomes
												// its parent
		if (node == root)
			root = child; // child becomes root
		else {
			Node<E> parent = node.getParent();
			if (node == parent.getLeft())
				parent.setLeft(child);
			else
				parent.setRight(child);
		}
		size--;
		E temp = node.getElement();
		node.setElement(null); // help garbage collection
		node.setLeft(null);
		node.setRight(null);
		node.setParent(node); // our convention for defunct node
		return temp;
	}

	@Override
	public Iterator<E> iterator() {
		return new ElementIterator();
	}

	// Method that returns a Iterable for either of the traversal algorhitms.
	@Override
	public Iterable<Position<E>> positions() {
		// return preorder();
		return postorder();
		// return inorder();
	}

	/**
	 * Preorder:
	 * 
	 * @return
	 */
	public Iterable<Position<E>> preorder() {
		ArrayList<Position<E>> snapshot = new ArrayList<>();
		if (!isEmpty()) {
			preorderSubtree(root(), snapshot); // fill the snapshot recursively
		}
		return snapshot;
	}

	private void preorderSubtree(Position<E> p, List<Position<E>> snapshot) {
		snapshot.add(p); // for preorder, we add position p before exploring
							// subtrees
		for (Position<E> c : children(p))
			preorderSubtree(c, snapshot);
	}
	
	
	private void preorderGeneralTreeStart()
	{
		preorderGeneralTree(root());
	}
	
	private void preorderGeneralTree(Node root, SearchNode node)
	{
		//definition af compareTo metoden =  
		//hvis Collections.equals metoden giver true, så returnere vi +.
		//hvis Hvis den er false, så laver vi vores egen metode som returnere true 
		//hvis vi er på det rette spor, det betyder at hvis vi har bare nogle som matcher.
		//fordi så bliver den vel fanget af vores int der tæller op automatisk?
		
		if(root.compareTo(node) == 0)
		{
			root.add(node);
		}
		else if(root.compareTo(node) == 1)
		{
			//fortsæt. Men hvad hvis den aldrig rammer et 0 ??.så skal den jo tilføjes
			//til den sidste node der var compatibel med. så man have en lokal variable,
			//der holder styr på 
		}
		else if(root.compareTo(node) == -1)
		{
			//kan vel ikke bare returne. Hvad hvis der slet ikke er noget der matcher?
			//Hvad er forbindelsen mellem hvilket niveau vi er på, og hvor mange
			//Emner der findes?... det er vel hvis. subjects.length >= level , og vi ikke har ramt 0
			//så skal vi tilføje noden hvorend vi er. Tror at man kan tælle level sammen med en local
			//int man giver med ind som parameter fra root af, som starter på 1 og ++ hvergang vi 
			//går rekursivt videre.
			return;
		}
		for(Node newNode : root.children())
		{
			preorderGeneralTree(newNode);
		}
	}

	/**
	 * Prints preorder representation of subtree of T rooted at p having depth
	 * d.
	 */
	public static <E> void printPreorderIndent(Tree<E> T, Position<E> p, int d) {
		System.out.println(spaces(2 * d) + p.getElement()); // indent based on d
		for (Position<E> c : T.children(p))
			printPreorderIndent(T, c, d + 1); // child depth is d+1
	}

	// postOrder:
	// ------------------------------------------------------------------------------------------------

	public Iterable<Position<E>> postorder() {
		List<Position<E>> snapshot = new ArrayList<>();
		if (!isEmpty())
			postorderSubtree(root(), snapshot); // fill the snapshot recursively
		return snapshot;
	}

	private void postorderSubtree(Position<E> p, List<Position<E>> snapshot) {
		for (Position<E> c : children(p))
			postorderSubtree(c, snapshot);
		snapshot.add(p); // for postorder, we add position p after exploring
							// subtrees
	}

	// Breadth First:
	// ------------------------------------------------------------------------------------------------

	/**
	 * Returns an iterable collection of positions of the tree in breadth-first
	 * order.
	 * 
	 * import LinkedQueue.
	 */
	public Iterable<Position<E>> breadthfirst() {
		List<Position<E>> snapshot = new ArrayList<>();
		if (!isEmpty()) {
			Queue<Position<E>> fringe = new LinkedQueue<>();
			fringe.enqueue(root()); // start with the root
			while (!fringe.isEmpty()) {
				Position<E> p = fringe.dequeue(); // remove from front of the
													// queue
				snapshot.add(p); // report this position
				for (Position<E> c : children(p))
					fringe.enqueue(c); // add children to back of queue
			}
		}
		return snapshot;
	}

	// inorder for binary tree!
	// ------------------------------------------------------------------------------------------------

	private void inorderSubtree(Position<E> p, List<Position<E>> snapshot) {
		if (left(p) != null)
			inorderSubtree(left(p), snapshot);
		snapshot.add(p);
		if (right(p) != null)
			inorderSubtree(right(p), snapshot);
	}

	public Iterable<Position<E>> inorder() {
		List<Position<E>> snapshot = new ArrayList<>();
		if (!isEmpty())
			inorderSubtree(root(), snapshot); // fill the snapshot recursively
		return snapshot;
	}

	// ------------------------------------------------------------------------------------------------

	public boolean isInternal(Position<E> p) {
		return numChildren(p) > 0;
	}

	public boolean isExternal(Position<E> p) {
		return numChildren(p) == 0;
	}

	public boolean isRoot(Position<E> p) {
		return p == root();
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	/** Returns the Position of p's sibling (or null if no sibling exists). */
	public Position<E> sibling(Position<E> p) {
		Position<E> parent = parent(p);
		if (parent == null)
			return null; // p must be the root
		if (p == left(parent)) // p is a left child
			return right(parent); // (right child might be null)
		else
			// p is a right child
			return left(parent); // (left child might be null)
	}

	/** Returns the number of children of Position p. */
	public int numChildren(Position<E> p) {
		int count = 0;
		if (left(p) != null)
			count++;
		if (right(p) != null)
			count++;
		return count;
	}

	/**
	 * Returns an iterable collection of the Positions representing p's
	 * children.
	 */
	public Iterable<Position<E>> children(Position<E> p) {
		List<Position<E>> snapshot = new ArrayList<>(2); // max capacity of 2
		if (left(p) != null)
			snapshot.add(left(p));
		if (right(p) != null)
			snapshot.add(right(p));
		return snapshot;
	}

	// ---------------- nested ElementIterator class ----------------
	/*
	 * This class adapts the iteration produced by positions() to return
	 * elements.
	 */
	private class ElementIterator implements Iterator<E> {
		Iterator<Position<E>> posIterator = positions().iterator();

		public boolean hasNext() {
			return posIterator.hasNext();
		}

		public E next() {
			return posIterator.next().getElement();
		} // return element!

		public void remove() {
			posIterator.remove();
		}
	}

}
