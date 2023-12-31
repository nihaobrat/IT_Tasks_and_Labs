import java.util.regex.*; // Импорт пакета для работы с регулярными выражениями.

public class IPAddressValidator {

    public static void main(String[] args) {
        // Основной метод, который выполняется при запуске программы.
        String ipAddress = "192.168.1.1";  // Объявление и инициализация строки с IP-адресом для валидации.
        System.out.println(isValidIPAddress(ipAddress)); // Вызов метода валидации IP-адреса и вывод результата.
    }

    public static boolean isValidIPAddress(String ipAddress) {
        // Метод для валидации IP-адреса.
        if (ipAddress.isEmpty()) {
            // Проверка, пустая ли строка.
            System.out.println("Строка пуста."); // Вывод сообщения, если строка пуста.
            return false; // Возврат false, так как пустая строка не может быть валидным IP-адресом.
        }

        // Регулярное выражение для проверки IP-адреса.
        String regex = "^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$";

        try {
            // Блок try для обработки исключений.
            Pattern pattern = Pattern.compile(regex); // Компиляция регулярного выражения в шаблон.
            Matcher matcher = pattern.matcher(ipAddress); // Создание объекта Matcher для сопоставления с IP-адресом.

            // Проверка, соответствует ли IP-адрес регулярному выражению.
            if (!matcher.matches()) {
                // Если IP-адрес не соответствует регулярному выражению.
                System.out.println("Неверный формат IP-адреса."); // Вывод сообщения о неверном формате.
                return false; // Возврат false, так как IP-адрес неверен.
            }
            return true; // Возврат true, если IP-адрес валиден.
        } catch (PatternSyntaxException e) {
            // Блок catch для обработки ошибок синтаксиса регулярного выражения.
            System.err.println("Ошибка в синтаксисе регулярного выражения: " + e.getMessage()); // Вывод сообщения об ошибке.
            return false; // Возврат false в случае ошибки синтаксиса регулярного выражения.
        }
    }
}
