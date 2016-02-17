package printeJuletræer;

public class PrintChristmassTrees 
{

	public static void main(String[] args) 
	{
		drawChristmasTree(5);
	}
	
	 private static void drawChristmasTree(int max) {
		 /**segments */
	     for (int i = 0; i < max; i++) {
	         triangle(i+1,max);
	     }
	}
	
	
	private static void triangle(int n, int max)
	{
		 /**Height */
	     for (int i = 0; i < n; i++) 
	     {
	         for (int j = 0; j < max-i-1; j++) 
	         {
	             System.out.print(" ");
	         }
	         for (int j = 0; j < i*2+1; j++) 
	         {
	             System.out.print("*");
	         }
	         System.out.println("");
	     }
	 }

}
