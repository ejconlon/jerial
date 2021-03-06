package net.exathunk.jereal.base.dsl;

import net.exathunk.jereal.base.core.*;
import net.exathunk.jereal.base.functional.*;
import net.exathunk.jereal.base.jerializers.JerializerException;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * charolastra 10/31/12 9:09 PM
 */
public class DomainContext implements PushableContext<DomainContext, JThing> {

    @Override
    public DomainContext push(PathPart part) {
        return this;
    }

    private void writeInner(RefMapGroup<DomainContext, JThing> group, PathPart part, JThing value) throws JerializerException {
        Set<RefMapGroup.WModel> models = group.getModels(part);
        if (models == null) return;
        final RefMapGroup.WModel model;
        if (models.size() == 1) {
            model = models.iterator().next();
        } else {
            RefMapGroup.WModel test = RefMapGroup.WModel.fromModel(value.getModel());
            if (models.contains(test)) model = test;
            else if (models.contains(RefMapGroup.WModel.CUSTOM)) model = RefMapGroup.WModel.CUSTOM;
            else if (models.contains(RefMapGroup.WModel.LIST)) model = RefMapGroup.WModel.LIST;
            else throw new IllegalArgumentException("Bad models: "+test+" "+models);
        }
        switch (model) {
            case OBJECT:
            {
                Ref<ObjectDSL<DomainContext, JThing>> sink = group.getObjects().get(part);
                if (sink != null) sink.getRef().pipe(new RefImpl<JThing>(value));
                break;
            }
            case ARRAY:
            {
                Ref<ArrayDSL<DomainContext, JThing>> sink = group.getArrays().get(part);
                if (sink != null) sink.getRef().pipe(new RefImpl<JThing>(value));
                break;
            }
            case STRING:
            {
                Ref<String> sink = group.getStrings().get(part);
                if (sink != null) sink.setRef(value.rawGetString().getRef());
                break;
            }
            case BOOLEAN:
            {
                Ref<Boolean> sink = group.getBooleans().get(part);
                if (sink != null) sink.setRef(value.rawGetBoolean().getRef());
                break;
            }
            case LONG:
            {
                Ref<Long> sink = group.getLongs().get(part);
                if (sink != null) sink.setRef(value.rawGetLong().getRef());
                break;
            }
            case DOUBLE:
            {
                Ref<Double> sink = group.getDoubles().get(part);
                if (sink != null) sink.setRef(value.rawGetDouble().getRef());
                break;
            }
            case CUSTOM:
            case LIST:
            {
                final Ref<Pipeable<JThing>> sink;
                if ( RefMapGroup.WModel.CUSTOM.equals(model)) {
                    sink = group.getCustoms().get(part);
                } else {
                    sink = group.getLists().get(part);
                }
                if (sink != null) sink.getRef().pipe(new RefImpl<JThing>(value));
                break;
            }
            default:
                throw new IllegalStateException("Uncovered case: "+model);
        }
    }

    @Override
    public void writeObject(RefMapGroup<DomainContext, JThing> group, Ref<JThing> ref) throws JerializerException{
        final JObject object = ref.getRef().rawGetObject();
        for (Map.Entry<String, JThing> entry : object.seq()) {
            final PathPart part = PathPart.key(entry.getKey());
            final JThing value = entry.getValue();
            writeInner(group, part, value);
        }
    }

    @Override
    public void writeArray(RefMapGroup<DomainContext, JThing> group, Ref<JThing> ref) throws JerializerException{
        final JArray array = ref.getRef().rawGetArray();
        for (Map.Entry<Integer, JThing> entry : array.seq()) {
            final PathPart part = PathPart.index(entry.getKey());
            writeInner(group, part, entry.getValue());
        }
    }

    @Override
    public void writeString(Ref<String> value, Ref<JThing> ref) {
        value.setRef(ref.getRef().rawGetString().getRef());
    }

    @Override
    public void writeBoolean(Ref<Boolean> value, Ref<JThing> ref) {
        value.setRef(ref.getRef().rawGetBoolean().getRef());
    }

    @Override
    public void writeLong(Ref<Long> value, Ref<JThing> ref) {
        value.setRef(ref.getRef().rawGetLong().getRef());
    }

    @Override
    public void writeDouble(Ref<Double> value, Ref<JThing> ref) {
        value.setRef(ref.getRef().rawGetDouble().getRef());
    }
}
