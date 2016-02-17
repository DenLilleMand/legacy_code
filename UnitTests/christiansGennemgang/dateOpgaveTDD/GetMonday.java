package dateOpgaveTDD;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GetMonday 
{
	public GetMonday(){}
	
//http://stackoverflow.com/questions/7579227/how-to-get-the-given-date-string-formatpattern-in-java
	
	
	public Date getMonday(Date date) throws ParseException
	{
		System.out.println(date.toString());
		
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		boolean monday = cal.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY;
		System.out.println("is monday:" + monday);
		
		
		
		
		SimpleDateFormat simpleDateFormatter = new SimpleDateFormat("EEE-MMM-d-yy");

		String dateString = simpleDateFormatter.format(date.toString());
		System.out.println("DateString:" +dateString);
		
		
		return date;
	}	
}
