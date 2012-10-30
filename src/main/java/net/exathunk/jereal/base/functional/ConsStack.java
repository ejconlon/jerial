package net.exathunk.jereal.base.functional;

import java.util.LinkedList;

/**
 * charolastra 10/28/12 8:02 PM
 */
public class ConsStack<T> implements Stack<T> {

    private ConsList<T> list;

    public ConsStack() {
        list = new ConsList<T>();
    }

    @Override
    public void push(T object) {
        list = list.cons(object);
    }

    @Override
    public T pop() {
        T value = list.head();
        list = list.tail();
        return value;
    }

    @Override
    public T peek() {
        return list.head();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public Sequence<T> seq() {
        return list;
    }

    @Override
    public Sequence<T> revSeq() {
        LinkedList<T> lprime = new LinkedList<T>();
        for (T object : list) {
            lprime.addFirst(object);
        }
        return FuncUtils.seqList(lprime);
    }
}
