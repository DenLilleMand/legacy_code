package linkedData;

import interfaces.BagInterface;

/**
 * Boger giver os nogle metoder for at teste,
 * men vi laver bare vores egne. 
 * @author DenLilleMand
 *
 */
public class LinkedBagDemo1
{
	public static void main(String[] args)
	{
		System.out.println("Creating an empty bag.");
		BagInterface<String> aBag = new LinkedBag<String>();
		
		aBag.add("lol");
		aBag.add("herpderp");
		aBag.add("herpderp");
		aBag.add("herpderp");
		aBag.add("herpderp");
		aBag.add("herpderp");
		aBag.add("burger");
		Object[] strings =  aBag.toArray();
		for(int i = 0; i < strings.length; i++)
		{
			System.out.println(strings[i]);
		}
		
		System.out.println(aBag.getFrequencyOf("herpderp"));
	//	System.out.println(aBag.contains("herpderp"));
		
		System.out.println(aBag.remove("lol"));
		System.out.println(aBag.remove("herpderp"));
		System.out.println(aBag.remove("herpderp"));
		System.out.println(aBag.remove("herpderp"));
		System.out.println(aBag.getFrequencyOf("herpderp"));
		System.out.println(aBag.getFrequencyOf("lol"));
		
	} // end main
	
	
	
} // end LinkedBagDemo1