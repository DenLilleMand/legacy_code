package avoidExcessiveSynchronization;

public class RunOgNoter {
	/**
	 * Avoid excessive synchronization
	 * tl;dr;
	 * in Summary:
	 * 'To avoid deadlock and data corruption, never call an alien
	 *  method from within a synchronized region. More generally, try to limit the amount of 
	 *  work that you do from within synchronized regions. When you are designing a mutable class
	 *  , think about whether it should do its own synchronization. In the modern
	 *   multicore era, it is more important than ever not to synchronize excesseively. Synchronize your class internally 
	 *   only if there is a good reason to do so, and document your decision clearly.'
	 * 
	 * 
	 * ---------------
	 * Noter:
	 * Den forrige sektion talte for Synchronization,
	 * og det her er s� modspillet, det virker som om at det 
	 * er meget situational.
	 * Pointen her er at der er nogle performance ting bundet op p� det.
	 * 
	 * 'To avoid liveness and safety failures, never cede control to the client 
	 * within a synchronized method or block'.
	 * 
	 * for at sige det med andre ord, s� m� vi ikke kalde en metode
	 * som er @Override, i en synchronized block , for det stykke kode er 
	 * "alien" fra hvad vi kender til, alts� i den forstand at hvis objektet
	 * kommer fra client kode, og vi kalder en @Override metode s� kan det v�re hvad som helst.
	 * 
	 * hvilket kan for�rsagde exceptions, deadlock og data korruption.
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{

	}

}
