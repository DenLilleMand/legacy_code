package stack;

public class StacksNoter {
	/**
	 * Because of the importance of the stack ADT, Java has included, since its original
version, a concrete class named java.util.Stack that implements the LIFO semantics
of a stack. However, Java’s Stack class remains only for historic reasons, and
its interface is not consistent with most other data structures in the Java library.
In fact, the current documentation for the Stack class recommends that it not be
used, as LIFO functionality (and more) is provided by a more general data structure
known as a double-ended queue (which we describe in Section 6.3).
For the sake of comparison, Table 6.1 provides a side-by-side comparison of
the interface for our stack ADT and the java.util.Stack class. In addition to
some differences in method names, we note that methods pop and peek of the
java.util.Stack class throw a custom EmptyStackException if called when the stack
is empty (whereas null is returned in our abstraction).



The array implementation of a stack is simple and efficient. Nevertheless, this
implementation has one negative aspect—it relies on a fixed-capacity array, which
limits the ultimate size of the stack.
For convenience, we allow the user of a stack to specify the capacity as a parameter
to the constructor (and offer a default constructor that uses capacity of
1,000). In cases where a user has a good estimate on the number of items needing
to go in the stack, the array-based implementation is hard to beat. However, if the
estimate is wrong, there can be grave consequences. If the application needs much
less space than the reserved capacity, memory is wasted. Worse yet, if an attempt
is made to push an item onto a stack that has already reached its maximum capacity,
the implementation of Code Fragment 6.2 throws an IllegalStateException,
refusing to store the new element. Thus, even with its simplicity and efficiency, the
array-based stack implementation is not necessarily ideal.
Fortunately, we will later demonstrate two approaches for implementing a stack
without such a size limitation and with space always proportional to the actual number
of elements stored in the stack. One approach, given in the next subsection uses
a singly linked list for storage; in Section 7.2.1, we will provide a more advanced
array-based approach that overcomes the limit of a fixed capacity.


Analyzing the Array-Based Stack Implementation
The correctness of the methods in the array-based implementation follows from
our definition of index t. Note well that when pushing an element, t is incremented
before placing the new element, so that it uses the first available cell.
Table 6.2 shows the running times for methods of this array-based stack implementation.
Each method executes a constant number of statements involving
arithmetic operations, comparisons, and assignments, or calls to size and isEmpty,
which both run in constant time. Thus, in this implementation of the stack ADT,
each method runs in constant time, that is, they each run in O(1) time.
Method Running Time:
size O(1)
isEmpty O(1)
top O(1)
push O(1)
pop O(1)
Table 6.2: Performance of a stack realized by an array. The space usage is O(N),
where N is the size of the array, determined at the time the stack is instantiated, and
independent from the number n ≤ N of elements that are actually in the stack.
	 */
}
