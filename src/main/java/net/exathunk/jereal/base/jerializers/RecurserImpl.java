package net.exathunk.jereal.base.jerializers;

import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.core.Model;
import net.exathunk.jereal.base.dsl.*;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;
import net.exathunk.jereal.base.gen.Ref2;

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

    // NEW INTERFACE

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

    private static boolean canConvertDefault(Class klass) {
        return String.class.equals(klass) || Long.class.equals(klass) ||
                Double.class.equals(klass) || Boolean.class.equals(klass) || JThing.class.equals(klass);
    }
    
    private static Model modelFor(Class klass) {
        if (String.class.equals(klass)) {
            return Model.STRING;
        } else if (Boolean.class.equals(klass)) {
            return Model.BOOLEAN;
        } else if (Long.class.equals(klass)) {
            return Model.LONG;
        } else if (Double.class.equals(klass)) {
            return Model.DOUBLE;
        } else {
            return Model.OBJECT;
        }
    }

    @Override
    public <X> Pipeable<U> seeCustomRefList(final DSL<T, U> dsl, final Ref<List<Ref<X>>> domain, final Class<X> klass) throws JerializerException {
        final Jerializer<T, U, X> jerializer = registry.hasJerializer(klass) ? registry.getJerializer(klass) : null;
        if (jerializer == null && !canConvertDefault(klass)) throw new JerializerException("Invalid klass: "+klass);
        final Model model = modelFor(klass);
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
                        domain.setRef(new ArrayList<Ref<X>>(listSpec.size()));
                        for (final Speclike subSpec : listSpec) {
                            if (!subSpec.getModel().equals(model)) throw new JerializerException("Invalid model: "+model+" "+subSpec);
                            if (jerializer != null) {
                                domain.getRef().add(new RefImpl<X>(jerializer.prototype(subSpec)));
                            } else if (String.class.equals(klass) || Long.class.equals(klass) ||
                                       Double.class.equals(klass) || Boolean.class.equals(klass)) {
                                domain.getRef().add(new RefImpl<X>(null));
                            } else if (JThing.class.equals(klass)) {
                                domain.getRef().add((Ref<X>)new RefImpl<JThing>(JThing.fromSpec(subSpec)));
                            } else {
                                throw new JerializerException("Invalid klass: "+klass);
                            }
                        }
                    }
                }
                ArrayDSL<T, U> arrayDSL = dsl.seeArray();
                for (final Ref<X> value : domain.getRef()) {
                    final Pipeable<U> pipeable;
                    if (jerializer != null) {
                        pipeable = jerializer.jerialize(thiz, dsl, value.getRef());
                    } else if (String.class.equals(klass)) {
                        pipeable = dsl.seeString((Ref<String>)value);
                    } else if (Boolean.class.equals(klass)) {
                        pipeable = dsl.seeBoolean((Ref<Boolean>)value);
                    } else if (Long.class.equals(klass)) {
                        pipeable = dsl.seeLong((Ref<Long>)value);
                    } else if (Double.class.equals(klass)) {
                        pipeable = dsl.seeDouble((Ref<Double>)value);
                    } else if (JThing.class.equals(klass)) {
                        pipeable = ((JThing)value.getRef()).acceptDSL(dsl);
                    } else {
                        throw new JerializerException("Invalid klass: "+klass);
                    }
                    arrayDSL.seeWritable(new RefImpl<Pipeable<U>>(pipeable));
                }
                arrayDSL.pipe(ref);
            }
        };
    }

    @Override
    public <X, Y> Pipeable<U> seeCustomRefList2(final DSL<T, U> dsl, final Ref<List<Ref2<X, Y>>> domain, final Class<X> klassX, final Class<Y> klassY) throws JerializerException {
        final Jerializer<T, U, X> jerializerX = registry.hasJerializer(klassX) ? registry.getJerializer(klassX) : null;
        if (jerializerX == null && !canConvertDefault(klassX)) throw new JerializerException("Invalid klassX: "+klassX);
        final Model modelX = modelFor(klassX);

        final Jerializer<T, U, Y> jerializerY = registry.hasJerializer(klassY) ? registry.getJerializer(klassY) : null;
        if (jerializerY == null && !canConvertDefault(klassY)) throw new JerializerException("Invalid klassY: "+klassY);
        final Model modelY = modelFor(klassX);

        if (modelX.equals(modelY)) throw new JerializerException("Matching models: "+modelX);
        
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
                        domain.setRef(new ArrayList<Ref2<X, Y>>(listSpec.size()));
                        for (final Speclike subSpec : listSpec) {
                            if (subSpec.getModel().equals(modelX)) {
                                X x = null;
                                if (jerializerX != null) x = jerializerX.prototype(subSpec);
                                domain.getRef().add(Ref2.<X, Y>makeFirst(x));
                            } else if (subSpec.getModel().equals(modelY)) {
                                Y y = null;
                                if (jerializerY != null) y = jerializerY.prototype(subSpec);
                                domain.getRef().add(Ref2.<X, Y>makeSecond(y));
                            } else {
                                throw new JerializerException("Unexpected model: "+subSpec+" vs "+modelX+" + "+modelY);
                            }
                        }
                    }
                }
                ArrayDSL<T, U> arrayDSL = dsl.seeArray();
                for (final Ref2<X, Y> value : domain.getRef()) {
                    final Pipeable<U> pipeable;
                    if (value.hasFirst()) {
                        if (jerializerX != null) {
                            pipeable = jerializerX.jerialize(thiz, dsl, value.getFirstRef().getRef());
                        } else if (modelX.equals(Model.STRING)) {
                            pipeable = dsl.seeString((Ref<String>)value.getFirstRef());
                        } else if (modelX.equals(Model.BOOLEAN)) {
                            pipeable = dsl.seeBoolean((Ref<Boolean>)value.getFirstRef());
                        } else if (modelX.equals(Model.LONG)) {
                            pipeable = dsl.seeLong((Ref<Long>)value.getFirstRef());
                        } else if (modelX.equals(Model.DOUBLE)) {
                            pipeable = dsl.seeDouble((Ref<Double>)value.getFirstRef());
                        } else if (modelX.equals(Model.OBJECT)) {
                            pipeable = ((JThing)value.getFirstRef().getRef()).acceptDSL(dsl);
                        } else {
                            throw new JerializerException("Invalid x...");
                        }
                    } else {
                        if (jerializerY != null) {
                            pipeable = jerializerY.jerialize(thiz, dsl, value.getSecondRef().getRef());
                        } else if (modelY.equals(Model.STRING)) {
                            pipeable = dsl.seeString((Ref<String>)value.getSecondRef());
                        } else if (modelY.equals(Model.BOOLEAN)) {
                            pipeable = dsl.seeBoolean((Ref<Boolean>)value.getSecondRef());
                        } else if (modelY.equals(Model.LONG)) {
                            pipeable = dsl.seeLong((Ref<Long>)value.getSecondRef());
                        } else if (modelY.equals(Model.DOUBLE)) {
                            pipeable = dsl.seeDouble((Ref<Double>)value.getSecondRef());
                        } else if (modelY.equals(Model.OBJECT)) {
                            pipeable = ((JThing)value.getSecondRef().getRef()).acceptDSL(dsl);
                        } else {
                            throw new JerializerException("Invalid y...");
                        }
                    }
                    arrayDSL.seeWritable(new RefImpl<Pipeable<U>>(pipeable));
                }
                arrayDSL.pipe(ref);
            }
        };
    }
}
