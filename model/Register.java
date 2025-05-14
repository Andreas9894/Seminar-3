package se.kth.iv1350.model;

public class Register {

    private double moneyInRegister ;

    /**
     * Creates the register class and sets the current cash in it to be 1000.
     */
    public Register (){
        this.moneyInRegister = 1000;
    }


    /**
     * Updates the money in the register after customer has paid for their desired items.
     * @param finalTotal  The final cost of all the products purchased by the customer.
     */
    public void updateRegister (double finalTotal){
        moneyInRegister += finalTotal;
    }

    /**
     * Calculates the amount of change to give back to customer.
     * @param amountPaid the amount of money provided by the customer
     * @param finalTotal The final cost of the entire purchase including VAT rate.
     * @return
     */

    public double calculateChange (double amountPaid, double finalTotal){
        double finalChange = 0.0;
        if (amountPaid ==finalTotal)
            return finalChange;
        else 
            finalChange = amountPaid - finalTotal;
            return finalChange;
        
        
    }


}
