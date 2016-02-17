package treeTraversalAlgorithms;

public class Noter {
	/** Disse er for begge general trees og binære (tror jeg)
	 * men der er en bestemt Inorder der bliver forklaret nederst (+ på side 337) , som har med binære
	 * træer(only) at gøre.
	 * 
	 * 
	 * tl;dr -Preorder printer ud på vejen nedad, og kører ud i alle børnene før
	 * den går tilbage. og tager endnu et barn.
	 *
	 * -PostOrder kører rekursivt igennem det hele, og så når tingne returner
	 * bliver de printet ud, det betyder at vi får en print nede fra det
	 * nederste barn først helt ude til venstre.
	 * 
	 * 
	 * I Eksamens tid= tjek nederst side 334 for at se præcist hvordan den
	 * traverser Preorder, og for Inorder så kig på side 335.
	 * 
	 * PreOrder: Starter på side 334. 8.4.1 Preorder and Postorder Traversals of
	 * General Trees In a preorder traversal of a tree T, the root of T is
	 * visited first and then the subtrees rooted at its children are traversed
	 * recursively. If the tree is ordered, then the subtrees are traversed
	 * according to the order of the children. The pseudocode for the preorder
	 * traversal of the subtree rooted at a position p is shown in Code Fragment
	 * 8.12. Algorithm preorder(p): perform the “visit” action for position p {
	 * this happens before any recursion } for each child c in children(p) do
	 * preorder(c) { recursively traverse the subtree rooted at c } Code
	 * Fragment 8.12: Algorithm preorder for performing the preorder traversal
	 * of a subtree rooted at position p of a tree. Figure 8.13 portrays the
	 * order in which positions of a sample tree are visited during an
	 * application of the preorder traversal algorithm.
	 * 
	 * 
	 * 
	 * 
	 * 
	 * Postorder Traversal: Another important tree traversal algorithm is the
	 * postorder traversal. In some sense, this algorithm can be viewed as the
	 * opposite of the preorder traversal, because it recursively traverses the
	 * subtrees rooted at the children of the root first, and then visits the
	 * root (hence, the name “postorder”). Pseudocode for the postorder
	 * traversal is given in Code Fragment 8.13, and an example of a postorder
	 * traversal is portrayed in Figure 8.14. Algorithm postorder(p): for each
	 * child c in children(p) do postorder(c) { recursively traverse the subtree
	 * rooted at c } perform the “visit” action for position p { this happens
	 * after any recursion } Code Fragment 8.13: Algorithm postorder for
	 * performing the postorder traversal of a subtree rooted at position p of a
	 * tree.
	 * 
	 * 
	 * 
	 * 
	 * Running-Time Analysis Both preorder and postorder traversal algorithms
	 * are efficient ways to access all the positions of a tree. The analysis of
	 * either of these traversal algorithms is similar to that of algorithm
	 * height, given in Code Fragment 8.5 of Section 8.1.3. At each position p,
	 * the nonrecursive part of the traversal algorithm requires time O(cp+1),
	 * where cp is the number of children of p, under the assumption that the
	 * “visit” itself takes O(1) time. By Proposition 8.4, the overall running
	 * time for the traversal of tree T is O(n), where n is the number of
	 * positions in the tree. This running time is asymptotically optimal since
	 * the traversal must visit all n positions of the tree.
	 * 
	 * 
	 * 8.4.2 Breadth-First Tree Traversal Although the preorder and postorder
	 * traversals are common ways of visiting the positions of a tree, another
	 * approach is to traverse a tree so that we visit all the positions at
	 * depth d before we visit the positions at depth d+1. Such an algorithm is
	 * known as a breadth-first traversal. A breadth-first traversal is a common
	 * approach used in software for playing games. A game tree represents the
	 * possible choices of moves that might be made by a player (or computer)
	 * during a game, with the root of the tree being the initial configuration
	 * for the game. For example, Figure 8.15 displays a partial game tree for
	 * Tic-Tac-Toe.
	 * 
	 * 
	 * A breadth-first traversal of such a game tree(side 336) is often
	 * performed because a computer may be unable to explore a complete game
	 * tree in a limited amount of time. So the computer will consider all
	 * moves, then responses to those moves, going as deep as computational time
	 * allows. Pseudocode for a breadth-first traversal is given in Code
	 * Fragment 8.14. The process is not recursive, since we are not traversing
	 * entire subtrees at once. We use a queue to produce a FIFO (i.e., first-in
	 * first-out) semantics for the order in which we visit nodes. The overall
	 * running time is O(n), due to the n calls to enqueue and n calls to
	 * dequeue. Algorithm breadthfirst( ): Initialize queue Q to contain root( )
	 * while Q not empty do p = Q.dequeue( ) { p is the oldest entry in the
	 * queue } perform the “visit” action for position p for each child c in
	 * children(p) do Q.enqueue(c) { add p’s children to the end of the queue
	 * for later visits }
	 * 
	 * 
	 * 
	 * 
	 * Inorder Traversal of a Binary Tree The standard preorder, postorder, and
	 * breadth-first traversals that were introduced for general trees can be
	 * directly applied to binary trees. In this section, we will introduce
	 * another common traversal algorithm specifically for a binary tree. During
	 * an inorder traversal, we visit a position between the recursive
	 * traversals of its left and right subtrees. The inorder traversal of a
	 * binary tree T can be informally viewed as visiting the nodes of T “from
	 * left to right.” Indeed, for every position p, the inorder traversal
	 * visits p after all the positions in the left subtree of p and before all
	 * the positions in the right subtree of p. Pseudocode for the inorder
	 * traversal algorithm is given in Code Fragment 8.15, and an example of an
	 * inorder traversal is portrayed in Figure 8.16. Algorithm inorder(p): if p
	 * has a left child lc then inorder(lc) { recursively traverse the left
	 * subtree of p } perform the “visit” action for position p if p has a right
	 * child rc then inorder(rc) { recursively traverse the right subtree of p }
	 * Code Fragment 8.15: Algorithm inorder for performing an inorder traversal
	 * of a subtree rooted at position p of a binary tree.
	 */
}
