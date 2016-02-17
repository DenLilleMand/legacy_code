package exceptions;


public class StackIsFullException extends Exception
{
	private static final long serialVersionUID = 8142951951946415886L;
	
	public StackIsFullException(String s)
	{
		super(s);
	}

}
