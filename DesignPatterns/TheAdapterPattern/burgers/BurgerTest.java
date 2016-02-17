package burgers;

import static org.junit.Assert.*;

import org.junit.Test;

public class BurgerTest {

	@Test
	public void test() {
		//Arrange
		Burger burger = new Burger();
		burger = new Cheese(burger);
		burger = new Onion(burger);
		burger = new TurkeyBacon(burger);
		//act
		String result = burger.description();
		System.out.println(result);
		//assert
		assertEquals("herpderp didn't work", "You bought a burger with cheese and with onions adding turkeybacon",result);
		
	}

}
