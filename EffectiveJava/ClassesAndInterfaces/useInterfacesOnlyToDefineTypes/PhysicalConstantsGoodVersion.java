package useInterfacesOnlyToDefineTypes;

/**
 * dette er en utility klasse.
 * @author DenLilleMand
 *
 */
public class PhysicalConstantsGoodVersion {
	/**
	 * prevent instantiation
	 */
	private PhysicalConstantsGoodVersion()
	{
		//prevent reflection
	}
	
	static final double AVOGADROS_NUMBER = 6.02214199e23;
	static final double BOLTZMANN_CONSTANT = 1.3806503e-23;
	static final double ELECTRON_MASS = 9.10938188e-31;
}
