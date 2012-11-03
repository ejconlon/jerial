package net.exathunk.jereal.base.gen;

/**
 * charolastra 11/3/12 2:17 PM
 */
public class Stringer {
    private final StringBuilder sb;
    private final int indents;

    public Stringer() {
        this(new StringBuilder(), 0);
    }

    private Stringer(StringBuilder sb, int indents) {
        this.sb = sb;
        this.indents = indents;
    }

    public Stringer indent() {
        return new Stringer(sb, indents+1);
    }

    public StringBuilder append(String s) {
        for (int i = 0; i < indents; ++i) {
            sb.append("    ");
        }
        sb.append(s);
        return sb;
    }

    public StringBuilder cont() {
        return sb;
    }

    public String toString() {
        return sb.toString();
    }
}