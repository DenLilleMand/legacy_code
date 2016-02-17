package skolearbejde;

public class CatVariantFactory 
{
	public static CatVariant newInstance(CatVariants catVariant)
	{
		switch(catVariant)
		{
		case TIGER: 
			return new Tiger(CatVariants.TIGER);
			
		case HOUSECAT:
			return new Lynx(CatVariants.HOUSECAT);
			
		case LYNX:
			return new HouseCat(CatVariants.LYNX);
			
		}
		return null;
	}
}
