package net.exathunk.jereal.base.operators;

import net.exathunk.jereal.base.core.*;
import net.exathunk.jereal.base.functional.EitherRef;
import net.exathunk.jereal.base.util.EmptyVisitor;

/**
 * charolastra 10/29/12 9:52 PM
 */
public class OperatorMapVisitor<D, E extends Throwable> extends EmptyVisitor {

    private final OperatorMap<D, E> opMap;
    private final EitherRef<D, E> ref;

    public OperatorMapVisitor(OperatorMap<D, E> opMap, EitherRef<D, E> ref) {
        this.opMap = opMap;
        this.ref = ref;
    }

    private <Y> boolean run(Path path, Y thing, SuperModel model) throws VisitException {
        Operator<D, E, Y> op = (Operator<D, E, Y>)opMap.get(path, model);
        boolean hasRun = false;
        if (op != null && ref.hasLeft()) {
            final D domain = ref.getLeft();
            op.runFunc(path, thing, domain, ref.getRightReference());
            hasRun = true;
        }
        if (ref.hasRight()) {
            throw new VisitException("Exception while processing: "+path, ref.getRight());
        }
        return !hasRun;
    }

    @Override
    public boolean visitObjectStart(Path path, JObject thing) throws VisitException {
        return run(path, thing, SuperModel.OBJECT);
    }

    @Override
    public boolean visitArrayStart(Path path, JArray thing) throws VisitException {
        return run(path, thing, SuperModel.ARRAY);
    }

    @Override
    public void visitString(Path path, JString thing) throws VisitException {
        run(path, thing, SuperModel.STRING);
    }

    @Override
    public void visitBoolean(Path path, JBoolean thing) throws VisitException {
        run(path, thing, SuperModel.BOOLEAN);
    }

    @Override
    public void visitLong(Path path, JLong thing) throws VisitException {
        run(path, thing, SuperModel.LONG);
    }

    @Override
    public void visitDouble(Path path, JDouble thing) throws VisitException {
        run(path, thing, SuperModel.DOUBLE);
    }
}
