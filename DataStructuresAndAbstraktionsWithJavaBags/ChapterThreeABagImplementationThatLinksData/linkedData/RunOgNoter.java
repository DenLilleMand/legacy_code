package linkedData;

public class RunOgNoter 
{
	/**
	 * 
	 * tl;dr;
	 * Chapter summary:

* You can form a chain of linked data by using objects called nodes. Each node has two parts. One part contains
a reference to a data object, and the second part references the next node in the chain. The last node,
however, references no other node and contains null. A head reference external to the chain references the
first node.
• You can add a node to the beginning of a chain of linked nodes by changing two references: the one within
the node to be added and the chain’s head reference.
• You can remove the first node in a chain of linked nodes by setting the chain’s head reference to the reference
within the first node.
• Locating a particular node in a chain of linked nodes requires a traversal of the chain. Beginning at the first
node, you move from node to node sequentially until you reach the desired node.
• The class Node can be an inner class of LinkedBag or a class within a package that contains LinkedBag. In
the latter case, Node must define set and get methods to provide access to its data fields.
	 * 
	 * ---------------------
	 * Noter:
	 * En sektion copy-pasted fordi den taler om access modifiers på getters/setters
	 * i forhold til data feltet.
	 * The rest of the definition of the class Node is uneventful. Constructors to initialize the node are useful,
and since the data fields are private, methods to access and alter their contents are provided.
But are they really necessary? If we intend Node to be for public use, like our other classes, such
methods are necessary; however, Node is a detail of this implementation of the ADT bag that should
be hidden from the bag’s client. One way to hide Node from the world is to define it within a package
that also contains the class that implements the bag. Another way—the way we will use here—
is to define Node within an outer class, the one that implements the bag. Because of its placement
within another class, Node is an example of an inner class. We declare it to be private. An outer
class can access the data fields of an inner class directly by name without the need for accessor and
mutator methods. Thus, we write the simpler definition of Node shown in Listing 3-1.
	 * 
	 * kommentar i forhold til vores implementation af Node
	 * We did not include a default constructor because we will not need one.
Because Node will be an inner class, the generic type T will be the same as the generic type
declared by the outer class that contains Node. Thus, we do not write <T> after Node. If, however,
Node was not an inner class but instead had package access or public access, you would write
Node<T>. In that case, Node would also require set and get methods for its data fields.
	 * 
	 * 
	 * lidt off-topic, men terminology i forhold til hvornår en klasse er en inner-class,
	 * en nested class osv.
	 * 
	 * A nested class is defined entirely within another class definition. Nested classes can be static,
although we will not encounter any in this book. An inner class is a nested class that is not
static. An outer class, or enclosing class, contains a nested class. A top-level class is one that
is not nested.

Den første implementation vi skal lave med det her,
bruger et 'data field' kaldt 'the head reference' som svarer til det felt som hele tiden husker
på hvilken der er den første i rækken(og som hele tiden vil blive skiftet ud, hver gang der kommer
en ny til).


When you use the new operator, you create, or instantiate, an object. At that time, the Java
run-time environment allocates, or assigns, memory to the object. When you create a node
for a linked chain, we sometimes say that you have allocated the node.
Dette gør blandt andet at en LinkedBag kan give os en OutOfMemoryError fejl, hvilket tydeligvis
er fatalt .

To access the bag’s entries, we need to access each node in a
chain, beginning with the first one. This action is called a traversal,


Pros & Cons ved at implementere bag som en LinkedList:
You have seen how to use a chain in the implementation of the ADT bag. One of the greatest
advantages of this approach is that the chain, and therefore the bag, can grow and shrink in size as
necessary. As long as memory is available, you can add as many nodes to a chain as you wish.
Moreover, you can remove and recycle nodes that are no longer needed. Although you can resize an
array to allow a bag to grow in size—as the previous chapter describes—each time a larger array is
necessary, you must copy the entries from the full array to the new array. No such copying is
required when you use a chain.
Adding a new entry to the end of an array or to the beginning of a chain are both relatively simple
tasks. Both operations are fast, unless the array needs to be resized. Likewise, removing the
entry at the end of an array or the beginning of a chain takes about the same effort. However,
removing a specific entry requires a search of the array or chain.
Lastly, a chain requires more memory than an array of the same length. Although both data
structures contain references to data objects, each node in a chain also contains a reference to
another node. However, an array is often larger than necessary, so memory is wasted. A chain uses
memory only as needed.

programming tip(Måske har vi skrevet det ned før?)
If ref is a reference to a node in a chain, be sure that ref is not null before you use it to access ref.data or
ref.next.

	 * @param args
	 */
	public static void main(String[] args) 
	{

	}

}
