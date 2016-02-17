package queue.denNyeBog;

public class Noter {
	/**
	 * Another fundamental data structure is the queue. It is a close “cousin” of the stack,
but a queue is a collection of objects that are inserted and removed according to the
first-in, first-out (FIFO) principle. That is, elements can be inserted at any time,
but only the element that has been in the queue the longest can be next removed.
We usually say that elements enter a queue at the back and are removed from
the front. A metaphor for this terminology is a line of people waiting to get on an
amusement park ride. People waiting for such a ride enter at the back of the line
and get on the ride from the front of the line. There are many other applications
of queues (see Figure 6.4). Stores, theaters, reservation centers, and other similar
services typically process customer requests according to the FIFO principle. A
queue would therefore be a logical choice for a data structure to handle calls to a
customer service center, or a wait-list at a restaurant. FIFO queues are also used by
many computing devices, such as a networked printer, or a Web server responding
to requests.


The Queue Abstract Data Type
Formally, the queue abstract data type defines a collection that keeps objects in a
sequence, where element access and deletion are restricted to the first element in
the queue, and element insertion is restricted to the back of the sequence. This
restriction enforces the rule that items are inserted and deleted in a queue according
to the first-in, first-out (FIFO) principle. The queue abstract data type (ADT)
supports the following two update methods:
enqueue(e): Adds element e to the back of queue.
dequeue( ): Removes and returns the first element from the queue
(or null if the queue is empty).
The queue ADT also includes the following accessor methods (with first being
analogous to the stack’s top method):
first( ): Returns the first element of the queue, without removing it
(or null if the queue is empty).
size( ): Returns the number of elements in the queue.
isEmpty( ): Returns a boolean indicating whether the queue is empty.
By convention, we assume that elements added to the queue can have arbitrary
type and that a newly created queue is empty. We formalize the queue ADT with
the Java interface shown in Code Fragment 6.9.


The java.util.Queue Interface in Java
Java provides a type of queue interface, java.util.Queue, which has functionality
similar to the traditional queue ADT, given above, but the documentation for the
java.util.Queue interface does not insist that it support only the FIFO principle.
When supporting the FIFO principle, the methods of the java.util.Queue interface
have the equivalences with the queue ADT shown in Table 6.3.
The java.util.Queue interface supports two styles for most operations, which
vary in the way that they treat exceptional cases. When a queue is empty, the
remove( ) and element( ) methods throw a NoSuchElementException, while the
corresponding methods poll( ) and peek( ) return null. For implementations with a
bounded capacity, the add method will throw an IllegalStateException when full,
while the offer method ignores the new element and returns false to signal that the
element was not accepted.
Skal kigge på side (pdf) 240, for at se en tabel over hvilke interfaces/metoder
der gør hvad, der er nemlig nogle som smider exceptions, og andre som returnere null i special cases.



Array-Based Queue Implementation
In Section 6.1.2, we implemented the LIFO semantics of the Stack ADT using an
array (albeit, with a fixed capacity), such that every operation executes in constant
time. In this section, we will consider how to use an array to efficiently support the
FIFO semantics of the Queue ADT.
Let’s assume that as elements are inserted into a queue, we store them in an
array such that the first element is at index 0, the second element at index 1, and so
on. (See Figure 6.5.)
0
A B C D E F G K L M
1 2 N−1
data:
Figure 6.5: Using an array to store elements of a queue, such that the first element
inserted, “A”, is at cell 0, the second element inserted, “B”, at cell 1, and so on.
With such a convention, the question is how we should implement the dequeue
operation. The element to be removed is stored at index 0 of the array. One strategy
is to execute a loop to shift all other elements of the queue one cell to the left, so that
the front of the queue is again aligned with cell 0 of the array. Unfortunately, the
use of such a loop would result in an O(n) running time for the dequeue method.
We can improve on the above strategy by avoiding the loop entirely. We will
replace a dequeued element in the array with a null reference, and maintain an
explicit variable f to represent the index of the element that is currently at the
front of the queue. Such an algorithm for dequeue would run in O(1) time. After
several dequeue operations, this approach might lead to the configuration portrayed
in Figure 6.6.
0
F G K L M
1 2 f N−1
data:
Figure 6.6: Allowing the front of the queue to drift away from index 0. In this
representation, index f denotes the location of the front of the queue.
However, there remains a challenge with the revised approach. With an array
of capacity N, we should be able to store up to N elements before reaching any
exceptional case. If we repeatedly let the front of the queue drift rightward over
time, the back of the queue would reach the end of the underlying array even when
there are fewer than N elements currently in the queue. We must decide how to
store additional elements in such a configuration.


Using an Array Circularly
In developing a robust queue implementation, we allow both the front and back
of the queue to drift rightward, with the contents of the queue “wrapping around”
the end of an array, as necessary. Assuming that the array has fixed length N, new
elements are enqueued toward the “end” of the current queue, progressing from the
front to index N −1 and continuing at index 0, then 1. Figure 6.7 illustrates such a
queue with first element F and last element R.
0
Q R F G K L M N O P
1 2 f N−1
data:
Figure 6.7: Modeling a queue with a circular array that wraps around the end.
Implementing such a circular view is relatively easy with the modulo operator,
denoted with the symbol % in Java. Recall that the modulo operator is computed
by taking the remainder after an integral division. For example, 14 divided by 3
has a quotient of 4 with remainder 2, that is, 14
3 = 42
3 . So in Java, 14 / 3 evaluates
to the quotient 4, while 14 % 3 evaluates to the remainder 2.
The modulo operator is ideal for treating an array circularly. When we dequeue
an element and want to “advance” the front index, we use the arithmetic
f = ( f +1) % N. As a concrete example, if we have an array of length 10, and a
front index 7, we can advance the front by formally computing (7+1) % 10, which
is simply 8, as 8 divided by 10 is 0 with a remainder of 8. Similarly, advancing
index 8 results in index 9. But when we advance from index 9 (the last one in the
array), we compute (9+1) % 10, which evaluates to index 0 (as 10 divided by 10
has a remainder of zero).



Adding and Removing Elements
The goal of the enqueue method is to add a new element to the back of the queue.
We need to determine the proper index at which to place the new element. Although
we do not explicitly maintain an instance variable for the back of the queue, we
compute the index of the next opening based on the formula:
avail = (f + sz) % data.length;
Note that we are using the size of the queue as it exists prior to the addition of
the new element. As a sanity check, for a queue with capacity 10, current size 3,
and first element at index 5, its three elements are stored at indices 5, 6, and 7, and
the next element should be added at index 8, computed as (5+3) % 10. As a case
with wraparound, if the queue has capacity 10, current size 3, and first element at
index 8, its three elements are stored at indices 8, 9, and 0, and the next element
should be added at index 1, computed as (8+3) % 10.
When the dequeue method is called, the current value of f designates the index
of the value that is to be removed and returned. We keep a local reference to the
element that will be returned, before setting its cell of the array back to null, to aid
the garbage collector. Then the index f is updated to reflect the removal of the first
element, and the presumed promotion of the second element to become the new
first. In most cases, we simply want to increment the index by one, but because
of the possibility of a wraparound configuration, we rely on modular arithmetic,
computing f = (f+1) % data.length, as originally described on page 242.




Analyzing the Efficiency of an Array-Based Queue
Table 6.4 shows the running times of methods in a realization of a queue by an
array. As with our array-based stack implementation, each of the queue methods in
the array realization executes a constant number of statements involving arithmetic
operations, comparisons, and assignments. Thus, each method in this implementation
runs in O(1) time.
Method Running Time
size O(1)
isEmpty O(1)
first O(1)
enqueue O(1)
dequeue O(1)
Table 6.4: Performance of a queue realized by an array. The space usage is O(N),
where N is the size of the array, determined at the time the queue is created, and
independent from the number n < N of elements that are actually in the queue.
	 */
}
