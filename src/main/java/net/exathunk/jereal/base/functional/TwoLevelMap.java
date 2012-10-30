package net.exathunk.jereal.base.functional;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * charolastra 10/29/12 1:02 PM
 */
public class TwoLevelMap<A, B, C> implements Sequence<Triple<A, B, C>> {

    private final Map<A, Map<B, C>> mapA;
    private final Map<B, Map<A, C>> mapB;

    public TwoLevelMap() {
        mapA = new HashMap<A, Map<B, C>>();
        mapB = new HashMap<B, Map<A, C>>();
    }

    private void putA(A a, B b, C c) {
        Map<B, C> sub = mapA.get(a);
        if (sub == null) {
            sub = new HashMap<B, C>();
            mapA.put(a, sub);
        }
        sub.put(b, c);
    }

    private void putB(A a, B b, C c) {
        Map<A, C> sub = mapB.get(b);
        if (sub == null) {
            sub = new HashMap<A, C>();
            mapB.put(b, sub);
        }
        sub.put(a, c);
    }

    public void put(A a, B b, C c) {
        putA(a, b, c);
        putB(a, b, c);
    }

    public C get(A a, B b) {
        Map<B, C> sub = mapA.get(a);
        if (sub != null) return sub.get(b);
        else return null;
    }

    public boolean containsA(A a) {
        return mapA.containsKey(a);
    }

    public boolean containsB(B b) {
        return mapB.containsKey(b);
    }

    public boolean containsBoth(A a, B b) {
        return containsA(a) && containsB(b);
    }

    public Map<A, Map<B, C>> getMapA() {
        return mapA;
    }

    public Map<B, Map<A, C>> getMapB() {
        return mapB;
    }

    public boolean remove(A a, B b) {
        return removeA(a, b) && removeB(a, b);
    }

    private boolean removeA(A a, B b) {
        Map<B, C> sub = mapA.get(a);
        if (sub != null) {
            boolean ret = sub.remove(b) != null;
            if (sub.isEmpty()) {
                mapA.remove(a);
            }
            return ret;
        } else {
            return false;
        }
    }

    private boolean removeB(A a, B b) {
        Map<A, C> sub = mapB.get(b);
        if (sub != null) {
            boolean ret = sub.remove(a) != null;
            if (sub.isEmpty()) {
                mapB.remove(b);
            }
            return ret;
        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        return mapA.isEmpty();
    }

    private static class TripleIterator<X, Y, Z> implements Iterator<Triple<X, Y, Z>> {

        private final Iterator<Map.Entry<X, Map<Y, Z>>> it;
        private X subKey;
        private Iterator<Map.Entry<Y, Z>> subIt;

        public TripleIterator(Iterator<Map.Entry<X, Map<Y, Z>>> it) {
            this.it = it;
        }

        void advance() {
            while ((subIt == null || !subIt.hasNext()) && it.hasNext()) {
                Map.Entry<X, Map<Y, Z>> entry = it.next();
                subKey = entry.getKey();
                subIt = entry.getValue().entrySet().iterator();
            }
        }

        @Override
        public boolean hasNext() {
            advance();
            return subIt != null && subIt.hasNext();
        }

        @Override
        public Triple<X, Y, Z> next() {
            advance();
            Map.Entry<Y, Z> entry = subIt.next();
            return new Triple<X, Y, Z>(subKey, entry.getKey(), entry.getValue());
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /*public void subsume(Iterable<Triple<A, B, C>> other) {
        for (Triple<A, B, C> triple : other) {
            put(triple.first, triple.second, triple.third);
        }
    }*/

    @Override
    public Iterator<Triple<A, B, C>> iterator() {
        return new TripleIterator<A, B, C>(mapA.entrySet().iterator());
    }
}
