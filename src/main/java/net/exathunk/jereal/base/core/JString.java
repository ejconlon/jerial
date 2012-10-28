package net.exathunk.jereal.base.core;

/**
 * charolastra 10/27/12 11:56 PM
 */
public class JString implements JMutableScalar<String> {
    private String value;

    public JString() {}

    public JString(String value) {
        this.value = value;
    }

    @Override
    public void runFunc(String newValue) {
        value = newValue;
    }

    @Override
    public String runResFunc() {
        return value;
    }
}
