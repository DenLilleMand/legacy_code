package mvcherppderp;

public class Controller implements MessageListener{

	private View view;
	private Model model;
	public Controller(View view, Model model) {
		this.view = view;
		this.model = model;
	}
	@Override
	public void messageReceived() 
	{
		model.updateMessageLabel();
	}
	
	
	

}
