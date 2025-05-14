package se.kth.iv1350.view;
import controller.Controller;

/**
 * This is a placeholder for the actual view. it contains calls to all system operations in the controller 
 */
public class View {
    private Controller contr;

    public View (Controller contr){
        this.contr = contr;
    }

    public void trialExecution () {
        String existingID = "choklad231";
        String testID = "brod332";


        contr.startSale();
        contr.scanItem(existingID);
        contr.scanItem(existingID);
        contr.scanItem(testID);
        contr.scanItem(testID);
    

        contr.endSale();

        double correctAmount = 80.0;

        contr.customerPaysAmount(correctAmount);
        
    }



        

}
