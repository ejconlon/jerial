package net.exathunk.jereal.base.operators.converters;

import net.exathunk.jereal.base.core.JLong;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.core.Model;

/**
 * charolastra 10/30/12 2:42 PM
 */
public class JLongConverter extends BaseConverter<JLong> {
    public JLongConverter() {
        super(Model.LONG);
    }

    @Override
    protected JLong rawConvert(JThing thing) {
        return thing.rawGetLong();
    }
}