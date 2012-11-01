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
    public <V> Ref<Writable<U>> seeCustom(DSL<T, U> dsl, Ref<V> domain) throws JerializerException {
        if (!domain.isEmptyRef() && domain.getRef() != null) {
            Class<V> klass = (Class<V>)domain.getRef().getClass();
            Jerializer<T, U, V> jerializer = registry.getJerializer(klass);
            return new RefImpl<Writable<U>>(jerializer.jerialize(this, dsl, domain.getRef()));
        } else {
            return new RefImpl<Writable<U>>();
        }
    }

    @Override
    public <V> Ref<Writable<U>> seeCustomMap(DSL<T, U> dsl, Ref<Map<String, V>> domain) throws JerializerException {
        if (!domain.isEmptyRef() && domain.getRef() != null && !domain.getRef().isEmpty()) {
            Map.Entry<String, V> first = domain.getRef().entrySet().iterator().next();
            if (first.getValue() == null) return new RefImpl<Writable<U>>();
            Class<V> klass = (Class<V>)first.getValue().getClass();
            Jerializer<T, U, V> jerializer = registry.getJerializer(klass);
            ObjectDSL<T, U> objectDSL = dsl.seeObject();
            for (Map.Entry<String, V> entry : domain.getRef().entrySet()) {
                Writable<U> writable = jerializer.jerialize(this, dsl, entry.getValue());
                objectDSL.seeWritable(entry.getKey(), new RefImpl<Writable<U>>(writable));
            }
            return new RefImpl<Writable<U>>(objectDSL);
        } else {
            return new RefImpl<Writable<U>>();
        }
    }

    @Override
    public <V> Ref<Writable<U>> seeCustomList(DSL<T, U> dsl, Ref<List<V>> domain) throws JerializerException {
        if (!domain.isEmptyRef() && domain.getRef() != null &&
                !domain.getRef().isEmpty() && domain.getRef().get(0) != null) {
            Class<V> klass = (Class<V>)domain.getRef().get(0).getClass();
            Jerializer<T, U, V> jerializer = registry.getJerializer(klass);
            ArrayDSL<T, U> arrayDSL = dsl.seeArray();
            for (V value : domain.getRef()) {
                Writable<U> writable = jerializer.jerialize(this, dsl, value);
                arrayDSL.seeWritable(new RefImpl<Writable<U>>(writable));
            }
            return new RefImpl<Writable<U>>(arrayDSL);
        } else {
            return new RefImpl<Writable<U>>();
        }
    }

    @Override
    public Ref<Writable<U>> seeSimpleMap(DSL<T, U> dsl, Ref<Map<String, String>> domain) {
        if (domain.isEmptyRef() || domain.getRef() == null || domain.getRef().isEmpty()) return new RefImpl<Writable<U>>();
        ObjectDSL<T, U> objectDSL = dsl.seeObject();
        for (Map.Entry<String, String> entry : domain.getRef().entrySet()) {
            objectDSL.seeString(entry.getKey(), new RefImpl<String>(entry.getValue()));
        }
        return new RefImpl<Writable<U>>(objectDSL);
    }

    @Override
    public Ref<Writable<U>> seeThing(DSL<T, U> dsl, Ref<JThing> domain) {
        if (domain.isEmptyRef() || domain.getRef() == null) return new RefImpl<Writable<U>>();
        switch (domain.getRef().getModel()) {
            case OBJECT:
            {
                ObjectDSL<T, U> objectDSL = dsl.seeObject();
                for (Map.Entry<String, JThing> entry : domain.getRef().rawGetObject().seq()) {
                    Ref<Writable<U>> writable = seeThing(dsl, new RefImpl<JThing>(entry.getValue()));
                    objectDSL.seeWritable(entry.getKey(), writable);
                }
                return new RefImpl<Writable<U>>(objectDSL);
            }
            case ARRAY:
            {
                ArrayDSL<T, U> arrayDSL = dsl.seeArray();
                for (Map.Entry<Integer, JThing> entry : domain.getRef().rawGetArray().seq()) {
                    Ref<Writable<U>> writable = seeThing(dsl, new RefImpl<JThing>(entry.getValue()));
                    arrayDSL.seeWritable(writable);
                }
                return new RefImpl<Writable<U>>(arrayDSL);
            }
            case STRING:
                return new RefImpl<Writable<U>>(dsl.seeString(domain.getRef().rawGetString()));
            case BOOLEAN:
                return new RefImpl<Writable<U>>(dsl.seeBoolean(domain.getRef().rawGetBoolean()));
            case LONG:
                return new RefImpl<Writable<U>>(dsl.seeLong(domain.getRef().rawGetLong()));
            case DOUBLE:
                return new RefImpl<Writable<U>>(dsl.seeDouble(domain.getRef().rawGetDouble()));
            default:
                throw new IllegalStateException("Unexpected model: "+domain.getRef().getModel());
        }
    }
}
