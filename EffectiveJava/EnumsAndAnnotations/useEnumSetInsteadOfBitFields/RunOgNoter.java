package useEnumSetInsteadOfBitFields;

public class RunOgNoter 
{
	/**
	 * Use EnumSet instead of bit fields
	 * 
	 * tl;dr;
	 * Den her sektion er helt sort snak, 
	 * jeg hopper over for nu.
	 * 
	 * 
	 * ---------------
	 * Noter:
	 * 
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
		//Bit field enumeration constants - OBSOLETE!
		public class Text
		{
			public static final int STYLE_BOLD = 1 << 0; //1
			public static final int STYLE_ITALIC = 1 << 0; //2
			public static final int STYLE_UNDERLINE = 1 << 0; //3
			public static final int STYLE_STRIKETHROUGH = 1 << 0; //4
		
			//Parameter is bitwise OR of zero or more STYLE_ constants
			public void applyStyles(int styles) {...}
		}
	}

}
