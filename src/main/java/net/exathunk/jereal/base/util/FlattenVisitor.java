package net.exathunk.jereal.base.util;

import net.exathunk.jereal.base.core.*;
import net.exathunk.jereal.base.functional.ResFunc0;

/**
 * charolastra 10/29/12 9:09 PM
 */
public class FlattenVisitor extends EmptyTypedVisitor implements ResFunc0<JObject> {

    private final PathConverter converter = new DefaultPathConverter();
    private final JObject object = new JObject();

    @Override
    public void visitString(Path part, JString thing) throws VisitException {
        object.set(converter.convertPath(part), JThing.make(thing));
    }

    @Override
    public void visitBoolean(Path part, JBoolean thing) throws VisitException {
        object.set(converter.convertPath(part), JThing.make(thing));
    }

    @Override
    public void visitLong(Path part, JLong thing) throws VisitException {
        object.set(converter.convertPath(part), JThing.make(thing));
    }

    @Override
    public void visitDouble(Path part, JDouble thing) throws VisitException {
        object.set(converter.convertPath(part), JThing.make(thing));
    }

    @Override
    public JObject runResFunc() {
        return object;
    }
}
