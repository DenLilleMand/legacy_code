package enumerationToIteratorAdapter;
/**
 * Det her er en af de ting man kan bruge rigtigt n�r man koder,
 * sammenlignet med Duck eksempelt..
 * 
 * Der er nemlig en masse java legacy kode som stadig holder sig til det der hedder en
 * Enumerator, iforhold til de nyere collections som har en Iterator der tillader at man kan
 * fjerne et objekt imens man itererer. 
 * Vi kan ikke lave en adapter s�dan at Enumeration f�r remove() metoden, 
 * men vi kan g�re s�dan at den kan bruge den metode og s� smider den bare en exception
 * n�r den bliver brugt - dem som har lavet iterator interfacet havde nemlig forudset
 * dette behov s� Iterator supporter en 'UnsupportedOperationException' der bliver smidt
 * n�r en Enumeration kalder remove() ... 
 * jeg ved ikke helt endnu hvordan det kan gavne os at en Enumeration minder om en iterator i typen,
 * men det f�r vi nok at se...
 * @author DenLilleMand
 *
 */
public class TestEnumerationToIteratorInterface {

}
