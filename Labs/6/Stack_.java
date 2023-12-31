import java.util.EmptyStackException;

public class Stack_ {

    public static void main(String[] args) {
        // создаем объект стека с начальной вместимостью 10
        Stack<Integer> stack = new Stack<>(10);
        stack.push(1); // добавляем элементы в стек
        stack.push(2);
        stack.push(3);
        // выводим самый верхний элемента стека и удаляем его получается 3,
        // он удаляется и дальше становится 2
        System.out.println(stack.pop()); // 3
        // выводим самый верхний элемент стека без его удаления
        System.out.println(stack.peek()); // 2
        stack.push(4);
        System.out.println(stack.pop());  // 4
    }

    public static class Stack<T> {
        private T[] data;  // массив для хранения элементов стека
        private int size;  // размер стека

        @SuppressWarnings("unchecked")
        public Stack(int capacity) {
            data = (T[]) new Object[capacity];
            size = 0;  // начальный размер стека -> 0
        }

        public void push(T element) {
            if (size == data.length) {
                throw new StackOverflowError("Стек заполнен");
            }
            data[size++] = element;
        }

        public T pop() {
            if (size == 0) {
                throw new EmptyStackException();
            }
            T element = data[--size];
            data[size] = null; 
            return element; 
        }

        public T peek() {
            if (size == 0) {
                throw new EmptyStackException();
            }
            return data[size - 1];
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }
}
