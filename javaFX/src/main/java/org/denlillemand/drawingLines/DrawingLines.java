package org.denlillemand.drawingLines;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class DrawingLines extends Application 
{
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception 
	{
		Group root = new Group();
		Scene scene = new Scene(root, 300, 150, Color.GRAY);
		Label label = new Label("Hello World Cool edition!");
		label.relocate(524, 280);
	    label.setGraphic(new ImageView());
		
		stage.setScene(scene);
		stage.
		stage.show();
	}
	
	
	
}
