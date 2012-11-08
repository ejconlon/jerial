package net.exathunk.jereal.base.gen;

import net.exathunk.jereal.base.functional.Ref;

/**
 * charolastra 11/7/12 12:26 AM
 */
public class Ref1<First> {
    private static enum Which { FIRST };

    private Which which;
    private First first;

    public Ref1() { set(null, null); }

    private void set(Which which, First first) {
        this.which = which;
        this.first = first;
    }

    public boolean isEmptyRef() {
        return null == which;
    }

    public boolean hasFirst() {
        return Which.FIRST.equals(which);
    }

    public First getFirst() {
        return first;
    }

    public void setFirst(First first) {
        set(Which.FIRST, first);
    }

    public static <X> Ref1<X> makeFirst(X first) {
        Ref1<X> a = new Ref1();
        a.setFirst(first);
        return a;
    }

    public Ref<First> getFirstRef() {
        return new Ref<First>() {
            @Override
            public void setRef(First value) {
                setFirst(value);
            }

            @Override
            public First getRef() {
                return getFirst();
            }

            @Override
            public boolean isEmptyRef() {
                return !hasFirst();
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ref1)) return false;

        Ref1 ref1 = (Ref1) o;

        if (which != null ? !which.equals(ref1.which) : ref1.which != null) return false;
        if (first != null ? !first.equals(ref1.first) : ref1.first != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (which != null ? which.hashCode() : 0);
        result = 31 * result + (first != null ? first.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Ref1{" +
                "which=" + which +
                ", first=" + first +
                '}';
    }
}
