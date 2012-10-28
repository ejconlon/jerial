package net.exathunk.jereal.base.core;

/**
 * charolastra 10/28/12 1:32 AM
 */
public class JLong implements JMutableScalar<Long> {

    private Long value;

    public JLong() {}

    public JLong(Long value) {
        this.value = value;
    }

    @Override
    public void runFunc(Long newValue) {
        value = newValue;
    }

    @Override
    public Long runResFunc() {
        return value;
    }
}
