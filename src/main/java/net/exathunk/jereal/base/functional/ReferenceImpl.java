package net.exathunk.jereal.base.functional;

/**
 * charolastra 10/30/12 2:48 AM
 */
public class ReferenceImpl<T> implements Reference<T> {

    private T ref = null;

    @Override
    public T getReference() {
        return ref;
    }

    @Override
    public void setReference(T ref) {
        this.ref = ref;
    }
}
