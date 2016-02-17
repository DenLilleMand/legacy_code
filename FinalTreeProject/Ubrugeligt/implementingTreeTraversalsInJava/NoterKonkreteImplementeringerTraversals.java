package implementingTreeTraversalsInJava;

public class NoterKonkreteImplementeringerTraversals {
	/**
	 * PostOrder: Postorder Traversal We implement a postorder traversal using a
	 * similar design as we used for a preorder traversal. The only difference
	 * is that a “visited” position is not added to a postorder snapshot until
	 * after all of its subtrees have been traversed. Both the recursive utility
	 * and the top-level public method are given in Code Fragment 8.20.
	 * 
	 * 
	 * 
	 * Breadth-First Traversal On the following page, we will provide an
	 * implementation of the breadth-first traversal algorithm in the context of
	 * our AbstractTree class (Code Fragment 8.21). Recall that the
	 * breadth-first traversal algorithm is not recursive; it relies on a queue
	 * of positions to manage the traversal process. We will use the LinkedQueue
	 * class from Section 6.2.3, although any implementation of the queue ADT
	 * would suffice.
	 * 
	 * 
	 * Preorder Traversals We begin by considering the preorder traversal
	 * algorithm. Our goal is to provide a public method preorder( ), as part of
	 * the AbstractTree class, which returns an iterable container of the
	 * positions of the tree in preorder. For ease of implementation, we choose
	 * to produce a snapshot iterator, as defined in Section 7.4.2, returning a
	 * list of all positions. (Exercise C-8.47 explores the goal of implementing
	 * a lazy iterator that reports positions in preorder.) We begin by defining
	 * a private utility method, preorderSubtree, given in Code Fragment 8.18,
	 * which allows us to parameterize the recursive process with a specific
	 * position of the tree that serves as the root of a subtree to traverse.
	 * (We also pass a list as a parameter that serves as a buffer to which
	 * “visited” positions are added.)
	 * 
	 * Code Fragment 8.18: A recursive subroutine for performing a preorder
	 * traversal of the subtree rooted at position p of a tree. This code should
	 * be included within the body of the AbstractTree class. The
	 * preorderSubtree method follows the high-level algorithm originally
	 * described as pseudocode in Code Fragment 8.12. It has an implicit base
	 * case, as the for loop body never executes if a position has no children.
	 * The public preorder method, shown in Code Fragment 8.19, has the
	 * responsibility of creating an empty list for the snapshot buffer, and
	 * invoking the recursive method at the root of the tree (assuming the tree
	 * is nonempty). We rely on a java.util.ArrayList instance as an Iterable
	 * instance for the snapshot buffer.
	 * 
	 * Code Fragment 8.19: A public method that performs a preorder traversal of
	 * an entire tree. This code should be included within the body of the
	 * AbstractTree class.
	 */
}
