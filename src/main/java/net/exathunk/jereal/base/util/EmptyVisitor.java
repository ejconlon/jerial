package net.exathunk.jereal.base.util;

import net.exathunk.jereal.base.core.*;
import net.exathunk.jereal.base.functional.ConsList;

/**
 * charolastra 10/29/12 9:09 PM
 */
public class EmptyVisitor implements TypedVisitor {
    @Override
    public void visitObjectStart(ConsList<PathPart> part, JObject thing) throws VisitException {

    }

    @Override
    public void visitObjectEnd(ConsList<PathPart> part, JObject thing) throws VisitException {

    }

    @Override
    public void visitArrayStart(ConsList<PathPart> part, JArray thing) throws VisitException {

    }

    @Override
    public void visitArrayEnd(ConsList<PathPart> part, JArray thing) throws VisitException {

    }

    @Override
    public void visitString(ConsList<PathPart> part, JString thing) throws VisitException {

    }

    @Override
    public void visitBoolean(ConsList<PathPart> part, JBoolean thing) throws VisitException {

    }

    @Override
    public void visitLong(ConsList<PathPart> part, JLong thing) throws VisitException {

    }

    @Override
    public void visitDouble(ConsList<PathPart> part, JDouble thing) throws VisitException {

    }
}
