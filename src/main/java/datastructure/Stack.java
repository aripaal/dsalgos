package datastructure;

import java.lang.reflect.*;

public class Stack {
    int cap = 12;
    Integer[] array = new Integer[cap];

    int top = -1;

    public void push(Integer value) {
        if (top == cap) {
            return;
        } else {
            array[++top] = value;
        }
    }

    public Integer pop() {
        if (top == -1)
            return null;
        return array[top--];
    }

    public int size() {
        return top + 1;
    }

}
