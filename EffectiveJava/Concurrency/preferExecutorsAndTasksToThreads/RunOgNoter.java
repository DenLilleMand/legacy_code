package preferExecutorsAndTasksToThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunOgNoter {
	/**
	 * Prefer executors and tasks to threads
	 * tl;dr;
	 * 
	 * 
	 * ---------------
	 * Noter:
	 * Kan se den linje kode, der nu skal til for at lave en executor,
	 * der kr�vede en hel side med delicat kode f�r, i kode eksempel 1, kan man se 
	 * hvor man laver en executor.
	 * java.util.concurrent blev tilf�jet til java platformen. 
	 * 
	 * Men hvad kan man bruge en executor service til?
	 * 
	 * man kan f.eks vente for en bestemt opgave til at afslutte,
	 * man kan vente p� at en hel collection af tasks er f�rdig(ved at bruge invokeAny / invokeAll) metoderne
	 * , man kan vente p� at executor servicen elegant bliver f�rdigt ved at bruge awaitTermination metoden.
	 * Man kan skaffe alle resultaterne fra opgaver en efter en som de bliver f�rdige 
	 * ved at bruge ExecutorCompletionService osv.
	 * 
	 * Hvis man vil have mere end 1 tr�d til at processere requestsne fra 
	 * ens queue, skal man simpelt nok kalde en anden statisk factory der laver en anden slags
	 * executor service kaldet end Thread Pool,
	 * man kan lave en threadpool med et fixed antal eller et variablet nummer
	 * af tr�de. Java.util.concurrent.Executors klassen indeholder statiske factories
	 * der giver en de fleste executors som man nogensinde har brug for. Og hvis man 
	 * vil lave sin egen kan man bruge en ThreadPoolExecutor direkte, den g�r det muligt at styrer
	 * n�sten enhvert aspekt i en thread pools operation.
	 * 
	 * Man skal v�lge hvilken slags Executor service man vil bruge
	 * p� et tidspunkt. 
	 * Hvis man skriver et lille program, eller en let-loaded
	 *  server, s� kan man bruge  Executors.newCachedThreadPool som er et generalt godt valg, siden
	 *  den ikke har brug for nogen configuration og generalt g�r 'den rigtige ting' 
	 *  men en cached thread pool er ikke en god ide for heavily loaded produktions servere, I en cached Thread pool,
	 *  s� er modtagede opgaver ikke sat i k� med det samme, men givet til en tr�d
	 *  for at blive k�rt,  og hvis ingen tr�de er ledige, s� laver den en ny en, dette
	 *  bliver den ved med selvom hele systemets CPU k�rer p� h�jtryk, dvs. at det kun g�r problemet v�rre og v�rre for nu flere
	 *  tr�de der bliver lavet, og der er ingen kontrol p� dette.  Derfor i et heavily loaded produktions 
	 *  server er det en god ide at man bruger Executors.newFixedThreadPool, som giver en, en fixed m�ngde af tr�de, 
	 *  eller ogs� kan man direkte brug ThreadPoolExecutor klassen for maximum kontrol..
	 *  
	 *  
	 *  Man burde ikke skrive sine egne work queues l�ngere, og man burde fuldst�ndig stoppe med at arbejde direkte med tr�de.
	 *   Thread plejede at v�re 'the unit of work and the mechanism for executing it' men nu har vi opdelt disse, 
	 *   n�gle abstraktionen er nu 'the unit of work' som kaldes en task, der er 2 slags tasks,
	 *    Runnable og dens f�tter Callable(som er ligesom Runnable, bortset fra at den returnere en v�rdi).
	 *    Og s� er den generalle mekanisme til at udf�rer opgaver en 'executor service'. Hvis man t�nker i disse begreber og lader 
	 *    en executor service execute tasks s� f�r man den fleksibilitet at man kan v�lge hvilke de rigtige execution 'policies'.
	 *    'In essence, the Executor Framework does for execution what the Collections Framework did for aggregation.
	 *    
	 *    Det her Executor Framework har ogs� en erstatning for java.util.Timer, som hedder ScheduledThreadPoolExecutor. Mens det er lettere 
	 *    at bruge en timer, s� er en scheduled thread pool executor meget mere fleksible. En timer bruger kun en enkelt Thread for task execution, 
	 *    som kan v�re d�rligt for ens timing accuracy n�r der er lange running tasks.
	 *    Hvis timerens eneste tr�d kaster en uncaught exception, s� stopper timeren med at oprerer. imens en Scheduled Thread Pool executor har support
	 *     for flere tr�de og kommer tilbage elegant fra tasks der smider unchecked exceptions.
	 *     Man kan evt. l�se bogen 'Java concurrency in Practice' for mere om executor services osv.
	 *     
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		/**
		 * Kode eksempel 1:
		 */
		ExecutorService executor = Executors.newSingleThreadExecutor();
		
		executor.execute(runnable);
	
		executor.shutdown();
	
	}

}
