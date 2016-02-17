package noter;

public class NoterGeneralt 
{
	/**
	 * 
	 * tl;dr;
	 * Det er vigtigt at vi laver 'regression tests' - hvilket vil sige at vi 
	 * laver en ny test metode for hver parameter vi vil teste.
	 * 
	 * Det er også vigtigt at vi specielt tester borderline parameter, 
	 * som f.eks hvis vi regner med at intervallet 10-20 går godt, så burde man hvertfald teste
	 * 9-11 /  19-21   og så teste et rigtig rigtig lavt tal, og et rigtig rigtig højt tal.
	 * 
	 * 
	 * En samling af tests hedder et 'test sweep', men det er ikke så ofte at man har lyst til at teste
	 * alle sine tests igennem. 
	 * 
	 * Så oftest samler man nogle bestemte tests i en pakke.
	 * 
	 * 
	 * unitTests er hvor man tester 'mindst muligt', altså 1 metode.
	 * 
	 * Hvor Integration test er hvor man tester et helt kald oppe fra f.eks GUI'en og så hele vejen ned til DB.
	 * 
	 * 
	 * 
	 * TDD = Test Driven Development
	 * 
	 * I TDD, så starter man med at lave en car klasse f.eks, med 2 attributter,
	 * så laver man getters/setters, og så tester man disse metoder, og finder ud af hvilken
	 * exception disse metoder skal smide, hvad grænsen er osv med det samme,
	 * dvs. at vores test cases skal have os til at aktivt tænke, hvad skal den her metode faktisk kunne, 
	 * og hvad skal den ikke kunne. og jeg tænker specielt i forhold til at overholde alle reglerne
	 * fra effective java, så kunne det her bringe os ned i det tempo der er nødvendigt for at overholde
	 * alle reglerne, god dokumentation, generiske inputs, kaste de rigtige exceptions, håndtere
	 * de rigtige use-cases osv. osv.
	 * 
	 * 
	 *  * Eksempel på TDD, og det får en til at virke som en endnu bedre programmør,
 * fordi de ting man pusher ikke går i stykker specielt ofte. Der er et eksempel på dette over i CarTest 
 * klassen,
	 * 
	 * TF = Test First
	 * 
	 * 
	 * 
	 * ----------------------------------------------------------
	 * Noter:
	 * 
	 * 
	 */
}
