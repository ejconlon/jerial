package net.exathunk.jereal.base.operators.converters;

import net.exathunk.jereal.base.core.JBoolean;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.core.Model;

/**
 * charolastra 10/30/12 2:41 PM
 */
public class JBooleanConverter extends BaseConverter<JBoolean> {
    public JBooleanConverter() {
        super(Model.BOOLEAN);
    }

    @Override
    protected JBoolean rawConvert(JThing thing) {
        return thing.rawGetBoolean();
    }
}
