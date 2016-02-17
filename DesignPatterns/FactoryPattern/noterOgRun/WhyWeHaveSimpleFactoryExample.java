//package noterOgRun;
//
//public class WhyWeHaveSimpleFactoryExample 
//{
//	/**
//	 * Har lige et eksempel her som viser hvor vi har den her guideline(som ikke er et design pattern
//	 * , det er blot god skik, dette kan let forveksles med Factory Pattern som vi ogs� har pr�vet
//	 * at dokumentere i den her sektion). 
//	 * 
//	 * det f�lgende code snippet viser hvordan kode kan ende med
//	 * at se ud hvis vi i runtime skal bestemme os for hvilket
//	 * objekt vi har lyst til at instansiere -- og det er blot
//	 * pga. mangel p� vores erfaring at vi ikke genkender det her s�
//	 * meget. 
//	 */
//	
//	Duck duck;
//	
//	if(picnic)
//	{
//		duck = new MallardDuck();
//	}
//	else if(hunting)
//	{
//		duck = new DecoyDuck();
//	}
//	else if(inBathTub)
//	{
//		duck = new RubberDuck();
//	}
//	/**
//	 * Problemet med den her kode er at man skal f�lge det princip 
//	 * der lyder "closed for modifications, open for extensions" - som det her ikke f�lger,
//	 * her skal vi �bne koden op senere for at tilf�je noget mere.
//	 */
//	
//}
