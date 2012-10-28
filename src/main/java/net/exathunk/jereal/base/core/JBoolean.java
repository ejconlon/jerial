package net.exathunk.jereal.base.core;

/**
 * charolastra 10/27/12 11:56 PM
 */
public class JBoolean implements JMutableScalar<Boolean> {
    private Boolean value;

    public JBoolean() {}

    public JBoolean(Boolean value) {
        this.value = value;
    }

    @Override
    public Boolean runResFunc() {
        return value;
    }

    @Override
    public void runFunc(Boolean newValue) {
        value = newValue;
    }
}
