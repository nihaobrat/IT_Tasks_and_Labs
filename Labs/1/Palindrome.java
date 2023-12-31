/* Задание 2 
Создайте программу, которая определяет, является
ли введенная строка палиндромом. */


// Палиндром — это число, слово или текст, одинаково читающееся в обоих направлениях.
// Например, слова "радар", "топот" или число "12321" будут палиндромами

public class Palindrome {
    public static void main(String[] args) {
        for (int a = 0; a < args.length; a++) {
            String s = args[a];
            boolean isPal = isPalindrome(s);
            System.out.println(s + " это Палиндром: " + isPal);
        }
    }

    public static String reverseString(String s) {
        String reversed = "";
        for (int a = s.length() - 1; a >= 0; a--) {
            reversed += s.charAt(a);
        }
        return reversed;
    }

    public static boolean isPalindrome(String s) {
        String reversed = reverseString(s);
        return s.equals(reversed);
    }
}