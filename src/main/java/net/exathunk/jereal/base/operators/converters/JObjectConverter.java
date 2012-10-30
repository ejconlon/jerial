package net.exathunk.jereal.base.operators.converters;

import net.exathunk.jereal.base.core.JObject;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.core.Model;

/**
 * charolastra 10/30/12 2:43 PM
 */
public class JObjectConverter extends BaseConverter<JObject> {
    public JObjectConverter() {
        super(Model.OBJECT);
    }

    @Override
    protected JObject rawConvert(JThing thing) {
        return thing.rawGetObject();
    }
}
