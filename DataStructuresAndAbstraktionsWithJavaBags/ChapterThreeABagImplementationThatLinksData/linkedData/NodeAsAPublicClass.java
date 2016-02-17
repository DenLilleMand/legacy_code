package linkedData;

/**
 * Denne klasse er ikke implementeret
 * i nogle tests, vi bruger en innerclass i stedet for denne i 
 * vores LinkedBag, men hvis vi gerne ville bruge den her,
 * s� er det eneste vi skulle �ndre er 
 * Node  til Node<T> alts� deklarerer en type.
 * Bogen foresl�r bla. ogs� at man kan pr�ve at implementere
 * denne Self, men ogs� at man laver den klasse, som jeg tror hedder en nested
 * class, alts� Node inde i vores LinkedBag om til en innerclass som hedder
 * Node. 
 * @author DenLilleMand
 *
 */
public class NodeAsAPublicClass {
	class Node<T> {
		private T data;
		private Node<T> next;

		Node(T dataPortion) // the constructor�s name is Node, not Node<T>
		{
			this(dataPortion, null);
		} // end constructor

		Node(T dataPortion, Node<T> nextNode) {
			data = dataPortion;
			next = nextNode;
		} // end constructor

		T getData() {
			return data;
		} // end getData

		void setData(T newData) {
			data = newData;
		} // end setData

		Node<T> getNextNode() {
			return next;
		} // end getNextNode

		void setNextNode(Node<T> nextNode) {
			next = nextNode;
		} // end setNextNode
	} // end Node
}
