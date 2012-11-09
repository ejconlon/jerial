package net.exathunk.jereal.base.gen;

import net.exathunk.jereal.base.functional.Ref;

/**
 * charolastra 11/7/12 12:26 AM
 */
public class Ref2<First, Second> {
    private static enum Which { FIRST, SECOND };

    private Which which;
    private First first;
    private Second second;

    public Ref2() { set(null, null, null); }

    private void set(Which which, First first, Second second) {
        this.which = which;
        this.first = first;
        this.second = second;
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
        set(Which.FIRST, first, null);
    }

    public static <X, Y> Ref2<X, Y> makeFirst(X first) {
        Ref2<X, Y> a = new Ref2();
        a.setFirst(first);
        return a;
    }

    public boolean hasSecond() {
        return Which.SECOND.equals(which);
    }

    public Second getSecond() {
        return second;
    }

    public void setSecond(Second second) {
        set(Which.SECOND, null, second);
    }

    public static <X, Y> Ref2<X, Y> makeSecond(Y second) {
        Ref2<X, Y> a = new Ref2();
        a.setSecond(second);
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

    public Ref<Second> getSecondRef() {
        return new Ref<Second>() {
            @Override
            public void setRef(Second value) {
                setSecond(value);
            }

            @Override
            public Second getRef() {
                return getSecond();
            }

            @Override
            public boolean isEmptyRef() {
                return !hasSecond();
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ref2)) return false;

        Ref2 ref2 = (Ref2) o;

        if (which != null ? !which.equals(ref2.which) : ref2.which != null) return false;
        if (first != null ? !first.equals(ref2.first) : ref2.first != null) return false;
        if (second != null ? !second.equals(ref2.second) : ref2.second != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (which != null ? which.hashCode() : 0);
        result = 31 * result + (first != null ? first.hashCode() : 0);
        result = 31 * result + (second != null ? second.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Ref2{" +
                (which != null ? ("which=" + which) : "") +
                (first != null ? (", first=" + first) : "") +
                (second != null ? (", second=" + second) : "") +
                '}';
    }
}
