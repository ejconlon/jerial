package net.exathunk.jereal.base.core;

/**
 * charolastra 10/28/12 12:53 PM
 */
public class JMutableScalarImpl<T> implements JMutableScalar<T> {
    private T value;

    public JMutableScalarImpl() {}

    public JMutableScalarImpl(T value) {
        this.value = value;
    }

    @Override
    public void runFunc(T newValue) {
        value = newValue;
    }

    @Override
    public T runResFunc() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JMutableScalarImpl that = (JMutableScalarImpl) o;

        if (value != null ? !value.equals(that.value) : that.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "J"+value.getClass().getSimpleName()+"{" +
                "value=" + value +
                '}';
    }
}
