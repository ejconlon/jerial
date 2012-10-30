package net.exathunk.jereal.base.visitors;

import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.core.PathPart;
import net.exathunk.jereal.base.functional.ConsList;

/**
 * charolastra 10/29/12 4:40 PM
 */
public class VisitorAdapter implements Visitor {

    private final TypedVisitor wrapped;

    public VisitorAdapter(TypedVisitor wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public void visitStart(ConsList<PathPart> path, JThing thing) throws VisitException {
        switch (thing.getModel()) {
            case STRING:
                wrapped.visitString(path, thing.rawGetString());
                break;
            case BOOLEAN:
                wrapped.visitBoolean(path, thing.rawGetBoolean());
                break;
            case LONG:
                wrapped.visitLong(path, thing.rawGetLong());
                break;
            case DOUBLE:
                wrapped.visitDouble(path, thing.rawGetDouble());
                break;
            case OBJECT:
                wrapped.visitObjectStart(path, thing.rawGetObject());
                break;
            case ARRAY:
                wrapped.visitArrayStart(path, thing.rawGetArray());
                break;
            default:
                throw new VisitException("Invalid model: "+thing);
        }
    }

    @Override
    public void visitEnd(ConsList<PathPart> path, JThing thing) throws VisitException {
        switch (thing.getModel()) {
            case OBJECT:
                wrapped.visitObjectEnd(path, thing.rawGetObject());
                break;
            case ARRAY:
                wrapped.visitArrayEnd(path, thing.rawGetArray());
                break;
            default:
                throw new VisitException("Unknown model: "+thing);
        }
    }
}
