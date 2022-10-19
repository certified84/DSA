import exceptions.StackException;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CustomStack<T> {

    private static final int DEFAULT_SIZE = 10;
    protected T[] stack;
    protected int position = -1;

    public CustomStack(Class<T> tClass) {
        this(tClass, DEFAULT_SIZE);
    }

    public CustomStack(Class<T> tClass, int size) {
        stack = (T[]) Array.newInstance(tClass, size);
    }

    public boolean push(T value) throws StackException {
        if (isFilled())
            throw new StackException("Stack is full");
        stack[++position] = value;
        return true;
    }

    public T pop() throws StackException {
        if (isEmpty())
            throw new StackException("Stack is empty");
        T value = stack[position];
        stack[position--] = null;
        return value;
    }

    public T peak() throws StackException {
        if (isEmpty())
            throw new StackException("Stack is empty");
        return stack[position];
    }

    public boolean isEmpty() {
        return position == -1;
    }

    public boolean isFilled() {
        return position == stack.length - 1;
    }

    public int size() {
        return stack.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(stack);
    }
}
