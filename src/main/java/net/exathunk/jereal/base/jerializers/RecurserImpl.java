package net.exathunk.jereal.base.jerializers;

import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.dsl.ArrayDSL;
import net.exathunk.jereal.base.dsl.ObjectDSL;
import net.exathunk.jereal.base.dsl.PushableContext;
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
    public <V> void seeCustom(ObjectDSL<T, U> dsl, String key, Ref<V> domain) throws JerializerException {
        if (!domain.isEmptyRef() && domain.getRef() != null) {
            Class<V> klass = (Class<V>)domain.getRef().getClass();
            Jerializer<T, U, V> jerializer = registry.getJerializer(klass);
            Ref<ObjectDSL<T, U>> newDsl = dsl.seeObjectStart(key);
            jerializer.jerialize(this, newDsl.getRef(), domain.getRef());
        }
    }

    @Override
    public <V> void seeCustomMap(ObjectDSL<T, U> dsl, String key, Ref<Map<String, V>> domain) throws JerializerException {
        if (!domain.isEmptyRef() && domain.getRef() != null && !domain.getRef().isEmpty()) {
            Map.Entry<String, V> first = domain.getRef().entrySet().iterator().next();
            if (first.getValue() == null) return;
            Class<V> klass = (Class<V>)first.getValue().getClass();
            Jerializer<T, U, V> jerializer = registry.getJerializer(klass);
            Ref<ObjectDSL<T, U>> newDsl = dsl.seeObjectStart(key);
            for (Map.Entry<String, V> entry : domain.getRef().entrySet()) {
                Ref<ObjectDSL<T, U>> newNewDsl = newDsl.getRef().seeObjectStart(entry.getKey());
                jerializer.jerialize(this, newNewDsl.getRef(), entry.getValue());
            }
        }
    }

    @Override
    public <V> void seeCustomList(ObjectDSL<T, U> dsl, String key, Ref<List<V>> domain) throws JerializerException {
        if (!domain.isEmptyRef() && domain.getRef() != null &&
                !domain.getRef().isEmpty() && domain.getRef().get(0) != null) {
            Class<V> klass = (Class<V>)domain.getRef().get(0).getClass();
            Jerializer<T, U, V> jerializer = registry.getJerializer(klass);
            Ref<ArrayDSL<T, U>> newDsl = dsl.seeArrayStart(key);
            for (V value : domain.getRef()) {
                Ref<ObjectDSL<T, U>> newNewDsl = newDsl.getRef().seeObjectStart();
                jerializer.jerialize(this, newNewDsl.getRef(), value);
            }
        }
    }

    @Override
    public void seeSimpleMap(ObjectDSL<T, U> dsl, String key, Ref<Map<String, String>> domain) {
        if (domain.isEmptyRef() || domain.getRef() == null || domain.getRef().isEmpty()) return;
        Ref<ObjectDSL<T, U>> newDsl = dsl.seeObjectStart(key);
        for (Map.Entry<String, String> entry : domain.getRef().entrySet()) {
            newDsl.getRef().seeString(entry.getKey(), new RefImpl<String>(entry.getValue()));
        }
    }


    private void seeThing(ArrayDSL<T, U> dsl, Ref<JThing> domain) {
        if (domain.isEmptyRef() || domain.getRef() == null) return;
        switch (domain.getRef().getModel()) {
            case OBJECT:
            {
                Ref<ObjectDSL<T, U>> newDsl = dsl.seeObjectStart();
                for (Map.Entry<String, JThing> entry : domain.getRef().rawGetObject().seq()) {
                    seeThing(newDsl.getRef(), entry.getKey(), new RefImpl<JThing>(entry.getValue()));
                }
            }
            case ARRAY:
            {
                Ref<ArrayDSL<T, U>> newDsl = dsl.seeArrayStart();
                for (Map.Entry<Integer, JThing> entry : domain.getRef().rawGetArray().seq()) {
                    seeThing(newDsl.getRef(), new RefImpl<JThing>(entry.getValue()));
                }
            }
            case STRING:
                dsl.seeString(domain.getRef().rawGetString());
            case BOOLEAN:
                dsl.seeBoolean(domain.getRef().rawGetBoolean());
            case LONG:
                dsl.seeLong(domain.getRef().rawGetLong());
            case DOUBLE:
                dsl.seeDouble(domain.getRef().rawGetDouble());
        }
    }

    @Override
    public void seeThing(ObjectDSL<T, U> dsl, String key, Ref<JThing> domain) {
        if (domain.isEmptyRef() || domain.getRef() == null) return;
        switch (domain.getRef().getModel()) {
            case OBJECT:
            {
                Ref<ObjectDSL<T, U>> newDsl = dsl.seeObjectStart(key);
                for (Map.Entry<String, JThing> entry : domain.getRef().rawGetObject().seq()) {
                    seeThing(newDsl.getRef(), entry.getKey(), new RefImpl<JThing>(entry.getValue()));
                }
                break;
            }
            case ARRAY:
            {
                Ref<ArrayDSL<T, U>> newDsl = dsl.seeArrayStart(key);
                for (Map.Entry<Integer, JThing> entry : domain.getRef().rawGetArray().seq()) {
                    seeThing(newDsl.getRef(), new RefImpl<JThing>(entry.getValue()));
                }
                break;
            }
            case STRING:
                dsl.seeString(key, domain.getRef().rawGetString());
                break;
            case BOOLEAN:
                dsl.seeBoolean(key, domain.getRef().rawGetBoolean());
                break;
            case LONG:
                dsl.seeLong(key, domain.getRef().rawGetLong());
                break;
            case DOUBLE:
                dsl.seeDouble(key, domain.getRef().rawGetDouble());
                break;
        }
    }
}
