package mvc;

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
	private static final long serialVersionUID = 1L;
		private JButton messageButton;
		private MessageListener messageListener;
		private JLabel label;
		private Model model;
		
		public View(Model model)
		{
			model.addObserver(this);
			setLayout(new BorderLayout());
			messageButton = new JButton("Message");
			messageButton.addActionListener(new ActionListener() 
			{

				@Override
				public void actionPerformed(ActionEvent event) 
				{
					messageListener.messageReceived();
				}
				
			});
			label = new JLabel("Label text");
			
			add(messageButton, BorderLayout.CENTER);
			add(label, BorderLayout.SOUTH);
			setSize(100,100);
			
			setVisible(true);
		}
		
		public void setMessageListener(MessageListener messageListener)
		{
			this.messageListener = messageListener;
		}

		@Override
		public void update(Observable orient, Object integer) {
			label.setText("" + integer);
			
		}
	
}
