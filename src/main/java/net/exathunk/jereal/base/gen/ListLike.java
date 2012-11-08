package net.exathunk.jereal.base.gen;

/**
 * charolastra 11/8/12 1:44 AM
 */
public interface ListLike<T> {
    int size();
    boolean isEmpty();
    T get(int index);
    void set(int index, T value);
    void add(T value);
}
