package se.kth.iv1350.startup;

import se.kth.iv1350.controller.Controller;
import se.kth.iv1350.integration.IntegrationCreator;
import se.kth.iv1350.model.Register;
import se.kth.iv1350.view.View;
import se.kth.iv1350.view.ErrorMessageHandler;

/**
 * Starts the entire application. Contains the main method used to start the application.
 */
public class Main {
/**
 * The main method used to start the entire application.
 * 
 * @param args The application does not take any command line parameters.
 */
    public static void main(String[] args){
        
        IntegrationCreator creator = new IntegrationCreator(); 
        Register register = new Register();
        Controller contr = new Controller(creator, register);
        ErrorMessageHandler errorMessageHandler = new ErrorMessageHandler();
        new View(contr, errorMessageHandler).trialExecution();
    }

}
