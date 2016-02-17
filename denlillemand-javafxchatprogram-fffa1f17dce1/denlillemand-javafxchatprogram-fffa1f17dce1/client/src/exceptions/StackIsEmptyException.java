package exceptions;

public class StackIsEmptyException extends Exception
{
	private static final long serialVersionUID = 1L;

	public StackIsEmptyException(String s)
	{
		super(s);
	}
}
