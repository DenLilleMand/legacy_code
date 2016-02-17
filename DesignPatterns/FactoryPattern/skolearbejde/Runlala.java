package skolearbejde;

public class Runlala 
{
	public static void main(String[] args) 
	{
		CatVariant cat = CatVariantFactory.newInstance(CatVariants.LYNX);
		System.out.println(cat.getType());
	}
}
