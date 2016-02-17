package opgave5;

public class Opgave5 
{
	public static void main(String [] args)
	{
		printReverseGrid(4,3);
	}
	
	public static void printReverseGrid(int row, int column)
	{
		for(int i = row*column; i > 0 ; i--)
		{
			if(i%column == 0)
				System.out.println();
			System.out.print(i+ " ");
		}
	}
}
