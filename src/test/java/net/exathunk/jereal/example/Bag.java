package net.exathunk.jereal.example;

import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;

public class Bag {
    public final Ref<String> s = new RefImpl<String>();
    public final Ref<Long> l = new RefImpl<Long>();
    public final Ref<Double> d = new RefImpl<Double>();
    public final Ref<Boolean> b = new RefImpl<Boolean>();
    public final Ref<Bag> next = new RefImpl<Bag>();

    // constuctor for deserialization
    public Bag() {}

    // nulls are explicitly set in refs to test nulls in json output
    public Bag(String s, Long l, Double d, Boolean b) {
        this(s, l, d, b, null);
    }

    public Bag(String s, Long l, Double d, Boolean b, Bag next) {
        this.s.setRef(s);
        this.l.setRef(l);
        this.d.setRef(d);
        this.b.setRef(b);
        if (next != null) this.next.setRef(next);
    }

    // to test deserialization correctness
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bag bag = (Bag) o;

        if (b != null ? !b.equals(bag.b) : bag.b != null) return false;
        if (d != null ? !d.equals(bag.d) : bag.d != null) return false;
        if (l != null ? !l.equals(bag.l) : bag.l != null) return false;
        if (next != null ? !next.equals(bag.next) : bag.next != null) return false;
        if (s != null ? !s.equals(bag.s) : bag.s != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = s != null ? s.hashCode() : 0;
        result = 31 * result + (l != null ? l.hashCode() : 0);
        result = 31 * result + (d != null ? d.hashCode() : 0);
        result = 31 * result + (b != null ? b.hashCode() : 0);
        result = 31 * result + (next != null ? next.hashCode() : 0);
        return result;
    }
}
