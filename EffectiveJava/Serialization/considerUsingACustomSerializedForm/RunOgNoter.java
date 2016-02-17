package considerUsingACustomSerializedForm;

public class RunOgNoter 
{

	/**
	 * Consider using a custom serialized form
	 * tl;dr;
	 * 
	 * Jeg forstår sku ikke halvdelen af det her, jeg 
	 * nåede til side 320, 20 sider to-go - men jeg går i gang med 
	 * data abstractions bogen i stedet for. 
	 * 
	 * ----------------
	 * Noter:
	 * 'Do not accept the default serialized form without first
	 * considering whether it is appropriate'
	 * 
	 * 'The ideal serialized form of an object contains only the logical data
	 * represented by the object. It is independent of the physical representation.'
	 * 
	 * 'The default serialized form is likely to be appropriate if an object's physical representation is identical to its
	 * logical content' kode eksempel 1, viser 
	 * hvordan en klasse ser ud hvis man bare skal bruge den normale serialized form.
	 * 
	 * 
	 * 'Even if you decide that the default serialized from is appropriate, you
	 *  often must provide a readObject method to ensure invariants and security.
	 *  In the case of Name, the readObject method must ensure that lastName and firstName are 
	 *  non-null.'
	 *  
	 *  
	 *  kode eksempel 1: Note that there are documentation comments on the lastName, firstName,
	 *   and middleName fields, even though they are private. That is because these 
	 *   private fields define a public API, which is the serialized form of the class, and this public
	 *   API must be documented. The prsence of the @serial tag
	 *   tells the Javadoc utility to place this documentation on a special page that documents
	 *   serialized forms.
	 *   Near the opposite end of the spectrum from Name, consider the following class, which represents a list of strings(ignoring
	 *   for the moment that you'd be better off using one of the standard List implements)
	 *   kode eksempel 2. 
	 *   i kode eksempel 2 kan man se :"Logically speaking, this class represents a sequence of strings.
	 *   physically it represents the sequence of a doubly linked list. If you accept the default serialized form,
	 *   the serialized form will painstakingly mirror every entry in the linked list and all the links between the entries, in both directions."
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
		//Good candidate for default serialized form
		public class Name implements Serializable
		{
			/**
			 * Last name. Must be non-null.
			 * @Serial
			 */
			private final String lastName;
			
			/**
			 * First name. Must be non-null.
			 * @Serial
			 */
			private final String firstName
			
			/**
			 * Middle name, or null if there is none.
			 * @Serial
			 */
			private final String middleName;
			...//Remainder omitted
			
		}
		
		/**
		 * Kode eksempel 2:
		 */
		//Awful candidate for default serialized form
		public final class StringList implements Serializable 
		{
			private int size = 0;
			private Entry head = null;
			
			private static class Entry implements Serializable 
			{
				String data;
				Entry next;
				Entry previous;
			}
			
			...//Remainder omitted
			
		}
	}

}
