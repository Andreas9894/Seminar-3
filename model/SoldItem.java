package se.kth.iv1350.model;

import se.kth.iv1350.integration.ItemDTO;

public class SoldItem {

    private final ItemDTO item;
    private int quantityPurchased;

    public SoldItem (ItemDTO item, int quantityPurchased){
        this.item = item;
        this.quantityPurchased = quantityPurchased;
    }

    public ItemDTO getItem(){
        return item;
    }

    public int getQuantity(){
        return quantityPurchased;
    }

    public double getTotalPrice (){
        return item.getPrice()* quantityPurchased;
    }

    public double getTotalTax(){
        return item.getPrice()* item.getTaxRate()*quantityPurchased;
    }
    public void increaseQuantity(){
        quantityPurchased++;
    }
    

}
