package inPublicClassesUseAccessorMethodsNotPublicFields;

public class RunOgNoter 
{
	/**
	 * Jeg stopper med at skrive noter fra nu af, jeg tilføjer
	 * kun kode eksempler hvor de bliver givet,
	 * ellers må man håbe på at man kan huske nogle af reglerne, og
	 * måske at der kommer flere kode eksempler.
	 * @param args
	 */
	public static void main(String[] args) 
	{
		//Degenerate classes like this should not be public
		//side 94/95 taler om dette og forklare eksemplerne bedre.
		class Point
		{
			public double x;
			public double y;
		}
		
		//Encapsulation of data by accessor methods and mutators
		class Point
		{
			private double x;
			private double y;
			
			public Point(double x, double y)
			{
				this.x =x;
				this.y = y;
			}
			
			public double getX(){return x;}
			public double getY(){return y;}
			
			public void setX(double x) {this.x = x;}
			public void setY(double y) {this.y = y;}
		}
		
		//public class with exposed immutable fields - questionable
		public final class Time
		{
			private static final int HOURS_PER_DAY = 24;
			private static final int MINUTES_PER_HOUR = 60;
			
			public final int hour; //det er de her 2 variabler der bliver diskuteret(side 95)
			public final int minute;
		
			public Time(int hour, int minute)
			{
				if(hour < 0 || hour >= HOURS_PER_DAY)
				{
					throw new IllegalArgumentException("Hour: " + hour);
				}
				if(minute < 0 || minute >= MINUTES_PER_HOUR)
				{
					throw new IllegalArgumentException("Min: " + minute);
				}
				this.hour = hour;
				this.minute = minute;
			}
			// Remainder omitted
		}
		
		
		
	}

}
