package avoidCreatingUnnecessaryObjects;

public class RunOgNoter {
/**
 * starter p� side 43,
 * og handler tydeligvis om hvordan man kan undg�
 * at instansiere un�dvendige objekter.
 * @param args
 */
	public static void main(String[] args) {
		/**
		 * det f�lgende stykke kode er tilf�jet som et 
		 * ekstremt tilf�lde som man for alt i verden skal undg� :)
		 * forklare at hvis dette stykke kode k�rte i et loop
		 * s� ville flere millioner String objekter blive skabt
		 * uden nogen verdens nytte. og giver et forbedret eksempel neden-
		 * under(som nok heller ikke er det mest optimale, vi f�r at se).
		 */
		String s = new String("Stringette"); 

		/**
		 * det forbedrede stykke kode:
		 */
		String s1 = "stringette";
		/**
		 * dette er et bedre stykke kode pga.
		 * der aldrig bliver lavet mere end det ene objekt,
		 * men stadig er det bedre at bruge en factory metode,
		 * ogs� for at decouple denne variable fra vores klasse,
		 * lose-coupling princippet :)
		 */
		
		/**
		 * det n�ste stykke kode viser hvad man IKKE skal g�re,
		 * jeg har lavet en klasse til det som hedder Person.
		 */
		
		
		
	}

}
