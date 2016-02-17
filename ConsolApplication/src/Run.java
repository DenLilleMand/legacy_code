import javax.swing.*;
import java.awt.*;

public class Run 
{
   static JTextField nameField;
   static JTextField ageField;
   static JTextField herpderpField;
   
	public static void main(String[] args) 
	{
      JFrame frame = new JFrame();
      
      nameField = new JTextField("this is where name should be");
      ageField = new JTextField("This is where age should be");
      herpderpField = new JTextField("This is where herpderp should be");
      
      
      frame.setLayout(new GridLayout(3,3));
      frame.add(nameField);
      frame.add(ageField);
      frame.add(herpderpField);
      
      		
      
      
      frame.setVisible(true);
	}
}
