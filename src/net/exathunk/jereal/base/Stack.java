package net.exathunk.jereal.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Stack<T> {
    private final List<T> stack;

    public Stack() { stack = new ArrayList<T>(); }
    public Stack(List<T> stack) { this.stack = stack; }

    public void push(T object) {
        stack.add(object);
    }

    public T pop() {
        int s = stack.size() - 1;
        T x = stack.get(s);
        stack.remove(s);
        return x;
    }

    public T peek() {
        return stack.get(stack.size() - 1);
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int i = stack.size() - 1;

            @Override
            public boolean hasNext() {
                return i >= 0;
            }

            @Override
            public T next() {
                i -= 1;
                return stack.get(i + 1);
            }

            @Override
            public void remove() {
                i -= 1;
                stack.remove(i + 1);
            }
        };
    }

    public List<T> asList() {
        return stack;
    }
}
