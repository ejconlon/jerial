package net.exathunk.jereal.base.dsl;

/**
 * charolastra 10/31/12 7:25 PM
 */
public class WritableImpl<U> implements Writable<U> {
    private final U value;

    public WritableImpl(U value) {
        this.value = value;
    }

    @Override
    public U write() {
        return value;
    }
}
