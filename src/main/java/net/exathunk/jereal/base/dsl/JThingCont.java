package net.exathunk.jereal.base.dsl;

import net.exathunk.jereal.base.core.JThing;
import net.exathunk.jereal.base.functional.Cont;
import net.exathunk.jereal.base.functional.Ref;
import net.exathunk.jereal.base.functional.RefImpl;

import java.util.List;
import java.util.Map;

/**
 * charolastra 11/1/12 4:10 PM
 */
public class JThingCont implements Cont<JThing> {

    private final Ref<JThing> wrapped;

    public JThingCont() {
        this.wrapped = new RefImpl<JThing>();
    }

    public JThingCont(Ref<JThing> ref) {
        this.wrapped = ref;
    }


    @Override
    public boolean isSingle() {
        return true;
    }

    @Override
    public boolean isMap() {
        return wrapped.isEmptyRef() || wrapped.getRef().isObject();
    }

    @Override
    public boolean isList() {
        return wrapped.isEmptyRef() || wrapped.getRef().isArray();
    }

    @Override
    public Ref<JThing> getSingle() {
        return wrapped;
    }

    @Override
    public Ref<List<JThing>> getList() {
        return new Ref<List<JThing>>() {
            @Override
            public void setRef(List<JThing> value) {
                wrapped.setRef(JThing.make(value));
            }

            @Override
            public List<JThing> getRef() {
                return wrapped.getRef().rawGetArray().getList();
            }

            @Override
            public boolean isEmptyRef() {
                return wrapped.isEmptyRef();
            }
        };
    }

    @Override
    public Ref<Map<String, JThing>> getMap() {
        return new Ref<Map<String, JThing>>() {
            @Override
            public void setRef(Map<String, JThing> value) {
                wrapped.setRef(JThing.make(value));
            }

            @Override
            public Map<String, JThing> getRef() {
                return wrapped.getRef().rawGetObject().getMap();
            }

            @Override
            public boolean isEmptyRef() {
                return wrapped.isEmptyRef();
            }
        };
    }

    @Override
    public void setCont(Cont<JThing> cont) {
        if (cont.isMap() && !cont.getMap().isEmptyRef()) {
            getMap().setRef(cont.getMap().getRef());
        } else if (cont.isList() && !cont.getList().isEmptyRef()) {
            getList().setRef(cont.getList().getRef());
        } else if (cont.isSingle() && !cont.getSingle().isEmptyRef()) {
            getSingle().setRef(cont.getSingle().getRef());
        }
    }
}
