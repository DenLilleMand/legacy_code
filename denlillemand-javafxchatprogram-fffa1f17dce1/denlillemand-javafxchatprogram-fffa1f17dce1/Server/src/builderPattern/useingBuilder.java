package builderPattern;

public class useingBuilder {
	public void herpderp()
	{
		Customer customer = new Customer.Builder().firstName("firstname").
				lastName("lastname").build();
	}
}
