package mvc;

public class Controller implements IController{

	@Override
	public void setListeners(IModel model, IView view) 
	{
		model.setListeners();
		view.setListeners(model);
	}

}
