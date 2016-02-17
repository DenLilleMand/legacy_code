package useCheckedExceptionsForRecoverableConditionsAndRuntimeExceptionsForProgrammingErrors;

public class RunOgNoter 
{
	/**
	 * Use checked exceptions fpr recoverable conditions
	 * and runtime exceptions for programming errors.
	 * 
	 * tl;dr;
	 * Summary:
	 * 'Use checked exceptions for programming errors. Of course, the situation is not always black
	 * and white. For example, consider the case of resource exhaustion, which can be caused by a programming error such as allocating an
	 * unreasonably large array or by a genuine shortage of resources. If resource exhaustion is caused by a temprary 
	 * shortage or by a temporarily heightened demand, the condition may well be
	 * recoverable. It is a matter of judgment on the part of the API designer whether a given instance of resource exhaustion is likely to allow 
	 * for recovery. If you believe a condition is likely to allow for recovery, use a checked exception; if not, use a runtime exception. If it isn't clear whether recovery is possible, you're
	 * probably better off using an unchecked exception.'
	 * 
	 * Noget som er rigtig sjovt her, er at de her Objekter der bliver returneret, 
	 * er jo ligesom alle de andre objekter, s� vi kan subclass dem, og vedligge informationer,
	 * f.eks s� hvis en person pr�ver at k�be noget, og vi f�r en exception,
	 * hvorfor s� ikke lade den exception vi smider have en metode der hedder
	 * getShortage() alts� de penge som kunden manglede, s� er det meget lettere
	 * for clienten at skrive noget kode som fort�ller kunden dette.
	 * 
	 * 
	 * -------------
	 * Noter:
	 * Der er 3 slags throwable exceptions,
	 * der er checked exceptions, runtime exceptions og errors,
	 * og der er lidt tvivl om hvorn�r man smider hvad, 
	 * s� det er det som den her sektion handler om.
	 * 
	 * 
	 * 'The cardinal rule in deciding whether to use a checked or an unchecked exception is this:
	 * Use checked exceptions for conditions from which the caller can reasonably be expected to recover'
	 * Ved at smide en checked exception fort�ller man derfor at 
	 * den skal h�ndteres i en catch clause, hvilket vi jo throw i metode
	 * declarationen og skriver i vores documentation til client koden,
	 * at den kan finde p� at smide denne exception.
	 * 
	 * N�r vi konfrontere API useren med en checked exception, s� pr�sentere vi en mulighed
	 * for at komme tilbage fra situationen. s� kan Useren af vores API
	 * se bort fra denne exception og ignorerer den, men det er jo som regelt en d�rlig ide.
	 * 
	 * Der er 2 former for unchecked throwables, runtime exceptions og errors.
	 * De er identiske i deres opf�rsel: begge kan kastes uden at 
	 * nogen af de kr�ver at blive catched, Det er normalt at man ikke kan 
	 * komme tilbage i programmets flow efter s�dan en fejl, og hvis man ikke catcher denne throwable,
	 * s� vil den nuv�rende tr�d halte med en tilsvarende error besked.
	 * 
	 * 'Use runtime exceptions to indicate programming errors'
	 * normalt smider vi en 'ArrayIndexOutOfBoundsException' som viser at et array's API
	 * er blevet behandlet d�rligt, 
	 * 'There is a strong convention that errors are reserved for use by the JVM 
	 * to indicate ressource deficiencies, invariant failures, or other conditions that make it impossible to continue
	 * execution. Given the almost universal acceptance of this convention, it's best not
	 * to implement any new Error subclasses. Therefore, all of the unchecked throwables you implement should
	 * subclass RuntimeException(directly or indirectly'
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{

	}

}
