package beatController;

import java.util.ArrayList;

import interfaces.BPMObserver;
import interfaces.BeatModelInterface;





import interfaces.BeatObserver;

import javax.sound.midi.MetaEventListener;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.Sequencer;


public class BeatModel implements BeatModelInterface, MetaEventListener{
	
	int bpm = 90;
	Sequencer sequencer;
	ArrayList beatObservers = new ArrayList();
	ArrayList bpmObservers = new ArrayList();
	
	@Override
	public void meta(MetaMessage event) 
	{
		
	}

	@Override
	public void initialize() 
	{
		setUpMidi();
		buildTrackAndStart();
	}

	private void buildTrackAndStart() 
	{
		
	}

	private void setUpMidi() 
	{
		
	}

	@Override
	public void on() 
	{
		sequencer.start();
		setBPM(90);
	}

	@Override
	public void off() 
	{
		setBPM(0);
		sequencer.stop();
	}

	@Override
	public void setBPM(int bpm) 
	{
		this.bpm = bpm;
		sequencer.setTempoInBPM(getBPM());
		notifyBPMObservers();
	}

	private void notifyBPMObservers() 
	{
		
	}

	@Override
	public int getBPM() 
	{
		return bpm;
	}
	
	public void beatEvent()
	{
		notifyBeatObservers();
	}

	private void notifyBeatObservers() 
	{
		
	}

	@Override
	public void registerObserver(BeatObserver o) 
	{
		
	}

	@Override
	public void removeObserver(BeatObserver o) 
	{
	
	}

	@Override
	public void registerObserver(BPMObserver o) 
	{
		
	}

	@Override
	public void removeObserver(BPMObserver o) 
	{
		
	}

}
