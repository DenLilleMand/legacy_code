package mvcherppderp;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class View extends JFrame implements Observer
{
	private Model model;
	private JButton messageButton;
	private JLabel messageLabel;
	private MessageListener messageListener;
	
	public View(Model model)
	{
		this.model = model;
		model.addObserver(this);
		messageButton = new JButton("Message");
		messageLabel = new JLabel("label");
		
		messageButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				messageListener.messageReceived();		
			}
			
		});
		setLayout(new BorderLayout());
		
		add(messageButton, BorderLayout.NORTH);
		add(messageLabel, BorderLayout.SOUTH);
		setSize(200,200);
		setVisible(true);
	}

	@Override
	public void update(Observable arg0, Object integer) 
	{
		messageLabel.setText(""+ integer);
	}
	
	public void setMessageListener(MessageListener messageListener)
	{
		this.messageListener = messageListener;
	}

}
