package considerImplementingComparable;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class NoterOgRun {
/**
 * Okay, s� 'consider implementing comparable'.
 * 
 * ikke ligesom de andre metoder i det her kapitel,
 * s� er compareTo ikke en metode declared i Object.
 * men det er den eneste metode i interface Comparable.
 * 
 * at ens klasse implementere Comparable g�r det meget lettere
 * at sortere kig evt. p� kode eksempel 1 neden for.
 * 
 * hvis ens Object implementere Comparable siger man at ens
 * objekter har en 'natural ordering'.
 *	eksempel p� god kode med metode nummer 2.
 *
 *ved at implementere Comparable s� tillader man ens klasse
 *at arbejde sammen med alle de mange generiske algoritmer og collection
 *implementationer der afh�nger af denne interface.
 *man f�r en k�mpe m�ngde af kraft for meget lidt arbejde, alle
 *value classes i java platformens bibliotek implementere
 *Comparable. s� hvis man skriver en Value klasse med en natural
 *ordering ligesom en alfabetisk orden, numerisk orden eller en kronologisk orden s�
 *skal man seri�st overveje at implementere Comparable interfaced.
 *
 *interfaced ser s�dan ud:
 *	public interface Comparable<T>
 *	{
 *		int compareTo(T t);
 *	}
 * 
 * kontrakten for denne interface minder meget om equals() metoden
 * s� hvis man g�r tilbage i bogen og kigger p� alle de
 * r�d / ting man ikke skal g�re med equals kan det v�re at man l�rer noget om 
 * compareTo() metoden, compareTo() g�r s�dan set ud p� som
 * n�r vi har brugt bubble sort, at man sammenligner 2 objekter,
 * og s� returnere den enten en positiv integer, negativ integer 
 * eller 0. det er dog ogs� en mulighed at smide the ClassCastException hvis 
 * det specificeret objekts type forhindre den i at blive sammenlignet med et givent objekt.
 * 
 *  men den er tilladt ikke at fungere i mods�tning til equals() metoden
 *  den m� godt bare smide en exception og s� g�r sort() videre(m� man g� udfra)
 *  anyway - den er mindre kompliceret end equals() metoden og den  bliver forklaret
 *  p� side 86.
 *  
 *  Jeg er alts� g�et videre til kapitel 4 .. de pr�ver at forklare matematiske formler 
 *  i tekstform. anwyay - det er noget som er v�rd at g� tilbage til hvis man 
 *  finder det n�dvendigt at implementere compareTo metoden i sin Value klasse.
 * 	
 *  
 * @param args
 */
	public static void main(String[] args) {
		/**
		 * 1:
		 */
		Arrays.sort(a);
		
		/**
		 * 2: Det her kode eksempel g�r det super let at s�ge,
		 * compute ekstreme v�rdier og velligeholde en automatisk
		 * sorteret collection af Comparable objects. 
		 * den k�rer p� at String implementere Comparable og s� printer den en 
		 * alfabetisk liste af dens command line arguments med alle dupliketter fjernet.
		 * 
		 */
		
		Set<String> s = new TreeSet<String>();
		Collections.addAll(s,args);
		System.out.println(s);
		
		
		
	}

}
