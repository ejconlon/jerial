package net.exathunk.jereal.base.visitors;

import net.exathunk.jereal.base.functional.Either3;

/**
 * charolastra 10/24/12 8:53 AM
 */
public class TreeNode<T> extends Either3<Jitem, TreeObjectVisitor<T>, TreeArrayVisitor<T>> {
    private TreeNode(Jitem jitem, TreeObjectVisitor<T> objectVisitor, TreeArrayVisitor<T> arrayVisitor) {
        super(jitem, objectVisitor, arrayVisitor);
    }

    // RGH
    public static <W> TreeNode<W> makeLeft(Jitem left) {
        return new TreeNode<W>(left, null, null);
    }

    public static <W> TreeNode<W> makeMiddle(TreeObjectVisitor<W> middle) {
        return new TreeNode<W>(null, middle, null);
    }

    public static <W> TreeNode<W> makeRight(TreeArrayVisitor<W> right) {
        return new TreeNode<W>(null, null, right);
    }
}
