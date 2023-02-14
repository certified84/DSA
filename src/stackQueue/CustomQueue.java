package stackQueue;

import java.lang.reflect.Array;

public class CustomQueue<T> {

    private static final int DEFAULT_SIZE = 11;
    private int end = 0;
    T[] queue;

    public CustomQueue(Class<T> tClass) {
        this(tClass, DEFAULT_SIZE);
    }

    public CustomQueue(Class<T> tClass, int size) {
        queue = (T[]) Array.newInstance(tClass, size);
    }

    public boolean add(T value) {
        if (isFilled())
            return false;
        queue[end++] = value;
        return true;
    }

    public T remove() {
        if (isEmpty()) {
            System.out.println("You can't remove from an empty queue");
            return null;
        }
        T value = queue[0];
        for (int i = 0; i < end; i++) {
            queue[i] = queue[i + 1];
        }
        end--;
        return value;
    }

    public T peek() {
        return queue[0];
    }

    public boolean isEmpty() {
        return end == 0;
    }

    public boolean isFilled() {
        return end == queue.length - 1;
    }

    public int size() {
        return end;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < end; i++) {
            builder.append(queue[i]).append(" <- ");
        }
        builder.append("END");
        return builder.toString();
    }
}