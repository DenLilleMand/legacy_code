package alwaysOverrideToString;

public class NoterOgRun 
{
	/**
	 * Okay, s� man skal altid @Override toString()
	 * det er da noget vi kan forst�, problemet med toString()
	 * er vel at den returnere et objekts identitet istedet for at returnere
	 * noget brugbar information f.eks i en PhoneNumber klasse burde den returnere
	 * en String med det telefon nummer.
	 * en af de ting der g�r det til en god ide,
	 * er slet ikke at folk ville bruge en toString() metode p� den for at
	 * bruge det i koden, men n�r en Debugger f.eks k�rer s� 
	 * bruger den toString() metoden til at fort�lle hvad der sker.
	 *	hmm .. det virker faktisk lidt til at til sidst i det Item
	 *der hedder @Override allways String, s� virker det til at andre 
	 *programm�rer m�ske for lov til at bruge ens toString() metode
	 *til at lave rigtig programmering. s� man skal declare 
	 *hvilken format det bliver returneret i - der er nogle foreslag p� side 76.
	 *Og dette er specielt fordi man ikke har lyst til at have ens kollegaer sidde og parse
	 *ens toString() metoder fordi de er i tvivl om formatet.
	 * @param args
	 */
	public static void main(String[] args) 
	{

	}

}
