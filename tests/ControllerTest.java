package se.kth.iv1350.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.integration.IntegrationCreator;
import se.kth.iv1350.model.Register;

public class ControllerTest {

    private Controller controller;
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();


    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));

        IntegrationCreator creator = new IntegrationCreator();
        Register register = new Register();
        controller = new Controller(creator, register);
        controller.startSale();
    }
    @AfterEach
    void tearDown() {

        System.setOut(originalOut);
        controller = null;

}

    @Test
    void testScanItemInvalidItemIDPrintsErrorMessage() {
        controller.scanItem("laptop642");

        String output = outContent.toString();
        assertTrue(output.contains("could not be found"),
            "Expected error message about missing item ID");
    }

    @Test
    void testScanItemConnectionExceptionPrintsAndLogs() {
        controller.scanItem("fail");

        String output = outContent.toString();
        assertTrue(output.contains("Can't connect to servers."),
            "Expected error message about server connection");
    }

    @Test
    void testScanItemValidItemNoErrorOutput() {
        controller.scanItem("choklad231");

        String output = outContent.toString();
        assertFalse(output.contains("Error:"), 
            "No error message expected for valid item");
        assertFalse(output.contains("Exception was thrown"),
            "No exception should be logged for valid item");
    }
}
