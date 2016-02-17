package opg5.Trees.bogensEksempel;

public abstract class AbstractTree<E> implements Tree<E> {
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

	/**
	 * Returns the number of levels separating Position p from the root. Let p
	 * be a position within tree T. The depth of p is the number of ancestors of
	 * p, other than p itself. For example, in the tree of Figure 8.2, the node
	 * storing International has depth 2. Note that this definition implies that
	 * the depth of the root of T is 0. The depth of p can also be recursively
	 * defined as follows: • If p is the root, then the depth of p is 0. •
	 * Otherwise, the depth of p is one plus the depth of the parent of p. Based
	 * on this definition, we present a simple recursive algorithm, depth, in
	 * Code Fragment 8.3, for computing the depth of a position p in tree T.
	 * This method calls itself recursively on the parent of p, and adds 1 to
	 * the value returned. The running time of depth(p) for position p is O(dp
	 * +1), where dp denotes the depth of p in the tree, because the algorithm
	 * performs a constant-time recursive step for each ancestor of p. Thus,
	 * algorithm depth(p) runs in O(n) worst-case time, where n is the total
	 * number of positions of T, because a position of T may have depth n−1 if
	 * all nodes form a single branch. Although such a running time is a
	 * function of the input size, it is more informative to characterize the
	 * running time in terms of the parameter dp, as this parameter may be much
	 * smaller than n.
	 */
	public int depth(Position<E> p) {
		if (isRoot(p))
			return 0;
		else
			return 1 + depth(parent(p));
	}

	/**
	 * We next define the height of a tree to be equal to the maximum of the
	 * depths of its positions (or zero, if the tree is empty). For example, the
	 * tree of Figure 8.2 has height 4, as the node storing Africa (and its
	 * siblings) has depth 4. It is easy to see that the position with maximum
	 * depth must be a leaf. In Code Fragment 8.4, we present a method that
	 * computes the height of a tree based on this definition. Unfortunately,
	 * such an approach is not very efficient, and so name the algorithm
	 * heightBad and declare it as a private method of the AbstractTree class
	 * (so that it cannot be used by others). Returns the height of the tree:
	 * run time= 2 opløftet i n
	 */
	private int heightBad() { // works, but quadratic worst-case time
		int h = 0;
		for (Position<E> p : positions())
			if (isExternal(p)) // only consider leaf positions
				h = Math.max(h, depth(p));
		return h;
	}

	/**
	 * Returns the height of the subtree rooted at Position p. 'en algoritme der
	 * kører O(n) (linær tid). som man burde bruge i stedet for den anden.
	 * 
	 * Der er en forklaring på side 316 hvor der står hvad forskellen er på disse 2.
	 */
	public int height(Position<E> p) {
		int h = 0; // base case if p is external
		for (Position<E> c : children(p))
			h = Math.max(h, 1 + height(c));
		return h;
	}
}