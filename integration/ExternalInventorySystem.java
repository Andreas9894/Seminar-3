package se.kth.iv1350.integration;

import java.util.ArrayList;
import java.util.List;

import se.kth.iv1350.controller.ConnectionException;
import se.kth.iv1350.controller.ItemIDException;
import se.kth.iv1350.model.Sale;
import se.kth.iv1350.model.SoldItem;

/**
 * This contains the item description, itemID, price, tax rate.
 */
public class ExternalInventorySystem {
    private List <ItemDTO> items = new ArrayList<>();
    private int itemStorage;


    /**
     * Adds two specific items to the external inventory system
     */
    public ExternalInventorySystem () {
        items.add(new ItemDTO("choklad231", 0.2, "Daimchoklad", 15));
        items.add(new ItemDTO ("brod332", 0.15,"Baguette", 19 ));
        items.add(new ItemDTO ("lask256", 0.17,"Fanta", 20 ));

    }
    
    
    /**
     * Searches the external inventory system for a matching itemID and returns it if found.
     * @param itemID the specified item's itemID
     * @return
     * @throws ItemIDException if an item with the matching itemID can not be found.
     * @throws ConnectionException if a connection to the servers can't be established.
     */
    public ItemDTO getItem (String itemID) throws ItemIDException, ConnectionException{
            for(ItemDTO item :items ) {
                if(item.getItemID() .equals(itemID))
                    return item;  
             }
             
             if ("fail".equals(itemID))
                throw new ConnectionException ("Can't connect to servers.");
             throw new ItemIDException("\"" + itemID +"\" " +  "could not be found.");
    }
    /**
     * Updates the quantity of the item remaining in the storage after customer has purchased items.
     * @param quantityPurchased The quantity of the items purchased by the customer.
     */
    public void updateExtInvSys(Sale sale){
        for (SoldItem i: sale.getList()){
            int quantityPurchased = i.getQuantity();
            itemStorage -= quantityPurchased;

        }
        

    }
    
}