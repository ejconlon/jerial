package net.exathunk.jereal.base.operators.core;

import net.exathunk.jereal.base.functional.Func4;
import net.exathunk.jereal.base.operators.OpContext;
import net.exathunk.jereal.base.operators.core.ArgContext;

/**
 * charolastra 10/29/12 12:14 PM
 */
public interface Operator<J, K, D, E> extends Func4<OpContext<J, D>, ArgContext, K, E> {
}
