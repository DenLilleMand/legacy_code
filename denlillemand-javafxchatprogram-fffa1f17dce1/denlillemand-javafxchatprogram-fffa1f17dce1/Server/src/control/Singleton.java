package singletonPattern;

public class Singleton {
	//Static, for metoden getSingleton() skal kunne instantiere et objekt
	//uden at klassen Singleton er instantieret endnu, derofor skal metoden være static
	private static Singleton instance;

	// privat konstruktør
	private Singleton() {
		if(instance!=null){
			System.err.print("There can be one and only one!");
		}
	}
	
	//Static metode så den kan kaldes uden at et objekt af typen Singleton er instantieret.
	public static Singleton getSingleton() {
		if (instance == null) {
			System.out.println("Now we've created a new Singleton!");
			//lazy initialization
			instance = new Singleton();
		}
		return instance;
	}

}
