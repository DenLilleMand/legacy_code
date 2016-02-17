package avoidCreatingUnnecessaryObjects;

public class RunOgNoter {
/**
 * starter på side 43,
 * og handler tydeligvis om hvordan man kan undgå
 * at instansiere unødvendige objekter.
 * @param args
 */
	public static void main(String[] args) {
		/**
		 * det følgende stykke kode er tilføjet som et 
		 * ekstremt tilfælde som man for alt i verden skal undgå :)
		 * forklare at hvis dette stykke kode kørte i et loop
		 * så ville flere millioner String objekter blive skabt
		 * uden nogen verdens nytte. og giver et forbedret eksempel neden-
		 * under(som nok heller ikke er det mest optimale, vi får at se).
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
		 * også for at decouple denne variable fra vores klasse,
		 * lose-coupling princippet :)
		 */
		
		/**
		 * det næste stykke kode viser hvad man IKKE skal gøre,
		 * jeg har lavet en klasse til det som hedder Person.
		 */
		
		
		
	}

}
