package se.kth.iv1350.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import integration.ItemDTO;


public class Sale {
    private double runningTotal;
    private double totalTax;
    private LocalDateTime timeOfSale;
    private List <SoldItem> items = new ArrayList<>();


    public Sale () {
        this.items = new ArrayList<>();
        this.timeOfSale = LocalDateTime.now();
        this.totalTax = 0.0;
        this.runningTotal = 0.0;
    }
    public void addItemToItemList  (ItemDTO foundItem) {
        for(SoldItem soldItem : items)
            if(soldItem.getItem().getItemID().equals(foundItem.getItemID()) ){
                soldItem.increaseQuantity();
                runningTotal +=foundItem.getPrice();
                totalTax += foundItem.getPrice()*foundItem.getTaxRate();
                return;
            }
        int quantity = 1;
        items.add(new SoldItem (foundItem, quantity));
        runningTotal += foundItem.getPrice()*quantity;
        totalTax += foundItem.getPrice()* foundItem.getTaxRate();

    }

    public double getRunningTotal () {
        return runningTotal;
    }

    public double getTotalTax () {
        return totalTax;
    }
    public LocalDateTime getTimeOfSale(){
        return timeOfSale;
    }

    public List<SoldItem> getList(){
    return items;
    }
    
    public SoldItem getItem(int item){
        return items.get(item);
    }


    public void displaySaleInfo(ItemDTO foundItem){

        System.out.println("Item : " + foundItem.getItemDesc());
        System.out.println("Price : " + foundItem.getPrice());
        System.out.println("Running total : " + runningTotal);
    }

    public void addFinalTimeOfSale (Sale sale ){
        LocalDateTime timeOfSale = LocalDateTime.now();
    }

}
