package eliminateObsoleteObjectReferences;

/**
 * OKAY jeg fatter slet ikke det Stack
 * eksempel der bliver vist på side
 * 47-48, det har noget at gøre med
 * at når en Stack's størrelse bliver større 
 * og så skrumper bagefter så bliver de objekter
 * der plejede at være der ikke collected af garbage
 * collectoren fordi Stacken har hvad der hedder en 
 * 'obsolete reference' til objektet.
 * og dette kan undgås med den kode på side 48 tror jeg det er,
 * hvor man sætter de objekter som har den her 'obsolete reference'
 * til null når man popper dem af stacken.
 * 
 * Men det er et mere advanceret emne dette,
 * men en ting som giver mening er at man altid burde declare ting
 * i det mindste scope muligt sådan at garbage collectoren kan gå i gang,
 * og det er hvertfald noget vi ikke bruger specielt meget i vores programmering,
 * vi declare ting som klasse variabler hele tiden
 * selvom de kun bruges 1 sted.
 * Jeg skal dog ikke kunne sige hvor let det er at skaffe
 * os af med nogle af de variabler vi har siden java
 * er by reference og ikke by-value.
 * 
 * En anden ting som er til at forstå, og som er det vi kan se
 * udfra det kode eksempel der er. Når en klasse selv står for 
 * sin data management, som vores stack gør fordi den beholder en inaktiv del af objekter i sig
 * uden at gøre noget ved dem(hvor kun programmøren, 
 * kender til hvilke objekter der ikke skal bruges længere).
 * er at man skal bare være obs for memmory leaks i disse tilfælde.
 * 
 *  (Denne sektion minder os vel om at vi skal kigge på hvad
 *  caches kan bruges til :) ) 
 *  En anden ting der kan memmory leak er caches.
 *  Når man ligger et objekt ind i cache er det let at glemme den
 *  efter den ikke er relevant længere, og så sætter man den ikke til null.
 *  en måde at gøre dette på er (ud af mange)
 *  er at hvis man er så heldig at skulle implementere en cache
 *  hvor dens objekt kun er relevant så længe den har en key udenfor cachen
 *  så ville man kunne implementere det med noget som hedder 
 *  et WeakHashMap - så vil entries automatisk blive fjernet.
 *  
 *  Hvis man har en almindelig cache hvor man beholder objekterne i relativ lang tid,
 *  indtil de falder ud af use, så kan man bruge en 
 *  Timer eller en ScheduledThreadPoolExecutor til at
 *  rydde op i de objekter der er faldet ud af favør.
 *  Der er ikke noget kode eksempel på nogle caches,
 *  men når vi begynder at lærer caches er det værd at kigge på
 *  side 48-49 igen formentligt.
 *  
 *  en tredje form for 'ressource leak' er 
 *  listeners og andre callbacks. 
 *	dette forekommer når clients register callbacks,
 *	og så bliver de aldrig unregistered, og dette kan kører flere år i et system
 *	uden at nogen ligger mærke til det, før det er for sent. 
 *	Dette kan man ordne med det debugging tool som hedder 'heap profiler'.
 *
 *  man kan åbenbart også fixe dette ligesom cache problemet, ved at ligge
 *  ved at ligge dem ind kun som keys i et WeakHashMap
 *  og må den måde kun have en 'weak reference' til objektet.
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
