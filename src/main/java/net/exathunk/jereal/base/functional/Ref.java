package net.exathunk.jereal.base.functional;

/**
 * charolastra 10/29/12 3:36 PM
 */
public interface Ref<T> {
    T getRef();
    void setRef(T value);
    boolean isEmptyRef();
}
