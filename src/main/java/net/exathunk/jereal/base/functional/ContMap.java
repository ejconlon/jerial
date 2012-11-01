package net.exathunk.jereal.base.functional;

import java.util.List;
import java.util.Map;

/**
 * charolastra 11/1/12 2:55 PM
 */
public class ContMap<U> implements Cont<U> {
    private final Ref<Map<String, U>> ref;

    public ContMap() {
        ref = new RefImpl<Map<String, U>>();
    }

    public ContMap(Ref<Map<String, U>> ref) {
        this.ref = ref;
    }

    @Override
    public boolean isSingle() {
        return false;
    }

    @Override
    public boolean isMap() {
        return true;
    }

    @Override
    public boolean isList() {
        return false;
    }

    @Override
    public Ref<U> getSingle() {
        throw new IllegalArgumentException("map cont not a single");
    }

    @Override
    public Ref<List<U>> getList() {
        throw new IllegalArgumentException("map cont not a list");
    }

    @Override
    public Ref<Map<String, U>> getMap() {
        return ref;
    }

    @Override
    public void setCont(Cont<U> cont) {
        Ref<Map<String, U>> newRef = cont.getMap();
        if (!newRef.isEmptyRef())
            ref.setRef(newRef.getRef());
    }
}
