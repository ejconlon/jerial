package net.exathunk.jereal.base.gen;

/**
 * charolastra 11/7/12 12:41 AM
 */
public class Any3<First, Second, Third> {
    private static enum Which { FIRST, SECOND, THIRD };

    private Which which;
    private First first;
    private Second second;
    private Third third;

    private Any3() {}

    private void set(Which which, First first, Second second, Third third) {
        this.which = which;
        this.first = first;
        this.second = second;
        this.third = third;
        assert which != null;

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

    public static <X, Y, Z> Any3<X, Y, Z> makeFirst(X first) {
        Any3<X, Y, Z> a = new Any3();
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

    public static <X, Y, Z> Any3<X, Y, Z> makeSecond(Y second) {
        Any3<X, Y, Z> a = new Any3();
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

    public static <X, Y, Z> Any3<X, Y, Z> makeThird(Z third) {
        Any3<X, Y, Z> a = new Any3();
        a.setThird(third);
        return a;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Any3)) return false;

        Any3 any3 = (Any3) o;

        if (first != null ? !first.equals(any3.first) : any3.first != null) return false;
        if (second != null ? !second.equals(any3.second) : any3.second != null) return false;
        if (third != null ? !third.equals(any3.third) : any3.third != null) return false;
        if (which != any3.which) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = which.hashCode();
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