package stack;

public class StackWithLinkedListNoter {
	/**
	 * The Adapter Pattern
The adapter design pattern applies to any context where we effectively want to
modify an existing class so that its methods match those of a related, but different,
class or interface. One general way to apply the adapter pattern is to define a new
class in such a way that it contains an instance of the existing class as a hidden
field, and then to implement each method of the new class using methods of this
hidden instance variable. By applying the adapter pattern in this way, we have
created a new class that performs some of the same functions as an existing class,
but repackaged in a more convenient way.
In the context of the stack ADT, we can adapt our SinglyLinkedList class of
Section 3.2.1 to define a new LinkedStack class, shown in Code Fragment 6.4.
This class declares a SinglyLinkedList named list as a private field, and uses the
following correspondences:
Stack Method Singly Linked List Method
size( ) list.size( )
isEmpty( ) list.isEmpty( )
push(e) list.addFirst(e)
pop( ) list.removeFirst( )
top( ) list.first( )
	 */
}
