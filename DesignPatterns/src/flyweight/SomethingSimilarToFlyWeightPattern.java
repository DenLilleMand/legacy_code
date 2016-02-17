package flyweight;

public class SomethingSimilarToFlyWeightPattern {

		/**
		 * En metode der converter en primitiv boolean til en 
		 * Boolean med den korekte værdi. og med noget interessersant syntax må man sige
		 * , det må man hellere lige læse om på siden alle gode programmører virker til at
		 * bruge ? :  osv. 
		 * 
		 * Det her område i bogen handler om static factory methods,
		 * som skal understreges ikke er Factory Pattern fra design patterns, 
		 * en fordel ved at bruge static factory methods er at den har et navn,
		 * en constructor har jo ikke et navn man selv kan bestemme., 
		 * endnu en fordel ved at bruge dem istedet for en constructor er at
		 * de ikke er bundet af at skulle lave et objekt hver gang(hvilket constructors jo 
		 * heller ikke er hvis vi smider en exception BOOM! :) )
		 * 
		 * Jeg tror faktisk at den her metode sjovt nok returnere singleton objekter,
		 * det siger bogen hvertfald at den gør ... og de taler bla om at hvis objekter 
		 * er singleton så kan man få noget performance benefit ud af at bruge '==' operatoren
		 * istedet for object.equals(object) ... hvilket man lige skal være obs på at bruge 
		 * når vi har med singleton objekter at gøre.
		 * 
		 * Denne lille metode ligner desuden flyweight pattern.
		 * @param b
		 * @return
		 */
		public static Boolean valueOf(boolean b) {
			return b ? Boolean.TRUE : Boolean.FALSE;
			}
}
