package net.exathunk.jereal.base.functional;

public class Either3<Left, Middle, Right> {
    private final Left left;
    private final Middle middle;
    private final Right right;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Either3 either3 = (Either3) o;

        if (left != null ? !left.equals(either3.left) : either3.left != null) return false;
        if (middle != null ? !middle.equals(either3.middle) : either3.middle != null) return false;
        if (right != null ? !right.equals(either3.right) : either3.right != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = left != null ? left.hashCode() : 0;
        result = 31 * result + (middle != null ? middle.hashCode() : 0);
        result = 31 * result + (right != null ? right.hashCode() : 0);
        return result;
    }

    protected Either3(Left left, Middle middle, Right right) {
        this.left = left;
        this.middle = middle;
        this.right = right;
        assert left != null || middle != null || right != null;

    }

    public boolean hasLeft() {
        return left != null;
    }

    public boolean hasMiddle() {
        return middle != null;
    }

    public boolean hasRight() {
        return right != null;
    }

    public Left getLeft() {
        assert left != null;
        return left;
    }

    public Middle getMiddle() {
        assert middle != null;
        return middle;
    }

    public Right getRight() {
        assert right != null;
        return right;
    }

    public static <X, Y, Z> Either3<X, Y, Z> makeLeft(X left) {
        return new Either3<X, Y, Z>(left, null, null);
    }

    public static <X, Y, Z> Either3<X, Y, Z> makeMiddle(Y middle) {
        return new Either3<X, Y, Z>(null, middle, null);
    }

    public static <X, Y, Z> Either3<X, Y, Z> makeRight(Z right) {
        return new Either3<X, Y, Z>(null, null, right);
    }
}
