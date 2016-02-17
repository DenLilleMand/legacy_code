package controller;

import java.util.Observable;
import java.util.Observer;

import mediator.GUIMediatorClient;

public class UndoRedoController implements Observer {
	
	
	
	
	
	@Override
	public void update(Observable observable, Object event) {
		if(observable instanceof GUIMediatorClient)
		{
			
		}
		
	}

}
