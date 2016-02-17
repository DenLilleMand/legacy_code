package makeDefensiveCopiesWhenNeeded;

import java.util.Date;

public class HowToRuinPeriodClass {
/**
 * her kan vi se hvordan vi ødelægger en umiddelbart immutable
 * implementation af dates i Period klasse,
 * men fordi objekter bliver givet videre som by-reference,
 * så kan vi redigere end efter vi har givet den ind som parameter.
 * @param args
 */
	public static void main(String[] args) {
		Date start = new Date();
		Date end = new Date();
		Period p = new Period(start,end);
		end.setYear(78); //Modifies internals of p
		System.out.println(p.end());
	}

}
