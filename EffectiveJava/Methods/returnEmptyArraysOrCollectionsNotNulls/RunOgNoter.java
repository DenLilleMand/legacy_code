package returnEmptyArraysOrCollectionsNotNulls;

import java.util.Arrays;

public class RunOgNoter {

	/**
	 * tl;dr;
	 * 'There is no reason ever to return null from an array-
	 *  or collection-valued method instead of returning an empty array or collection.
	 *  The null-return idiom is likely a holdover from the c programming language,
	 *  in which array lengths are returned seperately from actual arrays. In C, there is no
	 *  advantage to allocating an array if zero is returned as the length.'
	 * 
	 * 
	 * 
	 * 
	 * ----------
	 * Noter:
	 * Kan se i kode eksempel 1, at vi tydeligvis g�r, hvad
	 * man ikke skal g�re, vi returnere null i stedet for at returnere noget
	 * man kan itererer over.
	 * Det kr�ver ekstra kode at h�ndtere en case hvor cheesen = 0, og det kr�ver ogs�
	 * arbejde p� ens clients side fordi der skal checkes efter null,
	 * 
	 * nede i kode eksempel 2, kan man se hvordan det hj�lper at bare
	 * returnere et array uden noget, ellers f�r vi flere linjer med kode.
	 * Og det er farligt at g�re, fordi den person som skriver client koden, glemmer m�ske at h�ndtere
	 * vores null case, og s� er skaden sket.
	 * Nogen kan argumentere for at det koster for meget performance
	 * at allokere et tomt array eller list,
	 * men der er 2  problemer med det argument,
	 * 1 er at det er ikke et godt r�d at 
	 * bekymrer sig om performance p� dette niveau,
	 * bortset fra hvis profiling har vist at metoden er en der virkelig giver
	 * performance problemer. For det andet s� 
	 * er det muligt at returnere det samme zero-length array
	 * for arrays er immutable objekter og de bliver delt frit.
	 * 
	 * Kode eksempel 3 viser hvordan
	 * man rigtigt skal returnere en kopi af en collection
	 * Man skal altid returnere collection.emptyList() for at v�re sikker 
	 * p� at det er den rigtige liste der bliver returneret, ellers
	 * kan den godt finde p� bare at give en anden tom liste.
	 * ved ikke helt med om man mister referencen, men det ville da
	 * v�re relativt aids.
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		/**
		 * kode eksempel 1:
		 */
		//It is not uncommon to see methods that look smt like this:
		private final List<Cheese> cheesesInStock = ...args;
		
		/**
		 * @return an arraycontaining all of the cheeses in the shop,
		 * or null if no cheeses are available for purchase.
		 */
		public Cheese[] getCheeses()
		{
			if(cheesesInStock.size() == 0)
				return null;
			...
		}
		
		
		/**
		 * kode eksempel 2:
		 */
		Cheese[] cheeses = shop.getCheeses();
		if(cheeses != null && Arrays.asList(cheeses).contains(Cheese.STILTON))
			System.out.println("Jolly good, just the thing");
		
		//instead of:
			if(Arrays.asList(shop.getCheeses()).contains(Cheese.STILTON))
				System.out.println("Jolly good, just the thing. ");
			
		/**
		 * Kode eksempel 3:
		 */
		//The right way to return a copy of a collection
			public List<Cheese> getCheeseList()
			{
				if(cheesesInStock.isEmpty())
				{
					return Collections.emptyList(); // allways returns the same list
				}
				else
					return new ArrayList<Cheese>(cheesesInStock);
			}
		
	}

}
