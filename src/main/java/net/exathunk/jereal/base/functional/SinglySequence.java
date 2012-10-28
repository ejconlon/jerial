package net.exathunk.jereal.base.functional;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * charolastra 10/28/12 12:53 AM
 */
public class SinglySequence<A> implements Sequence<A> {

    private final A singly;

    public SinglySequence(A singly) {
        this.singly = singly;
    }

    public static class SinglySequenceIterator<A> implements Iterator<A> {

        private final A a;
        private boolean wasCalled;

        public SinglySequenceIterator(A a) {
            this.a = a;
            wasCalled = false;
        }


        @Override
        public boolean hasNext() {
            return !wasCalled;
        }

        @Override
        public A next() {
            if (!wasCalled) {
                wasCalled = true;
                return a;
            } else {
                throw new NoSuchElementException();
            }
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public Iterator<A> iterator() {
        return new SinglySequenceIterator<A>(singly);
    }
}
