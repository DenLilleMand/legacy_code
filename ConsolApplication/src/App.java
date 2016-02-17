import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class App extends Application
{
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		Group root = new Group();
		Scene scene = new Scene(root,600,400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Hello world!");
		Label label = new Label("Hello world!");
		BorderPane border = new BorderPane();
		border.setTop(label);
		primaryStage.show();
	}

}
