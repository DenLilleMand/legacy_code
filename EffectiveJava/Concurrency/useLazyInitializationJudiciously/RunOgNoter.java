package useLazyInitializationJudiciously;

public class RunOgNoter 
{
	/**
	 * Use lazy initialization judiciously
	 * tl;dr;
	 * 
	 * in summary:
	 * 'You should initialize most fields normally, not lazily.
	 * If you must initialize a field lazily in order to achive your performance goals, or to break a
	 *  harmful initialization circularity, then use the appropriate lazy initialization technique. For
	 *   instance fields, it is the double-check idiom; for static fields, the lazy 
	 *   initialization holder class idiom. For instance fields that can tolerate repeated initialization,
	 *    you may also consider the single-check idiom.'
	 *    
	 *    Specielt den form for 'harmful initialization circularity' er vel relevant,
	 *    så vi kan skaffe os af med den cirkle af initialiseringer som
	 *     vores Singleton pattern lige nu skaber i vores projekter hvis vores klasser
	 *     begynder at initialisere den anden vej igennem arkitekturen.
	 *     
	 * 
	 * ---------------
	 * Noter:
	 * 'lazy initialization is the act of delaying the initialization of a field
	 * until its value is needed.'
	 * 
	 * 'Under most circumstances, normal initialization is preferable
	 * to lazy initialization'
	 * 
	 * Kode eksempel 1 viser hvordan en declaration for et normalt
	 * initialized instance field.
	 * 
	 * 
	 * 'If you need to use lazy initialization for performance on a static field,
	 * use the lazy initialization holder class idiom, this idiom(allso known as the initialize-
	 * on-demand holder class idiom' exploits the guarantee that a class will not be initalized
	 * until it is used, kan se hvordan kode eksempel ser ude i kode eksempel 3.
	 * 
	 * 
	 * 'If you need to use lazy initialization for performance on an instance field, use the
	 * double-check idiom.' (kode eksempel 4).
	 * 
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		/**
		 * Kode eksempel 1:
		 */
		
		//normal initialization of an instance field
		private final FieldType field = computeFieldValue();
		
		//If you use lazy initialization to break an initialization 
		//circularity, use a synchronized accessor, as it is the simplest, clearest alternative:
		
		//Lazy initialization of instance field - synchronized accessor
		private FieldType field;
		
		synchronized FieldType getField()
		{
			if(field == null)
			{
				field = computeFieldValue();
			}
			return field;
		}
		
		/**
		 * Kode eksempel 3
		 */
		//Lazy initialization holder class idiom for static fields
		private static class FieldHolder
		{
			static final FieldType field = computeFieldValue();
		}
		static FieldType getField() {return FieldHolder.field;}
	
	
	
		/**
		 * Kode eksempel 4:
		 * (koden forklares omkring 306-307).
		 */
		//Double-check idiom for lazy initialization of instance fields
		private volatile FieldType field;
		FieldType getField()
		{
			FieldType result = field;
			if(result == null) //First check(no locking)
			{
				synchronized(this)
				{
					result = field;
					if(result == null) // Second check(with locking)
					{
						field = result = computeFieldValue();
					}
				}
			}
			return result;
		}
	
		/**
		 * Kode eksempel 5:
		 * (mere om dette på side 307, og 
		 * hvad det skal bruges til.)
		 */
		//Single-check idiom - can cause repeated initialization!
		private volatile FieldType field;
		
		private FieldType getField()
		{
			FieldType result = field;
			if(result == null)
			{
				field = result = computeFieldValue();
			}
			return result;
		}
	
	}

}
