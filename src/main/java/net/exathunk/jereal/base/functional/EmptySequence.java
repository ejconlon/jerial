package net.exathunk.jereal.base.functional;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * charolastra 10/28/12 1:38 AM
 */
public class EmptySequence<A> implements Sequence<A> {

    public static class EmptyIterator<A> implements Iterator<A> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public A next() {
            throw new NoSuchElementException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public Iterator<A> iterator() {
        return new EmptyIterator<A>();
    }
}
