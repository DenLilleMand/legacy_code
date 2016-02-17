package dataStructuresAndAbstractionsGennemgang;

public class Test {

	public static void main(String[] args) {
		System.out.println("result: " + calculateHeight(1));
	}

	/**
	 * 
	 * 
	 * Now, if n is the number of nodes in a full tree, we have the following
	 * results: n = 2h - 1 2h = n + 1 h = log2 (n + 1) That is, the height of a
	 * full tree that has n nodes is log2 (n + 1).
	 * 
	 * The height of a binary tree with n nodes that is either complete or full
	 * is log2 (n + 1) rounded up.
	 * 
	 * 
	 * To compute log2 x in Java, first observe that loga x = logb x/logb a. In
	 * Java, Math.log(x) returns the natural logarithm of x. So Math.log(x) /
	 * Math.log(2.0) computes the base 2 logarithm of x.
	 * 
	 * OBS: husk at dette kun gælder for full/complete trees -
	 * så spørgsmålet er om man kan lave et smart if-check der checker
	 * på om det er det.
	 */
	public static double calculateHeight(double n) {
		return 1 + Math.log(n) / Math.log(2.0);
	}

}
