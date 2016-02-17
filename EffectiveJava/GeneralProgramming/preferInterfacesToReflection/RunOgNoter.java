package preferInterfacesToReflection;

public class RunOgNoter 
{
	/**
	 * Prefer interfaces to reflection
	 * tl;dr;
	 * Reflection is a powerful facility that is required for certain
	 * sophisticated system programming tasks, but it has many disadvantages. If you 
	 * are writing a program that has to work with classes unknown at compile time, you should, if at all possible,
	 * use reflection only to instantiate objects, and access the objects using 
	 * some interfaces or superclass that is known at compile time.
	 * 
	 * -----------------
	 * Noter:
	 * Ved sku ikke hvor meget man kan f� ud af den her sektion
	 * nu n�r vi ikke rigtig ved hvad reflection er, andet end at man kan
	 * bruge det til test, og vores singleton constructors er bange for det.
	 * 
	 * anyway - det virker til at bogen, ikke
	 *  er alt for glad for Reflection, 
	 *  der er 3 store r�d p� side 253 om hvorfor
	 *  reflection er d�rligt,
	 *  man kan nok godt bruge det til et eller andet.
	 *  
	 *  'As a rule, objects should not be accessed reflectively
	 *   in normal applications at runtime'
	 *   
	 *   Der er mange ting som reflection er god for dog, som f.eks
	 *   class browsers, object inspectors, code analysis tools, and interpretive 
	 *   embedded systems. Reflection is also appropriate for use 
	 *   in remote procedure call
	 *   (RPC) systems to eliminate the need for stub compilers.
	 *   Og hvis man er i tvivl om ens system h�rer ind under nogle af disse,
	 *   s� g�r det ikke :) 
	 *   
	 *   'You can obtain many of the benefits of reflection while incurring
	 *    few of its costs by using it only in a very limited form'
	 *    
	 *    omkring 253-255 kan man se/og l�se om hvordan man f.eks kan teste
	 *    en Generic metode ved at give den forskellige klasser ind med samme interface,
	 *    igennem reflection - det virker da ok smart, men m�ske lige over vores niveua lige nu.
	 *    
	 *    bogen fik ogs� lige hakket ned p� System.exit - vordi den faktisk lukker 
	 *    hele ens VM, det vidste vi ikke. Men det er jo alligevel ikke s�dan vi lukker det alligevel,
	 *    specielt nu med shutdown hook osv. 
	 * 
	 * @param args
	 */
	
	public static void main(String[] args) 
	{

	}

}
