package net.exathunk.jereal.base.functional;

import java.util.Iterator;

/**
 * charolastra 10/28/12 4:18 AM
 */
public class ConcatIterator<A> implements Iterator<A> {

    private final Iterator<A> first;
    private final Iterator<A> second;

    public ConcatIterator(Iterator<A> first, Iterator<A> second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean hasNext() {
        return first.hasNext() || second.hasNext();
    }

    @Override
    public A next() {
        if (first.hasNext()) return first.next();
        else return second.next();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
