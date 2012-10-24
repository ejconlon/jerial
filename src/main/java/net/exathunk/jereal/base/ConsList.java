package net.exathunk.jereal.base;

import java.util.Iterator;

public class ConsList<T> {
    private T _head;
    private ConsList<T> _tail;

    private ConsList() {}
    private ConsList(T head) { this._head = head; }
    private ConsList(T head, ConsList<T> tail) {
        this._head = head;
        this._tail = tail;
    }

    public T head() {
        return _head;
    }

    public ConsList<T> tail() {
        return _tail;
    }

    public static <X> ConsList<X> nil() {
        return new ConsList<X>();
    }

    public static <X> ConsList<X> singleton(X head) {
        assert head != null;
        return new ConsList<X>(head);
    }

    public ConsList<T> cons(T newHead) {
        assert newHead != null;
        return new ConsList<T>(newHead, this);
    }

    public int size() {
        if (_head != null) {
            if (_tail != null) {
                return 1 + _tail.size();
            } else {
                return 1;
            }
        } else {
            return 0;
        }
    }

    public boolean isEmpty() {
        return _head != null;
    }

    public Iterator<T> iterator() {
        final ConsList<T> thiz = this;
        return new Iterator<T>() {
            private ConsList<T> ref = thiz;

            @Override
            public boolean hasNext() {
                return ref != null && ref._head != null;
            }

            @Override
            public T next() {
                T href = ref._head;
                ref = ref._tail;
                return href;
            }

            @Override
            public void remove() {
               throw new UnsupportedOperationException();
            }
        };
    }

}
