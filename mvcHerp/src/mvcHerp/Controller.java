package mvcHerp;

public class Controller implements MessageListener{

	private Model model;
	private View view;
	
	
	@Override
	public void messageReceived() 
	{
		model.messageReceived();
	}
	
	public Controller(View view, Model model)
	{
		this.view = view;
		this.model = model;
	}

}
