package egetForsøg;

public class Person 
{
	private String firstName;
	private String lastName;
	private String addresse;
	private String cpr;
	private static final String ZERO = "";

	public static class Builder 
	{
		// Optional parameters - initialized
		private String firstName = ZERO;
		private String lastName = ZERO;
		private String cpr = ZERO;
		private String addresse = ZERO;

		public Builder() {
		}

		public Builder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public Builder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Builder cpr(String cpr) {
			this.cpr = cpr;
			return this;
		}

		public Builder addresse(String addresse) {
			this.addresse = addresse;
			return this;
		}

		public Person build()
		{ return new Person(this); }

	}

	private Person(Builder builder) {
		firstName 	= builder.firstName;
		lastName 	= builder.lastName;
		cpr 		= builder.cpr;
		addresse 	= builder.addresse;
	}

	public static Person makeClone(Person person) 
	{
		return new Person.Builder()
				.firstName(person.getFirstName())
				.lastName(person.getLastName()).cpr(person.getCpr()).build();
	}
	
	public static Person newInstance()
	{
		return new Person(new Builder());
	}

	public String getFirstName() {
		return firstName;
	}

	/**
	 * 
	 * 
	 * @param String firstName
	 * @return void
	 * @throws IllegalArgumentException if firstName is lower or higher than 2-25.
	 */
	public void setFirstName(String firstName) 
	{
		if(firstName.length() >= 25 || firstName.length() < 3) {throw new MyIllegalArgumentException(firstName);}
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName)
	{
		if(lastName.length() >= 25 || lastName.length() < 3) {throw new MyIllegalArgumentException(lastName);}
		this.lastName = lastName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	

	public String getAddresse() {
		return addresse;
	}

	public void setAddresse(String addresse) {
		if(addresse.length() >= 100 || addresse.length() < 4) {throw new MyIllegalArgumentException(addresse);}
		this.addresse = addresse;
	}

	public String getCpr() {
		
		return cpr;
	}

	public void setCpr(String cpr) {
		if(!(cpr.length() == 11)) {throw new MyIllegalArgumentException(cpr);}
		this.cpr = cpr;
	}

}
