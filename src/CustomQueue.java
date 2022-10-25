import java.lang.reflect.Array;
import java.util.Arrays;

public class CustomQueue<T> {

    private static final int DEFAULT_SIZE = 11;
    private int end = 0;
    private final int start = 0;
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
        T value = queue[start];
        for (int i = 0; i < end; i++) {
            queue[i] = queue[i + 1];
        }
        end--;
        return value;
    }

    public T peek() {
        return queue[start];
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
        return Arrays.toString(queue);
    }
}