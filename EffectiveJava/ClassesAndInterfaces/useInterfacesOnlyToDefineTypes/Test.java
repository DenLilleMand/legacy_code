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
	 * super farligt at bruge n�r man stadig pr�ver
	 * at f� styr p� strukturen i ens projekter.
	 */
}
