package interviewproblems;

import java.lang.reflect.Array;

/**
 * Created by aignat on 21-Jun-16.
 */
public class StacksAndQueues<T> {

    public T[] array;

    int[] startStack;
    int[] endStack;
    int[] currentIndex;

    public StacksAndQueues(Class<T> clazz) {
        this(clazz, 9);
    }

    public StacksAndQueues(Class<T> clazz, int size) {
        array = (T[]) Array.newInstance(clazz, size);
        startStack = new int[3];
        endStack = new int[3];
        currentIndex = new int[3];

        for (int i = 0; i<3; i++) {
            startStack[i] = currentIndex[i] = size >= i ? i * size / 3 : -1;
            endStack[i] = (i + 1) * size / 3;
        }
    }

    public void push1(T elem) {
        push(0, elem);
    }

    public void push2(T elem) {
        push(1, elem);
    }

    public void push3(T elem) {
        push(2, elem);
    }

    private void push(int stackIndex, T elem) {
        if (currentIndex[stackIndex] != -1 && currentIndex[stackIndex] < endStack[stackIndex]) {
            array[currentIndex[stackIndex]++] = elem;
        }
    }

    public T pop1() {
        return pop(0);
    }

    public T pop2() {
        return pop(1);
    }

    public T pop3() {
        return pop(2);
    }

    private T pop(int stackIndex) {
        if (currentIndex[stackIndex] > startStack[stackIndex]) {
            T value = array[--currentIndex[stackIndex]];
            array[currentIndex[stackIndex]] = null;
            return value;
        }
        return null;
    }

    @Override
    public String toString() {

        String result = "";

        for (T elem : array) {
            result += elem + " ";
        }

        return result;
    }


}
