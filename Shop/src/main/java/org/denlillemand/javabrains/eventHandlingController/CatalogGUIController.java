package org.denlillemand.javabrains.eventHandlingController;

import org.denlillemand.mediator.Mediator;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class CatalogGUIController 
{
	private CatalogGUIController instance;
	private Mediator mediator;
	
	
	@FXML
	private void initialize()
	{
		instance = this;
		mediator = Mediator.getInstance();
		
		
	
		
	}
}
