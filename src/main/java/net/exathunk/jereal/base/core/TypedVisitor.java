package net.exathunk.jereal.base.core;

import net.exathunk.jereal.base.functional.ConsList;

/**
 * charolastra 10/29/12 4:38 PM
 */
public interface TypedVisitor {
    void visitObjectStart(ConsList<PathPart> path, JObject thing) throws VisitException;
    void visitObjectEnd(ConsList<PathPart> path, JObject thing) throws VisitException;
    void visitArrayStart(ConsList<PathPart> path, JArray thing) throws VisitException;
    void visitArrayEnd(ConsList<PathPart> path, JArray thing) throws VisitException;
    void visitString(ConsList<PathPart> path, JString thing) throws VisitException;
    void visitBoolean(ConsList<PathPart> path, JBoolean thing) throws VisitException;
    void visitLong(ConsList<PathPart> path, JLong thing) throws VisitException;
    void visitDouble(ConsList<PathPart> path, JDouble thing) throws VisitException;
}
