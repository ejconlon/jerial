package net.exathunk.jereal.base.functional;

/**
 * charolastra 10/29/12 3:36 PM
 */
public interface Ref<T> extends ReadRef<T> {
    void setRef(T value);
}
