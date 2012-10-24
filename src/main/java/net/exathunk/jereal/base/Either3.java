package net.exathunk.jereal.base;

public class Either3<Left, Middle, Right> {
    private final Left left;
    private final Middle middle;
    private final Right right;

    protected Either3(Left left, Middle middle, Right right) {
        this.left = left;
        this.middle = middle;
        this.right = right;
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
        return left;
    }

    public Middle getMiddle() {
        return middle;
    }

    public Right getRight() {
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
