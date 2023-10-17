import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static final Scanner scanner = new Scanner(System.in).useDelimiter("\n");
    public static void main(String[] args) {
        System.out.println("Ingrese su nombre:");
        String name = scanner.nextLine();

        System.out.println("Ingrese un numero aleatorio (o presione enter si quiere un numero por defecto):");
        String number = scanner.nextLine();

        printExercise(name, number);
    }

    public static void printExercise(String name, String number){
        if (name == null) {
            System.out.println("Please set the NAME environment variable.");
            return;
        }

        int repeatCount = 15;

        if (!number.isEmpty()) {
            try {
                repeatCount = Integer.parseInt(number);
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Valor invalido para NUMERO. Utilizando valor por defecto (15)");
            }
        }

        for (int i = 1; i <= repeatCount; i++) {
            int randomNumber = ThreadLocalRandom.current().nextInt(1, 6);
            String outputLine = "Hello, I am " + name + " and I am printing the number " + i;
            System.out.println(outputLine); // Agrega esta línea para depurar
            try {
                Thread.sleep(randomNumber * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Sleep complete");
        }
    }
}