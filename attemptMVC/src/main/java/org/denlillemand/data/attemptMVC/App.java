package org.denlillemand.data.attemptMVC;

import org.denlillemand.data.controller.Controllers.LoginGUIController;
import org.denlillemand.data.view.gui.LoginGUI;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args)
    {
    	LoginGUI loginGUI = new LoginGUI();
    	LoginModel loginModel = new LoginModel();
    	LoginGUIController loginGUIController = new LoginGUIController();
    	
    	
    }
}
