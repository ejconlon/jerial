package net.exathunk.jereal.base.functional;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * charolastra 10/28/12 12:06 AM
 */
public class FuncUtils {
    public static <A, Z> Sequence<Z> fmap(ResFunc1<A, Z> f, Sequence<A> as) {
        return new FmapSequence<A, Z>(f, as);
    }

    public static <A> Sequence<A> filter(ResFunc1<A, Boolean> p, Sequence<A> as) {
        return new FilterSequence<A>(p, as);
    }

    public static <A, B, Z> Z applyEntry(ResFunc2<A, B, Z> f, Map.Entry<A, B> entry) {
        return f.runResFunc(entry.getKey(), entry.getValue());
    }

    public static <A, B, Z> Z applyEither(ResFunc1<A, Z> f, ResFunc1<B, Z> g, Either<A, B> either) {
        if (either.hasLeft()) return f.runResFunc(either.getLeft());
        else return g.runResFunc(either.getRight());
    }

    public static <A, B, C, Z> Z applyEither3(ResFunc1<A, Z> f, ResFunc1<B, Z> g, ResFunc1<C, Z> h, Either3<A, B, C> either3) {
        if (either3.hasLeft()) return f.runResFunc(either3.getLeft());
        if (either3.hasMiddle()) return g.runResFunc(either3.getMiddle());
        else return h.runResFunc(either3.getRight());
    }

    public static <A, B, Z> ResFunc1<Map.Entry<A, B>, Z> groupEntry(final ResFunc2<A, B, Z> f) {
        return new ResFunc1<Map.Entry<A, B>, Z>() {
            @Override
            public Z runResFunc(Map.Entry<A, B> entry) {
                return f.runResFunc(entry.getKey(), entry.getValue());
            }
        };
    }

    public static <A, B> Sequence<Map.Entry<A, B>> seqMap(Map<A, B> map) {
        return new MapSequence<A, B>(map);
    }

    public static <A, B> Sequence<A> seqKeys(Map<A, B> map) {
        return new KeySequence<A, B>(map);
    }

    public static <A, B> Sequence<B> seqValues(Map<A, B> map) {
        return new ValueSequence<A, B>(map);
    }

    public static <A> Sequence<A> seqList(List<A> list) {
        return new ListSequence<A>(list);
    }

    public static <A> Sequence<A> seqSingly(A singly) {
        return new SinglySequence<A>(singly);
    }

    public static <A, B, Z> Sequence<Z> fmapMap(ResFunc2<A, B, Z> f, Map<A, B> map) {
        return new FmapSequence<Map.Entry<A, B>, Z>(groupEntry(f), seqMap(map));
    }

    public static <A, Z> Sequence<Z> fmapList(ResFunc1<A, Z> f, List<A> list) {
        return new FmapSequence<A, Z>(f, seqList(list));
    }

    public static <A, B, Z> Sequence<Z> fmapSingly(ResFunc1<A, Z> f, A singly) {
        return new FmapSequence<A, Z>(f, seqSingly(singly));
    }

    public static <A, B> Sequence<Map.Entry<A, B>> filterMap(ResFunc2<A, B, Boolean> p, Map<A, B> map) {
        return new FilterSequence<Map.Entry<A, B>>(groupEntry(p), seqMap(map));
    }

    public static <A> Sequence<A> filterList(ResFunc1<A, Boolean> p, List<A> list) {
        return new FilterSequence<A>(p, seqList(list));
    }

    public static <A> Sequence<A> filterSingly(ResFunc1<A, Boolean> p, A singly) {
        return new FilterSequence<A>(p, seqSingly(singly));
    }

    public static <A> Iterator<A> concat(Iterator<A> first, Iterator<A> second) {
        return new ConcatIterator<A>(first, second);
    }
}
