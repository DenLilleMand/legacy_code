package motivation;

public class RunOgNoter {

	/**
	 * tl;dr;
	 * 
	 * 
	 * 
	 * 
	 * 
	 * ------------------- Noter:
	 * man kan se  hvordan algoritme b er helt umulig,
	 * elendig sammenlignet med de 2, så det er tydeligvis vigtigt
	 * at tænke over hvilke algoritmer man bruger når man programmere,
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @param args
	 */

	public static void main(String[] args) 
	{
		// Computing the sum of the consecutive integers from 1 to n:
		long n = 100000; // ten thousand
		// Algorithm A
		long sum = 0;
		for (long i = 1; i <= n; i++)
			sum = sum + i;
		System.out.println(sum);
		// Algorithm B
		sum = 0;
		for (long i = 1; i <= n; i++) {
			for (long j = 1; j <= i; j++)
				sum = sum + 1;
		} // end for
		System.out.println(sum);
		// Algorithm C
		sum = n * (n + 1) / 2;
		System.out.println(sum);
	}

}
