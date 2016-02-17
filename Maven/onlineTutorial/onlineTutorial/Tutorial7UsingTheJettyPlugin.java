package onlineTutorial;

public class Tutorial7UsingTheJettyPlugin 
{
	/**
	 * tl;dr;
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * ------------------------------------------
	 * Noter:
	 * Jetty er en light-weight container for ens webapp
	 * og noget af det som gør Jetty sejt, er at 
	 * man kan configurerer dens plugin i pom.xml filen,
	 * hvor man automatisk kan sætte den til at lytte til klasse
	 * ændringer, dvs. at hver gang vi ændre i en klasse, så redeployer den vores
	 * klasser.
	 * 
	 * dvs. at vores pom.xml kommer til at have det her stående:
	 * (det som man skal kigge efter er det i vores configuration bracket)
	 *  <build> 
  	<plugins>
  		<plugin>
  			<groupId>org.mortbay.jetty</groupId>
  			<artifactId>maven-jetty-plugin </artifactId>
  			<version> 6.1.10 </version>
  			<configuration>
  				<scanIntervalSeconds> 5 </scanIntervalSeconds>
  			</configuration>
  		</plugin>
  	</plugins>
  </build>
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
}
