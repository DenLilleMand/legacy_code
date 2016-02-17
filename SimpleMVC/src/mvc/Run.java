package mvc;

public class Run {
	public static void main(String [] args)
	{
		Model model = new Model();
		View view = new View(model);
		Controller control = new Controller(model, view);
	}
}
