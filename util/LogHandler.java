package se.kth.iv1350.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.server.LogStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * This class is responsible for creating the error log.
 */

public class LogHandler {

    private static final String LOG_FILE_NAME = "process-sale-log.txt";

    private PrintWriter logFile;
    
    public LogHandler() {
        try {
            logFile = new PrintWriter( new FileWriter (LOG_FILE_NAME), true);
        } catch (IOException ioe) {
            System.out.println("CAN NOT LOG.");
            ioe.printStackTrace();
        }
    }

    public void logException (Exception exception){
        StringBuilder logMessageBuilder = new StringBuilder();
        logMessageBuilder.append(createTime()); 
        logMessageBuilder.append(" Exception was thrown : ");
        logMessageBuilder.append(exception.getMessage());
        logFile.println(logMessageBuilder);
        exception.printStackTrace(logFile);
    }

    private String createTime (){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        return now.format(formatter);
    }

}
