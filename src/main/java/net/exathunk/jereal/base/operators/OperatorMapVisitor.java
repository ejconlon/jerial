package net.exathunk.jereal.base.operators;

import net.exathunk.jereal.base.core.*;
import net.exathunk.jereal.base.functional.EitherRef;

/**
 * charolastra 10/29/12 9:52 PM
 */
public class OperatorMapVisitor<D, E extends Throwable> implements TypedVisitor {

    private final OperatorMap<D, E> opMap;
    private final EitherRef<D, E> ref;

    public OperatorMapVisitor(OperatorMap<D, E> opMap, EitherRef<D, E> ref) {
        this.opMap = opMap;
        this.ref = ref;
    }

    private <Y> void run(Path path, Y thing, SuperModel model) throws VisitException {
        Operator<D, E, Y> op = (Operator<D, E, Y>)opMap.get(path.head().getLeft(), model);
        if (op != null && ref.hasLeft()) {
            final D domain = ref.getLeft();
            op.runFunc(path.head(), thing, domain, ref.getRightReference());
        }
        if (ref.hasRight()) {
            throw new VisitException("Exception while processing: "+path, ref.getRight());
        }
    }

    @Override
    public void visitObjectStart(Path path, JObject thing) throws VisitException {
        run(path, thing, SuperModel.OBJECT);
    }

    @Override
    public void visitObjectEnd(Path path, JObject thing) throws VisitException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void visitArrayStart(Path path, JArray thing) throws VisitException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void visitArrayEnd(Path path, JArray thing) throws VisitException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void visitString(Path path, JString thing) throws VisitException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void visitBoolean(Path path, JBoolean thing) throws VisitException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void visitLong(Path path, JLong thing) throws VisitException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void visitDouble(Path path, JDouble thing) throws VisitException {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
