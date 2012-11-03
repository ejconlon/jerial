package net.exathunk.jereal.base.jerializers;

import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.core.Model;
import net.exathunk.jereal.base.dsl.*;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;

/**
 * charolastra 10/31/12 3:50 PM
 */
public class RecurserImpl<T extends PushableContext<T, U>, U extends Questionable> implements Recurser<T, U> {

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
                    else domain.setRef(jerializer.prototype(ref.getRef().makeSpec()));
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
                if (domain.isEmptyRef()) {
                    if (ref.isEmptyRef()) return;
                    else {
                        final Speclike spec = ref.getRef().makeSpec();
                        final Map<String, ? extends Speclike> mapSpec = spec.getMapSpec();
                        if (!Model.OBJECT.equals(spec.getModel()) || mapSpec == null) {
                            throw new JerializerException("Expected object: "+spec.getModel());
                        }
                        domain.setRef(new TreeMap<String, V>());
                        for (Map.Entry<String, ? extends Speclike> entry : mapSpec.entrySet()) {
                            domain.getRef().put(entry.getKey(), jerializer.prototype(entry.getValue()));
                        }
                    }
                }
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
                if (domain.isEmptyRef()) {
                    if (ref.isEmptyRef()) return;
                    else {
                        final Speclike spec = ref.getRef().makeSpec();
                        final List<? extends Speclike> listSpec = spec.getListSpec();
                        if (!Model.ARRAY.equals(spec.getModel()) || listSpec == null) {
                            throw new JerializerException("Expected array: "+spec.getModel());
                        }
                        domain.setRef(new ArrayList<V>(listSpec.size()));
                        for (final Speclike subSpec : listSpec) {
                            domain.getRef().add(jerializer.prototype(subSpec));
                        }
                    }
                }
                ArrayDSL<T, U> arrayDSL = dsl.seeArray();
                for (final V value : domain.getRef()) {
                    Pipeable<U> pipeable = jerializer.jerialize(thiz, dsl, value);
                    arrayDSL.seeWritable(new RefImpl<Pipeable<U>>(pipeable));
                }
                arrayDSL.pipe(ref);
            }
        };
    }

    @Override
    public Pipeable<U> seeSimpleMap(final DSL<T, U> dsl, final Ref<Map<String, Ref<String>>> domain) {
        final Recurser<T, U> thiz = this;
        return new Pipeable<U>() {
            @Override
            public void pipe(Ref<U> ref) throws JerializerException {
                if (domain.isEmptyRef()) {
                    if (ref.isEmptyRef()) return;
                    else {
                        final Speclike spec = ref.getRef().makeSpec();
                        final Map<String, ? extends Speclike> mapSpec = spec.getMapSpec();
                        if (!Model.OBJECT.equals(spec.getModel()) || mapSpec == null) {
                            throw new JerializerException("Expected object: "+spec.getModel());
                        }
                        domain.setRef(new TreeMap<String, Ref<String>>());
                        for (Map.Entry<String, ? extends Speclike> entry : mapSpec.entrySet()) {
                            domain.getRef().put(entry.getKey(), new RefImpl<String>());
                        }
                    }
                }
                ObjectDSL<T, U> objectDSL = dsl.seeObject();
                for (Map.Entry<String, Ref<String>> entry : domain.getRef().entrySet()) {
                    objectDSL.seeString(entry.getKey(), entry.getValue());
                }
                objectDSL.pipe(ref);
            }
        };
    }

    @Override
    public Pipeable<U> seeThing(final DSL<T, U> dsl, final Ref<JThing> domain) {
        return new Pipeable<U>() {
            @Override
            public void pipe(Ref<U> ref) throws JerializerException {
                if (domain.isEmptyRef()) {
                    if (ref.isEmptyRef()) return;
                    else {
                        final Speclike spec = ref.getRef().makeSpec();
                        domain.setRef(JThing.fromSpec(spec));
                    }
                }
                Pipeable<U> pipeable = domain.getRef().acceptDSL(dsl);
                pipeable.pipe(ref);
            }
        };
    }
}
