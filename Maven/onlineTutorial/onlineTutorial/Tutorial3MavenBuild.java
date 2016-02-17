package onlineTutorial;

public class Tutorial3MavenBuild 
{
	/**
	 * tl;dr;
	 * 
	 * 
	 * 
	 * 
	 * 
	 * ---------------------------------------
	 * Noter:
	 * Man bruger build/deploy til sidst i projektet.
	 * 
	 * mvn compile
	 * mvn package
	 * 
	 * -Build lifecycle
	 * step-by-step process. 
	 * denne process består af faser.
	 * disse faser har en default rækkefølge og et default
	 * indhold, som
	 * vil blive kaldt hvis man ikke specificere det.
	 * jeg ved faktisk ikke om man kan ændre på rækkefølgen, det tror jeg ikke,
	 * men man kan hvertfald ændre på indholdet af de her phases.
	 * 
	 *	'specify the build phase you need. Previous phases will run automatically.'
	 * 
	 *  nogle af de faser vi kommer til at bruge meget:
	 *  
	 *  validate: man ville ikke udelukkende kalde denne, 
	 *  men fordi den er i starten bliver den ofte kaldt, den tjekker om det
	 *  hele er som det skal være.
	 *  
	 *  compile: tager alle .java filerne og compiler dem.
	 *  
	 *  test: det er her vi kører alle vores testcases.
	 *  som ligger i test folderen selvfølgelig.
	 *  
	 *  package:  denne executer jo alle de andre før denne,
	 *  hvis alle de ting går godt - så rammer vi package,
	 *  ellers får vi et failure.
	 *  
	 *  install: efter man har kørt package fasen og genereret 
	 *  vores artifact, så installere install denne her ind i vores
	 *  local repository.
	 *  
	 *  deploy: kun hvis man skal publishe sit artifact til
	 *  det remote repository, sådan at andre developers kan bruge vores,
	 *  hvilket effektivt ville lave det open-source.
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
