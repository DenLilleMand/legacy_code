package mediator;

import java.io.IOException;
import java.util.Observable;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GUIMediatorClient extends Observable
{
	private Scene loginScene;
	private Scene mainScene;
	private Stage stage;
	public void setStage(Stage stage)
	{
		this.stage = stage;
	}
	private static GUIMediatorClient instance;
	
	private GUIMediatorClient()
	{
		
	}
	
	
	
	public static GUIMediatorClient getInstance()
	{
		if(instance == null)
		{
			instance = new GUIMediatorClient();
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
			case LOGIN:
				try 
				{
					stage.setTitle("LOGIN");
					AnchorPane loginPage = FXMLLoader.load(GUIMediatorClient.class.getResource("/fxml/login.fxml"));
					loginScene = new Scene(loginPage);
					stage.setScene(loginScene);
					stage.show();
				} catch (IOException e) 
				{
					e.printStackTrace();
				}
				break;
			case MAIN:
				try
				{
					stage.setTitle("MAIN");
					AnchorPane mainPage =  FXMLLoader.load(GUIMediatorClient.class.getResource("/fxml/clientfxml.fxml"));
					mainScene = new Scene(mainPage);
					KeyCombination undo = new KeyCodeCombination(KeyCode.Z,
							KeyCombination.CONTROL_DOWN);
					KeyCombination redo = new KeyCodeCombination(KeyCode.Y,
							KeyCombination.CONTROL_DOWN);
					mainScene.setOnKeyPressed(new EventHandler<KeyEvent>()
					{
						@Override
						public void handle(KeyEvent event) {
							if(undo.match(event) || redo.match(event))
							{
								setChanged();
								notifyObservers(event);
							}	
						}
					});
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
