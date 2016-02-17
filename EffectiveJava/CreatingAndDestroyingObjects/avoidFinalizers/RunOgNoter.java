package avoidFinalizers;

/**
 * Okay - s� 'Avoid Finalizers'
 * 
 * 'Finalizers are unpredictable, often dangerous, and generally unnecessary'
 * �benbart er det noget c++ programm�rer nogle gange kan komme til at forbinde
 * med destructors.
 * 
 * det de mener med dette er at n�r vi f.eks laver et try-with-ressources eller
 * bare en try-catch-finally block i java, s� m� man under ingen omst�ndigheder ligge noget
 * tidsafh�ngigt kode derind som afh�nger af at den code snippet bliver f�rdigt relativt til noget
 * andet.   Og det giver jo fin mening fordi hvis den code snippet tager lang tid og man ikke havde 
 * regnet med det, af hvilken som helst �rsag f.eks at sende en fil i en try-with-ressources og modtageren s�
 * mister forbindelsen efter lang tid, s� skal andet kode jo ikke lige pludselig lave et kald som starter en helt ny
 * chain-of-events hvis vi er igang med noget andet.
 * et andet godt eksempel som s� ikke ville forekomme i en try-with-ressources(m�ske?) fordi
 * den er auto-closable, men man burde alle lukke en fil fordi 'open file descriptors'
 * er en limited ressourse. S� hvis en applikation �bner en masse filer,
 * og den er lidt langsom om at lukke dem igen, fordi 
 * finally ikke har nogen grund til at blive kaldt,
 * s� kan vi lige pludselig ikke �bne flere filer.
 * M� lige se om der bliver givet et alternativ til dette,
 * men ellers m� man lige s�ge efter det. 
 * 
 * En real-life eksempel der bliver brugt er at en af personens kollegaer havde debugged p� en
 * gui som fik en OutOfMemoryError - og da de s� tjekkede det igennem fandt de 1000 graphic objekter
 * der alle sammen ventede p� at blive finalized, men fordi finalize tr�den havde en lavere prioritet
 * var der en starvation agtig effekt. 
 * 
 * Man skal ogs� v�re obs p� at der er forskel p� computere, og der er ikke
 * nogen garanti for hvilken tr�d der st�r for at finalize(ikke helt sikker p� hvad
 * de mener med dette, men det m� v�re styrer systemet der m�ske giver finalize en lavere prioritet,
 * men man kan jo hardcode thread prioriteter, s� det virker lidt fjollet m�ske?) .
 * side 50 kan man l�se mere om dette. Men en anden ting er at
 * finalizers m�ske slet ikke bliver udf�rt, fordi man har mistet referencen til objektet -
 * og det er der hvor det bliver lidt farligt :)
 * og den store konklusion lyder p� :"Never depend on a finalizer to update critical persistent state"
 * - det betyder f.eks at hvis man har en finalizer der st�r for at release ressourcer 
 * som er system kritiske som f.eks en database. s� er det en god m�de at s�tte hele applikationen
 * over styr. 
 * Der er metoder som System.gc og System.runFinalization-
 * som g�r oddsne bedre for at disse bliver k�rt, men de guaranterer det ikke.
 * De eneste metoder der virker til at guaranterer at finalize bliver k�rt er System.runFinalizersOnExit og dens
 * onde tvilling Runtime.runFinalizersOnExit - disse metoder er vildt
 * bugged og er blevet deprecated.
 * 
 * og til allersidst - hvis man stadg ikke er overbevist om at finally blocks
 * er helt ude og skide, s� har de ogs� hvad bogen beskriver som 'severe' performance penalties
 * ved at bruge det, og det kunne man enlig godt forestille sig n�r man t�nker
 * over hvordan metode kald g�r rundt i systemet, at systemet s� skal holde �je med
 * hvorn�r et eller andet objekt stopper med at k�rer for at den kan execute en finalize.
 * 
 * hvis man vil �del�gge et objekt s� koster det 5.6 ns(nano-seconds),
 * imens det tager 2,400 ns hvis man g�r det i en finally block,
 * s� m�ske skal vi ikke bruge vores try-with-ressources alligevel :D :D  
 * eller ogs� er der undtagelser hvor performance kan klare det... men hvis man
 * kan finde veje udenom s� skal man helt sikkert g�re det.
 * hvis man er interesseret er det 430 gange hurtigere uden finally.
 * 
 * (OBS!) nu kommer det vigtige - som er hvad man s� skal g�re nu n�r man ikke
 * m� bruge finally blocken.
 * 
 * 'provide an explicit termination method', hvad deres vej til dette
 * er at den klasse som har finally blocken, skal have et private field 
 * ligesom et flag, der bliver sat n�r den er f�rdig, og s� smider vi bare en exception
 * hvis der er nogen som pr�ver at f� adgang til det objekt de vil have fat i,
 * hvis vores flag st�r p� terminated.
 * jeg h�bede lidt p� et kode eksempel, m� lige se,
 * ellers er det her helt sikkert noget der er v�rd at unders�ge p� stackoverflow.
 * Nogle eksempler p� explicit termination metoder
 * er close() metoden p� InputStream, OutputStream og java.sql.Connection. 
 * andre eksempleer er java.util.Timer, 
 * eksempler fra java.awt inkludere Graphics.dispose() og 
 * Window.dispose(); disse metoder er ofte overset med forudsigelige
 * forf�rdelige performance konsekvenser. 
 * 
 * Den er nu n�et til der hvor man siger, okay, hvad er den s� god for,
 * og det er n�r man vil lave et safety-net, alts� at sikrer at noget bliver lukket,
 * og s� bare sige f�r eller siden er bedre end aldrig.  Men man skal t�nke
 * lang tid og grundigt over at bruge det - fordi det ogs� handler om performance.
 * de 4 klasser som vi gav som eksempel bruger Finalizers som safetynets alts� (FileInputStream, FileOutputStream
 * , Timer og Connection) og det er nogle som skal bruges hvis termination
 * metoderne ikke bliver kaldt. Trist er det dog at disse finalizers
 * ikke logger advarsler, som man foretr�kker at de g�r. 
 * (h�ber stadig p� et kode eksempel). okay bogen g�r bare videre -
 * den er tydeligvis meget teoretisk p� nogle punkter, men i det mindste
 * har vi nogle guidelines til hvad vi kan google n�r internettet kommer.
 * 
 * En anden legitim grund til at bruge finalizers er objekter med 'native peers'
 * kan l�se mere om dette p� side 52-53, handler om n�r subclasses
 * overrider finally metoden osv. men alts� - 
 * jeg tror der g�r et par �r f�r det bliver relevant lol.
 * 
 * og det er typisk at der lige er kode eksempler p� disse, som 
 * man ikke rigtig har nogen reference til.
 * 
 * 
 * grunden til at det blev lidt hardcore der til sidst var selF at det var den sidste
 * del af kapitlet, s� det er vel okay ... bogen siger selv 
 * at alle afsnit er individuelle og man ikke beh�ver at l�se den ende-til-anden
 * som vi g�r- s� det giver fin mening at sv�rhedsgraden stiger som en enhed igennem
 * et helt kapitel og genstarter ved n�ste kapitel(relativt).
 * @author DenLilleMand
 *
 */
public class RunOgNoter 
{
	public static void main(String[] args) {
		
	}

}
