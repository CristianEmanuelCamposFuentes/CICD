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

    @BeforeMethod
    public void setUp() {
        // Redirigir la salida estándar a un ByteArrayOutputStream antes de cada prueba
        System.setOut(new PrintStream(outputStream));
        mainInstance = new Main();
    }

    @AfterMethod
    public void tearDown() {
        // Restablecer la salida estándar original después de cada prueba
        System.setOut(originalOut);
        // Limpiar el contenidi del ByteArrayOutputStream
        outputStream.reset();
    }

    @Test
    public void testPrintExerciseWithValidName() {
        String name = "John";
        String number = "15";

        mainInstance.printExercise(name, number);

        // Aserción 1: Verifica si la salida contiene una cadena específica.
        String output = outputStream.toString();
        Assert.assertTrue(output.contains("Hello, I am John and I am printing the number 1"));

        // Aserción 2: Puedes verificar si la salida contiene otra cadena específica.
        Assert.assertTrue(output.contains("Hello, I am John and I am printing the number 2"));

        // Aserción 3: Verifica si el número total de líneas en la salida es igual a 15.
//        String[] outputLines = output.split("\n");
//        Assert.assertEquals(outputLines.length, 15);

        // Aserción 4: Puedes verificar si el nombre en la salida es igual al valor esperado.
        Assert.assertTrue(output.contains("I am John"));

        // Aserción 5: Puedes verificar si el número en la salida es igual al valor esperado.
        Assert.assertTrue(output.contains("I am printing the number 15"));

    }

    @Test
    public void testPrintExerciseWithNullName() {
        String name = null;
        String number = "5";

        mainInstance.printExercise(name, number);

        // Aserción 1: Verifica si la salida contiene un mensaje específico para NAME nulo.
        String output = outputStream.toString();
        Assert.assertTrue(output.contains("Please set the NAME environment variable."));

        // Aserción 2: Verifica que la cadena del nombre no esté presente en la salida.
        Assert.assertFalse(output.contains("I am John"));

        // Aserción 3: Verifica si la variable "number" es igual a "5".
        Assert.assertEquals(number, "5");
    }

    @Test
    public void testPrintExerciseWithInvalidNumber() {
        String name = "Alice";
        String number = "invalid"; // You can set an invalid value for NUMBER

        // Aserción 1: Verifica si la salida contiene un mensaje específico para NUMBER inválido.
        try {
            mainInstance.printExercise(name, number);
            Assert.fail("Se esperaba una NumberFormatException");
        } catch (NumberFormatException e) {
            // Verifica el mensaje de la excepción
            String expectedMessage = "Valor invalido para NUMERO. Utilizando valor por defecto (15)";
            String actualMessage = e.getMessage();
            Assert.assertEquals(expectedMessage, actualMessage);
        }

//        // Aserción 2: Verifica que la cadena del nombre esté presente en la salida.
//        mainInstance.printExercise(name, number);
//        String output = outputStream.toString();
//        Assert.assertTrue(output.contains("I am "));
//        Assert.assertTrue(output.contains(name));
        // Aserción 3: Verifica que el valor de "number" es igual al valor esperado ("invalid").
        Assert.assertEquals(number, "invalid");
    }
}