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
	 *  og en side-note, n�r man designer en API, s� ofte
	 *  skal man lade v�re med at give konkrete implementationer, s� h�nger
	 *  man p� dem resten af livet(er ikke helt sikker p� om de mener at 
	 *  clients selv burde skrive koden, fordi det er vel absurd?) anyway,
	 *  m�ske er pointen bare at n�r man skriver en konkret implementation til en API, s� h�nger man p� den,
	 *  s� hvordan undg�r man det.
	 * -----------------
	 * Noter:
	 * Der er nogle meget sjovt citater p� side 257 om
	 * optimering, og de fleste af dem er - "dont do it, unless youre a fucking genius".
	 * 
	 * 'Strive to write good programs rather than fast ones'
	 * 
	 * Hvis et godt program ikke k�rer hurtigt nok,
	 * s� vil dens gode arkitektur tillade at den bliver optimeret,
	 * hvis man bruger sine design principper, hvor 
	 * implementationen er gemt v�k, s� er det muligt bagefter at g� ind og �ndre i denne implementation
	 * , uden at �ndre p� den omgivende kode.
	 * 
	 * og det er s� selF givet, at hvis man har et hurtigt program men elendigt design,
	 * s� kan en enkelt lille ting sl� en ud af kurs og s� skal 
	 * man skrive hele systemet om.
	 * 
	 * 'Strive to avoid design decisions that limit performance'
	 * Det er specielt API's for vores vedkommende der er umulige at �ndre bagefter, s�
	 * vi skal v�re meget omhyggeligt n�r dette skal designes.
	 * 
	 * Hvis man s� alligevel er p� vej ned af en vej, for at finde ud af hvor man kan optimere
	 * , s� er det vigtigt at man m�ler hastigheder f�r og efter og dokumentere hvad 
	 * man har brugt sin tid p�. desuden f�r man g�r i gang skal man bruge profiling tools, til at
	 * finde ud af hvor i programmet der bliver brugt mest tid. Det er specielt
	 * vigtigt i et sprog som java, at optimere(hvilket er lidt modstridende) men det skal forst�s i den forstand
	 * at det er ENDNU mere vigtigt i java, end i nogle andre sprog, fordi vores 'performance model' ikke er specielt
	 * godt dokumenteret, specielt de primitive operationer.
	 * s� for at opsummere, det som programm�ren skriver
	 * rent semantic m�ssigt, er meget langt fra hvad CPU'en udf�rer
	 * i den forstand at man kan �ndre fra Long til long, og s� udf�rer CPU'en 
	 * noget helt andet og meget hurtigere, s� OBS.
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{

	}
}
