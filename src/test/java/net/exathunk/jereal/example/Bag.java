package net.exathunk.jereal.example;

public class Bag {
    public final String s;
    public final Long l;
    public final Double d;
    public final Boolean b;
    public final Bag next;

    public Bag(String s, Long l, Double d, Boolean b) {
        this(s, l, d, b, null);
    }

    public Bag(String s, Long l, Double d, Boolean b, Bag next) {
        this.s = s;
        this.l = l;
        this.d = d;
        this.b = b;
        this.next = next;
    }
}
