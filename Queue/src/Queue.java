
public class Queue<T> 
{
	//skal bruge et circular array - når man når slutningen, skal man starte fra starten af arrayet, så for man den version hvor 
	//Queuen venter ligesom netværks programmering på at plads 0 bliver fyldt. 
	
	
	
	private int front = -1;
	private int back = 0;
	
	@SuppressWarnings("unchecked")
	/** Det som bogen skriver er at vi ikke kan lave et T array, så derfor laver vi et Object og caster det. */
	private T[] array = (T[]) new Object[5];
	
	
	/**
	 * 
	 * @param t
	 * @throws Our5QueueIsFullException 
	 */
	public void enqueue(T t) throws Our5QueueIsFullException
	{
		if(back == 5)
		{
			back = 0;
		}
		if(array[back] == null)
		{
			array[back++] = t;			
		}
		else
		{
			throw new Our5QueueIsFullException("No More room!");
		}
	}
	
	
	public T dequeue()
	{
		T temp = array[++front];
		array[front] = null;
		return temp;
	}
	
	
	
	
}
