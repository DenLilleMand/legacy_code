package dontDependOnTheThreadScheduler;

public class RunOgNoter 
{
	/**
	 * Don't depend on the thread scheduler
	 * tl;dr;
	 * In summary, do not depend on the thread scheduler for correctness of your
	 * program. the resulting program will be neither robost nor portable. As a corollary,
	 * do not rely on Thread.yield or thread priorities. These facilities are merely hints to the
	 * scheduler. Thread priorities may be used sparingly to improve the quality of 
	 * service of an already working program, but they should never be used to "fix" a program that barely works.
	 * 
	 * ---------------
	 * Noter:
	 * med thread scheduler så tror jeg de mener
	 * det i vores styrersystem som bestemmer hvilken tråd
	 * der skal kører.
	 * 
	 * 'Any program that relies on the thread scheduler for correctness
	 * or performance is likely to be nonportable'.
	 * 
	 * En måde at skrive en robust, responsiv og portable program er at sikre
	 * sig at det average antal af kerner deres system har,
	 * ikke er under det antal af runnables vi har kørende samtidigt.
	 * 
	 * hoved teknikken for at holde mængden af runnable tråde nede er at 
	 * hver tråd skal gøre noget brugbart arbejde og så vente for mere.
	 * 
	 * 'Threads should not run ifthey aren't doing useful work'
	 * 
	 * i forbindelse med Executor Framework som der er blevet talt om tidligere betyder 
	 * dette blandt andet at man skal size ens Thread pools
	 * til et passende antal.  og at holde ens opgaver passende små og uafhængige af hinanden, 
	 * Opgaver skal heller ikke være FOR små, ellers vil dispatch overheaden ødelægge vores performance(?).
	 * 
	 * Threads burde heller ikke 'busy-wait' og checke et delt objekt for at vente på 
	 * et eller andet, busy-waiting ligger alt for meget arbejde over på processoren som 
	 * reducere mængden af brugbart arbejde som den kan få udført. 
	 * for at give et ekstremt eksempel for hvad man IKKE skal gøre, kan man 
	 * kigge i kode eksempel 1.
	 * 
	 * Vi havde et CountdownLatch eksempel tidligere, i en af de andre 
	 * concurrency sektioner, det her eksempel er ca 2000 gange langsommere-
	 * og det er for at pointere hvad der sker når man har tråde som bare står busy-waiting.
	 * 
	 * 'Resist the tamptation to "fix" the 
	 * program by putting in calls to Thread.yield.' dette er fordi 
	 * hvad der måske gør noget hurtigere på din JVM kan sagtens gøre det langsommere på en anden JVM og 
	 * have ingen effekt på den tredje, hvilket gør ens program mindre portable.
	 * 
	 * 'Thread.yield has no testable semantics.'
	 * 
	 * En bedre måde at håndtere sådan et problem, er at omstrukturerer ens mængde af sideløbende runnable tråde.
	 * 
	 * 
	 * 'Thread priorities are among the least portable features of the Java platform'
	 * -så yeah.  det virker sku heller ikke, man skal altså ned og grave i ens underliggende kode
	 * og så lave noget kode der ikke afhænger af busy-wait tråde.
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
		
		//Awful CountDownLatch Implementation - busy-waits incessantly!
		public class SlowCountDownLatch
		{
			private int count;
			public SlowCountDownLatch(int count)
			{
				if(count < 0)
				{
					throw new IllegalArgumentException(count + " < 0");
				}
				this.count = count;
			}
			
			public void await()
			{
				while(true)
				{
					synchronized(this)
					{
						if(count == 0) return;
					}
				}
			}
			
			public synchronized void countDown()
			{
				if(count != 0)
				{
					count--;
				}
			}
		}
	}

}
