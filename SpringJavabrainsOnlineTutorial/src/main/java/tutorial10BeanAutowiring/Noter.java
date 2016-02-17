package tutorial10BeanAutowiring;

public class Noter 
{
	/**
	 * Noter:
	 * Hvis beansne har samme navne
	 * som variablerne, gør det Det her wireing byName muligt.
	 * 
	 * auto-wiring kan gøres både med navn på variablen, hvilket giver fin mening, men det kan også
	 * gøres byType, og så må vi ikke have mere end 1 af den samme type, ellers kan Spring ikke finde ud af det.
	 * 
	 * ellers kan man auto-wire med en constructor
	 * 
	 * hvis man ikke skriver autowire="byType eller en af de andre" så er den default bare   no-wireing. 
	 * 
	 * 
	 * 
	 */
}
