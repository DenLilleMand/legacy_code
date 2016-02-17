package singletonPattern;

public class SingletonRun {
	
	public static void main (String [] args)
	{
		System.out.println(Singleton.getSingleton());
		System.out.println(Singleton.getSingleton());
		System.out.println(Singleton.getSingleton());
		System.out.println(Singleton.getSingleton());
		
		//Kan bruge enum singleton som et hvilket som helst objekt:
		//Man kan bare tilgå den på 2 forskellige måder, 
		//Der er vidst nok en god grund til at bruge getInstance() 
		//
		EnumSingleton enumSingleton = EnumSingleton.getInstance();
		enumSingleton.setName("herpderp");
		System.out.println(enumSingleton.getName());
		
		EnumSingleton enumSingleton1 = EnumSingleton.INSTANCE;
		System.out.println(enumSingleton1.getName());
		
		
	}

}
