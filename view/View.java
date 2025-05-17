package se.kth.iv1350.view;

import java.util.LinkedList;

import se.kth.iv1350.controller.ConnectionException;
import se.kth.iv1350.controller.Controller;
import se.kth.iv1350.controller.ItemIDException;

/**
 * This is a placeholder for the actual view. it contains calls to all system operations in the controller 
 */
public class View {
    private Controller contr;
    private ErrorMessageHandler errorMessageHandler;

    public View (Controller contr, ErrorMessageHandler errorMessageHandler){
        this.contr = contr;
        this.errorMessageHandler = errorMessageHandler;
    }

    public void trialExecution () {

        LinkedList <String> items = new LinkedList<String>();
        items.add("choklad231");
        items.add("brod332");
        items.add("choklad231");
        //items.add("laptop642");
        //items.add("fail");

        contr.startSale();
        try {
            for (String item : items){
                contr.scanItem(item);
            }    
         } catch (ItemIDException e) {
            errorMessageHandler.showErrorMessage(e.getMessage());
        } catch (ConnectionException e) {
            errorMessageHandler.showErrorMessage(e.getMessage());
        }
        
    

        contr.endSale();

        double correctAmount = 80.0;

        contr.customerPaysAmount(correctAmount);
        
    }

}
