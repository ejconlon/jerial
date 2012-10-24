package net.exathunk.jereal.base.visitors;

import net.exathunk.jereal.base.Either3;

/**
 * charolastra 10/24/12 8:53 AM
 */
public class JerialNode<T> extends Either3<Jitem, TreeObjectVisitor<T>, TreeArrayVisitor<T>> {
    private JerialNode(Jitem jitem, TreeObjectVisitor<T> objectVisitor, TreeArrayVisitor<T> arrayVisitor) {
        super(jitem, objectVisitor, arrayVisitor);
    }

    // RGH
    public static <W> JerialNode<W> makeLeft(Jitem left) {
        return new JerialNode<W>(left, null, null);
    }

    public static <W> JerialNode<W> makeMiddle(TreeObjectVisitor<W> middle) {
        return new JerialNode<W>(null, middle, null);
    }

    public static <W> JerialNode<W> makeRight(TreeArrayVisitor<W> right) {
        return new JerialNode<W>(null, null, right);
    }
}
