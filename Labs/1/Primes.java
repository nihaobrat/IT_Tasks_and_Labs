/* Задание 1 
Создайте программу, которая находит и выводит все
простые числа меньше 100. */

// Просто́е число́ — натуральное число, имеющее ровно два различных натуральных делителя

// 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97 
// все простые числа до 100

public class Primes {
    public static void main(String[] args) {
        for (int a = 2; a < 100; a++) {
            if (isPrime(a)) {
                System.out.print(a + " ");
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int b = 2; b * b <= n; b++) {
            if (n % b == 0) {
                return false;
            }
        }
        return true;
    }
}
