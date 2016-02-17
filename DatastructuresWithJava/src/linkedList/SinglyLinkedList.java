package linkedList;

public class SinglyLinkedList<E> {
	
	/**
	 * Vi kan have en reference til både last node og head node. 
	 * så har vi adgang til begge ender af den linked list.
	 */
/**
 * Algorithm addFirst(e):
newest = Node(e) {create new node instance storing reference to element e}
newest.next = head {set new node’s next to reference the old head node}
head = newest {set variable head to reference the new node}
size = size+1 {increment the node count}
 */
public void addFirst(E element)
{
	
}

/**
 * Algorithm addLast(e):
newest = Node(e) {create new node instance storing reference to element e}
newest.next = null {set new node’s next to reference the null object}
tail.next = newest {make old tail node point to new node}
tail = newest {set variable tail to reference the new node}
size = size+1 {increment the node count}
 * @param element
 */
public void addLast(E element)
{
	
}


/**
 * Algorithm removeFirst( ):
if head == null then
the list is empty.
head = head.next {make head point to next node (or null)}
size = size−1 {decrement the node count}


Noter omkring at fjerne den sidste node, selvom vi har en reference(tl;dr; vi har brug for en doubley
linkedList.):
Unfortunately, we cannot easily delete the last node of a singly linked list. Even
if we maintain a tail reference directly to the last node of the list, we must be able
to access the node before the last node in order to remove the last node. But we
cannot reach the node before the tail by following next links from the tail. The only
way to access this node is to start from the head of the list and search all the way
through the list. But such a sequence of link-hopping operations could take a long
time. If we want to support such an operation efficiently, we will need to make our
list doubly linked
 * @param element
 */
public void removeFirst(E element)
{
	
}
	
}
