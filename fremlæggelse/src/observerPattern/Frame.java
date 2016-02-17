package observerPattern;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Frame extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	private Table table;
	private JButton addButton;
	private JButton removeButton;
	private ArrayListWrapper arrayListWrapper = ArrayListWrapper.getInstance();

	public Frame()
	{
		super("Hey mattis fremlæg");
		table = new Table(arrayListWrapper);
		
		
		
		
		
		
		
		
	}
	
	
	

}
