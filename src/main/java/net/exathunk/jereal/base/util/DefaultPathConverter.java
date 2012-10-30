package net.exathunk.jereal.base.util;

import net.exathunk.jereal.base.functional.ConsList;
import net.exathunk.jereal.base.core.PathPart;

/**
 * charolastra 10/25/12 9:17 AM
 */
public class DefaultPathConverter implements PathConverter {

    private final String delimiter = "/";
    private final String nullToken = "NULL";
    private final String arrayStart = "[";
    private final String arrayEnd = "]";

    private String format(PathPart part) {
        if (part.hasLeft()) {
            final String key = part.getLeft();
            if (key == null) return nullToken;
            else return key;
        } else {
            final Integer index = part.getRight();
            return arrayStart + index + arrayEnd;
        }
    }

    private boolean recurse(ConsList<PathPart> path, StringBuilder sb) {
        if (path == null || path.isEmpty()) return false;
        final boolean addDelim = recurse(path.tail(), sb);
        if (addDelim) sb.append(delimiter);
        sb.append(format(path.head()));
        return true;
    }

    @Override
    public String convertPath(ConsList<PathPart> path) {
        StringBuilder sb = new StringBuilder();
        recurse(path, sb);
        return sb.toString();
    }
}
