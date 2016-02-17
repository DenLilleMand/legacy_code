package tutorial5MVCInPractice;

import javax.swing.SwingUtilities;

import tutorial5MVCInPractice.controller.Controller;
import tutorial5MVCInPractice.model.Model;
import tutorial5MVCInPractice.view.View;


public class Application {
	public static void main(String [] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run() 
			{
				runApp();
			}
			
		});
	}
	
	public static void runApp() 
	{
		Model model = new Model();
		View view = new View(model);
		Controller controller = new Controller(model,view);
	}
}
