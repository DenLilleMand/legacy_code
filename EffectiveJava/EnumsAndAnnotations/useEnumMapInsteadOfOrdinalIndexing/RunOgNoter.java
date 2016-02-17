package useEnumMapInsteadOfOrdinalIndexing;

import java.util.Set;

public class RunOgNoter 
{
	/**
	 * tl;dr;
	 * 
	 * 
	 * 
	 * ----------------
	 * Noter:
	 * Der er igen mange eksempel med Sets og whatnot, og det giver ikke
	 * helt så meget mening, det første eksempel fejler fordi det bruger generics samme med
	 * arrays hvilket ikke er kompatiblet og derfor må nød til at kører
	 * med en warning- ellers kan jeg ikke helt finde ud af hvad der er galt.
	 * Jeg tror at selve denne sektion er en smule svær at sætte sig ind i før man har læst
	 * en bog og data structures.
	 * @param args
	 */
	public static void main(String[] args) 
	{
		/**
		 * kode eksempel 1:
		 */
		public class Herb
		{
			public enum Type{ANNUAL, PERENNIAL, BIENNIAL}
			
			private final String name;
			private final Type type;
			
			Herb(String name, Type type)
			{
				this.name = name;
				this.type = type;
			}
		
			@Override public String toString()
			{
				return name;
			}
		}
		
		/**
		 * Kode eksempel 2:
		 */
		
		//Using ordinal() to index an array - DON'T DO THIS!
		Herb[] garden = ...;
		
		
		Set<E> herbsByType = // Index by Herb.Type.ordinal()
		(Set<Herb>[]) new Set[Herb.Type.values().length];
		for(int i = 0; i < herbsByType.length; i++)
		{
			herbsByType[i]  = new HashSet<Herb>();
		}

		for(Herb h : garden)
		{
			HerbsByType[h.type.ordinal()].add(h);
		}
		
		//print the results
		for(int i = 0; i < herbsByType.length; i++)
		{
			System.out.println("%s: %s%n", Herb.Type.values()[i], herbsByType[i]);
		}
	
	
	/**
	 * Kode eksempel 3:
	 * (Dette program er klarere, kortere, mere sikkert og sammenlignelig
	 * i performance til den første version)
	 */
	//Using an EnumMap to associate data with an enum
		Map<Herb.Type, Set<Herb>> herbsByType = new EnumMap<Herb.Type, Set<Herb>>(Herb.Type.class);
		for(Herb.Type t : Herb.Type.values())
		{
			herbsByType.put(t, new HashSet<Herb>());
		}
		for(Herb h : garden)
		{
			herbsByType.get(h.type).add(h);
		}
		System.out.println(herbsByType);
	}
}
