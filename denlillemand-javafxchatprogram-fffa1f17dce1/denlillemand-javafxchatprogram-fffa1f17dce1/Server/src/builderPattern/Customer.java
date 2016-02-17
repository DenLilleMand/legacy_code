package builderPattern;




public final class Customer
{

	public static final String ZERO = "";
	private int id;
	
	private String userId;
	
	private String phoneNumber;
	
	
	private String firstName;
	
	
	private String lastName;
	

	
	private Customer(Builder builder)
	{
		id 			= builder.id;
		userId 		= builder.userId;
		phoneNumber = builder.phoneNumber;
		firstName 	= builder.firstName;
		lastName 	= builder.lastName;
	}
	
	public static class Builder
	{
		private int id = 0;
		private String phoneNumber = ZERO;
		private String firstName = ZERO;
		private String lastName = ZERO;
		private String userId = ZERO;
		
		public Builder()
		{
		}
		
		public Builder userId(String userId)
		{ this.userId = userId; return this; }
		
		public Builder id(int id)
		{this.id = id; return this;}
		
		public Builder firstName(String firstName)
		{this.firstName = firstName; return this;}
		
		public Builder lastName(String lastName)
		{this.lastName = lastName; return this;}
		
		
		public Builder phoneNumber(String phoneNumber)
		{this.phoneNumber = phoneNumber; return this;}
		
		
		public Customer build()
		{return new Customer(this);}
	}
	
	public int getId() {
		return id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
}