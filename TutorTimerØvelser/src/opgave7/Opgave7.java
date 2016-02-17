package opgave7;

public class Opgave7 {
	public static void main(String[] args) {
		System.out.println(smallerAbsVal(10, 15,20));
	}
	public static int smallerAbsVal(int a, int b, int c) 
	{
		int smallest;
		if (Math.abs(a) < Math.abs(b) && Math.abs(a) < Math.abs(c)) 
		{
			smallest = a;
		} else if (Math.abs(b) < Math.abs(c) && Math.abs(b) < Math.abs(a)) 
		{
			smallest = b;
		} else {
			smallest = c;
		}
		return Math.abs(smallest);
	}

}
