//package implementingTreeTraversalsInJava;
//
//public class Noter {
/**
//	 * Metode:
//	 */
//	// ---------------- nested ElementIterator class ----------------
//	/*
//	 * This class adapts the iteration produced by positions() to return
//	 * elements.
//	 */
//	private class ElementIterator implements Iterator<E> {
//		Iterator<Position<E>> posIterator = positions().iterator();
//
//		public boolean hasNext() {
//			return posIterator.hasNext();
//		}
//
//		public E next() {
//			return posIterator.next().getElement();
//		} // return element!
//
//		public void remove() {
//			posIterator.remove();
//		}
//	}
//
//	/** Returns an iterator of the elements stored in the tree. */
//	public Iterator<E> iterator() {
//		return new ElementIterator();
//	}
//}
