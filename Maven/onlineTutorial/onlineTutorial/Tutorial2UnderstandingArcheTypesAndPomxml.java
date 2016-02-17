package onlineTutorial;

public class Tutorial2UnderstandingArcheTypesAndPomxml 
{
	/**
	 * tl;dr;
	 * de informationer der er i vores pom:
	 * -Maven co-ordinates(Identifier of a artifact)
	 * -MetaData(what project it is, version etc.)
	 * -build information(project is a jar/war)
	 * -resources and dependencies(resources and dependencies to build the project.)
	 * 
	 * ---------------------------------
	 * Noter: https://www.youtube.com/watch?v=AI8Kjag1vGk&list=PL92E89440B7BFD0F6&index=3 
	 * Project template:
	 * 	-Folder structure:
	 * 	mvn generate:archetype(hører åbenbart under folder structure)
	 *     en bestemt archetype for alle disse forskellige applikationer, er en god start på
	 *     hvilken som helst applikation. Archetype inputtet vil bestemme fil strukturen og
	 *     dependencies.
	 *     
	 *     groupID:     groupid er mere en samling af artifacts, hvis ens projekt bliver launched
	 *     med 6 artifacts(moduler)- så går de alle sammen under det samme groupId(altså applikations navn)
	 *    
	 *     artifactID: artifacten er outputet for vores projekt.
	 *     
	 *     version: versioner er noget man bruger som best practice når
	 *     man vores default var 1.0-snapshot, men et snapshot er noget man har
	 *     noget noget stadig er i development,  bagefter vil man selF mark det som released,
	 *     men som sagt så er snapshots okay så længe vi udvikler
	 *     
	 *     
	 *     package: package er information til maven, mhs til hvilken
	 *     pakke   en bestemt klasse skal være i.
	 *     
	 *     
	 *    
	 *     
	 *     
	 * 	-pom.xml
	 * 		 grp id/artifact id/ version / package, som blev forklaret i 'project struture'
	 *      er dem der danner vores pom.xml fil, 
	 *        groupId/artifactid/version hvis man kigger i ens pom.xml,
	 *        er nøglen til en artifact. 
	 *        
	 *        hvis man har en artifact som man vil pushe til et repository
	 *        så er disse 3 nøglen til at identificere den.
	 *        
	 *        og packaging er selF hvad man vil eksportere det som.
	 * 
	 * 			name =   det navn som vores applikation vil få.
	 * 
	 * 	     så er der sourceencoding som burde være UTF-8 for at være
	 * 	    cross platform.
	 * 
	 * 
	 * 		i dependencies, kan man se at disse 3 også bliver vist for
	 * vores dependencies og ikke kun for vores eget projekt,
	 * f.eks er junit et godt eksempel, det er nemlig en default dependency i 
	 * de fleste projekter- den har et groupID, artifactId og et versions 
	 * nummer. 
	 * 
	 *  scope= when to use this artifact, så det er derfor scope=test hos JUnit,
	 *  
	 *  vores informationer, om vores egen jar, burde være sådan at andre projekter kan ligge den ind i deres dependencies.
	 *  Hvis vi laver et nyt pro
	 *  
	 *  
	 *  
	 *  
	 * 
	 * 
	 * Build:
	 * 
	 * 
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
