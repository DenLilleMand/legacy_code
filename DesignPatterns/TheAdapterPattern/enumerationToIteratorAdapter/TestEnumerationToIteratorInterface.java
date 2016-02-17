package enumerationToIteratorAdapter;
/**
 * Det her er en af de ting man kan bruge rigtigt når man koder,
 * sammenlignet med Duck eksempelt..
 * 
 * Der er nemlig en masse java legacy kode som stadig holder sig til det der hedder en
 * Enumerator, iforhold til de nyere collections som har en Iterator der tillader at man kan
 * fjerne et objekt imens man itererer. 
 * Vi kan ikke lave en adapter sådan at Enumeration får remove() metoden, 
 * men vi kan gøre sådan at den kan bruge den metode og så smider den bare en exception
 * når den bliver brugt - dem som har lavet iterator interfacet havde nemlig forudset
 * dette behov så Iterator supporter en 'UnsupportedOperationException' der bliver smidt
 * når en Enumeration kalder remove() ... 
 * jeg ved ikke helt endnu hvordan det kan gavne os at en Enumeration minder om en iterator i typen,
 * men det får vi nok at se...
 * @author DenLilleMand
 *
 */
public class TestEnumerationToIteratorInterface {

}
