import java.util.EmptyStackException;

public class Stack<T> {
    private T[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public Stack(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    // Добавляет элемент на вершину стека
    public void push(T element) {
        if (size == data.length) {
            throw new StackOverflowError("Стек переполнен");
        }
        data[size] = element;
        size++;
    }

    // Удаляет и возвращает верхний элемент стека
    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        size--;
        T element = data[size];
        data[size] = null; // Помогаем сборщику мусора
        return element;
    }

    // Возвращает верхний элемент стека без удаления
    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return data[size - 1];
    }
}
