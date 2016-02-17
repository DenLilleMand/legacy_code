package tutorial5MVCInPractice.controller;

import tutorial5MVCInPractice.model.Model;
import tutorial5MVCInPractice.view.View;

public class Controller 
{

	private Model model;
	private View view;
	
	public Controller(Model model, View view) 
	{
		this.model = model;
		this.view = view;
	}

}
