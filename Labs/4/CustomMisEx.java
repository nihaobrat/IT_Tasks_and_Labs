import java.util.InputMismatchException;
import java.util.Scanner;

// создаем новый класс для обработки ошибок
// он наследуется от InputMismatchException
// дальше создаем конструктор и в качестве параметра принимаем message (строку)
class CustomInputMismatchException extends InputMismatchException {
    public CustomInputMismatchException(String message) {
        super(message);
    }
}

public class CustomMisEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Пожалуйста, введите целое число:");

        try {
            int number = readInteger(scanner);
            System.out.println("Вы ввели целое число: " + number);
        } catch (CustomInputMismatchException e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }

    public static int readInteger(Scanner scanner) throws CustomInputMismatchException {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new CustomInputMismatchException("Введенные данные не являются целым числом.");
        }
    }
}