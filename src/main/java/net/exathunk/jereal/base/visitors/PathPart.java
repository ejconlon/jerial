package net.exathunk.jereal.base.visitors;

import net.exathunk.jereal.base.functional.Either;

/**
 * charolastra 10/25/12 9:34 AM
 */
public class PathPart extends Either<String, Integer> implements Comparable<PathPart> {
    private PathPart(String s, Integer integer) {
        super(s, integer);
    }

    public static PathPart key(String left) {
        return new PathPart(left, null);
    }

    public static PathPart index(Integer right) {
        return new PathPart(null, right);
    }

    @Override
    public int compareTo(PathPart other) {
        if (hasLeft()) {
            if (other.hasRight()) return -1;
            else return getLeft().compareTo(other.getLeft());
        } else {
            if (other.hasLeft()) return 1;
            else return getRight().compareTo(other.getRight());
        }
    }

    @Override
    public String toString() {
        if (hasLeft()) return "Key:"+getLeft();
        else return "Idx:"+getRight();
    }
}
