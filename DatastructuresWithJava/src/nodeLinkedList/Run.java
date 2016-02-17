package nodeLinkedList;


public class Run 
{
	public static void main(String[] args)
	{
		Node<String> start = new Node<String>("herpderp");
		start.next = new Node<String>("hey");
		start.next.next = new Node<String>("derpherp");
		start.next.next.next = new Node<String>("lolherp");
		start.next.next.next.next = new Node<String>("okayderp");
	}
}
