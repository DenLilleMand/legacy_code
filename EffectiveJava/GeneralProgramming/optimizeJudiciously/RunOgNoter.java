package optimizeJudiciously;

public class RunOgNoter {

	/**
	 * Optimize judiciously
	 * tl;dr;
	 * 
	 * Do not strive to write fast programs -- strive to write good ones;
	 * speed will follow. Do think about performance issues while you're
	 *  designing systems and especially while you're designing API's, wire-level protocols,
	 *  and persistent data formats. If it's fast enough, you're done. If not, locate the source 
	 *  of the problems with the aid of a profiler, and go to work optimizing the relevant parts
	 *  of the system. The first step is to examine your choice of algorithms: no amount of low-level
	 *  optimization can make up for a poor choice of algorithm. Repeat this process as necessary, measuring the performance 
	 *  after every change, until you're satisfied.
	 *  
	 *  og en side-note, når man designer en API, så ofte
	 *  skal man lade være med at give konkrete implementationer, så hænger
	 *  man på dem resten af livet(er ikke helt sikker på om de mener at 
	 *  clients selv burde skrive koden, fordi det er vel absurd?) anyway,
	 *  måske er pointen bare at når man skriver en konkret implementation til en API, så hænger man på den,
	 *  så hvordan undgår man det.
	 * -----------------
	 * Noter:
	 * Der er nogle meget sjovt citater på side 257 om
	 * optimering, og de fleste af dem er - "dont do it, unless youre a fucking genius".
	 * 
	 * 'Strive to write good programs rather than fast ones'
	 * 
	 * Hvis et godt program ikke kører hurtigt nok,
	 * så vil dens gode arkitektur tillade at den bliver optimeret,
	 * hvis man bruger sine design principper, hvor 
	 * implementationen er gemt væk, så er det muligt bagefter at gå ind og ændre i denne implementation
	 * , uden at ændre på den omgivende kode.
	 * 
	 * og det er så selF givet, at hvis man har et hurtigt program men elendigt design,
	 * så kan en enkelt lille ting slå en ud af kurs og så skal 
	 * man skrive hele systemet om.
	 * 
	 * 'Strive to avoid design decisions that limit performance'
	 * Det er specielt API's for vores vedkommende der er umulige at ændre bagefter, så
	 * vi skal være meget omhyggeligt når dette skal designes.
	 * 
	 * Hvis man så alligevel er på vej ned af en vej, for at finde ud af hvor man kan optimere
	 * , så er det vigtigt at man måler hastigheder før og efter og dokumentere hvad 
	 * man har brugt sin tid på. desuden før man går i gang skal man bruge profiling tools, til at
	 * finde ud af hvor i programmet der bliver brugt mest tid. Det er specielt
	 * vigtigt i et sprog som java, at optimere(hvilket er lidt modstridende) men det skal forstås i den forstand
	 * at det er ENDNU mere vigtigt i java, end i nogle andre sprog, fordi vores 'performance model' ikke er specielt
	 * godt dokumenteret, specielt de primitive operationer.
	 * så for at opsummere, det som programmøren skriver
	 * rent semantic mæssigt, er meget langt fra hvad CPU'en udfører
	 * i den forstand at man kan ændre fra Long til long, og så udfører CPU'en 
	 * noget helt andet og meget hurtigere, så OBS.
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{

	}
}
