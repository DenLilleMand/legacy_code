package mockito;

public class Noter {
	/**
	 * HVIS MAN KOMMER OP TIL EKSAMEN OG TALER OM EN UNIT TEST DER KONTAKTER DATABASEN SÅ ER DET IKKE(!)
	 * EN GOD IDE! -- dette er fordi vi ikke ved hvem der har redigeret i vores database fra gang til gang.
	 * Så brug vores mockup til dette.
	 * 
	 * Så generalt i alle vores testCases acceptere vi ikke at der er en ydre kraft der kan ændre
	 * resultatet.
	 * 
	 * 
	 * Vores unit tests kører i memory.
	 * 
	 * med Mockito kan man lave Mocks/Mock-ups, 
	 * 
	 * 
	 * en Mock,  er en fake. dvs. at når vi skal f.eks sørge for at nogle ting bliver
	 * sendt ned til databasen, og vores objekt tager imod den her DBWrapper, så laver vi en
	 * fake DBWrapper, for ikke at skulle kontakte databasen, dvs at vi kan sidde og teste uden 
	 * at spamme vores database som andre måske sidder og arbejder på, så man giver fake objekter ind
	 * som returnere noget default.
	 * 
	 * det handler om at man vil teste en metode, som har et kald videre vha. af et andet objekt,
	 * men vi er ikke interesseret i hvad det metodekald gør, så vi giver den et fake object der bare skriver
	 * en syso. det kan man se med vores saveStudent(Student s) metode- det er den vi gerne ville teste i den her pakke.
	 * 
	 * 
	 */
}
