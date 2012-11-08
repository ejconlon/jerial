package net.exathunk.jereal.base.gen;

import net.exathunk.jereal.base.functional.Ref;

/**
 * charolastra 11/7/12 12:41 AM
 */
public class Ref3<First, Second, Third> {
    private static enum Which { FIRST, SECOND, THIRD };

    private Which which;
    private First first;
    private Second second;
    private Third third;

    public Ref3() { set(null, null, null, null); }

    private void set(Which which, First first, Second second, Third third) {
        this.which = which;
        this.first = first;
        this.second = second;
        this.third = third;
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
        set(Which.FIRST, first, null, null);
    }

    public static <X, Y, Z> Ref3<X, Y, Z> makeFirst(X first) {
        Ref3<X, Y, Z> a = new Ref3();
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
        set(Which.SECOND, null, second, null);
    }

    public static <X, Y, Z> Ref3<X, Y, Z> makeSecond(Y second) {
        Ref3<X, Y, Z> a = new Ref3();
        a.setSecond(second);
        return a;
    }

    public boolean hasThird() {
        return Which.THIRD.equals(which);
    }

    public Third getThird() {
        return third;
    }

    public void setThird(Third third) {
        set(Which.THIRD, null, null, third);
    }

    public static <X, Y, Z> Ref3<X, Y, Z> makeThird(Z third) {
        Ref3<X, Y, Z> a = new Ref3();
        a.setThird(third);
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

    public Ref<Third> getThirdRef() {
        return new Ref<Third>() {
            @Override
            public void setRef(Third value) {
                setThird(value);
            }

            @Override
            public Third getRef() {
                return getThird();
            }

            @Override
            public boolean isEmptyRef() {
                return !hasThird();
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ref3)) return false;

        Ref3 any3 = (Ref3) o;

        if (which != null ? !which.equals(any3.which) : any3.which != null) return false;
        if (first != null ? !first.equals(any3.first) : any3.first != null) return false;
        if (second != null ? !second.equals(any3.second) : any3.second != null) return false;
        if (third != null ? !third.equals(any3.third) : any3.third != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (which != null ? which.hashCode() : 0);
        result = 31 * result + (first != null ? first.hashCode() : 0);
        result = 31 * result + (second != null ? second.hashCode() : 0);
        result = 31 * result + (third != null ? third.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Any3{" +
                "which=" + which +
                ", first=" + first +
                ", second=" + second +
                ", third=" + third +
                '}';
    }
}