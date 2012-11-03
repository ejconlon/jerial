package net.exathunk.jereal.base.functional;

public class Either<Left, Right> {
    private Left left;
    private Right right;

    protected Either(Left left, Right right) {
        this.left = left;
        this.right = right;
        assert left != null || right != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Either either = (Either) o;

        if (left != null ? !left.equals(either.left) : either.left != null) return false;
        if (right != null ? !right.equals(either.right) : either.right != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = left != null ? left.hashCode() : 0;
        result = 31 * result + (right != null ? right.hashCode() : 0);
        return result;
    }

    public boolean hasLeft() {
        return left != null;
    }

    public boolean hasRight() {
        return right != null;
    }

    public Left getLeft() {
        assert left != null;
        return left;
    }

    public Right getRight() {
        assert right != null;
        return right;
    }

    public void setLeft(Left left) {
        this.left = left;
        this.right = null;
    }

    public void setRight(Right right) {
        this.right = right;
        this.left = null;
    }

    public static <X, Y> Either<X, Y> makeLeft(X left) {
        return new Either<X, Y>(left, null);
    }

    public static <X, Y> Either<X, Y> makeRight(Y right) {
        return new Either<X, Y>(null, right);
    }

    @Override
    public String toString() {
        return "Either{" +
                ((left != null) ? ("left=" + left) :
                ("right=" + right)) +
                '}';
    }
}
