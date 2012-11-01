package net.exathunk.jereal.base.dsl;

import net.exathunk.jereal.base.core.*;
import net.exathunk.jereal.base.functional.*;
import net.exathunk.jereal.base.jerializers.JerializerException;

import java.util.List;
import java.util.Map;

/**
 * charolastra 10/31/12 9:09 PM
 */
public class DomainContext implements PushableContext<DomainContext, JThing> {

    @Override
    public DomainContext push(PathPart part) {
        return this;
    }

    private void writeInner(RefMapGroup<DomainContext, JThing> group, PathPart part, JThing value) throws JerializerException {
        RefMapGroup.WModel model = group.getModel(part);
        if (model == null) return;
        switch (model) {
            case OBJECT:
            {
                Ref<ObjectDSL<DomainContext, JThing>> sink = group.getObjects().get(part);
                if (sink != null) sink.getRef().pipe(new JThingCont(new RefImpl<JThing>(value)));
                break;
            }
            case ARRAY:
            {
                Ref<ArrayDSL<DomainContext, JThing>> sink = group.getArrays().get(part);
                if (sink != null) sink.getRef().pipe(new JThingCont(new RefImpl<JThing>(value)));
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
            case WRITABLE:
            {
                Ref<Pipeable<JThing>> sink = group.getWritables().get(part);
                final Cont<JThing> cont = new JThingCont(new RefImpl<JThing>(value));
                if (sink != null) sink.getRef().pipe(cont);
                break;
            }
            default:
                throw new IllegalStateException("Uncovered case: "+model);
        }
    }

    @Override
    public void writeObject(RefMapGroup<DomainContext, JThing> group, Cont<JThing> cont) throws JerializerException{
        final Map<String, JThing> object = cont.getMap().getRef();
        for (Map.Entry<String, JThing> entry : object.entrySet()) {
            final PathPart part = PathPart.key(entry.getKey());
            final JThing value = entry.getValue();
            writeInner(group, part, value);
        }
    }

    @Override
    public void writeArray(RefMapGroup<DomainContext, JThing> group, Cont<JThing> cont) throws JerializerException{
        final List<JThing> array = cont.getList().getRef();
        int index = 0;
        for (final JThing value : array) {
            final PathPart part = PathPart.index(index);
            writeInner(group, part, value);
            index += 1;
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
