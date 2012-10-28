package net.exathunk.jereal.base.core;

/**
 * charolastra 10/27/12 11:56 PM
 */
public class JDouble implements JMutableScalar<Double> {
    private Double value;

    public JDouble() {}

    public JDouble(Double value) {
        this.value = value;
    }

    @Override
    public void runFunc(Double newValue) {
        value = newValue;
    }

    @Override
    public Double runResFunc() {
        return value;
    }
}
