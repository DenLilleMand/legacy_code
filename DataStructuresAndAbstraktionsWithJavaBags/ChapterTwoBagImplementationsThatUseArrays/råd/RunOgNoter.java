package råd;

public class RunOgNoter {
	/**
	 * Bag implementations that use arrays
	 * 
	 * tl;dr;
	 * CHAPTER SUMMARY

You can use a Java array to define a relatively simple implementation of the ADT bag, but other implementations
are possible.
● Adding an entry right after the last entry in an array does not disturb the position of existing entries. Likewise,
deleting the last entry from an array does not disturb the position of existing entries.
● Because a bag does not maintain its entries in a specific order, deleting an entry does not require you to
move all subsequent array entries to the next lower position. Instead, you can replace the entry that you want
to delete with the last entry in the array and replace the last entry with null.
● Identifying and implementing a class’s central, or core, methods before any others is a good strategy to use
when you expect the class to be lengthy or complex. Use stubs for the remaining methods.
● Test a class at each stage of its development, particularly after adding a significant method.
● Using a fixed-size array can result in a full bag.
● Resizing an array makes it appear to change size. To do so, you allocate a new array, copy the entries from the
original array to the new array, and use the original variable to reference the new array.
● Resizing an array enables you to implement collections whose contents are limited in number only by the
size of the computer’s memory.


PROGRAMMING TIPS
When defining a class, implement and test a group of core methods. Begin with methods that add to a collection
of objects and/or have involved implementations.
● A class should not return a reference to an array that is a private data field.
● Do not wait until you complete the implementation of an ADT before testing it. By writing stubs, which are
incomplete definitions of required methods, you can begin testing early in the process.
● Even though you might have written a correct definition of a method, do not hesitate to revise it if you think
of a better implementation.
● When increasing the size of an array, you copy its entries to a larger array. You should expand the array sufficiently
to reduce the impact of the cost of copying. A common practice is to double the size of the array.
● A class implementing a single interface that declares the operations of an ADT should define the methods
declared in the interface as its only public methods. However, the class can also define private methods and
protected methods.
	 * 
	 * 
	 * ----------------------
	 * Noter:
	 * Objectives
	After studying this chapter, you should be able to
● Implement the ADT bag by using a fixed-size array or an array that you expand dynamically
● Discuss the advantages and disadvantages of the two implementations presented
	 * 
	 * Hvad bogen foreslår er at med sådan en kæmpe
	 * klasse som den vi skal bygge(generalt - alle store klasser evt?) så
	 * skal man beslutte sig for hvilke metoder der er vores CORE metoder - 
	 * og så skal vi lave og teste dem - og så bagefter tilføje alle mulige nitpick metoder.
	 * 
	 * 
	 * The core methods. We have identified the following core methods to be a part of the first draft of the
class ArrayBag:
● Constructors
● public boolean add(T newEntry)
● public T[] toArray()
● public boolean isFull()
With this core, we will be able to construct a bag, add objects to it, and look at the result. We will
not implement the remaining methods until these core methods work correctly.

When defining a class, implement and test a group of core methods.
Begin with methods that add to a collection of objects and/or have involved implementations
	 * 
	 * Noget som er interessersant:
	 *  
public ArrayBag()
{
this(DEFAULT_CAPACITY);
} // end default constructor
Recall that a constructor can invoke another constructor in the same class by using the keyword
this as a method name.
	 * 
	 
	
	
	A class should not return a reference to an array that is a private data field.


f.eks en interface generated kode, der ikke er blevet udfyldt endnu 
med en konkret implementation bliver kaldt for  en 'stub'.


'Do not wait until you complete the implementation of an ADT
before testing it. By writing stubs, which are incomplete definitions of required methods, you
can begin testing early in the process.'


contains metoden i vores ArrayBag implementation er faktisk interessersant,
fordi den også tjekker på en boolean.


Remove() metoden i ArrayBag:

● Access the entry so it can be returned
● Set the entry’s array element to null
● Decrement numberOfEntries


mhs til removeEntry(index) metoden, så skal vi have lavet en metode der kan finde et specifikt logentrys 
index i vores array, og vi har jo contains() metoden, dette er tankerne i forhold til at contains metoden
måske kunne ændres til at returnere en int i stedet for en boolean:

Design Decision: Should the method contains return the index of a located entry?
Should we change the definition of contains so that it returns an index instead of a boolean value?
No. As a public method, contains should not provide a client with such implementation details. The
client should have no expectation that a bag’s entries are in an array, since they are in no particular
order. Instead of changing the specifications for contains, we will follow our original plan to define a
private method to search for an entry and return its index.



Even though you might have written a correct definition of a method, do not hesitate to revise
it if you think of a better implementation.

**** side 50 i pdf form.
*Using Array Resizing to Implement the ADT Bag:
*
*The strategy. When a classroom is full, one way to accommodate additional students is to move to
a larger room. In a similar manner, when an array becomes full, you can move its contents to a
larger array. This process is called resizing an array

omkring side 49-52 kan man se hvordan man kan give et Array flere pladser . 
faktisk rimelig simpelt pga. et bibliotek i java, men der er alligevel mange skridt som den her metode udførerer
som vi ikke aner hvordan foregår, bortset fra selF hvis vi kigger på hvordan bogen siger den gør. 

vi har et array:
int[] myArray = {10, 20, 30, 40, 50};

og så fordoubler vi dens længde:
myArray = Arrays.copyOf(myArray, 2 * myArray.length);


The effect of the statement
myArray = Arrays.copyOf(myArray, 2 * myArray.length);
(a) The argument array; (b) the parameter that references the
argument array; (c) a new, larger array that gets the contents of the
argument array; (d) the return value that references the new array;
(e) the argument variable is assigned the return value

When increasing the size of an array, you copy its entries to a larger
array. You should expand the array sufficiently to reduce the impact of the cost of copying. A
common practice is to double the size of the array.

To say that we “resize” an array is really a misnomer, since an array’s length cannot
be changed. The process of resizing an array involves creating a completely new array that
contains the entries of the original array. The new array is given the name of the original
array—in other words, a reference to the new array is assigned to the variable that had referenced
the original array. The original array is then discarded.


A class implementing a single interface that declares the operations
of an ADT should define the methods declared in the interface as its only public methods.
However, the class can also define private methods and protected methods.

Using a fixed-size array limits the capacity of a bag, which is usually a disadvantage. Resizing
an array dynamically enables you to increase the array’s size but requires copying data. You should
realize that the array entries that we copy are references, and so do not occupy much space nor take
much time to move. Some languages other than Java store the data itself within the array. In such
cases, moving large, complex objects can be quite time-consuming.

Note: When you use an array to implement the ADT bag,
● Adding an entry to the bag is fast
● Removing an unspecified entry is fast
● Removing a particular entry requires time to locate the entry
● Increasing the size of the array requires time to copy its entries



*
*
}
