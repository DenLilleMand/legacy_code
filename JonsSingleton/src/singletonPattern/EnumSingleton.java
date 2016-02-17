package singletonPattern;

/**
 * Hvorfor bruger vi Singleton enums?
 * -største fordel: lette at skrive(Hvis man også taler om at skulle tage sig af Serialization,
 * Double checking mhs. til thread safety når man laver objektet.)
 * -Skabelsen af en enum er Thread Safe, så det får vi gratis(i modsætning til double checking
 * i den anden enum)
 *
 */
public enum EnumSingleton {
	INSTANCE;
	private String name;

	public String getName() {
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}

	EnumSingleton() {

	}

	public static EnumSingleton getInstance() {
		return INSTANCE;
	}

}
