package opgave9;

import java.util.ArrayList;
import java.util.List;

public class Opgave9 
{
	public static void main(String [] args)
	{
		sumOfDigits(297);
	}
	
	public static void sumOfDigits(Integer value)
	{
		    int result = 0;
		    while(value > 0) 
		    {
		        result += value % 10;
		        System.out.println("after modulus:" +result);
		        value/= 10;
		        System.out.println("after devision by 10"+result);
		    }
		    System.out.println(result);
		}
	}

