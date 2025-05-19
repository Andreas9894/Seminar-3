package se.kth.iv1350.view;


import se.kth.iv1350.model.RevenueObserver;

public class TotalRevenueView implements RevenueObserver {
    private double totalRevenue;

    @Override
    public void newRevenue(double revenue) {
        totalRevenue += revenue;
        showRevenue();
    }

    private void showRevenue() {
        System.out.println("Total Revenue (View): " + totalRevenue);
    }
}

