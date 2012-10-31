package net.exathunk.jereal.base.functional;

/**
 * charolastra 10/30/12 2:48 AM
 */
public class RefImpl<T> implements Ref<T> {

    private T value = null;

    public RefImpl() {}

    public RefImpl(T value) {
        this.value = value;
    }

    @Override
    public T getRef() {
        return value;
    }

    @Override
    public void setRef(T value) {
        this.value = value;
    }

    @Override
    public boolean isEmptyRef() {
        return value == null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ref)) return false;

        Ref ref = (Ref) o;

        if (value != null ? !value.equals(ref.getRef()) : ref.getRef() != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Ref{" +
                "value=" + value +
                '}';
    }
}
