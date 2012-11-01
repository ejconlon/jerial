package net.exathunk.jereal.base.jerializers;

import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.dsl.*;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;

import java.util.List;
import java.util.Map;

/**
 * charolastra 10/31/12 3:50 PM
 */
public class RecurserImpl<T extends PushableContext<T, U>, U> implements Recurser<T, U> {

    private final JerializerRegistry registry;

    public RecurserImpl(JerializerRegistry registry) {
        this.registry = registry;
    }

    @Override
    public <V> Pipeable<U> seeCustom(final DSL<T, U> dsl, final Ref<V> domain, Class<V> klass) throws JerializerException {
        final Jerializer<T, U, V> jerializer = registry.getJerializer(klass);
        final Recurser<T, U> thiz = this;
        return new Pipeable<U>() {
            @Override
            public void pipe(Ref<U> ref) throws JerializerException {
                if (domain.isEmptyRef()) {
                    if (ref.isEmptyRef()) return;
                    else domain.setRef(jerializer.prototype());
                }
                Pipeable<U> pipeable = jerializer.jerialize(thiz, dsl, domain.getRef());
                pipeable.pipe(ref);
            }
        };
    }

    @Override
    public <V> Pipeable<U> seeCustomMap(final DSL<T, U> dsl, final Ref<Map<String, V>> domain, Class<V> klass) throws JerializerException {
        final Jerializer<T, U, V> jerializer = registry.getJerializer(klass);
        final Recurser<T, U> thiz = this;
        return new Pipeable<U>() {
            @Override
            public void pipe(Ref<U> ref) throws JerializerException {
                ObjectDSL<T, U> objectDSL = dsl.seeObject();
                for (Map.Entry<String, V> entry : domain.getRef().entrySet()) {
                    Pipeable<U> pipeable = jerializer.jerialize(thiz, dsl, entry.getValue());
                    objectDSL.seeWritable(entry.getKey(), new RefImpl<Pipeable<U>>(pipeable));
                }
                objectDSL.pipe(ref);
            }
        };
    }

    @Override
    public <V> Pipeable<U> seeCustomList(final DSL<T, U> dsl, final Ref<List<V>> domain, Class<V> klass) throws JerializerException {
        final Jerializer<T, U, V> jerializer = registry.getJerializer(klass);
        final Recurser<T, U> thiz = this;
        return new Pipeable<U>() {
            @Override
            public void pipe(Ref<U> ref) throws JerializerException {
                ArrayDSL<T, U> arrayDSL = dsl.seeArray();
                for (V value : domain.getRef()) {
                    Pipeable<U> pipeable = jerializer.jerialize(thiz, dsl, value);
                    arrayDSL.seeWritable(new RefImpl<Pipeable<U>>(pipeable));
                }
                arrayDSL.pipe(ref);
            }
        };
    }

    /*@Override
    public Writable<U> seeSimpleMap(final DSL<T, U> dsl, final Ref<Map<String, String>> domain) {
        final Recurser<T, U> thiz = this;
        return new Writable<U>() {
            @Override
            public void pipe(Ref<U> ref) throws JerializerException {
                ObjectDSL<T, U> objectDSL = dsl.seeObject();
                for (Map.Entry<String, String> entry : domain.getRef().entrySet()) {
                    objectDSL.seeString(entry.getKey(), new RefImpl<String>(entry.getValue()));
                }
                objectDSL.pipe(ref);
            }
        };
    }*/

    @Override
    public Pipeable<U> seeThing(final DSL<T, U> dsl, final Ref<JThing> domain) {
        return new Pipeable<U>() {
            @Override
            public void pipe(Ref<U> ref) throws JerializerException {
                if (domain.isEmptyRef()) return;
                Pipeable<U> pipeable = domain.getRef().acceptDSL(dsl);
                pipeable.pipe(ref);
            }
        };
    }
}
