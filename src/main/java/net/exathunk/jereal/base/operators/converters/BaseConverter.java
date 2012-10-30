package net.exathunk.jereal.base.operators.converters;

import net.exathunk.jereal.base.core.JString;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.core.Model;
import net.exathunk.jereal.base.operators.OperatorException;

/**
 * charolastra 10/30/12 2:37 PM
 */
public abstract class BaseConverter<B> implements Converter<JThing, B> {

    private final Model model;

    public BaseConverter(Model model) {
        this.model = model;
        assert model != null;
    }

    @Override
    public boolean canConvert(JThing thing) {
        return thing != null && model.equals(thing.getModel());
    }

    @Override
    public B convert(JThing thing) throws OperatorException {
        if (!canConvert(thing)) throw new OperatorException("Cannot convert. Got: "+thing+" expected model "+model);
        return rawConvert(thing);
    }

    protected abstract B rawConvert(JThing thing);
}
