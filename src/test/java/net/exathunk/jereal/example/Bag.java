package net.exathunk.jereal.example;

import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;

public class Bag {
    public final Ref<String> s = new RefImpl<String>();
    public final Ref<Long> l = new RefImpl<Long>();
    public final Ref<Double> d = new RefImpl<Double>();
    public final Ref<Boolean> b = new RefImpl<Boolean>();
    public final Ref<Bag> next = new RefImpl<Bag>();

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
}
