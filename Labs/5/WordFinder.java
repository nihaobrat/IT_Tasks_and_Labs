import java.util.regex.*; // Импорт пакета для работы с регулярными выражениями.

public class WordFinder {

    public static void main(String[] args) {
        // Основной метод, который выполняется при запуске программы.
        String text = "Apple apricot banana cherry date."; // Инициализация строки с текстом для поиска.
        char startingLetter = 'b'; // Указание начальной буквы для поиска слов.
        findWords(text, startingLetter); // Вызов метода поиска слов, начинающихся на заданную букву.
    }

    public static void findWords(String text, char startingLetter) {
        // Метод для поиска слов, начинающихся с заданной буквы.
        if (text.isEmpty()) {
            // Проверка, пуста ли строка.
            System.out.println("Строка пуста."); // Вывод сообщения, если строка пуста.
            return; // Завершение метода, если строка пуста.
        }

        // Формирование регулярного выражения для поиска слов.
        String regex = "\\b" + Pattern.quote(String.valueOf(startingLetter)) + "\\w*\\b";

        try {
            // Блок try для обработки исключений.
            Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE); // Компиляция регулярного выражения с учетом регистра.
            Matcher matcher = pattern.matcher(text); // Создание объекта Matcher для поиска соответствий в тексте.

            // Поиск и вывод всех слов, начинающихся с заданной буквы.
            boolean found = false; // Флаг для отслеживания наличия найденных слов.
            while (matcher.find()) {
                // Цикл продолжается, пока находятся соответствия.
                System.out.println(matcher.group()); // Вывод найденного слова.
                found = true; // Установка флага в true при нахождении слова.
            }

            if (!found) {
                // Проверка, найдены ли слова.
                System.out.println("Слова, начинающиеся с буквы '" + startingLetter + "', не найдены."); // Вывод сообщения, если слова не найдены.
            }
        } catch (PatternSyntaxException e) {
            // Блок catch для обработки исключений, связанных с синтаксисом регулярных выражений.
            System.err.println("Ошибка в синтаксисе регулярного выражения: " + e.getMessage()); // Вывод сообщения об ошибке.
        }
    }
}
