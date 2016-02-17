package linkedLists;
/**
 * Hvad man kan bruge sådan en her LinkedList implementation til:
 * A round-robin scheduler(En evt. løsning på at alle processor
 * på en computer skal have lige meget tid.) could be implemented with a traditional linked list, by
repeatedly performing the following steps on linked list L (see Figure 3.15):
1. process p = L.removeFirst( )
2. Give a time slice to process p
3. L.addLast(p)

Det er dog en implementation med mange unødvendige operationer, så 
der er en anden løsning på at implementere en rund LinkedList, ved at ændre et par ting på klassen.
Kan se de ting der er ændret i RoundLinkedList klassen. 
 * @author denlillemand
 *
 * @param <E>
 */
public class SinglyLinkedList<E> 
{
	// instance variables of the SinglyLinkedList
	private Node<E> head = null; // head node of the list (or null if empty)
	private Node<E> tail = null; // last node of the list (or null if empty)
	private int size = 0; // number of nodes in the list

	public SinglyLinkedList() {
	} // constructs an initially empty list

	// access methods
	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E first() { // returns (but does not remove) the first element
		if (isEmpty())
			return null;
		return head.getElement();
	}

	public E last() {
		if (isEmpty())
			return null;
		return tail.getElement();
	}

	public void addFirst(E e) {
		head = new Node<>(e, head);
		if (size == 0)
			tail = head;
		size++;
	}

	public void addLast(E e) {
		Node<E> newest = new Node<>(e, null);
		if (isEmpty())
			head = newest;
		else
			tail.setNext(newest);
		tail = newest;
		size++;
	}

	public E removeFirst() {
		if (isEmpty()) {
			return null;
		}
		E answer = head.getElement();
		head = head.getNext();
		size--;
		if (size == 0) {
			tail = null;
		}
		return answer;
	}
	
	private static class Node<E> 
	{
		private E element; // reference to the element stored at this node
		private Node<E> next; // reference to the subsequent node in the list

		public Node(E e, Node<E> n) {
			element = e;
			next = n;
		}

		public E getElement() {
			return element;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> n) {
			next = n;
		}
	}
}
