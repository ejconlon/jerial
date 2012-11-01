package net.exathunk.jereal.base.jerializers;

import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.dsl.*;
import net.exathunk.jereal.base.functional.Cont;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;

import java.util.*;

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
            public void pipe(Cont<U> cont) throws JerializerException {
                if (domain.isEmptyRef()) {
                    if (cont.getSingle().isEmptyRef()) return;
                    else domain.setRef(jerializer.prototype());
                }
                Pipeable<U> pipeable = jerializer.jerialize(thiz, dsl, domain.getRef());
                pipeable.pipe(cont);
            }
        };
    }

    @Override
    public <V> Pipeable<U> seeCustomMap(final DSL<T, U> dsl, final Ref<Map<String, V>> domain, Class<V> klass) throws JerializerException {
        final Jerializer<T, U, V> jerializer = registry.getJerializer(klass);
        final Recurser<T, U> thiz = this;
        return new Pipeable<U>() {
            @Override
            public void pipe(Cont<U> cont) throws JerializerException {
                final Set<String> keys;
                final boolean create;
                if (domain.isEmptyRef()) {
                    if (cont.getMap().isEmptyRef()) return;
                    else {
                        keys = cont.getMap().getRef().keySet();
                        domain.setRef(new TreeMap<String, V>());
                        create = true;
                    }
                } else {
                    keys = domain.getRef().keySet();
                    create = false;
                }
                ObjectDSL<T, U> objectDSL = dsl.seeObject();
                for (final String key : keys) {
                    final V value;
                    if (create) {
                        value = jerializer.prototype();
                        domain.getRef().put(key, value);
                    } else {
                        value = domain.getRef().get(key);
                    }
                    Pipeable<U> pipeable = jerializer.jerialize(thiz, dsl, value);
                    objectDSL.seeWritable(key, new RefImpl<Pipeable<U>>(pipeable));
                }
                objectDSL.pipe(cont);
            }
        };
    }

    @Override
    public <V> Pipeable<U> seeCustomList(final DSL<T, U> dsl, final Ref<List<V>> domain, Class<V> klass) throws JerializerException {
        final Jerializer<T, U, V> jerializer = registry.getJerializer(klass);
        final Recurser<T, U> thiz = this;
        return new Pipeable<U>() {
            @Override
            public void pipe(Cont<U> cont) throws JerializerException {
                final int len;
                final boolean create;
                if (domain.isEmptyRef()) {
                    if (cont.getList().isEmptyRef()) return;
                    else {
                        len = cont.getList().getRef().size();
                        domain.setRef(new ArrayList<V>(len));
                        create = true;
                    }
                } else {
                    len = domain.getRef().size();
                    create = false;
                }
                ArrayDSL<T, U> arrayDSL = dsl.seeArray();
                for (int index = 0; index < len; ++index) {
                    final V value;
                    if (create) {
                        value = jerializer.prototype();
                        domain.getRef().add(value);
                    } else {
                        value = domain.getRef().get(index);
                    }
                    Pipeable<U> pipeable = jerializer.jerialize(thiz, dsl, value);
                    arrayDSL.seeWritable(new RefImpl<Pipeable<U>>(pipeable));
                }
                arrayDSL.pipe(cont);
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

    /*@Override
    public Pipeable<U> seeThing(final DSL<T, U> dsl, final Ref<JThing> domain) {
        return new Pipeable<U>() {
            @Override
            public void pipe(Ref<U> ref) throws JerializerException {
                if (domain.isEmptyRef()) return;
                Pipeable<U> pipeable = domain.getRef().acceptDSL(dsl);
                pipeable.pipe(ref);
            }
        };
    }*/
}
