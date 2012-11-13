package net.exathunk.jereal.base.jerializers;

import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.dsl.DSL;
import net.exathunk.jereal.base.dsl.PushableContext;
import net.exathunk.jereal.base.dsl.Pipeable;
import net.exathunk.jereal.base.dsl.Questionable;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.gen.Ref2;

import java.util.List;
import java.util.Map;

/**
 * charolastra 10/31/12 3:37 PM
 */
public interface Recurser<T extends PushableContext<T, U>, U extends Questionable> {
    <X> Pipeable<U> seeCustom(DSL<T, U> dsl, Ref<X> domain, Class<X> klass) throws JerializerException;
    <X> Pipeable<U> seeCustomList(DSL<T, U> dsl, Ref<List<X>> domain, Class<X> klass) throws JerializerException;

    Pipeable<U> seeSimpleMap(DSL<T, U> dsl, Ref<Map<String, Ref<String>>> domain);

    Pipeable<U> seeThing(DSL<T, U> dsl, Ref<JThing> domain);
    <X> Pipeable<U> seeCustomRefList(DSL<T, U> dsl, Ref<List<Ref<X>>> domain, Class<X> klass) throws JerializerException;
    <X, Y> Pipeable<U> seeCustomRefList2(DSL<T, U> dsl, Ref<List<Ref2<X, Y>>> domain, Class<X> klassX, Class<Y> klassY) throws JerializerException;
    <X> Pipeable<U> seeCustomMap(DSL<T, U> dsl, Ref<Map<String, Ref<X>>> domain, Class<X> klass) throws JerializerException;
}
