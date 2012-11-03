package net.exathunk.jereal.base.core;

import net.exathunk.jereal.base.dsl.Speclike;
import net.exathunk.jereal.base.functional.RefImpl;

import java.util.List;
import java.util.Map;

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

    @Override
    public boolean hasMapSpec() {
        return false;
    }

    @Override
    public Map<String, ? extends Speclike> getMapSpec() {
        return null;
    }

    @Override
    public boolean hasListSpec() {
        return false;
    }

    @Override
    public List<? extends Speclike> getListSpec() {
        return null;
    }

    @Override
    public Speclike makeSpec() {
        return this;
    }
}
