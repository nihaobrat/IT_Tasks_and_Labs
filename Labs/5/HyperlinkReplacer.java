import java.util.regex.*;

public class HyperlinkReplacer {

    public static void main(String[] args) {
        // Основной метод, точка входа в программу.
        String text = "https://www.youtube.com/"; // Определение строки с URL.
        String replacedText = replaceLinksWithHyperlinks(text); // Вызов метода для замены URL на гиперссылки.
        System.out.println(replacedText); // Вывод результата.
    }

    public static String replaceLinksWithHyperlinks(String text) {
        // Метод для замены URL во входной строке на HTML-гиперссылки.
        if (text.isEmpty()) {
            // Проверка, пуста ли входная строка.
            return "Строка пуста."; // Возвращение сообщения, если строка пуста.
        }

        // Шаблон регулярного выражения для определения URL.
        String regex = "\\bhttps?://[-A-Za-z0-9+&@#/%?=~_|!:,.;]*[-A-Za-z0-9+&@#/%=~_|]";

        try {
            // Компиляция шаблона регулярного выражения.
            Pattern pattern = Pattern.compile(regex);
            // Создание объекта Matcher для поиска совпадений шаблона в тексте.
            Matcher matcher = pattern.matcher(text);

            // Проверка, содержит ли текст URL.
            if (!matcher.find()) {
                // Возвращение сообщения, если URL не найдены.
                return "Строка не содержит ссылок.";
            }

            // Сброс объекта Matcher для повторного рассмотрения всего текста.
            matcher.reset();

            // StringBuffer для хранения результирующей строки.
            StringBuffer result = new StringBuffer();
            while (matcher.find()) {
                // Для каждого найденного URL создается строка замены с HTML-гиперссылкой.
                String replacement = "<a href=\"" + matcher.group() + "\">" + matcher.group() + "</a>";
                // Замена URL в тексте на гиперссылку.
                matcher.appendReplacement(result, replacement);
            }
            // Добавление оставшейся части строки к результату.
            matcher.appendTail(result);

            // Возвращение преобразованной строки.
            return result.toString();
        } catch (PatternSyntaxException e) {
            // Блок catch для обработки потенциальных синтаксических ошибок в шаблоне регулярного выражения.
            System.err.println("Ошибка в синтаксисе регулярного выражения: " + e.getMessage());
            // Возвращение null в случае ошибки.
            return null;
        }
    }
}
