package net.exathunk.jereal.base.core;

import net.exathunk.jereal.base.functional.ConsList;

/**
 * charolastra 10/29/12 4:38 PM
 */
public interface TypedVisitor {
    void visitObjectStart(ConsList<PathPart> part, JObject thing) throws VisitException;
    void visitObjectEnd(ConsList<PathPart> part, JObject thing) throws VisitException;
    void visitArrayStart(ConsList<PathPart> part, JArray thing) throws VisitException;
    void visitArrayEnd(ConsList<PathPart> part, JArray thing) throws VisitException;
    void visitString(ConsList<PathPart> part, JString thing) throws VisitException;
    void visitBoolean(ConsList<PathPart> part, JBoolean thing) throws VisitException;
    void visitLong(ConsList<PathPart> part, JLong thing) throws VisitException;
    void visitDouble(ConsList<PathPart> part, JDouble thing) throws VisitException;
}
