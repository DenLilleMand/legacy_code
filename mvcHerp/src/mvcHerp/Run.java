package mvcHerp;

public class Run 
{

	public static void main(String[] args) 
	{
		Model model = new Model();
		View view = new View(model);
		Controller controller = new Controller(view,model);
		view.setMessageListener(controller);
	}

}
