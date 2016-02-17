package onlineTutorial;

public class Tutorial5AWebApplicationUsingMaven 
{
	/**
	 * tl;dr;
	 * 
	 * man filter archetypes igennem maven ved at bruge:
	 * 
	 * mvn archetype:generate -Dfilter=org.apache:struts
	 * hvor  org.apache  er groupID og struts er artifactId
	 * 
	 * 
	 * 
	 * ------------------------------------------
	 * Noter:
	 * laver et nyt projekt.
	 * ved at søge efter   mvn archetype:generate -DFilter=org.codehaus:webapp
	 * 
	 * og så kom den frem med et par foreslag,
	 * 
	 * vi gik så ind i vores pom.xml fil, og vi kan nu se de forskellige ting er 
	 * som vi satte dem efter vi havde genereret filen, packaging er dog anderledes end tidligere,
	 * det er en .war fil, fordi det er en webapplication, 
	 * og hvad jeg kan læse mig frem til, man kan åbenbart "deploy" en warfil igennem  'apache tomcat'
	 * en af apaches andre frameworks som vi nok kommer til på et tidspunkt.
	 * 
	 * vi kan også se i vores pom.xml at
	 * artifactId  maven-compiler-plugin  bliver nævnt,
	 * og det er vidst nok det plugin som downloader alle de der ting,
	 * og det er noget default som er med hos alle maven projekter, men 
	 * man behøver ikke at nævne den, udover hvis man vil modificere den, og det er
	 * det der ske i lige vores pom.xml fil inde i den
	 *  bracket som hedder configuration.
	 *  
	 *  som sagt, så efter vi har packaged vores webapp
	 *  så giver den os en .war fil som output, denne
	 *  kan man bare smide direkte over i tomcat, og kører den uden problemer.
	 *  
	 *  hvad der er lidt sjovt når man laver dette projekt,
	 *  så har java folderen ikke noget kode by-default, men inde i vores
	 *  webapp folder, der ligger en  .jsp  fil, med en helloworld klar til ens browser
	 *  
	 *  hvordan man åbner en .war fil med tomcat:
	 *  
	 *  You can access your application from: http://localhost:8080/sample
Deploying or redeploying of war files is automatic by default - after copying/overwriting the file sample.war, check your webapps folder for an extracted folder sample.
If it doesn't open properly, check the log files (e.g. tomcat/logs/catalina.out) for problems with deployment.
	 * 
	 * Når man har installeret tomcat sådan at den kører på ens localhost,
	 * så kan man gå ind på localhost, logge ind på tomcat, og så er der en funktion tæt på nederst hvor man kan uploade en 
	 * .war fil under en overskift der hedder "deploy"
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
}
