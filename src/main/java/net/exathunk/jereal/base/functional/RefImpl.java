package net.exathunk.jereal.base.functional;

/**
 * charolastra 10/30/12 2:48 AM
 */
public class RefImpl<T> implements Ref<T> {

    private T value = null;
    private boolean isEmpty = true;

    public RefImpl() {}

    public RefImpl(T value) {
        this.value = value;
        this.isEmpty = false;
    }

    @Override
    public T getRef() {
        if (isEmpty) throw new IllegalStateException("NIL REF!");
        return value;
    }

    @Override
    public void setRef(T value) {
        this.value = value;
        this.isEmpty = false;
    }

    @Override
    public boolean isEmptyRef() {
        return isEmpty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ref)) return false;

        Ref ref = (Ref) o;

        if (isEmpty) {
            return ref.isEmptyRef();
        } else {
            if (getRef() != null ? !getRef().equals(ref.getRef()) : ref.getRef() != null) return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = value != null ? value.hashCode() : 0;
        result = 31 * result + (isEmpty ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Ref{" +
                (isEmpty ? "" : "value=" + value) +
                '}';
    }
}
