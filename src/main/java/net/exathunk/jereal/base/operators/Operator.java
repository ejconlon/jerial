package net.exathunk.jereal.base.operators;

import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.core.SuperModel;
import net.exathunk.jereal.base.core.PathPart;
import net.exathunk.jereal.base.functional.Func4;
import net.exathunk.jereal.base.functional.Reference;

/**
 * charolastra 10/29/12 12:14 PM
 */
public interface Operator<D, J> extends Func4<PathPart, J, D, Reference<ExecutionException>> {
    boolean canCast(SuperModel model);
    J cast(SuperModel model, JThing thing) throws ExecutionException;
}
