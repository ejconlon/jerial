package net.exathunk.jereal.base.functional;

import java.util.Iterator;
import java.util.List;

/**
 * charolastra 10/28/12 12:52 AM
 */
public class ListSequence<A> implements Sequence<A> {

    private final List<A> list;

    public ListSequence(List<A> list) {
        this.list = list;
    }

    @Override
    public Iterator<A> iterator() {
        return list.iterator();
    }
}
