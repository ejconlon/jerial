package net.exathunk.jereal.base.functional;

import java.util.Iterator;
import java.util.Map;

/**
 * charolastra 10/28/12 1:18 AM
 */
public class IndexedSequence<A> implements Sequence<Map.Entry<Integer, A>> {

    private final Sequence<A> as;

    public IndexedSequence(Sequence<A> as) {
        this.as = as;
    }

    @Override
    public Iterator<Map.Entry<Integer, A>> iterator() {
        return new IndexedListSequenceIterator<A>(as.iterator());
    }

    private static class IndexedListSequenceIterator<A> implements Iterator<Map.Entry<Integer, A>> {
        private final Iterator<A> it;
        private int index;

        private IndexedListSequenceIterator(Iterator<A> it) {
            this.it = it;
            index = 0;
        }

        @Override
        public boolean hasNext() {
            return it.hasNext();
        }

        @Override
        public Map.Entry<Integer, A> next() {
            return new Pair<Integer, A>(index++, it.next());
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
