package net.exathunk.jereal.base.functional;

import java.util.Iterator;

/**
 * charolastra 10/28/12 12:15 AM
 */
public class FmapSequence<A, Z> implements Sequence<Z> {

    private final Sequence<A> as;
    private final ResFunc1<A, Z> f;

    public FmapSequence(ResFunc1<A, Z> f, Sequence<A> as) {
        this.as = as;
        this.f = f;
    }

    public static class FmapSequenceIterator<A, Z> implements Iterator<Z> {
        private final Iterator<A> it;
        private final ResFunc1<A, Z> f;

        public FmapSequenceIterator(ResFunc1<A, Z> f, Iterator<A> it) {
            this.it = it;
            this.f = f;
        }

        @Override
        public boolean hasNext() {
            return it.hasNext();
        }

        @Override
        public Z next() {
            final A a = it.next();
            return f.runResFunc(a);
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public Iterator<Z> iterator() {
        return new FmapSequenceIterator(f, as.iterator());
    }
}
