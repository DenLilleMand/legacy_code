public class Noter {

	/**
	 * tl;dr;
	 * 
	 * 
	 * 
	 * 
	 * Noter:
	 * 
	 * MockObject definition:—A mock object is an object created to stand in for
	 * an object that your code will be collaborating with. Your code can call
	 * methods on the mock object, which will deliver results as set up by your
	 * tests.
	 * 
	 * JUnit best practices: only test what can possibly break You may have
	 * noticed that you did not mock the Account class. The reason is that this
	 * data-access object class does not need to be mocked—it does not depend on
	 * the environment, and it’s very simple. Your other tests use the Account
	 * object, so they test it indirectly. If it failed to operate correctly,
	 * the tests that rely on Account would fail and alert you to the problem.
	 * 
	 * 
	 * Kommentar mhs. til at åbne ens kode for tests + lettere refaktorering:
	 * The design is better now because you can use and reuse the
	 * DefaultAccountManager class with any implementation of the Log and
	 * Configuration interfaces (if you use the constructor that takes two
	 * parameters). The class can be controlled from the outside (by its
	 * caller). Meanwhile, you have not broken the existing interface, because
	 * you have only added a new constructor. You kept the original default
	 * constructor that still initializes the logger and configuration field
	 * members with default implementations.
	 * 
	 * Should you worry about introducing trapdoors to make your code easier to
	 * test? Here’s how Extreme Programming guru Ron Jeffries explains it: My
	 * car has a diagnostic port and an oil dipstick. There is an inspection
	 * port on the side of my furnace and on the front of my oven. My pen
	 * cartridges are transparent so I can see if there is ink left. And if I
	 * find it useful to add a method to a class to enable me to test it, I do
	 * so. It happens once in a while, for example in classes with easy
	 * interfaces and complex inner function (probably starting to want an
	 * Extract Class). I just give the class what I understand of what it wants,
	 * and keep an eye on it to see what it wants next.1
	 * 
	 * Dette pattern er også kaldt inversion of control(IOC) The main idea is to
	 * externalize all domain objects from outside the class/method and pass
	 * everything to it. Instead of the class creating object instances, the
	 * instances are passed to the class (usually through interfaces).
	 * 
	 * IOC explained as design pattern: Design patterns in action: Inversion of Control (IOC) Applying
	 * the IOC pattern to a class means removing the creation of all object
	 * instances for which this class is not directly responsible and passing
	 * any needed instances instead. The instances may be passed using a
	 * specific constructor, using a setter, or as parameters of the methods
	 * needing them. It becomes the responsibility of the calling code to
	 * correctly set these domain objects on the called class.2
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
}
