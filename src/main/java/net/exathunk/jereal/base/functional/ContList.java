package net.exathunk.jereal.base.functional;

import java.util.List;
import java.util.Map;

/**
 * charolastra 11/1/12 2:55 PM
 */
public class ContList<U> implements Cont<U> {
    private final Ref<List<U>> ref;

    public ContList() {
        ref = new RefImpl<List<U>>();
    }

    public ContList(Ref<List<U>> ref) {
        this.ref = ref;
    }

    @Override
    public boolean isSingle() {
        return false;
    }

    @Override
    public boolean isMap() {
        return false;
    }

    @Override
    public boolean isList() {
        return true;
    }

    @Override
    public Ref<U> getSingle() {
        throw new IllegalArgumentException("list cont not a single");
    }

    @Override
    public Ref<List<U>> getList() {
        return ref;
    }

    @Override
    public Ref<Map<String, U>> getMap() {
        throw new IllegalArgumentException("list cont not a map");
    }

    @Override
    public void setCont(Cont<U> cont) {
        Ref<List<U>> newRef = cont.getList();
        if (!newRef.isEmptyRef())
            ref.setRef(newRef.getRef());
    }
}
