import java.util.regex.*; // Импортируем пакет для работы с регулярными выражениями.

public class NumberFinder {
    public static void main(String[] args) {
        // Основной метод, точка входа в программу.
        String text1 = "The price of the product is $-19.99"; // Определение первой тестовой строки.
        String text2 = "abc"; // Определение второй тестовой строки (без чисел).
        String text3 = ""; // Определение третьей тестовой строки (пустой).

        try {
            // Блок try для обработки исключений.
            findAndPrintNumbers(text1); // Вызов метода поиска чисел для первой строки.
            findAndPrintNumbers(text2); // Вызов метода поиска чисел для второй строки.
            findAndPrintNumbers(text3); // Вызов метода поиска чисел для третьей строки.
        } catch (Exception e) {
            // Блок catch для обработки исключений.
            System.err.println("Произошла ошибка: " + e.getMessage()); // Вывод сообщения об ошибке.
        }
    }

    private static void findAndPrintNumbers(String text) {
        // Метод для поиска и вывода чисел в строке.
        Pattern pattern = Pattern.compile("-?\\b\\d+(\\.\\d{1,2})?\\b");
        // Компиляция регулярного выражения для поиска чисел.
        Matcher matcher = pattern.matcher(text); // Создание объекта Matcher для работы с регулярным выражением.

        System.out.println("Предложение: " + text); // Вывод обрабатываемой строки.

        if (!matcher.find()) {
            // Проверка, найдены ли числа в строке.
            System.out.println("В данном предложении нет чисел.\n"); // Вывод сообщения, если чисел нет.
            return; // Выход из метода, если числа не найдены.
        }

        System.out.print("Найденные числа: "); // Вывод заголовка перед списком найденных чисел.

        // Цикл поиска и вывода всех чисел в строке.
        do {
            System.out.print(matcher.group() + " "); // Вывод найденного числа.
        } while (matcher.find()); // Продолжение поиска до тех пор, пока есть числа.

        System.out.println("\n"); // Вывод новой строки после списка чисел.
    }
}
