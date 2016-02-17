package onlineTutorial;

public class Tutorial4AddingADependency 
{
	/**
	 * tl;dr;
	 * 
	 * Der er flere hjemmesider til at finde de forskellige
	 * maven dependencies.
	 * en af dem er:'mvnrepository.com'
	 * 
	 * inde på denne hjemmeside kan man bare hente jarfilen ned,
	 * og tilføje den som vi normalt gør igennem eclipse,
	 * men det behøver vi slet ikke med maven, man søger bare efter
	 * den archetype man er interesseret i, klikker på den - går ind på
	 * den seneste 'release' 'type' - så nedenunder der hvor der står
	 * download jar, er der en dependency man bare kan copy paste ind i ens pom.xml
	 * fil. og så næste gang man compiler, så downloader den det bare automatisk.
	 * 
	 * sonatype er bla et af de selskaber der gør meget for maven,
	 * så hvis man støder på en af deres hjemmesider er det ikke nødvendigvis dårligt.
	 * 
	 * vi har dog ikke vores scope værdi i det vi har copy pasted,
	 * så det der sker når vi ikke har tilføjet et scope, så giver den vores default,
	 * hvilket vil sige at  den får et <scope> compile </scope>   
	 * hvilket vil sige at den jar, kun er tilgængelig ved compile time(hvilket ikke
	 * betyder at man ikke kan kører filen tror jeg, men jeg tror at hvis vi kørte 
	 * en build phase som var senere hen, f.eks install, så ville den få et default scope som
	 * ville give os jar filen til loggeren med i vores egen jar)
	 * 
	 * 
	 * 
	 * 
	 * -----------------------------------------
	 * Noter:
	 * vi har tænkt os at ændre vores pom.xml i den her tutorial,
	 * 
	 * cd myapp/maventestapp
	 * 
	 * vi brugte  mvn clean  
	 * som sletter vores target folder, hvilket vil
	 * ligne det samme som når man lige har lavet ens projekt.
	 * 
	 * grunden til at vi kørte den, var fordi de forrige tutorials havde kørt
	 * en masse ting i den der target folder, og lavet nogle filer,
	 * så dem gad vi ikke lige at have.
	 * 
	 * anyway, vi gik ind og tilføjede en logger i form af 'slf4j'-
	 * prøvede at importere den, vi tilføjede det bare direkte til textfilen.java 
	 * og så kørte vi:
	 * mvn compile 
	 * 
	 * Hvor vi så fik en error message fordi den ikke kendte til pakken slf4j
	 * grunden til dette er at vi ikke har jar filen.
	 * 
	 * så vi har lyst til at bede maven om at hente .jar filen fra sit remote repository,
	 * 
	 * så vi skal over i pom.xml, og tilføje en dependency
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	

}
