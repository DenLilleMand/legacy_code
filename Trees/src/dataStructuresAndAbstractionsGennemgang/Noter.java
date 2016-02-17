package dataStructuresAndAbstractionsGennemgang;

public class Noter {
	/**
	 * Noter: While the roots of most plants are firmly in the ground, the root
	 * of an ADT tree is at the tree’s top; it is the origin of a hierarchical
	 * organization. Each node can have children. A node with children is a
	 * parent; a node without children is a leaf. The root is the only node that
	 * has no parent; all other nodes have one parent each
	 * 
	 * 
	 * In general, each node in a tree can have an arbitrary number of children.
	 * We sometimes call such a tree a general tree. If each node has no more
	 * than n children, the tree is called an n-ary tree. Realize that not every
	 * general tree is an n-ary tree. If each node has at most two children, the
	 * tree is called a binary tree.
	 * 
	 * All leaves in a full binary tree are on the same level and every nonleaf
	 * has exactly two children. A complete binary tree is full to its
	 * next-to-last level, and its leaves on the last level are filled from left
	 * to right. Binary trees are used extensively, and these special trees will
	 * be important to our later discussions.
	 * 
	 * brug til matematik: Now, if n is the number of nodes in a full tree, we
	 * have the following results: n = 2h - 1 2h = n + 1 h = log2 (n + 1) That
	 * is, the height of a full tree that has n nodes is log2 (n + 1). Der er
	 * mere om dette ovre i Test klassen.
	 * 
	 * Traversals: Note: Traversals of a binary tree A preorder traversal visits
	 * the root of a binary tree before visiting the nodes in its two subtrees.
	 * An inorder traversal visits the root between visiting the nodes in its
	 * two subtrees. A postorder traversal visits the root after visiting the
	 * nodes in its two subtrees. A level-order traversal visits nodes from left
	 * to right within each level of the tree, beginning with the root.
	 */
}
