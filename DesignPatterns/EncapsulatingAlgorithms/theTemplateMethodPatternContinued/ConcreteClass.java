package theTemplateMethodPatternContinued;

public class ConcreteClass extends AbstractClass{

	@Override
	public void primitiveOperation1() 
	{
		System.out.println("PrimitiveOperation1");
	}

	@Override
	public void primitiveOperation2() 
	{
		System.out.println("PrimitiveOperation2");
	}
	
	/**
	 * bare for eksemplets skyld - prøver
	 * vi her at ændre vores hook. 
	 */
	@Override
	public boolean hook()
	{
		return false;
	}

}
