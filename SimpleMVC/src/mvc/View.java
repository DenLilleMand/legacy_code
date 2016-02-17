package mvc;

import javax.swing.JFrame;

public class View extends JFrame implements IView
{
	private static final long serialVersionUID = 1L;
	
	/**Kunne overveje at lave den her API til kun getters */
	private IModel model;

	
	@Override
	public void setListeners(IModel model) 
	{
		
	}
	
	public View(IModel model)
	{
		this.model = model;
		model.setListeners(this);
	}
	
	
}
