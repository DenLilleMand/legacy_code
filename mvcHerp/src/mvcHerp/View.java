package mvcHerp;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class View extends JFrame implements Observer{
	private Model model;
	private JButton messageButton;
	private JLabel messageLabel;
	private MessageListener messageListener;
	
	public View(Model model)
	{
		this.model = model;
		model.addObserver(this);
		messageButton = new JButton("MessageButton");
		messageLabel = new JLabel("label");
		
		messageButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent event) 
			{
				messageListener.messageReceived();
			}
			
		});
		
		setLayout(new BorderLayout());
		
		
		add(messageButton,BorderLayout.NORTH);
		add(messageLabel, BorderLayout.SOUTH);
		
		
		
		setVisible(true);
	}
	
	public void setMessageListener(MessageListener messageListener)
	{
		this.messageListener = messageListener;
	}

	@Override
	public void update(Observable view, Object string) {
		messageLabel.setText(""+string);
		
	}
}
