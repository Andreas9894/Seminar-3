package se.kth.iv1350.controller;

import se.kth.iv1350.integration.DiscountDatabase;
import se.kth.iv1350.integration.ExternalAccountingSystem;
import se.kth.iv1350.integration.ExternalInventorySystem;
import se.kth.iv1350.integration.IntegrationCreator;
import se.kth.iv1350.integration.ItemDTO;
import se.kth.iv1350.integration.Printer;
import se.kth.iv1350.model.Register;
import se.kth.iv1350.model.RevenueObserver;
import se.kth.iv1350.model.Sale;
import se.kth.iv1350.util.LogHandler;
import se.kth.iv1350.view.ErrorMessageHandler;

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
    private ErrorMessageHandler errorMessageHandler;
    private LogHandler logHandler;

    /**
     * Initialises the sale.
     */

    public void startSale(){
        this.sale = new Sale();
        this.printer = new Printer();
        this.errorMessageHandler = new ErrorMessageHandler();
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
        this.logHandler = new LogHandler();
     
        
    
    }

   /**
    * Searches the external inventory for the specified item and adds it to the sale.
    * @param itemID is the itemID of the specified item.
    * @return
 * @throws Exception 
    */

    public void scanItem  (String itemID) throws Exception {
           
        try {
            ItemDTO foundItem = extInvSys.getItem(itemID);
            sale.addItemToItemList(foundItem);
            sale.displaySaleInfo(foundItem);
          
         } catch (ItemIDException e) {
            throw e;
        } 
            
         catch (Exception e ){
            logHandler.logException(e);
            throw e;
            
        }
    }

    private void updateExternalSystems(Sale sale){
        extAccSys.updateAccounting(sale.getRunningTotal());
        register.updateRegister(sale.getRunningTotal());
        extInvSys.updateExtInvSys(sale);

    }

    private void printReceipt (double amountPaid){
       printer.printReceipt(amountPaid, finalChange, sale);

    }
    public void addRevenueObserver(RevenueObserver obs){
        sale.addRevenueObserver(obs);
    }

    /**
     * Ends the sale, adds the current time to the sale class and prints the total cost.
     */
    public void endSale (){
        sale.endSale(sale);
        System.out.println("Final Total including VAT : " + sale.getRunningTotal());
    }

    public void customerPaysAmount(double amountPaid){
        finalChange = register.calculateChange(amountPaid, sale.getRunningTotal());
        updateExternalSystems(sale);

        System.out.println("Change : " +finalChange );

        printReceipt(amountPaid);

    }

}
