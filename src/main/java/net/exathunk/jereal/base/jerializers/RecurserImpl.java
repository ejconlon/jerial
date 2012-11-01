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
    public <V> Writable<U> seeCustom(final DSL<T, U> dsl, final Ref<V> domain, Class<V> klass) throws JerializerException {
        final Jerializer<T, U, V> jerializer = registry.getJerializer(klass);
        final Recurser<T, U> thiz = this;
        return new Writable<U>() {
            @Override
            public void writeTo(Ref<U> ref) throws JerializerException {
                if (domain.isEmptyRef()) {
                    if (ref.isEmptyRef()) return;
                    else domain.setRef(jerializer.prototype());
                }
                Writable<U> writable = jerializer.jerialize(thiz, dsl, domain.getRef());
                writable.writeTo(ref);
            }
        };
    }

    @Override
    public <V> Writable<U> seeCustomMap(final DSL<T, U> dsl, final Ref<Map<String, V>> domain, Class<V> klass) throws JerializerException {
        final Jerializer<T, U, V> jerializer = registry.getJerializer(klass);
        final Recurser<T, U> thiz = this;
        return new Writable<U>() {
            @Override
            public void writeTo(Ref<U> ref) throws JerializerException {
                ObjectDSL<T, U> objectDSL = dsl.seeObject();
                for (Map.Entry<String, V> entry : domain.getRef().entrySet()) {
                    Writable<U> writable = jerializer.jerialize(thiz, dsl, entry.getValue());
                    objectDSL.seeWritable(entry.getKey(), new RefImpl<Writable<U>>(writable));
                }
                objectDSL.writeTo(ref);
            }
        };
    }

    @Override
    public <V> Writable<U> seeCustomList(final DSL<T, U> dsl, final Ref<List<V>> domain, Class<V> klass) throws JerializerException {
        final Jerializer<T, U, V> jerializer = registry.getJerializer(klass);
        final Recurser<T, U> thiz = this;
        return new Writable<U>() {
            @Override
            public void writeTo(Ref<U> ref) throws JerializerException {
                ArrayDSL<T, U> arrayDSL = dsl.seeArray();
                for (V value : domain.getRef()) {
                    Writable<U> writable = jerializer.jerialize(thiz, dsl, value);
                    arrayDSL.seeWritable(new RefImpl<Writable<U>>(writable));
                }
                arrayDSL.writeTo(ref);
            }
        };
    }

    /*@Override
    public Writable<U> seeSimpleMap(final DSL<T, U> dsl, final Ref<Map<String, String>> domain) {
        final Recurser<T, U> thiz = this;
        return new Writable<U>() {
            @Override
            public void writeTo(Ref<U> ref) throws JerializerException {
                ObjectDSL<T, U> objectDSL = dsl.seeObject();
                for (Map.Entry<String, String> entry : domain.getRef().entrySet()) {
                    objectDSL.seeString(entry.getKey(), new RefImpl<String>(entry.getValue()));
                }
                objectDSL.writeTo(ref);
            }
        };
    }*/

    @Override
    public Writable<U> seeThing(final DSL<T, U> dsl, final Ref<JThing> domain) {
        return new Writable<U>() {
            @Override
            public void writeTo(Ref<U> ref) throws JerializerException {
                if (domain.isEmptyRef()) return;
                Writable<U> writable = domain.getRef().acceptDSL(dsl);
                writable.writeTo(ref);
            }
        };
    }
}
