package net.exathunk.jereal.base.operators;

import net.exathunk.jereal.base.core.Model;
import net.exathunk.jereal.base.core.Path;
import net.exathunk.jereal.base.functional.Func1;
import net.exathunk.jereal.base.functional.Reference;

/**
 * charolastra 10/30/12 1:30 AM
 */
public class OpContext<J, D> {
    public final Direction dir;
    public final Path path;
    public final Model model;
    public final J thing;
    public final D domain;
    public final Reference<OperatorException> failRef;

    public OpContext(Direction dir, Path path, Model model, J thing, D domain, Reference<OperatorException> failRef) {
        this.dir = dir;
        this.path = path;
        this.model = model;
        this.thing = thing;
        this.domain = domain;
        this.failRef = failRef;
    }

    public <K> OpContext<K, D> withThing(K thing) {
        return new OpContext<K, D>(dir, path, model, thing, domain, failRef);
    }

    public OpContext<J, D> withPath(Path path) {
        return new OpContext<J, D>(dir, path, model, thing, domain, failRef);
    }

    public OpContext<J, D> withModel(Model model) {
        return new OpContext<J, D>(dir, path, model, thing, domain, failRef);
    }

    public void fail(OperatorException e) {
        failRef.setReference(e);
    }

    public boolean hasFailed() {
        return failRef.getReference() == null;
    }

    public boolean apply(Func1<OpContext<J, D>> f) {
        if (!hasFailed()) {
            f.runFunc(this);
        }
        return !hasFailed();
    }
}
