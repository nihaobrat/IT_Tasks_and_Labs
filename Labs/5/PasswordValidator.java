import java.util.regex.*; // Импортируем пакет java.util.regex для работы с регулярными выражениями.

public class PasswordValidator {

    public static void main(String[] args) {
        // Основной метод программы.
        String password = "Pod13242323"; // Объявляем и инициализируем строку с паролем для валидации.
        System.out.println(isValidPassword(password)); // Выводим результат работы метода isValidPassword.
    }

    public static boolean isValidPassword(String password) {
        // Метод для валидации пароля.
        if (password.isEmpty()) {
            // Проверяем, не является ли строка пароля пустой.
            System.out.println("Вы не ввели пароль."); // Выводим сообщение, если строка пуста.
            return false; // Возвращаем false, так как пароль не был введен.
        }
        // Проверяем длину пароля.
        if (password.length() < 8 || password.length() > 16) {
            // Проверяем, что длина пароля находится в пределах от 8 до 16 символов.
            System.out.println("Пароль должен быть от 8 до 16 символов."); // Сообщаем об ошибке, если длина пароля не подходит.
            return false; // Возвращаем false, если длина пароля не соответствует требованиям.
        }

        // Регулярное выражение для проверки пароля.
        String regex = "^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,16}$";

        Pattern pattern = Pattern.compile(regex); // Компилируем регулярное выражение в Pattern.
        Matcher matcher = pattern.matcher(password); // Создаем объект Matcher для проверки пароля.

        // Проверяем, соответствует ли пароль регулярному выражению.
        if (!matcher.matches()) {
            // Если пароль не соответствует шаблону.
            System.out.println("Пароль должен содержать хотя бы одну заглавную букву и одну цифру."); // Выводим сообщение о неверном формате.
            return false; // Возвращаем false, так как пароль не соответствует требованиям.
        }

        return true; // Возвращаем true, если пароль прошел все проверки.
    }
}
