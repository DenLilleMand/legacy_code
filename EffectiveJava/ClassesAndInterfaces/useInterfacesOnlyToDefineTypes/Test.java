package useInterfacesOnlyToDefineTypes;
import static useInterfacesOnlyToDefineTypes.PhysicalConstantsGoodVersion.*;

public class Test 
{
	double atoms(double mols)
	{
		return AVOGADROS_NUMBER * mols;
	}
	
	/**
	 * Many more uses than just this one,
	 * justify the use of static imports'
	 * jeg tror dog at for en begynder er dette
	 * super farligt at bruge når man stadig prøver
	 * at få styr på strukturen i ens projekter.
	 */
}
