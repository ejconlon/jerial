package net.exathunk.jereal.base.core;

/**
 * charolastra 10/29/12 4:38 PM
 */
public interface TypedVisitor {
    boolean visitObjectStart(Path path, JObject thing) throws VisitException;
    void visitObjectEnd(Path path, JObject thing) throws VisitException;
    boolean visitArrayStart(Path path, JArray thing) throws VisitException;
    void visitArrayEnd(Path path, JArray thing) throws VisitException;
    void visitString(Path path, JString thing) throws VisitException;
    void visitBoolean(Path path, JBoolean thing) throws VisitException;
    void visitLong(Path path, JLong thing) throws VisitException;
    void visitDouble(Path path, JDouble thing) throws VisitException;
}
