package introduktion;

public class Noter 
{
	/**
	 * tl;dr;
	 * 
	 * 
	 * 
	 * 
	 * -------------------------------------
	 * Noter:
	 * 
	 * Noger super interessersant jeg ikke havde tænkt på før, er at vi jo tilføjer .jar filer til vores
	 * projekter, hvilket vil sige, at vi faktisk kan lave moduler, publish dem som jarfiler, når man har noget konkret
	 * på bordet som fungere - f.eks et bestemt util modul, eller nogle entity klasser, det vil sige at man kan lave
	 * nogle reusable jar filer(moduler) - og så bruge dem i alle mulige projekter- hvilket jo understøtter mængden
	 * af generiske metoder er vigtigt, helst skal et helt modul jo være så generisk som det kan være.
	 * 
	 * En 'archetype' er et af de mest standard maven udtryk,
	 * og en maven archetype er bare et projekt. som man kan eksportere som enten en war fil 
	 * eller en jar fil . men vi har jo set i eclipse at man kan vælge andre packaging options.
	 * 
	 * i gamle maven eksempler bliver der brugt 'archetype: create'
	 * til at lave et projekt som vi nu har lavet i en fil der
	 * hedder newproject,  med den command der hedder 'archetype:generate' som er den nye,
	 * 'create' er deprecated.
	 * 
	 * 
	 * A number of projects take advantage of Maven's archetype mechanism to deliver a template project for their framework. A sample of these can be seen at http://docs.codehaus.org/display/MAVENUSER/Archetypes+List. One in particular to note is Appfuse (http://appfuse.org/), which assembles ready-to-use stacks of popular combinations of open source web application frameworks, and is based on Maven's archetype technology. More information on these can be found in
		Chapter 11, Archetypes.
		
		
		Group ID: An identifier for a collection of related modules. This is usually a hierarchy that starts with the organization that produced the modules, and then possibly moves into the increasingly more specialized project or sub-projects that the artifacts are a part of. This can also be thought of as a namespace, and is structured much like the Java package system.
		Artifact ID: The Artifact ID is a unique identifier for a given module within
		a group.
		Version: The version is used to identify the release or build number of
		the project.

		de specificerede en bestemt archetype i bogen,
		men vi fik tal fra 900-1100, fordi der er så mange archetypes
		må man gå udfra, og siden vi ikke kan scrolle igennem så mange,
		så er det bedre bare at søge på dem, 
		det gør man ved at skrive:

		mvn archetype:generate -Dfilter=groupId:artifactId
		anyway- den måde jeg fik genereret mit webprojekt på var:
		
		'mvn archetype:generate -Dfilter=org.sonatype.mavenbook.simpleweb:simple-webapp'
		
		og man kan selvfølgelig også tilføje flere ting, der er en lang række af de der ting, f.eks så
		jeg at der var en med interactivity, ikke at jeg ved hvad det gør men .. 
		
		
		
		
		(i vores eksempel er artifactId:maven-archetype-webapp)

og her havde vi faktisk et forkert groupId men et korrekt
artifactId, og så genererede den bare vores artifactId, med et standard
groupId- så selvom man ikke har alle informationer kan man alligevel prøve,
men det er nok til at foreslå at man søger efter hvilket artifactId/groupId
som en bestemt kombination af frameworks har, og så udfra det søger man.
virker til at man kan få rigtig rigtig mange kombinationer,
men man skal da også kunne lave sine egne.


når man laver et nyt projekt, så bliver man prompted
for de her specifikationer-

i bogen bruger vi disse til projektet:

Define value for groupId: : com.effectivemaven.chapter01
Define value for artifactId: : simple-webapp
Define value for version: 1.0-SNAPSHOT: : 1.0-SNAPSHOT
Define value for package: : com.effectivemaven.chapter01
	 * 
	 * 
	 * You may have noticed that the 
	 * version is referred to as a 
	 * snapshot. In Maven, there are 
	 * two types of versions: releases 
	 * and snapshots (those that end in
	 *  -SNAPSHOT). A snapshot should 
	 *  always be used by your projects 
	 *  during development as it has a 
	 *  special meaning to Maven to 
	 *  indicate that development is still
	 *   occurring and that the project may change. A release is
	 *    assumed never to change, so release versions (such as 1.1, 2.0, or 3.0-beta-5) should only be used for a single state
	 *     of the project when it is released,
	 *      and then updated to the next snapshot.
	 *      
	 *      
	 *      btw- åbenbart er 'war' packaging type, 
	 *      standarden for web applicationer.
	 *      
	 *      POM, which stands
			for Project Object Model.
	 * 		
	 * The POM contains important pieces of information about the project, which include:
The Maven coordinate of the project for reuse by other Maven projects
The project name, description and license
Project resource information such as the location of source control, issue tracking, and continuous integration
The developers, contributors and organizations participating in the project
The POM will also include information about how the project should be built,
such as:
The source directory layout
Dependencies on other projects
Build requirements (by means of Maven plugins) and configuration


Nevertheless, let's take one step back—what does Maven mean by "a project"? In software development, the term project is very ambiguous—it could mean just one part of a larger application, a plan for one release of a particular subset of an application, or it could be the entire application itself.
In Maven, the term project refers to a unit of work. That is, it takes one particular set of sources and produces a build artifact identified by the project's coordinate. While a conventional project has a single build artifact, it is possible to attach more artifacts that are alternate derivatives of the same sources in some limited ways. It is also worth noting that a POM can be both an artifact in itself, and a piece of metadata associated with a particular artifact file.


Maven gør også brug af arv- hvilket betyder at de dependencies i vores pom fil,
kan også gælde for nogle af de ting som er længere 
nede i vores struktur(tydeligvis ved vi ikke nok endnu til at vide
hvad dette præcis betyder).
	 */
}
