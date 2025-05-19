package se.kth.iv1350.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RegisterTest {

   private Register register;

    @BeforeEach
    public void setUp() {
        register = new Register();
    }

    @AfterEach
    public void cleanUp(){
        register = null;
    }

    @Test
    public void testUpdateRegisterIncreasesMoneyCorrectly() {
        double initialAmount = 1000.0;
        double finalTotal = 200.0;

        register.updateRegister(finalTotal);
        
        double expected = initialAmount + finalTotal;
        assertEquals(expected, register.calculateChange(expected, 0), 0.001);
    }

    @Test
    public void testCalculateChangeExactAmount() {
        double change = register.calculateChange(100.0, 100.0);
        assertEquals(0.0, change, 0.00);
    }

    @Test
    public void testCalculateChangeReturnsCorrectDifference() {
        double change = register.calculateChange(150.0, 100.0);
        assertEquals(50.0, change, 0.00);
    }
}

