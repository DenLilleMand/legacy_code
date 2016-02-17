package binarySearchTree;

public class NoterInsertionsDeletions {
	/**At læse specielt om deletions  på side 464/465(billed) ville gavne meget i forberedelsen,
	 * fordi deletions er det sværeste i binære træer. 
	 * 
	 * 
	 * 
	 * 
	 * 11.1.2 Insertions and Deletions Binary search trees: allow
	 * implementations of the put and remove operations using algorithms that
	 * are fairly straightforward, although not trivial. Insertion The map
	 * operation put(k, v) begins with a search for an entry with key k. If
	 * found, that entry’s existing value is reassigned. Otherwise, the new
	 * entry can be inserted into the underlying tree by expanding the leaf that
	 * was reached at the end of the failed search into an internal node. The
	 * binary search-tree property is sustained by that placement (note that it
	 * is placed exactly where a search would expect it). Let us assume a proper
	 * binary tree supports the following update operation: expandExternal(p,
	 * e): Stores entry e at the external position p, and expands p to be
	 * internal, having two new leaves as children. We can then describe the
	 * TreeInsert algorithm with the pseudocode given in in Code Fragment 11.2.
	 * An example of insertion into a binary search tree is shown in Figure
	 * 11.4. Algorithm TreeInsert(k, v): Input: A search key k to be associated
	 * with value v p = TreeSearch(root( ), k) if k == key(p) then Change p’s
	 * value to (v) else expandExternal(p, (k,v)) Code Fragment 11.2: Algorithm
	 * for inserting a key-value pair into a map that is represented as a binary
	 * search tree.
	 * 
	 * 464: Deletion Deleting an entry from a binary search tree is a bit more
	 * complex than inserting a new entry because the position of an entry to be
	 * deleted might be anywhere in the tree (as opposed to insertions, which
	 * always occur at a leaf). To delete an entry with key k, we begin by
	 * calling TreeSearch(root( ), k) to find the position p storing an entry
	 * with key equal to k (if any). If the search returns an external node,
	 * then there is no entry to remove. Otherwise, we distinguish between two
	 * cases (of increasing difficulty): • If at most one of the children of
	 * position p is internal, the deletion of the entry at position p is easily
	 * implemented (see Figure 11.5). Let position r be a child of p that is
	 * internal (or an arbitrary child, if both are leaves). We will remove p
	 * and the leaf that is r’s sibling, while promoting r upward to take the
	 * place of p. We note that all remaining ancestor-descendant relationships
	 * that remain in the tree after the operation existed before the operation;
	 * therefore, the binary search-tree property is maintained. • If position p
	 * has two children, we cannot simply remove the node from the tree since
	 * this would create a “hole” and two orphaned children. Instead, we proceed
	 * as follows (see Figure 11.6): ◦ We locate position r containing the entry
	 * having the greatest key that is strictly less than that of position p
	 * (its so-called predecessor in the ordering of keys). That predecessor
	 * will always be located in the rightmost internal position of the left
	 * subtree of position p. ◦ We use r’s entry as a replacement for the one
	 * being deleted at position p. Because r has the immediately preceding key
	 * in the map, any entries in p’s right subtree will have keys greater than
	 * r and any other entries in p’s left subtree will have keys less than r.
	 * Therefore, the binary search-tree property is satisfied after the
	 * replacement. ◦ Having used r’s entry as a replacement for p, we instead
	 * delete the node at position r from the tree. Fortunately, since r was
	 * located as the rightmost internal position in a subtree, r does not have
	 * an internal right child. Therefore, its deletion can be performed using
	 * the first (and simpler) approach. As with searching and insertion, this
	 * algorithm for a deletion involves the traversal of a single path downward
	 * from the root, possibly moving an entry between two positions of this
	 * path, and removing a node from that path and promoting its child.
	 * Therefore, it executes in time O(h) where h is the height of the tree.
	 */
}
