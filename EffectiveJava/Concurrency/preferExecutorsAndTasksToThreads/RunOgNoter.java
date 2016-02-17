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
	 * der krævede en hel side med delicat kode før, i kode eksempel 1, kan man se 
	 * hvor man laver en executor.
	 * java.util.concurrent blev tilføjet til java platformen. 
	 * 
	 * Men hvad kan man bruge en executor service til?
	 * 
	 * man kan f.eks vente for en bestemt opgave til at afslutte,
	 * man kan vente på at en hel collection af tasks er færdig(ved at bruge invokeAny / invokeAll) metoderne
	 * , man kan vente på at executor servicen elegant bliver færdigt ved at bruge awaitTermination metoden.
	 * Man kan skaffe alle resultaterne fra opgaver en efter en som de bliver færdige 
	 * ved at bruge ExecutorCompletionService osv.
	 * 
	 * Hvis man vil have mere end 1 tråd til at processere requestsne fra 
	 * ens queue, skal man simpelt nok kalde en anden statisk factory der laver en anden slags
	 * executor service kaldet end Thread Pool,
	 * man kan lave en threadpool med et fixed antal eller et variablet nummer
	 * af tråde. Java.util.concurrent.Executors klassen indeholder statiske factories
	 * der giver en de fleste executors som man nogensinde har brug for. Og hvis man 
	 * vil lave sin egen kan man bruge en ThreadPoolExecutor direkte, den gør det muligt at styrer
	 * næsten enhvert aspekt i en thread pools operation.
	 * 
	 * Man skal vælge hvilken slags Executor service man vil bruge
	 * på et tidspunkt. 
	 * Hvis man skriver et lille program, eller en let-loaded
	 *  server, så kan man bruge  Executors.newCachedThreadPool som er et generalt godt valg, siden
	 *  den ikke har brug for nogen configuration og generalt gør 'den rigtige ting' 
	 *  men en cached thread pool er ikke en god ide for heavily loaded produktions servere, I en cached Thread pool,
	 *  så er modtagede opgaver ikke sat i kø med det samme, men givet til en tråd
	 *  for at blive kørt,  og hvis ingen tråde er ledige, så laver den en ny en, dette
	 *  bliver den ved med selvom hele systemets CPU kører på højtryk, dvs. at det kun gør problemet værre og værre for nu flere
	 *  tråde der bliver lavet, og der er ingen kontrol på dette.  Derfor i et heavily loaded produktions 
	 *  server er det en god ide at man bruger Executors.newFixedThreadPool, som giver en, en fixed mængde af tråde, 
	 *  eller også kan man direkte brug ThreadPoolExecutor klassen for maximum kontrol..
	 *  
	 *  
	 *  Man burde ikke skrive sine egne work queues længere, og man burde fuldstændig stoppe med at arbejde direkte med tråde.
	 *   Thread plejede at være 'the unit of work and the mechanism for executing it' men nu har vi opdelt disse, 
	 *   nøgle abstraktionen er nu 'the unit of work' som kaldes en task, der er 2 slags tasks,
	 *    Runnable og dens fætter Callable(som er ligesom Runnable, bortset fra at den returnere en værdi).
	 *    Og så er den generalle mekanisme til at udfører opgaver en 'executor service'. Hvis man tænker i disse begreber og lader 
	 *    en executor service execute tasks så får man den fleksibilitet at man kan vælge hvilke de rigtige execution 'policies'.
	 *    'In essence, the Executor Framework does for execution what the Collections Framework did for aggregation.
	 *    
	 *    Det her Executor Framework har også en erstatning for java.util.Timer, som hedder ScheduledThreadPoolExecutor. Mens det er lettere 
	 *    at bruge en timer, så er en scheduled thread pool executor meget mere fleksible. En timer bruger kun en enkelt Thread for task execution, 
	 *    som kan være dårligt for ens timing accuracy når der er lange running tasks.
	 *    Hvis timerens eneste tråd kaster en uncaught exception, så stopper timeren med at oprerer. imens en Scheduled Thread Pool executor har support
	 *     for flere tråde og kommer tilbage elegant fra tasks der smider unchecked exceptions.
	 *     Man kan evt. læse bogen 'Java concurrency in Practice' for mere om executor services osv.
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
