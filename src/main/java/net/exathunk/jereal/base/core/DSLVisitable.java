package net.exathunk.jereal.base.core;

import net.exathunk.jereal.base.dsl.DSL;
import net.exathunk.jereal.base.dsl.Pipeable;
import net.exathunk.jereal.base.dsl.PushableContext;

/**
 * charolastra 10/31/12 11:10 PM
 */
public interface DSLVisitable {
    <A extends PushableContext<A, B>, B> Pipeable<B> acceptDSL(DSL<A,B> dsl);
}
