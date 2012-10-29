package net.exathunk.jereal.base.functional;

/**
 * charolastra 10/29/12 3:36 PM
 */
public class Reference<T> {
    private T reference;

    public Reference() {}
    public Reference(T reference) {
        this.reference = reference;
    }

    public T getReference() {
        return reference;
    }

    public void setReference(T reference) {
        this.reference = reference;
    }

    public boolean isEmpty() {
        return this.reference == null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reference reference1 = (Reference) o;

        if (reference != null ? !reference.equals(reference1.reference) : reference1.reference != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return reference != null ? reference.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Reference{" +
                "reference=" + reference +
                '}';
    }
}
