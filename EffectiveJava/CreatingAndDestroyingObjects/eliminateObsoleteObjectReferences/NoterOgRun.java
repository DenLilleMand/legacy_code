package eliminateObsoleteObjectReferences;

/**
 * OKAY jeg fatter slet ikke det Stack
 * eksempel der bliver vist p� side
 * 47-48, det har noget at g�re med
 * at n�r en Stack's st�rrelse bliver st�rre 
 * og s� skrumper bagefter s� bliver de objekter
 * der plejede at v�re der ikke collected af garbage
 * collectoren fordi Stacken har hvad der hedder en 
 * 'obsolete reference' til objektet.
 * og dette kan undg�s med den kode p� side 48 tror jeg det er,
 * hvor man s�tter de objekter som har den her 'obsolete reference'
 * til null n�r man popper dem af stacken.
 * 
 * Men det er et mere advanceret emne dette,
 * men en ting som giver mening er at man altid burde declare ting
 * i det mindste scope muligt s�dan at garbage collectoren kan g� i gang,
 * og det er hvertfald noget vi ikke bruger specielt meget i vores programmering,
 * vi declare ting som klasse variabler hele tiden
 * selvom de kun bruges 1 sted.
 * Jeg skal dog ikke kunne sige hvor let det er at skaffe
 * os af med nogle af de variabler vi har siden java
 * er by reference og ikke by-value.
 * 
 * En anden ting som er til at forst�, og som er det vi kan se
 * udfra det kode eksempel der er. N�r en klasse selv st�r for 
 * sin data management, som vores stack g�r fordi den beholder en inaktiv del af objekter i sig
 * uden at g�re noget ved dem(hvor kun programm�ren, 
 * kender til hvilke objekter der ikke skal bruges l�ngere).
 * er at man skal bare v�re obs for memmory leaks i disse tilf�lde.
 * 
 *  (Denne sektion minder os vel om at vi skal kigge p� hvad
 *  caches kan bruges til :) ) 
 *  En anden ting der kan memmory leak er caches.
 *  N�r man ligger et objekt ind i cache er det let at glemme den
 *  efter den ikke er relevant l�ngere, og s� s�tter man den ikke til null.
 *  en m�de at g�re dette p� er (ud af mange)
 *  er at hvis man er s� heldig at skulle implementere en cache
 *  hvor dens objekt kun er relevant s� l�nge den har en key udenfor cachen
 *  s� ville man kunne implementere det med noget som hedder 
 *  et WeakHashMap - s� vil entries automatisk blive fjernet.
 *  
 *  Hvis man har en almindelig cache hvor man beholder objekterne i relativ lang tid,
 *  indtil de falder ud af use, s� kan man bruge en 
 *  Timer eller en ScheduledThreadPoolExecutor til at
 *  rydde op i de objekter der er faldet ud af fav�r.
 *  Der er ikke noget kode eksempel p� nogle caches,
 *  men n�r vi begynder at l�rer caches er det v�rd at kigge p�
 *  side 48-49 igen formentligt.
 *  
 *  en tredje form for 'ressource leak' er 
 *  listeners og andre callbacks. 
 *	dette forekommer n�r clients register callbacks,
 *	og s� bliver de aldrig unregistered, og dette kan k�rer flere �r i et system
 *	uden at nogen ligger m�rke til det, f�r det er for sent. 
 *	Dette kan man ordne med det debugging tool som hedder 'heap profiler'.
 *
 *  man kan �benbart ogs� fixe dette ligesom cache problemet, ved at ligge
 *  ved at ligge dem ind kun som keys i et WeakHashMap
 *  og m� den m�de kun have en 'weak reference' til objektet.
 *  
 *
 *  
 * 
 * 
 * 
 * @author DenLilleMand
 *
 */
public class NoterOgRun {
	public static void main(String [] args)
	{
		
	}
}
