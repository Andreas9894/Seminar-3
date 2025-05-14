package se.kth.iv1350.integration;

public class IntegrationCreator {
    private ExternalInventorySystem extInvSys = new ExternalInventorySystem();
    private ExternalAccountingSystem extAccSys = new ExternalAccountingSystem ();
    private DiscountDatabase discountDB = new DiscountDatabase();

    public ExternalInventorySystem getExternalInventorySystem() {

        return extInvSys;
    }

    public ExternalAccountingSystem getExternalAccountingSystem () {

        return extAccSys;
    }

    public DiscountDatabase getDiscountDatabase() {
        
        return discountDB;
    }


        
}
