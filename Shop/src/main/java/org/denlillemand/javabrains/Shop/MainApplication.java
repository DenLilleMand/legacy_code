package org.denlillemand.javabrains.Shop;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.denlillemand.javabrains.eventHandlingController.MainGUIController;
import org.denlillemand.mediator.*;
import org.denlillemand.persistence.PersistenceLoader;
import org.denlillemand.productPackage.ProductController;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class MainApplication extends Application 
{
	private Mediator mediator = Mediator.getInstance();
	private ProductController productController = ProductController.getInstance();
	
	public static void main(String[] args) 
	{
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		mediator.setStage(primaryStage);
		
		//hvis vi have en scene her, så for at importere vores
		//css så skulle vi skrive:
		//scene.getStyleSheets().add("/fxml/styles/main.css");
		
	
	
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() 
		{
			    public void handle(WindowEvent event) 
			    {
			        try 
			        {
			        	PersistenceLoader.save(ProductController.getInstance().getCopy());
			        	Platform.exit();
						stop();
					} catch (Exception e) 
			        {
						e.printStackTrace();
					}
			    }
			});
	
			try 
			{
				mediator.handle(Go.MAINGUI);
			} catch(Exception e) 
			{
				 Logger.getLogger(MainApplication.class.getName()).log(Level.SEVERE, null, e);
			}
    
	}
}
