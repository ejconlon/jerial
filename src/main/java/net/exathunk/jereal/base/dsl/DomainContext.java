package net.exathunk.jereal.base.dsl;

import net.exathunk.jereal.base.builders.JerialContext;
import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.core.PathPart;
import net.exathunk.jereal.base.functional.Ref;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * charolastra 10/31/12 9:09 PM
 */
public class DomainContext implements PushableContext<DomainContext, JThing> {

    // TODO not this context
    private final JerialContext context;

    public DomainContext() {
        this(new JerialContext());
    }

    public DomainContext(JerialContext context) {
        this.context = context;
    }

    @Override
    public DomainContext push(PathPart part) {
        throw new NotImplementedException();
    }

    @Override
    public void writeObject(RefMapGroup<DomainContext, JThing> group, Ref<JThing> ref) {
        throw new NotImplementedException();
    }

    @Override
    public void writeArray(RefMapGroup<DomainContext, JThing> group, Ref<JThing> ref) {
        throw new NotImplementedException();
    }

    @Override
    public void writeString(Ref<String> value, Ref<JThing> ref) {
        throw new NotImplementedException();
    }

    @Override
    public void writeBoolean(Ref<Boolean> value, Ref<JThing> ref) {
        throw new NotImplementedException();
    }

    @Override
    public void writeLong(Ref<Long> value, Ref<JThing> ref) {
        throw new NotImplementedException();
    }

    @Override
    public void writeDouble(Ref<Double> value, Ref<JThing> ref) {
        throw new NotImplementedException();
    }
}
