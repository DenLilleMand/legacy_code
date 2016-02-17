package tutorial5ApplicationContextAndPropertyInitialization;

public class Noter 
{
	/**
	 * OBS! - vi kører kun med 1 xml fil, så nogle gange så bliver navnene 
	 * skiftet på klasserne, så man skal lige ind og redigere i 
	 * spring.xml før man kan kører nogle af de her eksempler højst sandsynligt.
	 * 
	 * 
	 * Noter:
	 * Okay, så vores tutorial 4 DrawingApp klasse vil gerne have spring.xml
	 * i vores projekt ved siden af vores pom.xml, imens tutorial5 
	 *	's  DrawingApp kun godtager filen hvis den er i vores src/main/java 
	 *	directory.  anyway- så vidt jeg forstår så gør de nogenlunde det samme,
	 *	man bruger den i tutorial 4 udelukkende hvis ens program virkelig 
	 *afhænger af performance, imens vores tutorial 5 version er vores go-to
	 *
	 * Denne tutorial viser hvorfor det er så smart med det her initialisering,
	 * i stedet for bare at bruge normalt.
	 * 
	 * denne form for injection hedder 'setter injection', fordi Spring bruger
	 * vores setter metoder i Triangle klassen til at sætte værdien, så vi skal
	 * være obs på hvad der sker hvis vi ingen setter metoder har, når vi prøver på dette.
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
}
