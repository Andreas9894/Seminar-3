package se.kth.iv1350.controller;

import integration.DiscountDatabase;
import integration.ExternalAccountingSystem;
import integration.ExternalInventorySystem;
import integration.IntegrationCreator;
import integration.ItemDTO;
import integration.Printer;
import model.Register;
import model.Sale;

/**
 * This is the only controller in the application and all 
 * calls to the model pass through this 
 */
public class Controller {

    private ExternalAccountingSystem extAccSys;
    private ExternalInventorySystem extInvSys;
    private DiscountDatabase discountDB;
    private Sale sale;
    private Printer printer;
    private Register register;
    private double finalChange;

    /**
     * Initialises the sale.
     */

    public void startSale(){
        this.sale = new Sale();
        this.printer = new Printer();
    }
    /**
     * Calls on another method to instantiate the external accounting system, external inventory system and the discount database.
     * @param creator is the integrationCreator that has been instantiated and is used to create the three databases part of integration.
     */
    public Controller (IntegrationCreator creator, Register register) {

        this.extAccSys = creator.getExternalAccountingSystem();
        this.extInvSys = creator.getExternalInventorySystem();
        this.discountDB = creator.getDiscountDatabase();
        this.register = register;
    
    }

   /**
    * Searches the external inventory for the specified item and adds it to the sale.
    * @param itemID is the itemID of the specified item.
    * @return
    */

    public void scanItem (String itemID){
        try {
            ItemDTO foundItem = extInvSys.getItem(itemID);
            sale.addItemToItemList(foundItem);
            sale.displaySaleInfo(foundItem);
        } catch (Exception InvalidItemIDException){
            System.out.println(InvalidItemIDException.getMessage());
        }
        

    }

    private void updateExternalSystems(Sale sale){
        extAccSys.updateAccounting(sale.getRunningTotal());
        register.updateRegister(sale.getRunningTotal());
        extInvSys.updateExtInvSys(sale);

        //FIX THIS 
        //extInvSys.updateExtInvSys(getQuantity);


    }

    private void printReceipt (double amountPaid){
       printer.printReceipt(amountPaid, finalChange, sale);

    }

    /**
     * Ends the sale, adds the current time to the sale class and prints the total cost.
     */
    public void endSale (){
        sale.addFinalTimeOfSale(sale);
        System.out.println("Final Total including VAT : " + sale.getRunningTotal());
    }

    public void customerPaysAmount(double amountPaid){
        finalChange = register.calculateChange(amountPaid, sale.getRunningTotal());
        updateExternalSystems(sale);

        System.out.println("Change : " +finalChange );

        printReceipt(amountPaid);

    }

    

    


}
