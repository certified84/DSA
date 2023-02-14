package stackQueue;

import exceptions.StackException;

import java.lang.reflect.Array;

public class DynamicCustomStack<T> extends CustomStack<T> {

    private Class<T> tClass;

    public DynamicCustomStack(Class<T> tClass) {
        super(tClass);
        this.tClass = tClass;
    }

    public DynamicCustomStack(Class<T> tClass, int size) {
        super(tClass, size);
        this.tClass = tClass;
    }

    @Override
    public boolean push(T value) throws StackException {
        if (isFilled()) {
            T[] temp = (T[]) Array.newInstance(tClass, stack.length * 2);
            for (int i = 0; i < stack.length; i++) {
                temp[i] = stack[i];
            }
            stack = temp;
        }
        return super.push(value);
    }
}
