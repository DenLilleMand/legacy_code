/**
 * 
 */
package råd;

/**
 * tl;dr;
 * kode eksempler fungere, ikke
 * fordi der mangler lidt små klasser
 * ,men jeg tænkte at vi alligevel tilføjer dem, 
 * måske giver det mening hvis man læser bogne igen,
 * vil lave nogle eksempler eller deslignende.
 * 
 * Den nævner dog at i de næste kapitler,
 *  kommer de kode eksempler der får dette kode til at kører
 *  , så det håber vi er sandt
 * 
 * 
 * CHAPTER SUMMARY
public boolean add(T newEntry)
public boolean remove(Object anEntry)
public void clear()
public boolean contains(Object anEntry)
public boolean isEmpty()
public int size()
public Object[] toArray()
● An abstract data type, or ADT, is a specification of a data set and the operations on that data. This specification
does not indicate how to store the data or how to implement the operations, and it is independent of any
programming language.
● When you use data abstraction to design an ADT, you focus on what you want to do with or to the data without
worrying about how you will accomplish these tasks. That is, you ignore the details of how you represent
data and how you manipulate it.
● The manifestation of the ADT in a programming language encapsulates the data and operations. As a result,
the particular data representations and method implementations are hidden from the client.
● A collection is an object that holds a group of other objects.
● A bag is a finite collection whose entries are in no particular order.
● A client manipulates or accesses a bag’s entries by using only the operations defined for the ADT bag.
● When you add an object to a bag, you cannot indicate where in the bag it will be placed.
● You can remove from a bag an object having either a given value or one that is unspecified. You also can
remove all objects from a bag.
● A bag can report whether it contains a given object. It can also report the number of times a given object
occurs within its contents.
● A bag can tell you the number of objects it currently contains and can provide an array of those objects.
● Carefully specify the methods for a proposed class before you begin to implement them, using tools such as
CRC cards and UML notation.
● After designing a draft of an ADT, confirm your understanding of the operations and their design by writing
some pseudocode that uses the ADT.
● You should specify the action a method should take if it encounters an unusual situation.
● Writing a Java interface is a way to organize a specification for an ADT.
● Writing a program that tests a class before it is defined is a way to see whether you fully understand and are
satisfied with the specification of the class’s methods.
 * ---------------
 * Noter:
 * Bogen foreslår at når vi har lavet 
 * vores ADT(abstract data type) - så skal vi beslutte programmerings sproget tydeligvis,
 * efter dette kan vi så lave et interface, 
 * så normalt ville man måske springe direkte til at lave den konkrete implementation,
 * men det er faktisk bedre at lave et lille test program hvor man bare gør
 * brug af ens interface, og ser hvordan metoderne fungere, om det giver mening -
 * hvorefter man så kan lave den konkrete implementation.
 * Dette kan også hjælpe en til at tage noter omkring dokumentationen, 
 * at sætte sig selv i client kode skriverens sko først.
 * 
 * 
 * bogen fortæller noget om generics, så som at vi burde bruge vores
 * interface til at specificicere en type på en collection osv. sådan at
 * subclasser og klasser der implementere alle sammen kan være der.
 * 
 * Det er også meget vigtigt at når man udvikler en ADT, at man ikke bekymrer sig om 
 * "hvordan" man skal implementere en metode, men blot om hvad den skal kunne. 
 * 
 * man skal ikke vide hvordan den gør nogenting overhovedt når man bruger en API,
 * den skal bare give en resultatet.
 * 
 * 
 * bogen omtalte lige det vi også havde opdaget i effective java,
 * at når man giver et objekt ind som parameter så hvis man ikke laver
 * en defensiv kopi, så er det ikke et immutable field objektet kan blive sat til, lige meget hvad.
 * 
 * 
 * Bogen laver en sammenligning med en sodavands
 * maskine(automat) - og så vidt jeg forstår er det en reference 
 * til hvordan en implementation og en API arbejder sammen.
 * 
 *  disse 5 punkter bliver nævnt:
 *  You can perform only the specific tasks that the machine’s interface presents to you.
● You must understand these tasks—that is, you must know what to do to buy a soda.
● You cannot access the inside of the machine, because a locked shell encapsulates it.
● You can use the machine even though you do not know what happens inside.
● If someone replaced the machine’s inner mechanism with an improved version, leaving the
interface unchanged, you could still use the machine in the same way.
 * 
 * 
 * Og her har vi så den konkrete oversættelse 
 * til vores kode eksempel af disse punkter:
 * 
 * The client can perform only the operations specific to the ADT bag. These operations often
are declared within a Java interface.
● The client must adhere to the specifications of the operations that the ADT bag provides.
That is, the programmer of the client must understand how to use these operations.
● The client cannot access the data within the bag without using an ADT operation. The principle
of encapsulation hides the data representation within the ADT.
● The client can use the bag, even though the programmer does not know how the data is stored.
● If someone changed the implementation of the bag’s operations, the client could still use the
bag in the same way, as long as the interface did not change.
 * 
 * og man skal huske at - clienten godt kan sende objekter ind, ligesom vi kan smide mønter i en automat,
 * men når de har smidt noget ind i vores API,
 * så tager vi bare en defensiv kopi af det og 
 * oprerer med det, og giver noget output.
 * 
 * Igen bliver det pointeret at det gør ens opgave som programmør
 * meget sværerer hvis man begynder for tidligt at fokusere på hvordan
 * en konkret implementation kommer til at fungere,
 *  man skal i stedet sætte sig i clientens position i lang tid før man begynder at kode.
 * 
 * Man kan evt. huske på at det design princip der hedder 'abstraction' 
 * beder en om at fokusere på 'what' i stedet for 'how'.
 * 
 * 
 */
public class Råd {

}
