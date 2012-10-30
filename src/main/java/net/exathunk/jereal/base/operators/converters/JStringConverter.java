package net.exathunk.jereal.base.operators.converters;

import net.exathunk.jereal.base.core.JString;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.core.Model;

/**
 * charolastra 10/30/12 2:41 PM
 */
public class JStringConverter extends BaseConverter<JString> {
    public JStringConverter() {
        super(Model.STRING);
    }

    @Override
    protected JString rawConvert(JThing thing) {
        return thing.rawGetString();
    }
}
