package net.exathunk.jereal.base.functional;

import java.util.Iterator;

public class ConsList<T> implements Sequence<T> {
    protected final T _head;
    protected final ConsList<T> _tail;
    protected final boolean isNil;

    public ConsList() {
        this._head = null;
        this._tail = null;
        this.isNil = true;
    }
    protected ConsList(T head, ConsList<T> tail) {
        this._head = head;
        this._tail = tail;
        this.isNil = false;
        assert tail != null;
    }

    public T head() {
        if (isNil) throw new IllegalStateException("NIL HEAD");
        return _head;
    }

    public ConsList<T> tail() {
        if (isNil) throw new IllegalStateException("NIL TAIL");
        return _tail;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConsList)) return false;

        ConsList consList = (ConsList) o;

        if (_head != null ? !_head.equals(consList._head) : consList._head != null) return false;
        if (_tail != null ? !_tail.equals(consList._tail) : consList._tail != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = _head != null ? _head.hashCode() : 0;
        result = 31 * result + (_tail != null ? _tail.hashCode() : 0);
        return result;
    }
}
