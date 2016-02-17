package collections.queues;

import java.util.Iterator;

import collections.linkedLists.SinglyLinkedList;


public class LinkedQueue<E> implements Queue<E>, Iterable<E> 
{
	private SinglyLinkedList<E> list = new SinglyLinkedList<E>(); // an empty
																	// list
	public LinkedQueue() 
	{
	} // new queue relies on the initially empty list

	public int size() 
	{
		return list.size();
	}

	public boolean isEmpty() 
	{
		return list.isEmpty();
	}

	public void enqueue(E element) 
	{
		list.addLast(element);
	}

	public E first() 
	{
		return list.first();
	}

	public E dequeue() {
		return list.removeFirst();
	}

	@Override
	public Iterator<E> iterator() {
		return list.iterator();
	}

	
}