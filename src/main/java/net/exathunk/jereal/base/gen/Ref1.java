package net.exathunk.jereal.base.gen;

import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;

/**
 * charolastra 11/7/12 12:26 AM
 */
public class Ref1<First> {
    private final Ref<First> ref;

    public Ref1() {
        ref = new RefImpl<First>();
    }

    public boolean isEmptyRef() {
        return ref.isEmptyRef();
    }

    public boolean hasFirst() {
        return !ref.isEmptyRef();
    }

    public First getFirst() {
        return ref.getRef();
    }

    public void setFirst(First first) {
        ref.setRef(first);
    }

    public static <X> Ref1<X> makeFirst(X first) {
        Ref1<X> a = new Ref1();
        a.setFirst(first);
        return a;
    }

    public Ref<First> getFirstRef() {
        return ref;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ref1)) return false;

        Ref1 ref1 = (Ref1) o;

        if (!ref.equals(ref1.ref)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + ref.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Ref1{" +
                "ref=" + ref +
                '}';
    }
}
