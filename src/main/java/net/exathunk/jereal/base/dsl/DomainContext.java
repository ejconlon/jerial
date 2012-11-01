package net.exathunk.jereal.base.dsl;

import net.exathunk.jereal.base.core.JArray;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.core.Path;
import net.exathunk.jereal.base.core.PathPart;
import net.exathunk.jereal.base.functional.Ref;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Map;

/**
 * charolastra 10/31/12 9:09 PM
 */
public class DomainContext implements PushableContext<DomainContext, JThing> {

    // TODO not this context
    private final Path path;

    public DomainContext() {
        this(Path.root());
    }

    public DomainContext(Path path) {
        this.path = path;
    }

    @Override
    public DomainContext push(PathPart part) {
        return new DomainContext(path.cons(part));
    }

    @Override
    public void writeObject(RefMapGroup<DomainContext, JThing> group, Ref<JThing> ref) {
        throw new NotImplementedException();
    }

    @Override
    public void writeArray(RefMapGroup<DomainContext, JThing> group, Ref<JThing> ref) {
        final ArrayDSL<DomainContext, JThing> arrayDSL = group.getArrays().get(path.head());
        final JArray array = ref.getRef().rawGetArray();
        for (Map.Entry<Integer, JThing> entry : array.seq()) {
            final PathPart part = PathPart.index(entry.getKey());
            final JThing value = entry.getValue();
            switch (value.getModel()) {
                case OBJECT:

                    break;
                case ARRAY:
                    break;
                case STRING:
                    break;
                case BOOLEAN:
                    break;
                case LONG:
                    break;
                case DOUBLE:
                    break;
                default:
                    throw new IllegalStateException();
            }
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
