package avoidCreatingUnnecessaryObjects;

public class BadForLoop {
	
	public static void main(String[] args) {
		
		/**
		 * det her er noget man absolut ikke
		 * skal g�re, det laver jo s� mange
		 * objekter af long der svarer til 
		 * hvor h�j en int g�r ... faktisk er det
		 * her nok det f�rste program jeg har k�rt
		 * som er fuldst�ndig umuligt, p� den m�de at det 
		 * tager en i7 m�ske 30 sekunder at udf�rer.


		 * Det her handler om primitive typer
		 * iforhold til deres tilsvarene Objekter
		 * alts� Long/long, og det tager en umulig m�ngde
		 * mere tid at k�rer den hvor Long 
		 * er den variable type vi ligger til, iforhold til 
		 * long varianten nedenunder.
		 */
		Long sum = 0L;
		for(long i = 0; i < Integer.MAX_VALUE; i++)
		{
			sum += i;
		}
		System.out.println(sum);
		
		
		/**
		 * budskabet er tydeligt, brug altid
		 * primitives og fejl i performance kan v�re
		 * pga. en har brugt objekt typen af en variable.
		 */
		long sum1 = 0L;
		for(long i = 0; i < Integer.MAX_VALUE; i++)
		{
			sum1 += i;
		}
		System.out.println(sum1);
		
	}
}
