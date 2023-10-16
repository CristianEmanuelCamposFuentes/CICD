import org.testng.Assert;
import org.testng.annotations.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.testng.Assert.*;

public class MainTest {
    // Instancia que voy a testear
    private Main mainInstance;
//    Para capturar la salida del método printExercise, debes redirigir la salida estándar (System.out)
//    a una instancia de ByteArrayOutputStream.
//    Luego, puedes convertir este ByteArrayOutputStream a una cadena para realizar aserciones.
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeSuite
    public void setUpSuite() {
        // Redirigir la salida estándar a un ByteArrayOutputStream antes de todas las pruebas
        System.setOut(new PrintStream(outputStream));
    }

    @AfterSuite
    public void tearDownSuite() {
        // Restablecer la salida estándar original después de todas las pruebas
        System.setOut(originalOut);
    }
    @BeforeTest
    public void setup(){
        mainInstance = new Main();
    }
    @Test
    public void testPrintExerciseWithValidName() {
        String name = "John";
        String number = "5"; // You can set the desired value for NUMBER

        mainInstance.printExercise(name, number);

        // Aserción 1: Verifica si la salida contiene una cadena específica.
        String output = outputStream.toString();
        Assert.assertTrue(output.contains("Hello, I am John and I am printing the number 1"));

        // Aserción 2: Puedes verificar si la salida contiene otra cadena específica.
        Assert.assertTrue(output.contains("Hello, I am John and I am printing the number 2"));

        // Aserción 3: Verifica si el número total de líneas en la salida es igual a 15.
        String[] outputLines = output.split("\n");
        Assert.assertEquals(outputLines.length, 15);

        // Aserción 4: Puedes verificar si el nombre en la salida es igual al valor esperado.
        Assert.assertTrue(output.contains("I am John"));

        // Aserción 5: Puedes verificar si el número en la salida es igual al valor esperado.
        Assert.assertTrue(output.contains("I am printing the number 66"));

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