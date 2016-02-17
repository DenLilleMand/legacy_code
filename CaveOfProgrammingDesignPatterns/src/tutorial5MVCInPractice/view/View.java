package tutorial5MVCInPractice.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import tutorial5MVCInPractice.model.Model;

/**
 * Main-frame.
 * @author DenLilleMand
 *
 */
public class View extends JFrame implements ActionListener
{
	private static final long serialVersionUID = -7228312218317232624L;
	private Model model;
	private JButton helloButton;
	private JButton goodbyeButton;
	
	public View(Model model) throws HeadlessException
	{
		super("MVC Demo");
		this.model = model;
		helloButton = new JButton("Hello button");
		goodbyeButton = new JButton("Goodbye button");
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.anchor = GridBagConstraints.CENTER;
		c.gridheight = 0;
		c.gridwidth = 0;
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1;
		c.weighty = 1;
		c.fill=GridBagConstraints.NONE;
		
		add(helloButton, c);
		helloButton.addActionListener(this);
		
			
		
			
		
		c.anchor = GridBagConstraints.CENTER;
		c.gridheight = 0;
		c.gridwidth = 0;
		c.gridx = 3;
		c.gridy = 3;
		c.weightx = 1;
		c.weighty = 1;
		c.fill=GridBagConstraints.NONE;
		add(goodbyeButton,c);
		/**Fordi at det hedder addActionListener, så kan man gå udfra
		 * at knappen har en liste af listeners, ellers ville metode
		 * hedde setActionListener, hvilket den ikke gør. så det er brugbart
		 * både til når man selv skal kalde ting noget, og når man skal 
		 * kalde en metode. */
		goodbyeButton.addActionListener(this);
		goodbyeButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent event) 
			{
				System.out.println("Sorry to see you go ! , but love to see you walk ! :-)))");
			}	
		});
		
		setSize(600,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public Model getModel() {
		return model;
	}
	public void setModel(Model model) {
		this.model = model;
	}

	/** man kalder som regelt de objekter der bliver sendt videre
	 * her for events...  så f.eks, personEvent... og så er spørgsmålet
	 * om vi ville få noget ud af at Extende den klasse der hedder
	 * ActionEvent - det ved jeg ikke helt endnu. spørgsmålet er bare
	 * om det er lovligt at @Override event.getSource() metoden. 
	 * , altså om klassen må lov til at skaffe sig selv en local variable reference,
	 * men det gør den vel alligevel? fordi den wrapper klasse der er, bliver 
	 * jo sendt med ind. så man kan sige at event.getSource() er indbygget i vores
	 * Observer pattern. */
	@Override
	public void actionPerformed(ActionEvent event) 
	{
		if(event.getSource() == helloButton)
		{
			System.out.println("hello");
		}
		else if(event.getSource() == goodbyeButton)
		{
			System.out.println("Goodbye");
		}
	}
	
	
	
	
}
