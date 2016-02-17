package Tutorial1UnderstandingDependencyInjection;

public class Run {
	public static void main(String[] args)
	{
		Drawing drawing = new Drawing();
		Triangle myTriangle = new Triangle();
		drawing.setShape(myTriangle);
		drawing.drawShape();
		
	}
}
