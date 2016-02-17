package avoidFinalizers;

/**
 * Okay - så 'Avoid Finalizers'
 * 
 * 'Finalizers are unpredictable, often dangerous, and generally unnecessary'
 * Åbenbart er det noget c++ programmører nogle gange kan komme til at forbinde
 * med destructors.
 * 
 * det de mener med dette er at når vi f.eks laver et try-with-ressources eller
 * bare en try-catch-finally block i java, så må man under ingen omstændigheder ligge noget
 * tidsafhængigt kode derind som afhænger af at den code snippet bliver færdigt relativt til noget
 * andet.   Og det giver jo fin mening fordi hvis den code snippet tager lang tid og man ikke havde 
 * regnet med det, af hvilken som helst årsag f.eks at sende en fil i en try-with-ressources og modtageren så
 * mister forbindelsen efter lang tid, så skal andet kode jo ikke lige pludselig lave et kald som starter en helt ny
 * chain-of-events hvis vi er igang med noget andet.
 * et andet godt eksempel som så ikke ville forekomme i en try-with-ressources(måske?) fordi
 * den er auto-closable, men man burde alle lukke en fil fordi 'open file descriptors'
 * er en limited ressourse. Så hvis en applikation åbner en masse filer,
 * og den er lidt langsom om at lukke dem igen, fordi 
 * finally ikke har nogen grund til at blive kaldt,
 * så kan vi lige pludselig ikke åbne flere filer.
 * Må lige se om der bliver givet et alternativ til dette,
 * men ellers må man lige søge efter det. 
 * 
 * En real-life eksempel der bliver brugt er at en af personens kollegaer havde debugged på en
 * gui som fik en OutOfMemoryError - og da de så tjekkede det igennem fandt de 1000 graphic objekter
 * der alle sammen ventede på at blive finalized, men fordi finalize tråden havde en lavere prioritet
 * var der en starvation agtig effekt. 
 * 
 * Man skal også være obs på at der er forskel på computere, og der er ikke
 * nogen garanti for hvilken tråd der står for at finalize(ikke helt sikker på hvad
 * de mener med dette, men det må være styrer systemet der måske giver finalize en lavere prioritet,
 * men man kan jo hardcode thread prioriteter, så det virker lidt fjollet måske?) .
 * side 50 kan man læse mere om dette. Men en anden ting er at
 * finalizers måske slet ikke bliver udført, fordi man har mistet referencen til objektet -
 * og det er der hvor det bliver lidt farligt :)
 * og den store konklusion lyder på :"Never depend on a finalizer to update critical persistent state"
 * - det betyder f.eks at hvis man har en finalizer der står for at release ressourcer 
 * som er system kritiske som f.eks en database. så er det en god måde at sætte hele applikationen
 * over styr. 
 * Der er metoder som System.gc og System.runFinalization-
 * som gør oddsne bedre for at disse bliver kørt, men de guaranterer det ikke.
 * De eneste metoder der virker til at guaranterer at finalize bliver kørt er System.runFinalizersOnExit og dens
 * onde tvilling Runtime.runFinalizersOnExit - disse metoder er vildt
 * bugged og er blevet deprecated.
 * 
 * og til allersidst - hvis man stadg ikke er overbevist om at finally blocks
 * er helt ude og skide, så har de også hvad bogen beskriver som 'severe' performance penalties
 * ved at bruge det, og det kunne man enlig godt forestille sig når man tænker
 * over hvordan metode kald går rundt i systemet, at systemet så skal holde øje med
 * hvornår et eller andet objekt stopper med at kører for at den kan execute en finalize.
 * 
 * hvis man vil ødelægge et objekt så koster det 5.6 ns(nano-seconds),
 * imens det tager 2,400 ns hvis man gør det i en finally block,
 * så måske skal vi ikke bruge vores try-with-ressources alligevel :D :D  
 * eller også er der undtagelser hvor performance kan klare det... men hvis man
 * kan finde veje udenom så skal man helt sikkert gøre det.
 * hvis man er interesseret er det 430 gange hurtigere uden finally.
 * 
 * (OBS!) nu kommer det vigtige - som er hvad man så skal gøre nu når man ikke
 * må bruge finally blocken.
 * 
 * 'provide an explicit termination method', hvad deres vej til dette
 * er at den klasse som har finally blocken, skal have et private field 
 * ligesom et flag, der bliver sat når den er færdig, og så smider vi bare en exception
 * hvis der er nogen som prøver at få adgang til det objekt de vil have fat i,
 * hvis vores flag står på terminated.
 * jeg håbede lidt på et kode eksempel, må lige se,
 * ellers er det her helt sikkert noget der er værd at undersøge på stackoverflow.
 * Nogle eksempler på explicit termination metoder
 * er close() metoden på InputStream, OutputStream og java.sql.Connection. 
 * andre eksempleer er java.util.Timer, 
 * eksempler fra java.awt inkludere Graphics.dispose() og 
 * Window.dispose(); disse metoder er ofte overset med forudsigelige
 * forfærdelige performance konsekvenser. 
 * 
 * Den er nu nået til der hvor man siger, okay, hvad er den så god for,
 * og det er når man vil lave et safety-net, altså at sikrer at noget bliver lukket,
 * og så bare sige før eller siden er bedre end aldrig.  Men man skal tænke
 * lang tid og grundigt over at bruge det - fordi det også handler om performance.
 * de 4 klasser som vi gav som eksempel bruger Finalizers som safetynets altså (FileInputStream, FileOutputStream
 * , Timer og Connection) og det er nogle som skal bruges hvis termination
 * metoderne ikke bliver kaldt. Trist er det dog at disse finalizers
 * ikke logger advarsler, som man foretrækker at de gør. 
 * (håber stadig på et kode eksempel). okay bogen går bare videre -
 * den er tydeligvis meget teoretisk på nogle punkter, men i det mindste
 * har vi nogle guidelines til hvad vi kan google når internettet kommer.
 * 
 * En anden legitim grund til at bruge finalizers er objekter med 'native peers'
 * kan læse mere om dette på side 52-53, handler om når subclasses
 * overrider finally metoden osv. men altså - 
 * jeg tror der går et par år før det bliver relevant lol.
 * 
 * og det er typisk at der lige er kode eksempler på disse, som 
 * man ikke rigtig har nogen reference til.
 * 
 * 
 * grunden til at det blev lidt hardcore der til sidst var selF at det var den sidste
 * del af kapitlet, så det er vel okay ... bogen siger selv 
 * at alle afsnit er individuelle og man ikke behøver at læse den ende-til-anden
 * som vi gør- så det giver fin mening at sværhedsgraden stiger som en enhed igennem
 * et helt kapitel og genstarter ved næste kapitel(relativt).
 * @author DenLilleMand
 *
 */
public class RunOgNoter 
{
	public static void main(String[] args) {
		
	}

}
