package se.kth.iv1350.view;

public class ErrorMessageHandler {

    public void showErrorMessage (String message){
        StringBuilder errorInfo = new StringBuilder();
        errorInfo.append("Error: ");

        errorInfo.append(message);
        System.out.println(errorInfo);
    }

}
