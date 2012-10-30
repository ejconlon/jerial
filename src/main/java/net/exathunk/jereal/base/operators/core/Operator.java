package net.exathunk.jereal.base.operators.core;

import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.core.Path;
import net.exathunk.jereal.base.core.SuperModel;
import net.exathunk.jereal.base.functional.Func4;
import net.exathunk.jereal.base.functional.Reference;
import net.exathunk.jereal.base.operators.ExecutionException;

/**
 * charolastra 10/29/12 12:14 PM
 */
public interface Operator<D, E, J> extends Func4<Path, J, D, Reference<E>> {
    boolean canCast(SuperModel model);
    J cast(SuperModel model, JThing thing) throws ExecutionException;
}
