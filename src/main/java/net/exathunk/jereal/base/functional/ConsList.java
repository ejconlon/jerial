package net.exathunk.jereal.base.functional;

import java.util.Iterator;

public class ConsList<T> implements Sequence<T> {
    private final T _head;
    private final ConsList<T> _tail;

    private ConsList() {
        this._head = null;
        this._tail = this;
    }
    private ConsList(T head, ConsList<T> tail) {
        this._head = head;
        this._tail = tail;
        assert tail != null;
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

    public ConsList<T> cons(T newHead) {
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
        return _head == null;
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
