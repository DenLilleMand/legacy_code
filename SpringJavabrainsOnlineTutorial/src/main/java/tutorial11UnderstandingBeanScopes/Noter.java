package tutorial11UnderstandingBeanScopes;

public class Noter 
{
	/**
	 * By default bliver vores .xml dokument loaded ind lige så snart vi giver vores applicationContext 
	 * object xml filen ind som parameter, og så bliver alle beansne, altså vores objekter initialiseret med det
	 * samme, så man kan forestille sig at der er lidt for meget overhead hvis der er mange beans med endnu flere
	 * inner beans der initialisere hele vejen ned igennem systemet.
	 * Derfor kan man configurer hvordan initialisere.
	 * 
	 * Springs objekter er singleton. så hvis flere klasser vil have den samme klasse,
	 * så er det Det samme objekt der bliver givet rundt.
	 * Og dette er den default opførsel.  i denne udgave initialisere vi også
	 * beanen med det samme i modsætning til Prototype.
	 * 
	 * Prototype - "New bean created with every request or reference"
	 * Det er en configuration man kan sætte den til i stedet for singleton.
	 * i denne version venter man også på at der bliver kaldt getBean() før den bliver
	 * initialiseret.
	 * 
	 * Hvad man kan bruge dette til:
	 * *Web-aware Context Bean scope
	 * -Request - New bean per servlet request
	 * -Session - New bean per session.
	 * -Global session - New bean per global HTTP session(portlet context).
	 * 
	 * 
	 * Det er dog vigtigt at man forstår at det ikke er et singleton 
	 * pattern i den strengeste forstand hvor der virkelig kun er 1/0 instans af en klasse,
	 * Det er et, men kun indenfor 1 Spring Container, og man kan have flere Spring containers(og jeg er ikke
	 * helt sikker på om en SpringContainer er .xml filen i sin strengeste forstand, eller om det er
	 * vores ApplicationContext objekt, det er det nok nærmere). 
	 * 
	 * 
	 */
}
