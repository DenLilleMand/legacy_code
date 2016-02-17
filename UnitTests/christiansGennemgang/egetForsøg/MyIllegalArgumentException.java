package egetForsøg;

public class MyIllegalArgumentException extends IllegalArgumentException
{
	private static final long serialVersionUID = 1L;
	
	private int offBy;
	
	public MyIllegalArgumentException(String input)
	{
		offBy = input.length()-25;
	}
	
	public int getOffBy()
	{
		return offBy;
	}
	
	
}
