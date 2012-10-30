package net.exathunk.jereal.base.operators.converters;

import net.exathunk.jereal.base.core.JArray;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.core.Model;

/**
 * charolastra 10/30/12 2:43 PM
 */
public class JArrayConverter extends BaseConverter<JArray> {
    public JArrayConverter() {
        super(Model.ARRAY);
    }

    @Override
    protected JArray rawConvert(JThing thing) {
        return thing.rawGetArray();
    }
}
