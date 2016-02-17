package binarySearchTreeFinal;

public class BinarySearchTree {
	class Node 
	{
		protected Comparable el;
		protected Node left, right;

		public Node() {
			left = right = null;
		}

		public Node(Comparable el) {
			this(el, null, null);
		}

		public Node(Comparable el, Node lt, Node rt) {
			this.el = el;
			left = lt;
			right = rt;
		}
	}

	protected Node root = null;

	public BinarySearchTree() {
	}

	public Comparable search(Comparable el) {
		return search(root, el);
	}

	protected Comparable search(Node p, Comparable el) {
		while (p != null)
			if (el.equals(p.el))
				return p.el;
			else if (p.el.compareTo(el) < 0)
				p = p.right;
			else
				p = p.left;
		return null;
	}

	public void insert(Comparable el) 
	{
		Node node = root, prev = null;
		while (node != null) { //Hvis man lækker nøje mærke til det her while loop, så fungere det nærmest rekursivt.
			prev = node;

			if (node.el.compareTo(el) < 0)
			{
				node = node.right;				
			}
			else
			{
				node = node.left;				
			}
		}
		if (root == null) // tree is empty;
		{
			root = new Node(el);			
		}
		else if (prev.el.compareTo(el) < 0)
		{
			prev.right = new Node(el);			
		}
		else
		{
			prev.left = new Node(el);			
		}
	}

	protected void visit(Node p) {
		System.out.print(p.el + " ");
	}

	public void inorder() {
		inorder(root);
	}

	protected void inorder(Node p) {
		if (p != null) {
			inorder(p.left);
			visit(p);
			inorder(p.right);
		}
	}

}
