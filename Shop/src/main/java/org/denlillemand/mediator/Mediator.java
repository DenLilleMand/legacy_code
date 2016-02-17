package org.denlillemand.mediator;
import org.denlillemand.javabrains.eventHandlingController.CatalogGUIController;
import org.denlillemand.javabrains.eventHandlingController.MainGUIController;


import java.io.IOException;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Mediator 
{
	private Scene catalogScene;
	private Scene mainScene;
	private Stage stage;
	private static Mediator instance;
	
	private Mediator()
	{
		
	}
	
	public void setCatalogScene(Scene catalogScene)
	{
		this.catalogScene = catalogScene;
	}
	
	public void setMainScene(Scene mainScene)
	{
		this.mainScene = mainScene;
	}
	
	public void setStage(Stage stage)
	{
		this.stage = stage;
	}
	
	public static Mediator getInstance()
	{
		if(instance == null)
		{
			instance = new Mediator();
		}
		return instance;
	}
	
	public void handle(Go login) 
	{
			switch(login)
			{
			//m�ske kan man lave en enkelt metode med det her, og desuden finde ud af hvilke variabler
			//der skal beholde som v�rdi, og hvilke der alligevel ville blive collected af GC.
			//burde have en static block m�ske der loader de her ting ind, ligesom med Pictures i Oikos projektet.
			case CATALOGGUI:
				try 
				{
					stage.setTitle("Catalog gui");
					AnchorPane loginPage = FXMLLoader.load(Mediator.class.getResource("/fxml/CatalogGUI.fxml"));
					catalogScene = new Scene(loginPage);
					stage.setScene(catalogScene);
					stage.show();
				} catch (IOException e) 
				{
					e.printStackTrace();
				}
				break;
			case MAINGUI:
				try
				{
					stage.setTitle("MAIN");
					AnchorPane mainPage =  FXMLLoader.load(Mediator.class.getResource("/fxml/MainGUI.fxml"));
					mainScene = new Scene(mainPage);
					stage.setScene(mainScene);
					stage.show();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				break;
			}
		
	}
}
