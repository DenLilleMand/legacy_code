package eventHandlingController;



import entities.User;
import entities.UserStatus;
import state.State;
import mediator.Go;
import mediator.GUIMediatorClient;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;


public class EventHandlingControllerLogin
{
	private static EventHandlingControllerLogin instance;
	public EventHandlingControllerLogin()
	{
		//dont handle reflection here - the FXML loader uses reflection to load data into this object
		//atleast the documentation mentions smt. about reflection.
	}
	
	public static EventHandlingControllerLogin getInstance()
	{
		if(instance == null)
		{
			instance = new EventHandlingControllerLogin();
		}
		return instance;
	}
	
	
	@FXML
	private AnchorPane mainPane;
	
	@FXML
	private TextField newUserField;
	
	
	@FXML
	private TextField userTextField;
	
	private GUIMediatorClient mediator;
	private State state = State.getInstance();
	
	@FXML
	private void initialize()
	{
		instance = this;
		mediator = GUIMediatorClient.getInstance();
		userTextField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
               if(ke.getCode() == KeyCode.ENTER)
               {
            	   		if(userTextField.getLength() <1)
            	   		{
            	   			return;
            	   		}
            		   User user = User.newUser(userTextField.getText());
            		   user.newUser = false;
            		   user.setUserStatus(UserStatus.USER);
            		   state.setUser(user);          		   
            		   mediator.handle(Go.MAIN);
               }
            }
        });
		
		newUserField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if(ke.getCode() == KeyCode.ENTER)
                {
                	if(newUserField.getLength() <1)
        	   		{
                		return;
        	   		}
                   User user = User.newUser(newUserField.getText());
         		   user.newUser = true;
         		   user.setUserStatus(UserStatus.USER);
         		   state.setUser(user);
             	   mediator.handle(Go.MAIN);
                }
             }
         });
		
	}
	
	
	
}