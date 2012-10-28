package net.exathunk.jereal.base.functional;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * charolastra 10/28/12 12:24 AM
 */
public class FilterSequence<A> implements Sequence<A> {
    private final Sequence<A> as;
    private final ResFunc1<A, Boolean> p;

    public FilterSequence(ResFunc1<A, Boolean> p, Sequence<A> as) {
        this.as = as;
        this.p = p;
    }

    public static class FilterSequenceIterator<A> implements Iterator<A> {
        private final Iterator<A> it;
        private final ResFunc1<A, Boolean> p;
        private A val;
        private boolean hasAdvanced;

        public FilterSequenceIterator(ResFunc1<A, Boolean> p, Iterator<A> it) {
            this.it = it;
            this.p = p;
            hasAdvanced = false;
        }

        private void advance() {
            if (!hasAdvanced && val == null) {
                while (it.hasNext()) {
                    A temp = it.next();
                    if (p.runResFunc(temp)) {
                        val = temp;
                        break;
                    }
                }
                hasAdvanced = true;
            }
        }

        @Override
        public boolean hasNext() {
            advance();
            return val != null;
        }

        @Override
        public A next() {
            advance();
            if (val == null) {
                throw new NoSuchElementException();
            } else {
                A temp = val;
                val = null;
                return temp;
            }
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public Iterator<A> iterator() {
        return new FilterSequenceIterator<A>(p, as.iterator());
    }
}
