package onlineTutorial;

public class tutorial1 {
	/**
	 * Noter om hvorfor maven er nice(https://www.youtube.com/watch?v=al7bRZzz4oU): 2:28

Man bruger maven bla. pga alle jars der har forskellige versioner og forskellige dependendcies

-----------------------------------------------------------------
Mini-guide:

når man skal bygge sin archetype:
'mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false'

så går man ind i dens directory igennem cmd(cd my-app)

så kalder man  'mvn package' for at bygge ens projekt.
hvilket på dansk vel bare betyder at man laver jar filen.

kører jarfilen med:java -cp target/my-app-1.0-SNAPSHOT.jar com.mycompany.app.App


og det burde syso  hello world. 

--------------------------------------------------------------------



http://maven.apache.org/guides/getting-started/index.html



Hvad man kan bruge maven til, bla:
1Multiple Jars
2Dependencies and versions
3project structure
4Building, publishing and deploying

brug for en pom.xml fil -- det er en build file.


Maven går udfra en specifik layout struktur , 
src / main / java,src,/ test / java, etc.

splitter tests ud osv. 


maven har nogle hooks, den har sådan en "build life cycle phases"
hvor den kalder en række metoder, og disse kan man override med
noget man gerne vil lave. 

man specificere 3rd party libraries som dependencies,
der er faktisk ikke nogen god løsning uden at have et 
3rd party library som en dependency.


Standard projekt:
mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false


når vi kalder 'mvn package'


Der er mange andre lifecycles, men det her er nogen af dem:


validate: validate the project is correct and all necessary information is available
compile: compile the source code of the project
test: test the compiled source code using a suitable unit testing framework. These tests should not require the code be packaged or deployed
package: take the compiled code and package it in its distributable format, such as a JAR.
integration-test: process and deploy the package if necessary into an environment where integration tests can be run
verify: run any checks to verify the package is valid and meets quality criteria

clean: cleans up artifacts created by prior builds
site: generates site documentation for this project

mvn site
This phase generates a site based upon information on the project's pom. You can look at the documentation generated under target/site.
install: install the package into the local repository, for use as a dependency in other projects locally
deploy: done in an integration or release environment, copies the final package to the remote repository for sharing with other developers and projects.


 provides a way to help with managing:

Builds
Documentation
Reporting
Dependencies
SCMs
Releases
Distribution

an archetype is a template of a project:http://maven.apache.org/guides/introduction/introduction-to-archetypes.html


How do I compile my application sources?

Change to the directory where pom.xml is created by archetype:generate and execute the following command to compile your application sources:

mvn compile


How do I compile my test sources and run my unit tests?

Now you're successfully compiling your application's sources and now you've got some unit tests that you want to compile and execute (because every programmer always writes and executes their unit tests *nudge nudge wink wink*).

Execute the following command:

mvn test



How do I create a JAR and install it in my local repository?

Making a JAR file is straight forward enough and can be accomplished by executing the following command:

mvn package


Man kan også åbne den der pom.xml fil igennem eclipse, 
der kan man se hvordan man exportere den under 'packaging'
altså om det er en jar fil - eller en anden variant,
man kan ikke lave en .exe fil, men jeg har også på fornemmelsen at .exe
filer er en form for jar, det er bare packaged på en anden måde, burde
vi nok finde ud af på et tidspunkt. 

Now you'll want to install the artifact you've generated (the JAR file) in your local repository (~/.m2/repository is the default location). For more information on repositories you can refer to our Introduction to Repositories but let's move on to installing our artifact! To do so execute the following command:

mvn install


Note that the surefire plugin (which executes the test) looks for tests contained in files with a particular naming convention. By default the tests included are:

*Test.java
Test*.java
*TestCase.java
And the default excludes are:

Abstract*Test.java
Abstract*TestCase.java


So what else can you get for free? There are a great number of Maven plug-ins that work out of the box with even a simple POM like we have above. We'll mention one here specifically as it is one of the highly prized features of Maven: without any work on your part this POM has enough information to generate a web site for your project! You will most likely want to customize your Maven site but if you're pressed for time all you need to do to provide basic information about your project is execute the following command:

mvn site
There are plenty of other standalone goals that can be executed as well, for example:

mvn clean
This will remove the target directory with all the build data before starting so that it is fresh.

Perhaps you'd like to generate an IntelliJ IDEA descriptor for the project?

mvn idea:idea
This can be run over the top of a previous IDEA project - it will update the settings rather than starting fresh.

If you are using Eclipse IDE, just call:

mvn eclipse:eclipse
Noter fra stackoverflow:(The m2eclipse and command line mvn
 tool take two very different approaches to Eclipse/Maven 
integration. It sounds like your question is about mvn tool)

The mvn eclipse:eclipse command reads your pom file and creates Eclipse projects with correct metadata so that Eclipse will understand project types, relationships, classpath, etc. It does not actually import those projects into a workspace as creating a workspace or importing projects into a workspace requires running Eclipse. You have to re-run this command when anything in your pom changes. Once you run this command, it is simple to import the created projects into your workspace. Just start Eclipse and use File -> Import -> Existing Projects wizard. Once you've imported projects you will not have to repeat this process after re-generating metadata unless the number of projects have changes. Just start Eclipse back up, select all projects and invoke refresh from the context menu.)



mhs til det 'resources' directory vi selv har tilføjet,
så lover maven åbenbart at alt vi propper i det directory forbliver den samme
path når vi laver en 'mvn package'  ved ikke helt hvordan jeg kan teste
dette ordentligt, men det er vel fint nok, så har man et sted man kan ligge
de ting der bare følger med projektet uden at være en del af det.






You see below in our example we have added the directory ${basedir}/src/main/resources into which we place any resources we wish to package in our JAR. The simple rule employed by Maven is this: any directories or files placed within the ${basedir}/src/main/resources directory are packaged in your JAR with the exact same structure starting at the base of the JAR.



In a unit test you could use a simple snippet of code like the following to access the resource required for testing:

...

// Retrieve resource
InputStream is = getClass().getResourceAsStream( "/test.properties" );

// Do something with the resource





Dependencies: det som vores projekt afhænger af, f.eks kan vores projekt afhænge af 
JUnit, som vi så kan læse mere om i vores 'pom.xml'

for at kører vores app.java  skal vi 
-compile(mvn compile) //skal stå der hvor vores pom.xml fil er.
-package(mvn package) //skal stå der hvor vores pom.xml fil er.
-run(fra directory c:\Users\DenLilleMand\myapp\MavenTestApp  og så kalder vi:
java -cp target/MavenTestApp-1.0-SNAPSHOT.jar org.denlillemand.javabrains.App)
	
	 *
	 *
	 *Forresten så får Maven alt sin information fra det der hedder
	 *'The Maven Repository' - som er en ekstern placering,  og så har vi vores
	 *eget maven på vores computer selvfølgelig,  det er derfor vi nogle gange skal downloade plugins osv.
	 *the maven repository indeholde Archetype info og Dependency information, 
	 *
	 *når vi f.eks kalder mvn archetype:generate - så går maven over til det remote repository og henter 
	 *alt information om disse archetypes. og så kan vi specificere hvilken archetype vi har lyst til at genere
	 *som en fil struktur.
	 *
	 *
	 *denne directory structure indeholder så
	 *vores 'pom.xml' fil, så når vi lige laver den har den kun den dependency der hedder
	 *'junit' fordi den er default, det som maven kan gøre når vores dependency er junit, er at den checker det op
	 *imod de dependencies den har i sit repository, den henter også de rigtige versioner.
	 *
	 *når vi compiler og packager denne fil struktur får vi så en 
	 *jar fil. 
	 *
	 */
}
