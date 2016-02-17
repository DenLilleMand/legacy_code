package binarySearchTree;

public class NoterJavaImplementation {
	/**
	 * Java Implementation In Code Fragments 11.3 through 11.6 we define a
	 * TreeMap class that implements the sorted map ADT while using a binary
	 * search tree for storage. The TreeMap class is declared as a child of the
	 * AbstractSortedMap base class, thereby inheriting support for performing
	 * comparisons based upon a given (or default) Comparator, a nested MapEntry
	 * class for storing key-value pairs, and concrete implementations of
	 * methods keySet and values based upon the entrySet method, which we will
	 * provide. (See Figure 10.2 on page 406 for an overview of our entire map
	 * hierarchy.) For representing the tree structure, our TreeMap class
	 * maintains an instance of a subclass of the LinkedBinaryTree class from
	 * Section 8.3.1. In this implementation, we choose to represent the search
	 * tree as a proper binary tree, with explicit leaf nodes in the binary tree
	 * as sentinels, and map entries stored only at internal nodes. (We leave
	 * the task of a more space-efficient implementation to Exercise P-11.55.)
	 * The TreeSearch algorithm of Code Fragment 11.1 is implemented as a
	 * private recursive method, treeSearch(p, k). That method either returns a
	 * position with an entry equal to key k, or else the last position that is
	 * visited on the search path. The method is not only used for all of the
	 * primary map operations, get(k), put(k, v), and remove(k), but for most of
	 * the sorted map methods, as the final internal position visited during an
	 * unsuccessful search has either the greatest key less than k or the least
	 * key greater than k. Finally, we note that our TreeMap class is designed
	 * so that it can be subclassed to implement various forms of balanced
	 * search trees. We discuss the balancing framework more thoroughly in
	 * Section 11.2, but there are two aspects of the design that impact the
	 * code presented in this section. First, our tree member is technically
	 * declared as an instance of a BalanceableBinaryTree class, which is a
	 * specialization of the LinkedBinaryTree class; however, we rely only on
	 * the inherited behaviors in this section. Second, our code is peppered
	 * with calls to presumed methods named rebalanceAccess, rebalanceInsert,
	 * and rebalanceDelete; these methods do not do anything in this class, but
	 * they serve as hooks that can later be customized. We conclude with a
	 * brief guide to the organization of our code.
	 */
}
