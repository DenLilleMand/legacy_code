package runExempler;

import interfaces.BagInterface;

public class ResizableArrayBagDemo {
	/**
	 * Har tilf�jet en bag.length-1 til vores add, alts� hvorn�r
	 * vi skal fordoble, ellers ville det her for-loop ikke k�rer, 
	 * og det har tydeligvis noget at g�re med den aBag.length() der bliver tjekket p�,
	 * og s� den length som aBag.add() g�r udfra n�r de er i et for-loop. s� man skal lige 
	 * give den det plads at arbejde med som hedder -  vi fordobler arrayed 1 Object f�r den er fyldt.
	 * @param args
	 */
	public static void main(String[] args) 
	{
//		BagInterface<String> aBag = new ResizableArrayBag<String>(10);
//		boolean herp = false;
//		
//		for(int i = 0; herp == false && i < aBag.length(); i++)
//		{
//			if(i == 120)
//			{aBag.add("herpderp");
//				herp = true;
//			}
//			aBag.add("lol");
//			System.out.println(i);
//		}
		/** udkommenter en af disse */
		/**test 1: */
//		aBag.clear();
//		for(int i = 0; i < aBag.length(); i++)
//		{
//			System.out.println("Index: " + i);
//		}
//		
//		/**test 2: */
//		for(int i = 0; i < aBag.length(); i++)
//		{
//			aBag.remove();
//			System.out.println("removeing stuff  from index [" + i +"]");
//		}
		
		/** test 3: Synes ikke helt den her metode fungerer, det m� v�re noget 
		 * med for-loopsne jeg har misset, jeg kan ikke helt se om det er equals eller
		 * om det er et for-loop der g�r i stykker et sted - men den fjerner i hvertfald
		 * nogle af 'lol' - s� man m� n�sten antage at det er et for-loop der f�r sin l�ngde
		 * redigeret l�bende med at vi f�r fjernet dem, hvilket er underligt.*/
//		aBag.removeEvery("herpderp");
//		
		
		/**
		 * Test 4:
		 */
//		BagInterface<String> aBag = new ArrayBag<String>(10);
//		aBag.add("YOYO");
//		aBag.add("YOYO");
//		aBag.add("YOYO");
		
//		BagInterface<Object> sizeableBag = convert(aBag);
//		for(int i = 0; i < sizeableBag.length(); i++)
//		{
//			aBag.printItem(i);
//		}
		
		/**
		 * test 5(virker som om at vores equals metode nu er okay, men alts�,
		 * man ville jo aldrig bare returne true by-default, man ville kun gemme sit return
		 * true ind i en if else.);
		 */
		
//		BagInterface<String> aBag = new ArrayBag<String>(10);
//		BagInterface<String> aBag1 = new ArrayBag<String>(10);
//		aBag.add("YOYO");
//		aBag.add("YOYO");
//		aBag.add("YOYO");
//		aBag.add("kk");
//		aBag1.add("YOYO");
//		aBag1.add("YOYO");
//		aBag1.add("YOYO");
//		aBag1.add("k");
//		System.out.println(aBag.equals(aBag1));
		
		/**
		 * Test 6(lidt off-topic, men skal lige se hvad der sker hvis man f�r
		 * smidt en assertion error)
		 */
		
		calculate(11);
		
		
	}
	
	/**
	 * client level code.
	 * Define a method at the client level that accepts as its argument an instance of the class ArrayBag and 
	 * returns an instance of the class ResizableArrayBag that contains the same entries as
	 * the argument bag.
	 * @param <T>
	 */
	
	public static <T> BagInterface<Object> convert(BagInterface<?> array)
	{
		BagInterface<Object> aBag = new ResizableArrayBag<Object>(array.length());
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) array.toArray();
		for(int i = 0; i < temp.length-1; i++)
		{
			System.out.println("Resizable array length:" + aBag.length());
			System.out.println("input array length: " + array.length());
			System.out.println("the index:" +i);
			aBag.add(temp[i]);
		}
		return aBag;
		
	}
	
	/**
	 * Hmm, der sker �benbart ingenting hvis man smider 11 ind iforhold til hvis man smider 10 ind. 
	 * @param x
	 */
	public static void calculate(int x)
	{
		assert x == 10;
		System.out.println("herpderp");
	}

	
}
