package net.exathunk.jereal.base.visitors;

import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.functional.Either3;

/**
 * charolastra 10/24/12 8:53 AM
 */
public class TreeNode<T> extends Either3<JThing, TreeObjectVisitor<T>, TreeArrayVisitor<T>> {
    private TreeNode(JThing thing, TreeObjectVisitor<T> objectVisitor, TreeArrayVisitor<T> arrayVisitor) {
        super(thing, objectVisitor, arrayVisitor);
    }

    // RGH
    public static <W> TreeNode<W> makeLeft(JThing left) {
        return new TreeNode<W>(left, null, null);
    }

    public static <W> TreeNode<W> makeMiddle(TreeObjectVisitor<W> middle) {
        return new TreeNode<W>(null, middle, null);
    }

    public static <W> TreeNode<W> makeRight(TreeArrayVisitor<W> right) {
        return new TreeNode<W>(null, null, right);
    }
}
