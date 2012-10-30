package net.exathunk.jereal.base.operators;

import net.exathunk.jereal.base.core.*;
import net.exathunk.jereal.base.operators.core.Operator;
import net.exathunk.jereal.base.util.EmptyVisitor;

/**
 * charolastra 10/29/12 9:52 PM
 */
public class OperatorMapVisitor<F> extends EmptyVisitor {

    private final OperatorMap<JThing, F> opMap;
    private final OpContext<JThing, F> context;

    public OperatorMapVisitor(OperatorMap<JThing, F> opMap, OpContext<JThing, F> context) {
        this.opMap = opMap;
        this.context = context;
    }

    private boolean run(Path path, SuperModel model, JThing thing) throws VisitException {
        Operator<JThing, F> op = opMap.dir(context.dir).get(path, model);
        boolean hasRun = false;
        final OpContext newContext = context.withPath(path).withThing(thing);
        if (op != null && newContext.out.hasLeft()) {
            op.runFunc(newContext);
            hasRun = true;
        }
        if (newContext.out.hasRight()) {
            throw new VisitException("Exception while processing: "+context, context.out.getRight());
        }
        return !hasRun;
    }

    @Override
    public boolean visitObjectStart(Path path, JObject thing) throws VisitException {
        return run(path, SuperModel.OBJECT, JThing.make(thing));
    }

    @Override
    public boolean visitArrayStart(Path path, JArray thing) throws VisitException {
        return run(path, SuperModel.ARRAY, JThing.make(thing));
    }

    @Override
    public void visitString(Path path, JString thing) throws VisitException {
        run(path, SuperModel.STRING, JThing.make(thing));
    }

    @Override
    public void visitBoolean(Path path, JBoolean thing) throws VisitException {
        run(path, SuperModel.BOOLEAN, JThing.make(thing));
    }

    @Override
    public void visitLong(Path path, JLong thing) throws VisitException {
        run(path, SuperModel.LONG, JThing.make(thing));
    }

    @Override
    public void visitDouble(Path path, JDouble thing) throws VisitException {
        run(path, SuperModel.DOUBLE, JThing.make(thing));
    }
}
