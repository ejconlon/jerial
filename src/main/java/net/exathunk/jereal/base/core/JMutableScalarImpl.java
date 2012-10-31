package net.exathunk.jereal.base.core;

import net.exathunk.jereal.base.functional.RefImpl;

/**
 * charolastra 10/28/12 12:53 PM
 */
public abstract class JMutableScalarImpl<T> extends RefImpl<T> implements JMutableScalar<T> {
    public JMutableScalarImpl() {
        super();
    }

    public JMutableScalarImpl(T value) {
        super(value);
    }
}
