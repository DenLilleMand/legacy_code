package onlineTutorial;

public class Tutorial6IntroductionToPluginsWithMaven {
	/**
	 * tl;dr;
	 * 
	 * 
	 * 
	 * 
	 * -----------------------
	 * Noter:
	 * plugins er den måde vi kan extende
	 * mavens opførsel på. den har en meget modular opførsel,
	 * selv compileren er et plugin, så vi kan configurerer maven
	 * til den måde vi har lyst til at bruge det til.
	 * 
	 * I vores pom.xml fil i den webapp vi lavede i sidste tutorial,
	 * kan vi se at under compileren, plugin - 
	 * under <configuration>  
	 * så har vi skrevet at source koden(altså javas version) 
	 * er 1.4, dvs. at generics/enums ikke ville være accepteret 
	 * med den her compiler specifikation.
	 * 
	 * åbenbart er source også med.
	 * 
	 * så vi prøver at lave en java fil der bruger generics, og prøver at compile den.
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
}
