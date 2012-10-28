package net.exathunk.jereal.base.functional;

import java.util.Iterator;

/**
 * charolastra 10/28/12 1:38 AM
 */
public class Maybe<A> implements Sequence<A> {

    private final A value;
    private final boolean just;

    private Maybe(A value) {
        this.value = value;
        this.just = true;
    }

    private Maybe() {
        this.value = null;
        this.just = false;
    }

    public static <A> Maybe<A> just(A value) {
        return new Maybe<A>(value);
    }

    public static <A> Maybe<A> nonNull(A value) {
        if (value != null) {
            return new Maybe<A>(value);
        } else {
            return new Maybe<A>();
        }
    }

    public static <A> Maybe<A> nothing() {
        return new Maybe<A>();
    }

    public <Z> Maybe<Z> fmap(ResFunc1<A, Z> f) {
        if (just) {
            return Maybe.just(f.runResFunc(value));
        } else {
            return Maybe.nothing();
        }
    }

    public <Z> Maybe<Z> bind(ResFunc1<A, Maybe<Z>> f) {
        if (just) {
            return f.runResFunc(value);
        } else {
            return Maybe.nothing();
        }
    }

    @Override
    public Iterator<A> iterator() {
        if (just) return new SinglySequence.SinglySequenceIterator<A>(value);
        else return new EmptySequence.EmptyIterator<A>();
    }

    public A unJust() {
        return value;
    }

    public boolean isJust() {
        return just;
    }

    public boolean isNothing() {
        return !just;
    }
}
