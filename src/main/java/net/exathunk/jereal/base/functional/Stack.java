package net.exathunk.jereal.base.functional;

/**
 * charolastra 10/28/12 8:00 PM
 */
public interface Stack<T> {
    void push(T object);
    T pop();
    T peek();
    boolean isEmpty();
    int size();
    Sequence<T> seq();
    Sequence<T> revSeq();
}
