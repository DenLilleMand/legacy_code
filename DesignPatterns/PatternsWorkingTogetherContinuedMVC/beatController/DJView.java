package beatController;
import interfaces.BPMObserver;
import interfaces.BeatModelInterface;
import interfaces.BeatObserver;
import interfaces.ControllerInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;


public class DJView implements ActionListener, BeatObserver,BPMObserver 
{
	BeatModelInterface model;
	ControllerInterface controller;
	JFrame viewFrame;
	JPanel viewPanel;
	JProgressBar beatBar;
	JLabel bpmOutputLabel;
	JTextField bpmTextField;
	JLabel bpmLabel;
	JButton setBPMButton;
	JButton increaseBPMButton;
	JButton decreaseBPMButton;
	JMenuBar menuBar;
	JMenu menu;
	JMenuItem startMenuItem;
	JMenuItem stopMenuItem;
	
	
	public void createControls()
	{
		//create all Swing components
	}
	
	public void disableStopMenuItem()
	{
		stopMenuItem.setEnabled(false);
	}
	
	public void enableStopMenuItem()
	{
		stopMenuItem.setEnabled(true);
	}
	
	public void enableStartMenuItem()
	{
		startMenuItem.setEnabled(true);;
	}
	
	public void disableStartMenuItem()
	{
		startMenuItem.setEnabled(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) 
	{
		if(event.getSource() == setBPMButton)
		{
			int bpm = Integer.parseInt(bpmTextField.getText());
			controller.setBPM(bpm);
		}
		else if(event.getSource() == increaseBPMButton)
		{
			controller.increaseBPM();
		}
		else if(event.getSource() == decreaseBPMButton)
		{
			controller.decreaseBPM();
		}
	}
	
	public DJView(ControllerInterface controller,BeatModelInterface model)
	{
		this.controller = controller;
		this.model = model;
		model.registerObserver((BeatObserver)this);
		model.registerObserver((BPMObserver)this);
	}
	
	public void createView()
	{
		
	}
	
	public void updateBPM()
	{
		int bpm = model.getBPM();
		if(bpm == 0)
		{
			bpmOutputLabel.setText("Offline");
		}
		else
		{
			bpmOutputLabel.setText("Current BPM: " + model.getBPM());
		}
	}
	
	public void updateBeat()
	{
		beatBar.setValue(100);
	}

}
