package se.kth.iv1350.integration;

public class ExternalAccountingSystem {

    private double moneyInAccounting; 
    /**
     * Fakes adding money to the accounting system.
     * @param finalTotal is the final cost of all products.
     */
    public void updateAccounting (double finalTotal){
        moneyInAccounting = 1000;
        moneyInAccounting += finalTotal;

    }

}
