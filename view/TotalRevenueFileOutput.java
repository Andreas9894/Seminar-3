package se.kth.iv1350.view;

import se.kth.iv1350.model.RevenueObserver;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TotalRevenueFileOutput implements RevenueObserver {
    private static final String LOG_FILE = "total-revenue-log.txt";
    private double totalRevenue;

    @Override
    public void newRevenue(double revenue) {
        totalRevenue += revenue;
        writeToFile();
    }

    private void writeToFile() {
        try (PrintWriter logWriter = new PrintWriter(new FileWriter(LOG_FILE, false))) {
            logWriter.println("Total Revenue (File): " + totalRevenue);
        } catch (IOException e) {
            System.out.println("Could not write to revenue log file: " + e.getMessage());
        }
    }
}


