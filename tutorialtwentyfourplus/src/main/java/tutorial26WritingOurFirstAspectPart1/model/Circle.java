package tutorial26WritingOurFirstAspectPart1.model;


public class Circle {
	private String name;

	public String getName() {
		return name;
	}
	
	/**returner en String fordi vi vil teste hvad man kan ændre på return typen med AOP */
	public String setName(String name) {
		return this.name = name;
		//throw new NullPointerException();  //åbenbart virker det her ikke med vores @AfterReturning annotation.
	}
}
