package sorting;

public class Noter {
	/**
	 * Man sammenligner faktisk bare løbende talne med hinanden, dvs. at
	 * index[1] bliver sammenlignet med index[0] , index[2] bliver sammenlignet
	 * med både index[0] og index[1], index 3 bliver sammenlignet med index[0],
	 * index[1] og index[2], og hver gang den sammenligner, så rykker den alle
	 * dem alle sammen 1 gang. Jeg har på fornemmelsen at lige så snart tallet
	 * vi tjekker op imod de andre, finder en som er lavere end den, så har vi
	 * det index vi gerne vil indsætte den på , men nu får vi at se.
	 * 
	 * psedeu kode:
	 * 
	 * insertionsort(data[]) { for i = 1 to data.length–1 tmp = data[i]; move
	 * all elements data[j] greater than tmp by one position; place tmp in its
	 * proper position; }
	 * 
	 * An advantage of using insertion sort is that it sorts the array only when
	 * it is really necessary. If the array is already in order, no substantial
	 * moves are performed; only the variable tmp is initialized, and the value
	 * stored in it is moved back to the same position. The algorithm recognizes
	 * that part of the array is already sorted and stops execution accordingly.
	 * But it recognizes only this, and the fact that elements may already be in
	 * their proper positions is overlooked. Therefore, they can be moved from
	 * these positions and then later moved back. This happens to numbers 2 and
	 * 3 in the example in Figure 9.1. Another disadvantage is that if an item
	 * is being inserted, all elements greater than the one being inserted have
	 * to be moved. Insertion is not localized and may require moving a
	 * significant number of elements. Considering that an element can be moved
	 * from its final position only to be placed there again later, the number
	 * of redundant moves can slow down execution substantially. To find the
	 * number of movements and comparisons performed by insertionsort(), observe
	 * first that the outer for loop always performs n – 1 iterations, where n =
	 * data.length. However, the number of elements greater than data[i] to be
	 * moved by one position is not always the same. The best case is when the
	 * data are already in order. Only one comparison is made for each position
	 * i, so there are n – 1 comparisons, which is O(n), and 2(n – 1) moves, all
	 * of them redundant. The worst case is when the data are in reverse order.
	 * In this case, for each i, the item data[i] is less than every item
	 * data[0], . . . , data[i-1], and each of them is moved by one position.
	 * For each iteration i of the outer for loop, there are i comparisons, and
	 * the total number of comparisons for all iterations of this loop is n –1
	 * i=1 i = 1 + 2 + · · · + (n – 1) =  n(n 2 – 1) = O(n2) The number of
	 * times the assignment in the inner for loop is executed can be computed
	 * using the same formula. The number of times tmp is loaded and unloaded in
	 * the outer for loop is added to that, resulting in the total number of
	 * moves:  n (n 2 – 1) + 2(n – 1) =  n2 + 3 2 n – 4 = O(n2)
	 */
}
