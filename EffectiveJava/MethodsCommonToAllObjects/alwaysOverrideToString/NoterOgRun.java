package alwaysOverrideToString;

public class NoterOgRun 
{
	/**
	 * Okay, så man skal altid @Override toString()
	 * det er da noget vi kan forstå, problemet med toString()
	 * er vel at den returnere et objekts identitet istedet for at returnere
	 * noget brugbar information f.eks i en PhoneNumber klasse burde den returnere
	 * en String med det telefon nummer.
	 * en af de ting der gør det til en god ide,
	 * er slet ikke at folk ville bruge en toString() metode på den for at
	 * bruge det i koden, men når en Debugger f.eks kører så 
	 * bruger den toString() metoden til at fortælle hvad der sker.
	 *	hmm .. det virker faktisk lidt til at til sidst i det Item
	 *der hedder @Override allways String, så virker det til at andre 
	 *programmører måske for lov til at bruge ens toString() metode
	 *til at lave rigtig programmering. så man skal declare 
	 *hvilken format det bliver returneret i - der er nogle foreslag på side 76.
	 *Og dette er specielt fordi man ikke har lyst til at have ens kollegaer sidde og parse
	 *ens toString() metoder fordi de er i tvivl om formatet.
	 * @param args
	 */
	public static void main(String[] args) 
	{

	}

}
