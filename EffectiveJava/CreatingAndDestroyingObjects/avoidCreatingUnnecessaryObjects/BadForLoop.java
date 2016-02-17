package avoidCreatingUnnecessaryObjects;

public class BadForLoop {
	
	public static void main(String[] args) {
		
		/**
		 * det her er noget man absolut ikke
		 * skal gøre, det laver jo så mange
		 * objekter af long der svarer til 
		 * hvor høj en int går ... faktisk er det
		 * her nok det første program jeg har kørt
		 * som er fuldstændig umuligt, på den måde at det 
		 * tager en i7 måske 30 sekunder at udfører.


		 * Det her handler om primitive typer
		 * iforhold til deres tilsvarene Objekter
		 * altså Long/long, og det tager en umulig mængde
		 * mere tid at kører den hvor Long 
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
		 * primitives og fejl i performance kan være
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
