package queue.denNyeBog;

public class LinkedQueueNoter {
	/**
	 * Analyzing the Efficiency of a Linked Queue
Although we had not yet introduced asymptotic analysis when we presented our
SinglyLinkedList implementation in Chapter 3, it is clear upon reexamination that
each method of that class runs in O(1) worst-case time. Therefore, each method of
our LinkedQueue adaptation also runs in O(1) worst-case time.
We also avoid the need to specify a maximum size for the queue, as was done
in the array-based queue implementation. However, this benefit comes with some
expense. Because each node stores a next reference, in addition to the element
reference, a linked list uses more space per element than a properly sized array of
references.
Also, although all methods execute in constant time for both implementations,
it seems clear that the operations involving linked lists have a large number of
primitive operations per call. For example, adding an element to an array-based
queue consists primarily of calculating an index with modular arithmetic, storing
the element in the array cell, and incrementing the size counter. For a linked list,
an insertion includes the instantiation and initialization of a new node, relinking an
existing node to the new node, and incrementing the size counter. In practice, this
makes the linked-list method more expensive than the array-based method.
	 */
}
