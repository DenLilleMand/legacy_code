package binarySearchTree;

public class NoterSearching {
	/**
	 * Searching in a binary tree: Searching Within a Binary Search Tree The
	 * most important consequence of the structural property of a binary search
	 * tree is its namesake search algorithm. We can attempt to locate a
	 * particular key in a binary search tree by viewing it as a decision tree
	 * (recall Figure 8.5). In this case, the question asked at each internal
	 * position p is whether the desired key k is less than, equal to, or
	 * greater than the key stored at position p, which we denote as key(p). If
	 * the answer is “less than,” then the search continues in the left subtree.
	 * If the answer is “equal,” then the search terminates successfully. If the
	 * answer is “greater than,” then the search continues in the right subtree.
	 * Finally, if we reach a leaf, then the search terminates unsuccessfully.
	 * (See Figure 11.2.)
	 * 
	 * 
	 * We describe this approach in Code Fragment 11.1. If key k occurs in a
	 * subtree rooted at p, a call to TreeSearch(p, k) results in the position
	 * at which the key is found. For an unsuccessful search, the TreeSearch
	 * algorithm returns the final leaf explored on the search path (which we
	 * will later make use of when determining where to insert a new entry in a
	 * search tree). Algorithm TreeSearch(p, k): if p is external then return p
	 * {unsuccessful search} else if k == key(p) then return p {successful
	 * search} else if k < key(p) then return TreeSearch(left(p), k) {recur on
	 * left subtree} else {we know that k > key(p)} return TreeSearch(right(p),
	 * k) {recur on right subtree} Code Fragment 11.1: Recursive search in a
	 * binary search tree.
	 * 
	 * Side 462:
	 *  Analysis of Binary Tree Searching The analysis of the
	 * worst-case running time of searching in a binary search tree T is simple.
	 * Algorithm TreeSearch is recursive and executes a constant number of
	 * primitive operations for each recursive call. Each recursive call of
	 * TreeSearch is made on a child of the previous position. That is,
	 * TreeSearch is called on the positions of a path of T that starts at the
	 * root and goes down one level at a time. Thus, the number of such
	 * positions is bounded by h+1, where h is the height of T. In other words,
	 * since we spend O(1) time per position encountered in the search, the
	 * overall search runs in O(h) time, where h is the height of the binary
	 * search tree T. (See Figure 11.3.)
	 * 
	 * Figure 11.3: Illustrating the running time of searching in a binary search tree. The
figure uses a standard visualization shortcut of a binary search tree as a big triangle
and a path from the root as a zig-zag line.
In the context of the sorted map ADT, the search will be used as a subroutine
for implementing the get method, as well as for the put and remove methods, since
each of these begins by trying to locate an existing entry with the given key. We
will later demonstrate how to implement sorted map operations, such as lowerEntry
and higherEntry, by navigating within the tree after performing a standard search.
All of these operations will run in worst-case O(h) time for a tree with height h.
Admittedly, the height h of T can be as large as the number of entries, n, but we
expect that it is usually much smaller. Later in this chapter we will show various
strategies to maintain an upper bound of O(logn) on the height of a search tree T.
	 */
}
