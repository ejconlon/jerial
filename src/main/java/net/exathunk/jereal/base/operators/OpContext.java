package net.exathunk.jereal.base.operators;

import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.core.Path;
import net.exathunk.jereal.base.core.SuperModel;
import net.exathunk.jereal.base.functional.EitherRef;

/**
 * charolastra 10/30/12 1:30 AM
 */
public class OpContext<J, D> {
    public final Direction dir;
    public final Path path;
    public final SuperModel model;
    public final J thing;
    public final EitherRef<D, OperatorException> out;

    public OpContext(Direction dir, Path path, SuperModel model, J thing, EitherRef<D, OperatorException> out) {
        this.dir = dir;
        this.path = path;
        this.model = model;
        this.thing = thing;
        this.out = out;
    }

    public <K> OpContext<K, D> withThing(K thing) {
        return new OpContext<K, D>(dir, path, model, thing, out);
    }

    public void fail(OperatorException e) {
        out.getRightReference().setReference(e);
    }

    public OpContext<J, D> withPath(Path path) {
        return new OpContext<J, D>(dir, path, model, thing, out);
    }
}
