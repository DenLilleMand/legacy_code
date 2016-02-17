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
	 * med thread scheduler s� tror jeg de mener
	 * det i vores styrersystem som bestemmer hvilken tr�d
	 * der skal k�rer.
	 * 
	 * 'Any program that relies on the thread scheduler for correctness
	 * or performance is likely to be nonportable'.
	 * 
	 * En m�de at skrive en robust, responsiv og portable program er at sikre
	 * sig at det average antal af kerner deres system har,
	 * ikke er under det antal af runnables vi har k�rende samtidigt.
	 * 
	 * hoved teknikken for at holde m�ngden af runnable tr�de nede er at 
	 * hver tr�d skal g�re noget brugbart arbejde og s� vente for mere.
	 * 
	 * 'Threads should not run ifthey aren't doing useful work'
	 * 
	 * i forbindelse med Executor Framework som der er blevet talt om tidligere betyder 
	 * dette blandt andet at man skal size ens Thread pools
	 * til et passende antal.  og at holde ens opgaver passende sm� og uafh�ngige af hinanden, 
	 * Opgaver skal heller ikke v�re FOR sm�, ellers vil dispatch overheaden �del�gge vores performance(?).
	 * 
	 * Threads burde heller ikke 'busy-wait' og checke et delt objekt for at vente p� 
	 * et eller andet, busy-waiting ligger alt for meget arbejde over p� processoren som 
	 * reducere m�ngden af brugbart arbejde som den kan f� udf�rt. 
	 * for at give et ekstremt eksempel for hvad man IKKE skal g�re, kan man 
	 * kigge i kode eksempel 1.
	 * 
	 * Vi havde et CountdownLatch eksempel tidligere, i en af de andre 
	 * concurrency sektioner, det her eksempel er ca 2000 gange langsommere-
	 * og det er for at pointere hvad der sker n�r man har tr�de som bare st�r busy-waiting.
	 * 
	 * 'Resist the tamptation to "fix" the 
	 * program by putting in calls to Thread.yield.' dette er fordi 
	 * hvad der m�ske g�r noget hurtigere p� din JVM kan sagtens g�re det langsommere p� en anden JVM og 
	 * have ingen effekt p� den tredje, hvilket g�r ens program mindre portable.
	 * 
	 * 'Thread.yield has no testable semantics.'
	 * 
	 * En bedre m�de at h�ndtere s�dan et problem, er at omstrukturerer ens m�ngde af sidel�bende runnable tr�de.
	 * 
	 * 
	 * 'Thread priorities are among the least portable features of the Java platform'
	 * -s� yeah.  det virker sku heller ikke, man skal alts� ned og grave i ens underliggende kode
	 * og s� lave noget kode der ikke afh�nger af busy-wait tr�de.
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
