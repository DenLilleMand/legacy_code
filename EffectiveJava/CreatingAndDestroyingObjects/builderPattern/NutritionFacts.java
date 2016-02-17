package builderPattern;

public class NutritionFacts {
	
	public static void main(String []args)
	{
		/**
		 * jeg aner ikke hvorfor carlories brokker sig, den skal
		 * ikke være statisk i det her pattern.
		 * anyway - det efterfølgende stykke kode er hvordan det
		 * ser ud - og man kan tydeligt se hvorfor
		 * dette pattern er nice, rent læsbarheds mæssigt,
		 * men også de mere tekniske ting som at det her er nærmest
		 * et læsbart javabean pattern med threadsafe implementation.
		 *Dette er tydeligvis noget som kunne bruges i vores Oikos projekt
		 *når vi henter logentries ind.
		 *
		 */
		
		NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8).calories(100) // NutritionFacts.Builder henviser til innerclass. 
				.sodium(35).carbohydrate(27).build();							   //eftersom NutritionFacts har en private constructor.
		
		NutritionFacts cocaCola = new NutritionFacts(); //kan man se at dette ikke er muligt, det betyder at den ovenover referer
														//udelukkende til sin innerclass . . når den skal have lavet et objekt af sig.
														// inde i vores innerclass har vi muligvis adgang til en private constructor
														//som gør vores build() metode mulig. det er jo et perfekt pattern det her,
														//private constructor, gør lange parametre tydelige, er thread-safe. etc.
		/**
		 * Jeg ved ikke helt hvad den statiske klasse spiller i dette, 
		 * det gør selF at vi kan kalde den udfra vores egen klasse altså  NutritionFacts.Builder,
		 * men spørgsmålet er om den statiske modifier også har noget at gøre med at vi kan kalde
		 * så mange metoder der returnere et Builder objekt og ikke gå ind i en mur mhs. til at have skabt
		 * 20 builder objekter for et enkelt nutrition objekt, fordi så kunne man tænke sig at GC faldt bagud.
		 * eller også bliver vi bare ved med at returnere det samme Builder objekt, og det ligner det 
		 * faktisk lidt mere på grund af at vi returner this. 
		 */
		/**
		 * bogen siger bla. at hvis nogen invariants forekommer så skal vi smide en IllegalArgumentException,
		 * og den refererer ikke til rækkefølgen af setter kaldne, men spørgsmålet er hvis man kalder build() før .carbohydrate(27)
		 * og så sætter denne bagefter ... om det ikke ville prompte for en exception - spørgsmålet er bare hvordan man implementere det.
		 * man kunne evt. lave en instans af de objekt man gerne ville returnere og bare lade det være null, så i vores build så instansiere
		 * vi det og returner det... og alle de andre setter metoder kan tjekke på om objektet er null og smide en exception hvis den ikke 
		 * er null.
		 */
		
	}
	
	/**
	 * --------------------
	 * Et builder pattern istedet for Javabeans construction og den almindelige 
	 * telescoping constructor.
	 */
	
	private final int servingSize;
	private final int servings;
	private final int calories;
	private final int fat;
	private final int sodium;
	private final int carbohydrate;
	
	private NutritionFacts(Builder builder)
	{
		servingSize  = builder.servingSize;
		servings 	 = builder.servings;
		calories   	 = builder.carlories;
		fat 		 = builder.fat;
		sodium		 = builder.sodium;
		carbohydrate = builder.carbohydrate;
	}
	
	/**
	 * åbenbart en inner class
	 * @author DenLilleMand
	 *
	 */
	public static class Builder
	{
		//required parameters
		private final int servingSize;
		private final int servings;
		//Optional parameters - initialized 
		private int carlories = 0;
		private int fat = 0;
		private int carbohydrate = 0;
		private int sodium = 0;
		
		public Builder(int servingSize,int servings)
		{
			this.servingSize = servingSize;
			this.servings = servings;
		}
		
		public Builder calories(int val)
		{	calories = val; return this; }
		
		public Builder fat(int val)
		{ fat = val; return this;	}
		
		public Builder carbohydrate(int val)
		{	carbohydrate = val; return this; }
		
		public Builder sodium(int val)
		{ sodium = val; return this;}
		
		
		public NutritionFacts build()
		{ return new NutritionFacts(this); }
	}
	
	
	
}
