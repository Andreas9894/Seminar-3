package se.kth.iv1350.integration;

/**
 * Contains information about one specific item. 
 */
public final class ItemDTO {

    private final String itemID;
    private final double taxRate;
    private final String itemDesc;
    private final double price;

    /**
     * Creates a new instance representing a particular item.
     * @param itemID    The item's item ID. 
     * @param taxRate   The tax rate for the particular item.
     * @param itemDesc  The item description for the particular item.
     * @param price     The price of the particular item with tax
     */

    public ItemDTO (String itemID, double taxRate, String itemDesc, double price){
        this.itemID = itemID;
        this.taxRate = taxRate;
        this.itemDesc = itemDesc;
        this.price = price;

    }

    public String getItemID() {
        return itemID;
    }
    public String getItemDesc() {
        return itemDesc;
    }
    public double getPrice(){
        return price;
    }
    public double getTaxRate (){
        return taxRate;
    }




}
