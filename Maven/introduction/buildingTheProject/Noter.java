package buildingTheProject;

public class Noter 
{
	/**
	 * tl;dr;
	 * 
	 * 
	 * --------------------------------------------
	 * Noter:
	 * In Maven, the build is run using a predefined, ordered set of steps called the build lifecycle. The individual steps are called phases, and the same phases are run for every Maven build using the default lifecycle, no matter what it will produce. The build tasks that will be performed during each phase are determined by the configuration in the project file, and in particular the selected packaging.
		Some of the most commonly used lifecycle phases in the default lifecycle are:
		validate—checks build prerequisites
		compile—compiles the source code identified for the build
		test—runs unit tests for the compiled code
		package—assembles the compiled code into a binary build result
		install—shares the build with other projects on the same machine
		deploy—publishes the build into a remote repository for other projects
		to use.
		
		
		The following is a complete list of phases available in Maven 2.2:
validate, generate-sources, process-sources, generate-resources, process-resources, compile, process-classes,
 generate-test-sources, process-test-sources, generate-test-resources, process-test-resources, test-compile, test,
  prepare-package, package, integration-test, verify, install, deploy.
	 * 
	 * De forskellige af disse fases afhænger af de fases der blev kørt før den,
	 * så dvs. at hvis man kalder generate-sources, så bliver alle phases kørt kronologisk der
	 *  er før generate-sources.
	 *  
	 *  
	 *  To see the build lifecycle in action, run the following command from the directory that contains pom.xml:
simple-webapp$ mvn package
Again, if this is the first time you have built this project, Maven may download a few more JAR files to the local repository.


[ 17 ]
As you can see, the build has gone through a number of tasks, such as [compiler:compile], [war:war], and so on. These tasks are known as goals, and they are attached to the build lifecycle to give the build substance.


bliver bla. nævnt at man kan tilføje nogle plugins til de forskellige phases,
som er uafhængigt af de andre phases.

f.eks så skal man selF tilføje alle source-generation goals 
inden compile-phase, sådan at det hele bliver compiled. 


Clean lifecycle: The command mvn clean is often used to remove Maven's work directory target. However, as some plugins can generate information that does not reside in the work area, it is possible for them to bind to the clean lifecycle to clean up after themselves as well. To help with ordering,
the complete list of phases in the lifecycle is pre-clean, clean, and
post-clean.
Site lifecycle: While much of the site generation is coordinated by Maven's reporting mechanism, it is also possible to bind plugins to be executed as
part of the site generation lifecycle. The phases available are pre-site,
site, post-site, and site-deploy.
	 * 
	 * 
	 * 
	 */
}
