import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MainTest {
    // Instancia que voy a testear
    private Main mainInstance;
    @BeforeClass
    public void setup(){
        mainInstance = new Main();
    }
    @Test
    public void testPrintExerciseWithValidName() {
        String name = "John";
        String number = "5"; // You can set the desired value for NUMBER

        mainInstance.printExercise(name, number);

        // Add assertions here to verify the expected behavior using TestNG's Assert class.
        // Example: Assert.assertTrue(mainInstance.someMethodReturnsTrue());
    }

    @Test
    public void testPrintExerciseWithNullName() {
        String name = null;
        String number = "5"; // You can set the desired value for NUMBER

        mainInstance.printExercise(name, number);

        // Add assertions here to verify the expected behavior when NAME is null.
    }

    @Test
    public void testPrintExerciseWithInvalidNumber() {
        String name = "Alice";
        String number = "invalid"; // You can set an invalid value for NUMBER

        mainInstance.printExercise(name, number);

        // Add assertions here to verify the expected behavior when NUMBER is invalid.
    }
}