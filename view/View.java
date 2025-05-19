package se.kth.iv1350.view;

import java.util.LinkedList;

import se.kth.iv1350.controller.Controller;

/**
 * This is a placeholder for the actual view. it contains calls to all system operations in the controller 
 */
public class View {
    private Controller contr;

    public View (Controller contr){
        this.contr = contr;
    }

    public void trialExecution () {

        LinkedList <String> items = new LinkedList<String>();
        items.add("choklad231");
        items.add("brod332");
        items.add("choklad231");
        items.add("lask256");

        contr.startSale();
        TotalRevenueView revenueView = new TotalRevenueView();
        TotalRevenueFileOutput revenueFile = new TotalRevenueFileOutput();

        contr.addRevenueObserver(revenueView);
        contr.addRevenueObserver(revenueFile);

         for (String item : items){
            contr.scanItem(item);
            }    
    
        contr.endSale();

        double amountPaid = 80.0;

        contr.customerPaysAmount(amountPaid);


        
    }

}
