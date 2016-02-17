import static org.junit.Assert.*;

import org.junit.Test;


public class IteratorTest {

	@Test
	public void test() 
	{
		//Arrange
		VicePresident vp = new VicePresident();
		vp.setName("Tony Blair");
		vp.setDivision("The herpderp league");
		
		VicePresident vp1 = new VicePresident();
		vp1.setName("Barack Obama");
		vp1.setDivision("The herpderp league");
		
		VicePresident vp2 = new VicePresident();
		vp2.setName("Ryan Gosling");
		vp2.setDivision("The herpderp league");
		
		VicePresident vp3 = new VicePresident();
		vp3.setName("Magic Stick");
		vp3.setDivision("The herpderp league");
		
		Division division = new Division();
		division.addVicePresident(vp);
		division.addVicePresident(vp1);
		division.addVicePresident(vp2);
		division.addVicePresident(vp3);
	
		//Act
		DivisionIterator<VicePresident> iterator = new DivisionIterator<VicePresident>(division.getVicePresidents());
		while(iterator.hasNext())
		{
			iterator.remove();
		}
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		
		}
		//Assert
		
		
		
	}

}
