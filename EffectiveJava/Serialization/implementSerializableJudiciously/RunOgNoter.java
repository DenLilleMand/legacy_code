package implementSerializableJudiciously;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class RunOgNoter {
	/**
	 * Implement Serializable Judiciously
	 * tl;dr;
	 * To summerize:'The ease of implementing Serializable is specious.
	 *  Unless a class is to be thrown away after a short period of use, implementing
	 *  Serializable is a serious commitment that should be made with care. Extra caution is warranted if a class is designed
	 *  for inheritance. For such classes, and intermediate design point between implementing Serializable and prohibiting it in subclasses
	 *  is to provide an accessible parameterless constructor. This design point permits, but does not require, subclasses to implement Serializable.'
	 * 
	 * desuden s� handler n�ste sektion om hvordan man konkret implementere sin custom Serializable
	 * klasse, s�dan at man ikke f�r alle felterne med.
	 * ----------------
	 * Noter:
	 * 
	 * 'A major cost of implementing Serializable is that it 
	 * decreases the flexibility to change a class's implementation once it has been released'
	 * 
	 * og det er selF fordi at dens byte-stream encoding(eller serialized form)
	 * bliver en del af den eksportede API. 
	 * 
	 * s� bogen her taler om at n�r man f�rst har smidt 
	 * den serialized form ud i den eksportede API, s� skal vi
	 * support den forevigt, 
	 * hvilket vel ogs� betyder at alle vores metoder og felter ikke kan optimeres osv.
	 * 
	 * Alt dette sker, hvis man ikke tager sig tiden til at ksirve sin egen 'custom serialized form', men blot 
	 * acceptere den 'default form'.  Med andre ord s� 
	 * hvis man acceptere den default serialized form, s� er klassens private og package-private instance fields
	 * blevet en del af den eksportede API,  og den praksis som g�r ud p� at minimere
	 * adgang til felter mister dens effektivitet i den forstand at den ikke kan bruge 'information hiding' l�ngere.
	 * 
	 * Hvis man acceptere den default version og senere �ndre klassens interne repr�sentation, s� 
	 * kan det som sagt ske at en incompatible �ndring i den serialized from m�ske kan h�nde - hvilket 
	 * i bund og grund betyder at clients som f�r en Serialized instans af en gamle version af klassen men pr�ver at deserialize den
	 * med den nye version vil f� program fejl.  Det er muligt at bevarer den originale serialized form ved 
	 * at bruge ObjectOutputStream.putFields() og ObjectInputStream.readFields() men det kan v�re sv�rt og det efterlader
	 * 'visible warts in the source code(?)).
	 * 
	 * Derfor burde man designe et h�j kvalitet serialized form som man kan leve med i laaaang tid.
	 * At g�re dette vil koste mere i den f�rste del af udviklingen,  men det er det v�rd.
	 * En rigtig godt designet serialized form kan ligge l� p� udviklingen af en klasse; s� en d�rligt designet serialized form kan fuldst�ndig �del�gge en klasse.
	 * 
	 * UIDs alts� de der auto generated serialize ids, kommer fra Serializable, og de bliver 
	 * lavet ud fra navnet p� klassen og navnene p� interfaces.  Hvis man �ndre en lille metode i klassen, s� vil
	 * dette id �ndre sig, 'if you fail to declare an explicit serial version UID,
	 * compability will be broken, resulting in an InvalidClassException at runtime.'
	 * 
	 * 
	 * 'A second cost of implementing Serializable is that it increases the likelihood of bugs and security holes'.
	 * fordi at deserialize bruger en hidden constructor, glemmer man nogen gange
	 * at de er underlagt de samme constraints som normale
	 * constructors, s� hvis man afh�nger af den default
	 * deserialization mechanism kan man let efterlade 
	 * objektet �ben til invariant curruption og ulovlig adgang(bliver 
	 * ikke rigtig uddybet - s� vi ved ikke hvordan man 
	 * g�r v�k fra den default deserialization).
	 * 
	 * 'A third cost of implementing Serializable is that it increases the testing burden 
	 * associated with releasing a new version of a class' 
	 * Det er vigtigt at n�r man �ndre en allerede Serializable klasse og opdatere den, at man tjekker 
	 * om den nye version kan deserialize den gamle version og vice versa. 
	 * Og nu st�rre'nu'�ndringer, nu mere vigtigt bliver det at teste objektet.
	 * 
	 * 'Implementing the Serializable interface is not a decision to be 
	 * undertaken lightly'
	 * 
	 * 
	 * 
	 * 'Classes designed for inheritance should rarely implement Serializable, and interfaces should rarely extend it'.
	 * Denne regel er lavet fordi det n�rmest er umuligt at implementere eller extende
	 * et interface hvis det er et krav at Serializable ogs� skal implementeres.
	 * Det er lidt for meget at "kr�ve". - det eneste tidspunkt det er okay at bryde denne regel 
	 * er n�r en klasse eller interface prim�rt er med i et framework der afh�nger af at all medlemmer implementere Serializable, der giver det perfekt 
	 * mening at g�re dette.
	 * 
	 * Classes som er designet til arv og som implementere Serializable inkludere
	 * Throwable, Component og HttpServlet. 
	 * grundene til at disse g�r det kan l�ses lige under midten 
	 * p� side 314.
	 * 
	 * En lille ting er at hvis ens superklasse IKKE implementere Serializable er det muligvis umuligt
	 * at lade en subclass implementere dette, hvis man ikke laver en parameterl�s constructor i super klassen.
	 *	='You should consider providing a parameterless constructor on nonserializable classes
	 *designed for inheritance.'
	 *
	 * Det kan jo dog blive et problem at lave en public constructor i ens super klasse,
	 * hvis man har noget state som man gerne vil beskytte, derfor ser vi i eksempel 1,
	 * hvordan man h�ndtere dette.
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
		
		//Nonserializable stateful class allowing serializable subclass
		public abstract class AbstractFoo
		{
			private int x,y; //Our state
			
			//this enum and field are used to track initialization
			private enum State{NEW,INITIALIZING,INITIALIZED};
			private final AtomicReference<State> init = new AtomicReference<State>(State.NEW);
			
			public AbstractFoo(int x, int y) {initialize(x,y);}
			
			//This constructor and the following method allow
			//Subclass's readObject method to initialize our state, protected AbstractFoo();
		}
		
		protected final void initialize(int x, int y)
		{
			if(!init.compareAndSet(State.NEW, State.INITIALIZING))
			{
				throw new IllegalStateException("Allready initialized");
			}
			this.x = x;
			this.y = y;
			...//Do anything else the original constructor did
			init.set(State.INITIALIZED);
		}
		
		//These methods provide access to internal state so it can
		//be manually serialized by subclass's writeObject method.
		protected final int getX() {checkInit(); return x;}
		protected final int getY() {checkInit(); return y;}
		
		//Must call from all public and protected instance methods
		private void checkInit()
		{
			if(init.get() != State.INITIALIZED)
			{
				throw new IllegalStateException("Uninitialized");
			}
			... //Remainder omitted
		}
	}
	
	
	// klassen der subclasser koden f�r dette.
	
	//Serializable subclass of nonserializable stateful class
	public class Foo extends AbstractFoo implements Serializable
	{
		private void readBoject(ObjectInputStream s)throws IOException, ClassNotFoundException	
		{
				s.defaultReadObject();
				
				//Manually deserialize and initialize superclass state
				int x = s.readInt();
				int y = s.readInt();
				initialize(x,y);
		
		}
		
		private void writeObject(ObjectOutputStream s) throws IOException
		{
			s.defaultWriteObject();
			
			//Manually serialize superclass state
			s.writeInt(getX());
			s.writeInt(getY());
		}
		
		//Constructor does not use the fancy mechanism
		public Foo(int x, int y) {super(x,y);}
		
		private static final long serialVersionUID = 22848248248248248L;
	}
}

}
