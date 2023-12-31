public class ArrayAverage {

    public static void main(String[] args) {
        // создаем массив Object т.к который может содержать элементы любого типа
        // в массиве есть и целые числа и строки и null.
        Object[] array = {4, -1, 6, "abc", null, true};

        try {
            System.out.println("Среднее: " + calculateAverage(array));
            System.out.println(array[array.length + 1]); // Произошла ошибка: Индекс 6 вышел за пределы длины 6.

        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }

    static double calculateAverage(Object[] array) throws Exception {
        if (array == null || array.length == 0) {
            throw new Exception("Массив пуст или = 0");
        }

        double sum = 0;
        int validNumberCount = 0;

        for (Object obj : array) {
            try {
                if (obj != null) {
                    // если obj является Number то есть ( Int, Double, Float, Long и так далее )
                    if (obj instanceof Number) {
                        sum += ((Number) obj).doubleValue();
                        validNumberCount++;
                    } else {
                        sum += Double.parseDouble(obj.toString());
                        validNumberCount++;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Пропуск нечисленных значений:" + obj);
            }
        }

        if (validNumberCount == 0) {
            throw new Exception("В массиве не найдено допустимых чисел");
        }

        return sum / validNumberCount;
    }
}