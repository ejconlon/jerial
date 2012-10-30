package net.exathunk.jereal.base.core;

import net.exathunk.jereal.base.functional.ConsList;
import net.exathunk.jereal.base.util.DefaultPathConverter;
import net.exathunk.jereal.base.util.PathConverter;

/**
 * charolastra 10/29/12 10:16 PM
 */
public class Path extends ConsList<PathPart> implements Comparable<Path> {
    private static final PathConverter CONVERTER = new DefaultPathConverter();

    public Path() { super(); }
    public Path(PathPart part) { super(part); }

    public static Path root() {
        return new Path();
    }

    @Override
    public Path cons(PathPart newHead) {
        return new Path(newHead);
    }

    public Path consKey(String key) {
        return cons(PathPart.key(key));
    }

    public Path consIndex(Integer index) {
        return cons(PathPart.index(index));
    }

    public String convert() {
        return CONVERTER.convertPath(this);
    }

    @Override
    public int compareTo(Path other) {
        return convert().compareTo(other.convert());
    }

    @Override
    public String toString() {
        return "Path{convert="+convert()+"}";
    }
}
