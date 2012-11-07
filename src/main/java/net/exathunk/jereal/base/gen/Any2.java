package net.exathunk.jereal.base.gen;

/**
 * charolastra 11/7/12 12:26 AM
 */
public class Any2<First, Second> {
    private static enum Which { FIRST, SECOND };

    private Which which;
    private First first;
    private Second second;

    private Any2() {}

    private void set(Which which, First first, Second second) {
        this.which = which;
        this.first = first;
        this.second = second;
        assert which != null;
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

    public static <X, Y> Any2<X, Y> makeFirst(X first) {
        Any2<X, Y> a = new Any2();
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

    public static <X, Y> Any2<X, Y> makeSecond(Y second) {
        Any2<X, Y> a = new Any2();
        a.setSecond(second);
        return a;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Any2)) return false;

        Any2 any2 = (Any2) o;

        if (first != null ? !first.equals(any2.first) : any2.first != null) return false;
        if (second != null ? !second.equals(any2.second) : any2.second != null) return false;
        if (which != any2.which) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = which.hashCode();
        result = 31 * result + (first != null ? first.hashCode() : 0);
        result = 31 * result + (second != null ? second.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Any2{" +
                "which=" + which +
                ", first=" + first +
                ", second=" + second +
                '}';
    }
}
