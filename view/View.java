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

    public View (Controller contr){
        this.contr = contr;
        this.errorMessageHandler = new ErrorMessageHandler();
    }

    public void trialExecution () {

        LinkedList <String> items = new LinkedList<String>();
        items.add("choklad231");
        items.add("brod332");
        items.add("laptop192");
        items.add("choklad231");
        items.add("lask256");
        items.add("fail");
        

        contr.startSale();
        TotalRevenueView revenueView = new TotalRevenueView();
        TotalRevenueFileOutput revenueFile = new TotalRevenueFileOutput();

        contr.addRevenueObserver(revenueView);
        contr.addRevenueObserver(revenueFile);

         for (String item : items){
            try{
            contr.scanItem(item);
            }
            catch (ItemIDException e){
                errorMessageHandler.showErrorMessage(e.getMessage());
                continue;
            } catch (Exception e){
                errorMessageHandler.showErrorMessage(e.getMessage());
                System.exit(1);

            }
            }    
    
        contr.endSale();

        double amountPaid = 80.0;

        contr.customerPaysAmount(amountPaid);


        
    }

}
