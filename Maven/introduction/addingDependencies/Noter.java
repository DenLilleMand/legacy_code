package addingDependencies;

public class Noter 
{

	/**
	 * tl;dr;
	 * 
	 * vores .m2 mappe er faktisk vores local repository, sådan at
	 * når vi kalder mvn install eller mvn clean install  så ryger vores program derover,
	 * og er tilgængeligt for vores andre projekter.
	 * (tydeligvis lidt off-limit fordi det her handler om dependencies.)
	 * 
	 * 
	 * 
	 * --------------------------------
	 * Noter:
	 * In any non-trivial project, it is unlikely (and unwise!) for the programmer to
write every single piece of code that it will use and bundle it all up in one large
all-or-nothing build. This is particularly true for a web application where generally only the web-based functionality is part of the project, with business logic contained in separate libraries. For this reason, one of the first features of Maven you will find yourself using is the dependency mechanism.
	 * 
	 * A dependency is simply a way of expressing that the current project requires another project in order to build or run in some way, using the Maven coordinates to locate it. The dependency may be another project you are building at the same time, another project you have already built on the current machine (shared from the local repository), or a project built by another team member or a third party (downloaded from a remote repository).
	 * 
	 * 
	 * 
	 */
}
