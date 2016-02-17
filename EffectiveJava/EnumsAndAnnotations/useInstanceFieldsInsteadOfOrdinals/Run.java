package useInstanceFieldsInsteadOfOrdinals;

class Run {

	public static void main(String[] args) 
	{
		System.out.println(Ensemble.DUET.numberOfMusicians());

	}

	enum Ensemble
	{
		SOLO, TRIO, QUARTET, QUINTET, SEXTET, SEPTET, DUET, OCTET , NONET , DECTET;
		public int numberOfMusicians() {return ordinal() +1;}
	}
}
 