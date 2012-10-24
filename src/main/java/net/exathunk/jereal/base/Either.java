package net.exathunk.jereal.base;

public class Either<Left, Right> {
    private final Left left;
    private final Right right;

    private Either(Left left, Right right) {
        this.left = left;
        this.right = right;
    }

    public boolean hasLeft() {
        return left != null;
    }

    public boolean hasRight() {
        return right != null;
    }

    public Left getLeft() {
        return left;
    }

    public Right getRight() {
        return right;
    }

    public static <X, Y> Either<X, Y> makeLeft(X left) {
        return new Either<X, Y>(left, null);
    }

    public static <X, Y> Either<X, Y> makeRight(Y right) {
        return new Either<X, Y>(null, right);
    }

}
