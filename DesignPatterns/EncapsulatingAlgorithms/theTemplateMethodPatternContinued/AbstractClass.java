package theTemplateMethodPatternContinued;

public abstract class AbstractClass 
{
		public final void templateMethod()
		{
			primitiveOperation1();
			primitiveOperation2();
			concreteOperation();
			if(hook())
			{
				concreteOperation();
			}
		}

		public abstract void primitiveOperation1();
		public abstract void primitiveOperation2();

		public final void concreteOperation()
		{
			//implementation here
		}
		/**
		 * hook() - er en konkret metode, som er tom,
		 * Og fordi det er en algoritme vi encapsulere,
		 * altså en given rækkefølge, så kan det være at en subklasse
		 * har brug for at filføje endnu et metode kald, ind i vores algoritme,
		 * så kan man @Override vores hook, og hvis subclasen ikke har brug for sin
		 * hook - så sker der jo ingenting..
		 * det her eksempel med at den returner 'true'
		 * er bare en ting man kan gøre... man kan gøre så meget mere
		 * med den selF(altså givet at man kan override den og return den false).
		 * side 297 forklare det rimelig godt, og det er enlig ret simpelt.
		 */
		public boolean hook() 
		{
			return true;
		}  

}
