package opg4.stack;

public class LinkListEntry<T> {

	private T t;
	private LinkListEntry<T> prev;
	private LinkListEntry<T> next;
	
	public LinkListEntry(T t, LinkListEntry<T> prev, LinkListEntry<T> next)
	{
		this.t = t;
		this.prev = prev;
		this.next = next;
	}
	
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t = t;
	}
	public LinkListEntry<T> getPrev() {
		return prev;
	}
	public void setPrev(LinkListEntry<T> prev) {
		this.prev = prev;
	}
	public LinkListEntry<T> getNext() {
		return next;
	}
	public void setNext(LinkListEntry<T> next) {
		this.next = next;
	}
	
}
