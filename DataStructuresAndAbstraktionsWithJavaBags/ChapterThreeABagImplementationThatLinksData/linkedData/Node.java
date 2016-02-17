package linkedData;
/**
 * Because Node will be an inner class, the generic type T will be the same as the generic type
declared by the outer class that contains Node. Thus, we do not write <T> after Node. If, however,
Node was not an inner class but instead had package access or public access, you would write
Node<T>. In that case, Node would also require set and get methods for its data fields.
 * @author DenLilleMand
 *
 */
private class Node> {
	private T data; // entry in bag
	private Node next; // link to next node

	private Node(T dataPortion) {
		this(dataPortion, null);
	} // end constructor

	private Node(T dataPortion, Node nextNode) {
		data = dataPortion;
		next = nextNode;
	} // end constructor
} // end Node

