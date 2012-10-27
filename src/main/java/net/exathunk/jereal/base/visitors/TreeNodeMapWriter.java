package net.exathunk.jereal.base.visitors;

/**
 * charolastra 10/25/12 11:37 AM
 */
public interface TreeNodeMapWriter<T> {
    void writeTo(TreeNodeMap<T> source, T sink);
}
