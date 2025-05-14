package se.kth.iv1350.startup;

import controller.Controller;
import integration.IntegrationCreator;
import model.Register;
import view.View;

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
        new View(contr).trialExecution();
    }

}
