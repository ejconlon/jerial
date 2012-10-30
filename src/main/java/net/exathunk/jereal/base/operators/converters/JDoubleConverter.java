package net.exathunk.jereal.base.operators.converters;

import net.exathunk.jereal.base.core.JDouble;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.core.Model;

/**
 * charolastra 10/30/12 2:42 PM
 */
public class JDoubleConverter extends BaseConverter<JDouble> {
    public JDoubleConverter() {
        super(Model.DOUBLE);
    }

    @Override
    protected JDouble rawConvert(JThing thing) {
        return thing.rawGetDouble();
    }
}
