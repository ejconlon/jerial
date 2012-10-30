package net.exathunk.jereal.base.util;

import net.exathunk.jereal.base.core.*;

/**
 * charolastra 10/29/12 9:09 PM
 */
public class EmptyVisitor implements TypedVisitor {
    @Override
    public boolean visitObjectStart(Path part, JObject thing) throws VisitException {
        return true;
    }

    @Override
    public void visitObjectEnd(Path part, JObject thing) throws VisitException {

    }

    @Override
    public boolean visitArrayStart(Path part, JArray thing) throws VisitException {
        return true;
    }

    @Override
    public void visitArrayEnd(Path part, JArray thing) throws VisitException {

    }

    @Override
    public void visitString(Path part, JString thing) throws VisitException {

    }

    @Override
    public void visitBoolean(Path part, JBoolean thing) throws VisitException {

    }

    @Override
    public void visitLong(Path part, JLong thing) throws VisitException {

    }

    @Override
    public void visitDouble(Path part, JDouble thing) throws VisitException {

    }
}
