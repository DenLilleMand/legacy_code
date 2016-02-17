package reusingBuilds;

public class Noter 
{
	/**
	 * tl;dr;
	 * 
	 * 
	 * 
	 * 
	 * ----------------------------------------------------
	 * Noter:
	 * 
	 * Previously, we ran the command mvn package. If you just needed to produce a web application to test manually, this would be sufficient. However, what if you need to include it in a Java EAR file, or to build a self-contained distribution that includes the web application along with a servlet container? More commonly, what if you were building a JAR project instead that needed to be used by another Java project?
In Maven, instead of passing relative links to other projects and files in the build, projects share their build products in the form of build artifacts, with the mechanism for sharing these artifacts being the Maven repositories that we touched on earlier. We have already seen that Maven downloads remote dependencies to the local repository, and we can see here that this is also where Maven places artifacts to share with other builds that you run yourself from the same machine. Note that the local repository is not intended for sharing among multiple users, however, when it comes to publishing a build for other developers or projects to use, a remote 
repository is used instead.


så de vil altså have os til at installere noget ind i vores local repository sådan at andre projekter kan bruge vores "modul",
så vi kører: To install the web application we have created already into the local repository,
run the command in the folder that contains the pom.xml file:
simple-webapp$ mvn install

Og det virker åbenbart, som om at install ikke kørte ordentligt på vores test projekt, fordi
der ikke var noget source-code eller tests, og samtidig brugte vi en underlig encodig til at kopiere de her filer et eller 
andet sted hen, så projektet blev ikke platform independant, hvilket vi helst vil undgå siden det er en kernefunktionalitet i java.
Den måde vi fixer dette på er :
How do I prevent "[WARNING] Using platform encoding (Cp1252 actually) to copy filtered resources, i.e. build is platform dependent!"
This or a similar warning is emitted by a plugin that processes plain text files but has not been configured to use a specific file encoding. So eliminating the warning is simply a matter of finding out what plugin emits it and how to configure the file encoding for it. For plugins that follow our guideline for source file encoding, this is as easy as adding the following property to your POM (or one of its parent POMs):

<project>
  ...
  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
  </properties>
  ...
</project>


mvn install : (This is the command (or perhaps mvn clean install) that you will run in almost all cases while building Maven projects.)
vores projekt virkede dog heller ikke med 'clean install'

anyway, den her install kommando kører de samme 'phases', som 'mvn package', bortset
fra at den også kopieres over i vores local repository hvilket gør den brugbar for vores andre
projekter.

It is worth noting that Maven has one step beyond install, called deploy. This does lead to some confusion, as it does not refer to deployment of an application into a development or production server, but rather uploading the build product into a remote repository. While this can be used as a location to deploy your applications into a server from, that is not the direct purpose of Maven's deploy step.
We will look at remote repository deployment later in the book. For now, let's focus on improving the project we have been constructing.
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
}
